package com.shoppaholic.shoppaholic.restcontrollers;
import java.util.Collection;
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
	public Collection<Product> getProducts() {
		return productService.findAll();
	}
	
	@RequestMapping(value="/api/productGetComments/{id}", method=RequestMethod.GET)
	public Collection<Comment> getProductComments(@PathVariable long id) {
		Product p=productService.findOne(id);
		List<Comment> x = commentService.findByProduct(p);
		return x;
	}


	@RequestMapping(value="/api/addProduct", method=RequestMethod.POST)
	public ResponseEntity<Product> AddProduct(
			@RequestBody Product p) throws Exception{
		productService.save(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
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
	
	@RequestMapping(value="/api/editProduct/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Product> EditCustomer(@PathVariable long id,@RequestParam(value = "productnameoriginal", defaultValue = "") String productnameoriginal,
			@RequestParam(value = "productname", defaultValue = "") String productname,
			@RequestParam(value = "productlabel", defaultValue = "") String productlabel,
			@RequestParam(value = "productdescription", defaultValue = "") String productdescription,
			@RequestParam(value = "productprice", defaultValue = "-3") long productprice) {
		Customer uLogged=customerService.findOne(customerComponent.getIdLoggedUser());
		if (uLogged.isIdLogged()&& uLogged.getRoles().contains("ADMIN")){
		Product p=productService.findOne(id);
		
			if (!productname.equals("")){
				
				 productService.findByName(productnameoriginal).setName(productname);
				 productService.save(productService.findByName(productnameoriginal));
			
			}
			
			if (!productlabel.equals("")){
				
				 productService.findByName(productnameoriginal).setLabel(productlabel);
				 productService.save(productService.findByName(productnameoriginal));
			} 
			
			if (!productdescription.equals("")){
				
				 productService.findByName(productnameoriginal).setLabel(productdescription);
				 productService.save(productService.findByName(productnameoriginal));
			} 
			if (productprice != -3){
				
				 productService.findByName(productnameoriginal).setPrice(productprice);
				 productService.save(productService.findByName(productnameoriginal));
			} 
			
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
}
 