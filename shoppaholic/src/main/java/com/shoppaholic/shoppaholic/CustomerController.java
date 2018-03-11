package com.shoppaholic.shoppaholic;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerController {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerComponent customerComponent;
	@Autowired 
	private CommentRepository commentRepository;
 
	
	@RequestMapping("/userprofile") //Screen shown just when logged
	public String userStart(Model model, HttpServletRequest request) {

		boolean login=customerComponent.isLoggedUser();
    	
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		if(uLogged.getRoles().equals("ROLE_USER")){
    			model.addAttribute("loggeduser", uLogged);
    			model.addAttribute("hider", true); 
    		}
    	}
    	
    	model.addAttribute("loggeduser", true);
		return "userprofile";
	}

	@RequestMapping("/userprofile/{id}")
	public String userStart(Model model ,@PathVariable long id, HttpServletRequest request) {
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		
		Customer user = customerRepository.findOne(id);
		if (uLogged.getId()==id) {
			
			model.addAttribute("hider",true);//Esconder mis orders y editar
		}
		model.addAttribute("user", user);
		return "userprofile";
	}
  
	 
	@RequestMapping("/register")
	public String signIn(Model model, HttpServletRequest request,
			@RequestParam(value = "firstname", defaultValue = "") String firstname,
			@RequestParam(value = "lastname", defaultValue = "") String lastname,
			@RequestParam(value = "email", defaultValue = "") String email,
    		@RequestParam(value = "password", defaultValue = "") String password,
    		@RequestParam(value = "telephone", defaultValue = "") String telephone,
    		@RequestParam(value = "address", defaultValue = "") String address,
    		@RequestParam(value = "file", defaultValue = "") String file){
		if(!firstname.equals("") && !lastname.equals("") && !email.equals("") && !password.equals("")) {
		java.util.Date fecha = new Date(); 
		List<Product> products = new ArrayList<Product>();
		Pedido newcart = new Pedido("Pending",firstname, fecha.toGMTString(), products);
		pedidoRepository.save(newcart);
		List<Pedido> newmyorders = new ArrayList<>();
		newmyorders.add(newcart);
		Customer newcustomer= new Customer(firstname, lastname , email, password, address, Long.valueOf(telephone).longValue(),file,newmyorders , newcart, "ROLE_USER");
		if(!file.equals("")) {
			newcustomer.setImageUrl("../../../../imgProfile/"+file);
			customerRepository.save(newcustomer);
		}
		customerRepository.save(newcustomer);
		}
		return "signUp";
	}

	@RequestMapping("/orderlist/{id}")
	public String orderlistStart(Model model, @PathVariable long id ) {
	boolean login=customerComponent.isLoggedUser();
    	
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		if(uLogged.getRoles().contains("ROLE_USER") && uLogged.getId()==id){

    			model.addAttribute("user", uLogged);
    			Customer c = customerRepository.findById(id);
    			String x =c.getFirstName();
    			List<Customer> n = customerRepository.findByFirstName(x);
    			model.addAttribute("x", n);
    			List<Pedido> norders = pedidoRepository.findByUser(x);
    			model.addAttribute("orders" , norders);
    			;
    			model.addAttribute("ordersize" , c.getMyOrders().size());

    		}
    	}
		
		

		return "orderlist";
	}
 
	//CON ID
		@RequestMapping("/editprofile/{id}")
		public String editprofileStart(Model model, @PathVariable long id,
						@RequestParam(value = "userfirstname", defaultValue = "") String userfirstname,
						@RequestParam(value = "userlastname", defaultValue = "") String userlastname,
						@RequestParam(value = "usermail", defaultValue = "") String usermail,
						@RequestParam(value = "useraddress", defaultValue = "") String useraddress,
						@RequestParam(value = "usertelephone", defaultValue = "") String usertelephone,
						@RequestParam(value = "file", defaultValue = "") String file) {
			
		boolean login=customerComponent.isLoggedUser();
	    	
	    	if(login){
	    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
	    		if(uLogged.getRoles().contains("ROLE_USER") && uLogged.getId()==id){

	    			model.addAttribute("user", uLogged);
	    			Customer customer= customerRepository.findOne(id);
	    			model.addAttribute("customer", customer);
	    			
	    			
	    			if(!userfirstname.equals("")) {
	    				customer.setFirstName(userfirstname);
	    				customerRepository.save(customer); 
	    			}
	    			
	    			if(!userlastname.equals("")) {
	    				customer.setLastName(userlastname);
	    				customerRepository.save(customer); 
	    			}
	    			if(!usermail.equals("")) {
	    				customer.setMail(usermail); 
	    				customerRepository.save(customer); 
	    				
	    			}
	    			if(!useraddress.equals("")) {
	    				customer.setAddress(useraddress);
	    				customerRepository.save(customer);  
	    				
	    			}
	    			
	    			if(!usertelephone.equals("")) {
	    				customer.setTelephone(Long.valueOf(usertelephone).longValue());;
	    				customerRepository.save(customer);  
	    				
	    			}
	    			if(!file.equals("")) {
	    				customer.setImageUrl("../../../../imgProfile/"+file);
	    				customerRepository.save(customer);
	    			}
	    		}
	    	}
			return "editprofile";
		}


		 //Aqui tendremos de id la id del customer que tiene ese carrito
			@RequestMapping("/cart/{id}")
			public String cartStart(Model model, @PathVariable long id, HttpServletRequest request,
					@RequestParam(value = "deletion", defaultValue = "-1") long deletion) {
				boolean login=customerComponent.isLoggedUser();
		    	if(login){
		    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		    		if(uLogged.getRoles().contains("ROLE_USER") && uLogged.getId()==id){
		    			model.addAttribute("user", uLogged);
		    			Customer customer= customerRepository.findOne(id);
		    			model.addAttribute("customer", customer);
		    			Pedido carrito = customer.getMyCart();
		    			model.addAttribute("cartdetails", carrito);
		    			 
		    			List<Product> productsfromcart = customer.getMyCart().getProductsofPedido(); 
		    			model.addAttribute("products", productsfromcart);
		    			
		    			if(deletion!=-1) {
		    				
		    				pedidoRepository.findById(id).deleteProduct(productRepository.findById(deletion));
		    				pedidoRepository.findById(id).calculaprecio();
		    				pedidoRepository.save(carrito);
		    			}
		    	}

				} 
				 
				return "cart";
			}

}