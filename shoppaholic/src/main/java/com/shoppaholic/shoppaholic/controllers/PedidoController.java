package com.shoppaholic.shoppaholic.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

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
public class PedidoController {
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

@RequestMapping("/order/{id}")
public String orderStart(Model model, @PathVariable long id) {
	Pedido myorder = pedidoRepository.findById(id);

	boolean login=customerComponent.isLoggedUser();
	if(login){
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		
			model.addAttribute("user", uLogged);
	if (myorder.getUser().equals(uLogged.getFirstName())){

	Pedido pedido = pedidoRepository.findOne(id);
	model.addAttribute("pedido", pedido);
	List <Product> productos = pedido.getProductsofPedido();
	model.addAttribute("productos", productos);
	Integer cantidad= productos.size();
	model.addAttribute("cantidad", cantidad);
	}
	}
	else
		return"error"; 
	
	
			
	return "order";
}


@RequestMapping("/payment/{id}")
public String paymentStart(Model model, @PathVariable long id,
		@RequestParam(value = "tarjeta", defaultValue = "") String tarjeta) {
	
	boolean login=customerComponent.isLoggedUser();
	if(login){
		Customer uLogged=customerRepository.findOne(customerComponent.getIdLoggedUser());
		
			model.addAttribute("user", uLogged);
	}
	Customer c= customerRepository.findById(id);
	Pedido p = c.getMyCart();
	
	model.addAttribute("pedido",p);
	if(!p.getStatus().equals("Paid")) {
	if(!tarjeta.equals("")) {
		p.setStatus("Paid");
		pedidoRepository.save(p);

		java.util.Date fechacarrito= new Date();
		List<Product> newcart=  new ArrayList<>();
		Pedido pedidonuevo = new Pedido("Pending",c.getFirstName(),fechacarrito.toGMTString(),newcart);
		c.setMyCart(pedidonuevo);
		pedidoRepository.save(pedidonuevo);
		
		c.setMyCart(pedidonuevo);
	customerRepository.save(c);}}
	
	
	
	return "payment";
}

}