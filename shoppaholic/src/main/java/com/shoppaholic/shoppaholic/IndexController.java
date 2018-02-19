package com.shoppaholic.shoppaholic;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	 private ProductRepository productRepository;
	
	@Autowired
	 private OrderRepository orderRepository;
	@Autowired
	 private CustomerRepository customerRepository;
	
	@PostConstruct
	public void init() {
		Product fifa= new Product("FIFA", 45, "Best football simulator","Videogames","18/10/2017","https://images-na.ssl-images-amazon.com/images/I/81JEhgEtqGL._SX385_.jpg");
		productRepository.save(fifa);
		productRepository.save(new Product("FARCRY Primal", 30, "Survive ","Videogames","2/12/2017","https://images-na.ssl-images-amazon.com/images/I/61oqT8IYn4L.jpg"));
		productRepository.save(new Product("NBA", 34.99, "Play basketball ","Videogames","5/12/2017","https://images-na.ssl-images-amazon.com/images/I/71r6RDosSDL._SL1000_.jpg"));
		productRepository.save(new Product("Pioneer cdj-2000nxs2", 2290.99, "For DJing ","Music","8/12/2017","https://images-na.ssl-images-amazon.com/images/I/9198ikbY1aL._SL1500_.jpg"));
		
		ArrayList<Product> products = new ArrayList<Product>();
		Order o = new Order(products,"Pending","Chubi","12/7/2018",12);

		ArrayList<Order> orders = new ArrayList<>();
		
		Customer c= new Customer("Ruben","Iglesias","chubi13ri@hotmail.com","Chubiholic","c/Aprobado",666666666,"https://pbs.twimg.com/profile_images/743815180153393152/cEnZYY2g_400x400.jpg",orders );
		customerRepository.save(c);
		
		
		
		
	
		
	}
	
	@RequestMapping("/")
	public String mainStart(Model model) {
		
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}
	
	@RequestMapping("/userprofile")
	public String userStart(Model model) {
		return "userprofile";
	}

	@RequestMapping("/signUp")
	public String signupStart(Model model) {
		return "signUp";
	}
	@RequestMapping("/product/{id}")
	public String productStart(Model model, @PathVariable long id) {
		Product p=productRepository.findOne(id);
		model.addAttribute("product", productRepository.findById(id));
		return "product";
	}
	@RequestMapping("/search")
	public String searchStart(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "search";
	}
	@RequestMapping("/payment")
	public String paymentStart(Model model) {
		return "payment";
	}
	@RequestMapping("/orderlist")
	public String orderlistStart(Model model) {
		model.addAttribute("orders", orderRepository.findAll());
		return "orderlist";
	}
	@RequestMapping("/order/{id}")
	public String orderStart(Model model) {
		return "order";
	}
	@RequestMapping("/login")
	public String loginStart(Model model) {
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
	@RequestMapping("/cart")
	public String cartStart(Model model) {
		return "cart";
	}
	
}
