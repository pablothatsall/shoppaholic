package com.shoppaholic.shoppaholic.restcontrollers;
import java.util.Collection;
import java.util.Date;
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
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.security.CustomerComponent;
import com.shoppaholic.shoppaholic.services.*;

@RestController
public class RestCommentController {

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

	
	@RequestMapping(value="/api/comments", method=RequestMethod.GET)
	public  ResponseEntity<Collection<Comment>> getComments() {
		return new ResponseEntity<>(commentService.findAll(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/api/addComment/{id}", method=RequestMethod.POST)
	public ResponseEntity<Comment> addComment(@PathVariable long id, @RequestBody Comment c) {
		if(!c.equals("") ) {
			Product p = productService.findOne(id);
			java.util.Date actualdate = new Date();
			Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
			Comment newcomment = new Comment(uLogged,c.getComment(),actualdate.toGMTString(), p);
			commentService.save(newcomment);	
			productService.save(p);
			 return new ResponseEntity<>(newcomment,HttpStatus.CREATED);
		} 
		else {return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
		
	}
}
