package com.shoppaholic.shoppaholic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
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
		productRepository.save(new Product("FIFA", 45, "Best football simulator","Videogames","18/10/2017","https://images-na.ssl-images-amazon.com/images/I/81JEhgEtqGL._SX385_.jpg"));
		productRepository.save(new Product("PUBG", 30, "Survive ","Videogames","2/12/2017","https://images-na.ssl-images-amazon.com/images/I/91XsDUSFTyL._SY500_.jpg"));
		productRepository.save(new Product("NBA", 34.99, "Play basketball ","Videogames","5/12/2017","https://images-na.ssl-images-amazon.com/images/I/71r6RDosSDL._SL1000_.jpg"));
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
	@RequestMapping("/product")
	public String productStart(Model model) {
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
	@RequestMapping("/order")
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
