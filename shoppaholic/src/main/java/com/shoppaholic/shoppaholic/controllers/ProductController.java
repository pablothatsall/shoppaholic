package com.shoppaholic.shoppaholic.controllers;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CommentRepository;
import com.shoppaholic.shoppaholic.repositories.CustomerRepository;
import com.shoppaholic.shoppaholic.repositories.PedidoRepository;
import com.shoppaholic.shoppaholic.repositories.ProductRepository;
import com.shoppaholic.shoppaholic.security.CustomerComponent;

@Controller
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductController {
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
	@RequestMapping("/product/{id}")
	public String productStart(Model model, @PathVariable long id, HttpServletRequest request,
			@RequestParam(value = "addproduct", defaultValue = "") String addproduct,
			@RequestParam(value = "addcomment", defaultValue = "") String addcomment) {
		
		
    	
		Product p = productRepository.findOne(id);
		List<Comment> c = commentRepository.findByProduct(p);
		model.addAttribute("product", p);
		
		model.addAttribute("comments", c);
		model.addAttribute("label", p.getLabel());
		model.addAttribute("topsLabel", productRepository.findByLabelOrderByScoreDesc(p.getLabel(), (new PageRequest(0,5))));
		
		boolean login=customerComponent.isLoggedUser();
    	if(login){
    		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
    		model.addAttribute("user", uLogged);
    		Pedido pedidotoadd = uLogged.getMyCart();
    			
    			if(!addproduct.equals("") && addcomment.equals("")) {
    				pedidotoadd.addProduct(p);
    				p.setScore(p.getScore()+1);
    				pedidotoadd.calculaprecio();
    				customerRepository.save(uLogged);
    				
    			}
    			
    			if(!addcomment.equals("") ) {
    				java.util.Date fecha = new Date(); 
    				
    				commentRepository.save(new Comment(uLogged,addcomment,fecha.toGMTString(),p));	
    				
    			} 
  
    			return "product";
    	}
			else
				if(!addcomment.equals("")) {
    				java.util.Date fecha = new Date(); 
    				Customer anonimo = new Customer("Anonimo");
    				commentRepository.save(new Comment(anonimo,addcomment,fecha.toGMTString(),p));	
    				
    			} 
		
		
		
		return "product";
	}
	
}