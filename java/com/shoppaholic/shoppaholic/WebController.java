package com.shoppaholic.shoppaholic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerComponent customerComponent;

	@Autowired
	private ProductRepository productRepository;


	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@RequestMapping("/")
	public @ResponseBody String getIndex(HttpSession session, Model model, 
			HttpServletRequest request) {

		boolean login = customerComponent.isLoggedUser();

		if (login) {
			Customer cLogged = customerRepository.findOne(customerComponent.getIdLoggedUser());
			if (cLogged.getFirstName().equals("admin")) {
				model.addAttribute("admin", true);
				return "administration";
			}
			
		}
		return "index";
	}
}
