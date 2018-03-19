package com.shoppaholic.shoppaholic.restcontrollers;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.security.CustomerComponent;
import com.shoppaholic.shoppaholic.services.*;

@RestController
public class RestProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CustomerComponent customerComponent;
	
	
	@RequestMapping(value="/api/product/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		List<Comment> x = commentService.findByProduct(p);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> getProducts() {
		return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/productGetComments/{id}", method=RequestMethod.GET)
	public ResponseEntity<Collection<Comment>> getProductComments(@PathVariable long id) {
		Product p=productService.findOne(id);
		List<Comment> x = commentService.findByProduct(p);
		return new ResponseEntity<>(x,HttpStatus.OK);
	}


	@RequestMapping(value="/api/admin/addProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> AddProduct(
			@RequestBody Product p) throws Exception{
		java.util.Date actualdate = new Date();
		Product pnew = new Product(p.getName(),p.getPrice(), p.getDescription(), p.getLabel(), actualdate.toGMTString(), p.getImageUrl(), p.getScore(), p.getComments());
		productService.save(pnew);
		return new ResponseEntity<>(pnew,HttpStatus.CREATED);
	}
	
	//Doesnt work
	@RequestMapping(value="/api/deleteProduct/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		List<Pedido> x = pedidoService.findAll();
		List<Comment> comments = commentService.findByProduct(p);
		for (int i=0; i<x.size(); i++){
		
			if (x.get(i).getProductsofPedido().contains(p)) {
				x.get(0).getProductsofPedido().remove(p);
				pedidoService.save(x.get(i));
			
				comments.clear();
			
			} 
		}
		productService.delete(p.getId());
	
		return new ResponseEntity<>("Deleted product" + p.getName(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/addToCart/{id}", method=RequestMethod.POST)
	public ResponseEntity<Pedido> addToCart(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		uLogged.getMyCart().addProduct(productService.findOne(id));
		customerService.save(uLogged);
		return new ResponseEntity<>(uLogged.getMyCart(),HttpStatus.OK);

	}
	@RequestMapping(value="/api/deleteFromCart/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Pedido> deleteFromCart(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		uLogged.getMyCart().deleteProduct((productService.findOne(id)));
		customerService.save(uLogged);
		return new ResponseEntity<>(uLogged.getMyCart(),HttpStatus.OK);

	}
	
	@RequestMapping(value="/api/admin/editProduct/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Product> EditCustomer(@PathVariable long id,@RequestBody Product p) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		
		
			Product poriginal = productService.findOne(id);
			if (!p.getName().equals("")){
				
				 productService.findByName(poriginal.getName()).setName(p.getName());
				 productService.save(poriginal);
			
			}
			
			if (!p.getLabel().equals("")){
				
				 productService.findByName(poriginal.getName()).setLabel(p.getLabel());
				 productService.save(poriginal);
			} 
			
			if (!p.getLabel().equals("")){
				
				 productService.findByName(poriginal.getName()).setLabel(p.getLabel());
				 productService.save(poriginal);
			} 
			if (p.getPrice() != -3){
				
				 productService.findByName(poriginal.getName()).setPrice(p.getPrice());
				 productService.save(poriginal);
			} 
			
			return new ResponseEntity<>(p,HttpStatus.OK);

	}
	
}
 