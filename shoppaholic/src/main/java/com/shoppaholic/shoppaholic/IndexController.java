package com.shoppaholic.shoppaholic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class IndexController {

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
	
	//final static Logger log = LoggerFactory.getLogger(IndexController.class); for login

	@PostConstruct
	public void init() {
		Product fifa = new Product("FIFA", 45, "Best football simulator", "Videogames", "18/10/2017","https://images-na.ssl-images-amazon.com/images/I/81JEhgEtqGL._SX385_.jpg",null);
		Product farcry = new Product("FARCRY Primal", 30, "Survive ", "Videogames", "2/12/2017","https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg",null);
		Product nba = new Product("NBA", 34.99, "Play basketball ", "Videogames", "5/12/2017","https://images-na.ssl-images-amazon.com/images/I/71r6RDosSDL._SL1000_.jpg",null);
		Product cdj = new Product("Pioneer cdj-2000nxs2", 2290.99, "For DJing ", "Music", "8/12/2017","https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg",null);
		Product pc = new Product("Medion S91 - Ordenador de sobremesa", 1071.18,"Intel Core i7-6700 | 8 GB RAM | 1 TB HDD", "Electronic", "11/12/2017","https://images-na.ssl-images-amazon.com/images/I/91jemD9L-OL._SL1500_.jpg",null);
		productRepository.save(fifa);
		productRepository.save(farcry);
		productRepository.save(nba);
		productRepository.save(cdj);
		productRepository.save(pc);
		
		

		List<Product> products = new ArrayList<Product>();
		products.add(farcry);
		java.util.Date fecha = new Date(); 
		Pedido pedido1 = new Pedido(12, "Pending", "Chubi", fecha.toGMTString(), products);
		pedidoRepository.save(pedido1); 
		Pedido pedido2 = new Pedido();
		pedidoRepository.save(pedido2); 
		
		List<Pedido> ordersc = new ArrayList<>();
		ordersc.add(pedido1);
	 
		Customer c = new Customer("Ruben", "Iglesias", "chubi", "chubi", "c/Aprobado", 1313,"https://pbs.twimg.com/profile_images/743815180153393152/cEnZYY2g_400x400.jpg", ordersc,pedido1, "ROLE_USER");
		Customer p = new Customer("Pablo", "Moreno", "pablo", "pablo", "c/Sprint", 666,"https://pbs.twimg.com/profile_images/916980080278102017/HfrABpSp_400x400.jpg",null, null, "ROLE_USER");
		Customer d = new Customer("Dani", "Ribeiro", "dani", "dani", "c/Henry", 88,"https://pbs.twimg.com/profile_images/578500665565130752/xVoASGTj_400x400.jpeg",null, null, "ROLE_USER");
		customerRepository.save(c);
		customerRepository.save(p);
		customerRepository.save(d);
		
		java.util.Date fechaactual = new Date();
		Comment c1 = new Comment(c,"Me gusta el fifa", fechaactual.toGMTString() ,fifa);
		commentRepository.save(c1);
		
		
 
	}

	@RequestMapping("/")
	public String mainStart(Model model, HttpServletRequest request) {
		model.addAttribute("products", productRepository.findAll(new PageRequest(0, 4)));
		return "index";
	}
	

	
	@RequestMapping("/userprofile")
	public String userStart(Model model, HttpServletRequest request ) {
		model.addAttribute("USER", request.isUserInRole("USER"));
		return "userprofile";
	}

	@RequestMapping("/userprofile/{id}")
	public String userStart(Model model ,@PathVariable long id) {
		Customer user = customerRepository.findOne(id);
		model.addAttribute("user", user);
		return "userprofile";
	}

	@RequestMapping("/signUp")
	public String signupStart(Model model) {
		return "signUp";
	}

	@RequestMapping("/product/{id}")
	public String productStart(Model model, @PathVariable long id, 
			@RequestParam(value = "addproduct", defaultValue = "") String addproduct,
			@RequestParam(value = "addcomment", defaultValue = "") String addcomment) {
		Product p = productRepository.findOne(id);
		model.addAttribute("product", p);
		List<Comment> c = commentRepository.findByProduct(p);
		model.addAttribute("comments", c);
		Customer chubi = customerRepository.findByMail("chubi"); //Esto una vez funcione login registro se cambia chubi por el customer que ha iniciado sesión
		Pedido pedidotoadd = chubi.getMyCart();
		
		if(!addproduct.equals("") && addcomment.equals("")) {
			pedidotoadd.addProduct(p);
			customerRepository.save(chubi);
			
		}
		
		if(!addcomment.equals("")) {
			java.util.Date fecha = new Date(); 
			commentRepository.save(new Comment(chubi,addcomment,fecha.toGMTString(),p));	
		} 
		
		return "product";
	}


	@RequestMapping("/search")
	public String searchStart(Model model, @RequestParam(value = "searchtext", defaultValue = "") String searchtext) {
		model.addAttribute("searchtext",searchtext);
		model.addAttribute("products", productRepository.findByName(searchtext));
		model.addAttribute("productslabel", productRepository.findByLabel(searchtext));
		return "search";
	}

	@RequestMapping("/payment")
	public String paymentStart(Model model) {
		return "payment";
	}

	@RequestMapping("/orderlist")
	public String orderlistStart(Model model) {

		return "orderlist";
	}
 
	@RequestMapping("/order/{id}")
	public String orderStart(Model model, @PathVariable long id) {
		Pedido pedido = pedidoRepository.findOne(id);
		model.addAttribute("pedido", pedido);
		List <Product> productos = pedido.getProductsofPedido();
		model.addAttribute("productos", productos);
		Integer cantidad= productos.size();
		model.addAttribute("cantidad", cantidad);
		
		
		
				
		return "order";
	}

	@RequestMapping("/login")
	public  String loginStart(Model model) {
		/*if (!customerComponent.isLoggedUser()) {
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			User loggedUser = userComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getName());
		return new ResponseEntity<>(loggedUser, HttpStatus.OK); */
		return "login";
	}
 
	@RequestMapping("/list")
	public String listStart(Model model) {
		return "list";
	}
	
	
	@RequestMapping("/editprofile")
	public String editprofileStart(Model model) {
		
		return "editprofile";
	}
	//CON ID
	/*@RequestMapping("/editprofile/{id}")
	public String editprofileStart(Model model, @PathVariable long id) {
		Customer customer= customerRepository.findOne(id);
		model.addAttribute("customer", customer);
		return "editprofile";
	}*/

	
	
	@RequestMapping("/cart")
	public String cartStart(Model model) {
		
		return "cart";
	}
 //Aqui tendremos de id la id del customer que tiene ese carrito
	@RequestMapping("/cart/{id}")
	public String cartStart(Model model, @PathVariable long id, @RequestParam(value = "deletion", defaultValue = "-1") long deletion) {
		Customer customer= customerRepository.findOne(id);
		model.addAttribute("customer", customer);
		Pedido carrito = customer.getMyCart();
		model.addAttribute("cartdetails", carrito);
		 
		List<Product> productsfromcart = customer.getMyCart().getProductsofPedido(); 
		model.addAttribute("products", productsfromcart);
		
		if(deletion!=-1) {
			
			pedidoRepository.findById(id).deleteProduct(productRepository.findById(deletion));;
			pedidoRepository.save(carrito);
		} 
		 
		return "cart";
	}

	@RequestMapping("/admin/addProduct")
	public String addProduct(Model model, @RequestParam(value = "nameproduct", defaultValue = "") String nameproduct,
			@RequestParam(value = "priceproduct", defaultValue = "0.0") double priceproduct,
			@RequestParam(value = "labelsproduct", defaultValue = "") String labelsproduct,
			@RequestParam(value = "descriptionproduct", defaultValue = "") String descriptionproduct,
			@RequestParam(value = "imageproduct", defaultValue = "https://images-eu.ssl-images-amazon.com/images/I/318gIw2AsDL._SS500.jpg") String imageproduct){
		
		if(!nameproduct.equals("") && !descriptionproduct.equals("") ) {
		java.util.Date fecha = new Date(); 
		List<Comment> comments = new ArrayList<>();
		Product newproduct = new Product(nameproduct,priceproduct,descriptionproduct,labelsproduct,fecha.toGMTString(),imageproduct,comments);
		productRepository.save(newproduct);}
		return "addProduct";

	}

	@RequestMapping("/admin/manageUser")
	public String manageUser(Model model, @RequestParam(value = "deletion", defaultValue = "-1") String deletion) {
		
		List<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers", customers);
		Customer toDelete = customerRepository.findByMail(deletion);
		if(toDelete  != null) {
			customerRepository.delete(toDelete);
		
		} 
		
		return "manageUser";

	}

}