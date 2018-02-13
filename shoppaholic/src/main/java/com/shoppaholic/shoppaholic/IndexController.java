package com.shoppaholic.shoppaholic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	

	
	
	@RequestMapping("/")
	public String mainStart(Model model) {
		return "index";
	}
	
	@RequestMapping("/index")
	public String indexStart(Model model) {
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
