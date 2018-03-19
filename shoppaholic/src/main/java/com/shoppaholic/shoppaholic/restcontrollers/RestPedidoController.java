package com.shoppaholic.shoppaholic.restcontrollers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.PedidoRepository;
import com.shoppaholic.shoppaholic.security.CustomerComponent;
import com.shoppaholic.shoppaholic.services.CommentService;
import com.shoppaholic.shoppaholic.services.CustomerService;
import com.shoppaholic.shoppaholic.services.PedidoService;
import com.shoppaholic.shoppaholic.services.ProductService;


	@RestController
	public class RestPedidoController {

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
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@RequestMapping(value="/api/order/{id}", method=RequestMethod.GET)
		public ResponseEntity<Pedido> getOrder( @PathVariable long id) {
			Customer uLogged = customerService.findOne(customerComponent.getIdLoggedUser());
			 if (pedidoService.findByUser(uLogged.getFirstName()).contains(pedidoService.findById(id))) {
			
				Pedido p = pedidoService.findById(id);
				
					
						 return new ResponseEntity<>(p,HttpStatus.OK);
					
				
			}
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		@RequestMapping(value="/api/paycart", method=RequestMethod.POST)
		public ResponseEntity <List<Pedido>> addPedido() throws Exception {
			Customer uLogged = customerService.findOne(customerComponent.getIdLoggedUser());
			java.util.Date fechacarrito= new Date();
			List<Product> newcart=  new ArrayList<>();
			uLogged.getMyCart().setStatus("Paid");
			Pedido newOrder = new Pedido("Pending",uLogged.getFirstName(),fechacarrito.toGMTString(),newcart);
			pedidoRepository.save(newOrder);
			//Empties the cart after an order is performed
			/*for (Product pr: uLogged.getMyCart().getProductsofPedido()) {
				uLogged.getMyCart().deleteProduct(pr);
			}*/
	
			uLogged.setMyCart(newOrder);
			uLogged.getMyOrders().add(uLogged.getMyCart());
			customerService.save(uLogged);
			return new ResponseEntity<>(uLogged.getMyOrders(),HttpStatus.CREATED);
		}
}
