package com.shoppaholic.shoppaholic.restcontrollers;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
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

	@RequestMapping(value="/api/product/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public Collection<Product> getProducts() {
		return productService.findAll();
	}


	@RequestMapping(value="/api/addProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> AddProduct(
			@RequestBody Product p) throws Exception{
		productService.save(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	//Doesnt work
	@RequestMapping(value="/api/deleteproduct/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		List<Pedido> x = pedidoService.findAll();
		List<Comment> comments = commentService.findByProduct(p);
		for (int i=0; i<x.size(); i++){
		
		if (x.get(i).getProductsofPedido().contains(p)) {x.get(0).getProductsofPedido().remove(p);
		pedidoService.save(x.get(i));
		
		comments.clear();
		
		} 
		}
		productService.delete(p.getId());
	
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
}
 