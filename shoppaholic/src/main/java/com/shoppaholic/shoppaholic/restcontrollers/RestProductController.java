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

	@RequestMapping(value="/api/product/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public Collection<Product> getProducts() {
		return productService.findAll();
	}

	//Not sure if working
	@RequestMapping(value="/api/addProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> AddProduct(
			@RequestBody Product p) throws Exception{
		productService.save(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/api/deleteproduct/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
		Product p=productService.findOne(id);
		productService.delete(p.getId());
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
}
 