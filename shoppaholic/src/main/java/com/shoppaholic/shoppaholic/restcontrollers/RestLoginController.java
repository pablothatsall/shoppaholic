package com.shoppaholic.shoppaholic.restcontrollers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.services.CommentService;
import com.shoppaholic.shoppaholic.services.CustomerService;
import com.shoppaholic.shoppaholic.services.PedidoService;
import com.shoppaholic.shoppaholic.services.ProductService;
@RestController
public class RestLoginController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value="/api/register" , method=RequestMethod.POST)
	public ResponseEntity<Customer> signIn(@RequestBody Customer customer){
		if(!customer.getFirstName().equals("") && !customer.getLastName().equals("") && !customer.getMail().equals("") && !customer.getPassword().equals("")) {
		java.util.Date fecha = new Date(); 
		List<Product> products = new ArrayList<Product>();
		Pedido newcart = new Pedido("Pending",customer.getFirstName(), fecha.toGMTString(), products);
		pedidoService.save(newcart);
		List<Pedido> newmyorders = new ArrayList<>();
		newmyorders.add(newcart);
		Customer newcustomer= new Customer(customer.getFirstName(), customer.getLastName() , customer.getMail(), customer.getPassword(), customer.getAddress(), Long.valueOf(customer.getTelephone()).longValue(),customer.getImageUrl(),newmyorders , newcart, "ROLE_USER");

		customerService.save(newcustomer);
		return new ResponseEntity<>(newcustomer,HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.PARTIAL_CONTENT);
	}

}
