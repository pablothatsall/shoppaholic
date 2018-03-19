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
		
		@RequestMapping(value="/api/order/{idC}/{idP}", method=RequestMethod.GET)
		public ResponseEntity<Pedido> getCustomer(@PathVariable long idC, @PathVariable long idP) {
			Customer uLogged = customerService.findOne(customerComponent.getIdLoggedUser());
			if (uLogged.getId() == idC) {
				//List<Pedido> pedidos= uLogged.getMyOrders();
				List<Pedido> ps = pedidoService.findByUser(uLogged.getFirstName());
				Pedido p = null;
				for (Pedido ped: ps) {
					if (ped.getId() == idP) {
						 p = ped;
						 return new ResponseEntity<>(p,HttpStatus.OK);
					}
				}
			}
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		@RequestMapping(value="/api/createorder", method=RequestMethod.POST)
		public ResponseEntity<Pedido> addPedido() throws Exception {
			Customer uLogged = customerService.findOne(customerComponent.getIdLoggedUser());
			java.util.Date fechacarrito= new Date();
			List<Product> newcart=  new ArrayList<>();
			uLogged.getMyCart().setStatus("Paid");
			Pedido newOrder = new Pedido("Pending",uLogged.getFirstName(),fechacarrito.toGMTString(),newcart);
			uLogged.setMyCart(newOrder);
			pedidoRepository.save(newOrder);
			//Empties the cart after an order is performed
			/*for (Product pr: uLogged.getMyCart().getProductsofPedido()) {
				uLogged.getMyCart().deleteProduct(pr);
			}*/
			pedidoService.save(newOrder);
			return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
		}
}
