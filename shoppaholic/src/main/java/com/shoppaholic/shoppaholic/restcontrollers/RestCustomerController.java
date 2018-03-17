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
	
	@RequestMapping(value="/api/customer/{id}", method=RequestMethod.GET)
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.getId()==id) {
		Customer c=customerService.findOne(id);
		return new ResponseEntity<>(c,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
	
	@RequestMapping(value="/api/editCustomer/id}", method=RequestMethod.PUT)
	public ResponseEntity<Customer> EditCustomer(@PathVariable long id,
			@RequestParam(value = "userfirstname", defaultValue = "") String userfirstname,
			@RequestParam(value = "userlastname", defaultValue = "") String userlastname,
			@RequestParam(value = "usermail", defaultValue = "") String usermail,
			@RequestParam(value = "useraddress", defaultValue = "") String useraddress,
			@RequestParam(value = "usertelephone", defaultValue = "") String usertelephone,
			@RequestParam(value = "file", defaultValue = "") String file) {
		
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.isIdLogged()&& uLogged.getId()==id) {
		if(!userfirstname.equals("")) {
			uLogged.setFirstName(userfirstname);
			customerService.save(uLogged); 
		}
		
		if(!userlastname.equals("")) {
			uLogged.setLastName(userlastname);
			customerService.save(uLogged); 
		}
		if(!usermail.equals("")) {
			uLogged.setMail(usermail); 
			customerService.save(uLogged); 
			
		}
		if(!useraddress.equals("")) {
			uLogged.setAddress(useraddress);
			customerService.save(uLogged);  
			
		}
		
		if(!usertelephone.equals("")) {
			uLogged.setTelephone(Long.valueOf(usertelephone).longValue());;
			customerService.save(uLogged);  
			
		}
		if(!file.equals("")) {
			uLogged.setImageUrl("../../../../imgProfile/"+file);
			customerService.save(uLogged);
		}
		return new ResponseEntity<>(uLogged,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value="/api/deleteCustomer/{id}", method=RequestMethod.DELETE)
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
