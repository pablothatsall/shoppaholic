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
public class RestCustomerController {

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
		
	@JsonView(Customer.Basic.class)
	@RequestMapping(value="/api/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.getId()==id) {
			Customer c=customerService.findOne(id);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/api/customers", method=RequestMethod.GET)
	public ResponseEntity<Collection<Customer>> getCustomers() {

			return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
		}
	
	@RequestMapping(value="/api/customer/cart/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pedido> getCustomerCart(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.getId()==id) {
			Customer c=customerService.findOne(id);
			return new ResponseEntity<>(c.getMyCart(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/api/customer/myorders/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Pedido>> getCustomerOrders(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.getId()==id) {
			Customer c=customerService.findOne(id);
			return new ResponseEntity<>(c.getMyOrders(),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
	
	@RequestMapping(value="/api/editCustomer", method=RequestMethod.PUT)
	public ResponseEntity<Customer> EditCustomer(
			@RequestBody Customer updatedCustomer) {
		
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		
			if(!updatedCustomer.getFirstName().equals("")) {
				uLogged.setFirstName(updatedCustomer.getFirstName());
				customerService.save(uLogged); 
			}
		
			if(!updatedCustomer.getLastName().equals("")) {
				uLogged.setLastName(updatedCustomer.getLastName());
				customerService.save(uLogged); 
			}
			if(!updatedCustomer.getMail().equals("")) {
				uLogged.setMail(updatedCustomer.getMail()); 
				customerService.save(uLogged); 
				
			}
			if(!updatedCustomer.getAddress().equals("")) {
				uLogged.setAddress(updatedCustomer.getAddress());
				customerService.save(uLogged);  
				
			}
			
			if (updatedCustomer.getTelephone()!=0) {
				uLogged.setTelephone(Long.valueOf(updatedCustomer.getTelephone()).longValue());;
				customerService.save(uLogged);  
				
			}
			if(updatedCustomer.getImageUrl().equals("")) {
				uLogged.setImageUrl("../../../../imgProfile/"+updatedCustomer.getImageUrl());
				customerService.save(uLogged);
			}
			return new ResponseEntity<>(uLogged,HttpStatus.OK);
	
		
		
	}
	
	@RequestMapping(value="/api/admin/deleteCustomer/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> DeleteCustomer(@PathVariable long id){
		Customer toDelete = customerService.findOne(id);
		
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if(uLogged.getRoles().contains("ROLE_ADMIN")){
		//Implementar
			List<Comment> commentstodelete = commentService.findByCustomer(toDelete);
			
			commentService.delete(commentstodelete);

			customerService.delete(toDelete);

			
			return new ResponseEntity<>("User " + toDelete.getFirstName() +" deleted",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}	
}
