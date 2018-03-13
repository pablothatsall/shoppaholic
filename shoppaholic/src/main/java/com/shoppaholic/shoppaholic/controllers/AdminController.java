package com.shoppaholic.shoppaholic.controllers;

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

import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CommentRepository;
import com.shoppaholic.shoppaholic.repositories.CustomerRepository;
import com.shoppaholic.shoppaholic.repositories.PedidoRepository;
import com.shoppaholic.shoppaholic.repositories.ProductRepository;
import com.shoppaholic.shoppaholic.security.CustomerComponent;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AdminController {
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


	@RequestMapping("/admin/addProduct")
	public String addProduct(Model model, @RequestParam(value = "nameproduct", defaultValue = "") String nameproduct,
			@RequestParam(value = "priceproduct", defaultValue = "0.0") double priceproduct,
			@RequestParam(value = "labelsproduct", defaultValue = "") String labelsproduct,
			@RequestParam(value = "descriptionproduct", defaultValue = "") String descriptionproduct,
			@RequestParam(value = "imageproduct", defaultValue = "https://images-eu.ssl-images-amazon.com/images/I/318gIw2AsDL._SS500.jpg") String imageproduct){
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    	
    		
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		model.addAttribute("user",uLogged);
    		if(uLogged.getRoles().contains("ROLE_ADMIN")){
    		if(!nameproduct.equals("") && !descriptionproduct.equals("") ) {
    			java.util.Date fecha = new Date(); 
    			List<Comment> comments = new ArrayList<>();
    			Product newproduct = new Product(nameproduct,priceproduct,descriptionproduct,labelsproduct,fecha.toGMTString(),imageproduct,0,comments);
    			productRepository.save(newproduct);}
    		}
    	}

		return "addProduct";

	}

	@RequestMapping("/admin/manageUser")
	public String manageUser(Model model,HttpServletRequest request, @RequestParam(value = "deletion", defaultValue = "") String deletion) {
		
		List<Customer> customers = customerRepository.findAll();
		System.out.println(deletion);
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		model.addAttribute("user",uLogged);
		if(uLogged.getRoles().contains("ROLE_ADMIN")){
		
		model.addAttribute("customers", customers);
	
		if (!deletion.equals("")) {	
			Customer toDelete = customerRepository.findByMail(deletion);
		//Implementar
			List<Comment> commentstodelete = commentRepository.findByCustomer(toDelete);
			commentRepository.delete(commentstodelete);

			customerRepository.delete(toDelete);

			
			}}
		return "manageUser";
 
	}  
	
	
	@RequestMapping("/admin/editproduct")
	public String editProduct(Model model, @RequestParam(value = "productnameoriginal", defaultValue = "") String productnameoriginal,
			@RequestParam(value = "productname", defaultValue = "") String productname,
			@RequestParam(value = "productlabel", defaultValue = "") String productlabel,
			@RequestParam(value = "productdescription", defaultValue = "") String productdescription,
			@RequestParam(value = "productprice", defaultValue = "-3") long productprice) {
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		model.addAttribute("user",uLogged);
		if(uLogged.getRoles().contains("ROLE_ADMIN")){
		List<Product> p = productRepository.findAll();
		model.addAttribute("products", p);
		
		if (!productname.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setName(productname);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		
		}
		
		if (!productlabel.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setLabel(productlabel);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		
		if (!productdescription.equals("")){
			
			 productRepository.findProductByName(productnameoriginal).setLabel(productdescription);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		if (productprice != -3){
			
			 productRepository.findProductByName(productnameoriginal).setPrice(productprice);
			 productRepository.save(productRepository.findProductByName(productnameoriginal));
		} 
		}
		
		return "editProduct";
		}

	
	@RequestMapping("/admin")
	public String manageUser(Model model) {
		return "administration";
		}
}