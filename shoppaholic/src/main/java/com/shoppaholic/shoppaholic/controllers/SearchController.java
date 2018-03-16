package com.shoppaholic.shoppaholic.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CustomerRepository;
import com.shoppaholic.shoppaholic.repositories.ProductRepository;
import com.shoppaholic.shoppaholic.security.CustomerComponent;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerComponent customerComponent;
	
	@RequestMapping("/search/{searchterm}/loadMore/{pages}")
	public String searchNext(Model model, @PathVariable String searchterm, @PathVariable int pages) {
	boolean login=customerComponent.isLoggedUser();
		
	Pageable page = new PageRequest (0, 8 + 8*pages);
	
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		if(uLogged.getRoles().contains("ROLE_USER")){

    			model.addAttribute("user", uLogged);
    			return "index";
    		}
    	}
		
		model.addAttribute("searchtext", searchterm);
		
		boolean more = true;
		List<Product> productList = productRepository.findByLabel(searchterm);
		productList.addAll(productRepository.findByNameContaining("%" + searchterm + "%"));
		if (productList.size() <= (8 + 8*pages)) {
			 more = false;
		}else more = true;
		model.addAttribute("more", more);
		
		Page<Product> products = productRepository.findByNameContaining( "%" + searchterm + "%",  page);
		model.addAttribute("products", products);
		
		products = productRepository.findByLabel(searchterm, page);
		model.addAttribute("productslabel", products);
		
		
		model.addAttribute("currentPage", products.getNumber());
		model.addAttribute("nextPage", pages+1);

		return "search";
	}
	
	@RequestMapping("/search/{searchtext}")
		public String searchStart(Model model, @PageableDefault(size = 8) Pageable page,  HttpServletRequest request,
							@RequestParam(value = "searchtext") String searchtext) {
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		
    			model.addAttribute("user", uLogged);
    	}
			model.addAttribute("searchtext", searchtext);
			
			boolean more = true;
			List<Product> productList = productRepository.findByLabel(searchtext);
			productList.addAll(productRepository.findByNameContaining("%" + searchtext + "%"));
			if (productList.size() <= 8) {
				 more = false;
			}else more = true;
			model.addAttribute("more", more);
			
			Page<Product> products = productRepository.findByNameContaining( "%" + searchtext + "%",  page);
			model.addAttribute("products", products);
			products = productRepository.findByLabel(searchtext, page);
			model.addAttribute("productslabel", products);
	
			model.addAttribute("currentPage", products.getNumber());
			model.addAttribute("nextPage", products.getNumber()+1);
		return "search";
	}
}
