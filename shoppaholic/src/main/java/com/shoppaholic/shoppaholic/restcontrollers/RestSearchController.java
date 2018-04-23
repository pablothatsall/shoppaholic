package com.shoppaholic.shoppaholic.restcontrollers;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.security.CustomerComponent;
import com.shoppaholic.shoppaholic.services.*;

@RestController
public class RestSearchController {
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
		
	@RequestMapping(value="/api/searchlabel/{labelname}/{npage}")
	public ResponseEntity<Page<Product>> SearchByLabel (@PathVariable String labelname, @PageableDefault(size = 8) Pageable page,  @PathVariable int npage){
		if (npage > 1) {
			int aux = npage;
			while (aux!=1) {
			page = page.next();
			aux= aux-1;
			}
		}
		return new ResponseEntity<>(productService.findByLabel(labelname, page),HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/api/searchname/{name}/{npage}")
	public ResponseEntity<List<Product>> SearchByName (@PathVariable String name, @PageableDefault(size = 8) Pageable page, @PathVariable int npage){
		if (npage > 1) {
			int aux = npage;
			while (aux!=1) {
			page = page.next();
			aux= aux-1;
			}
		}
		List<Product> labels = productService.findByLabel(name, page).getContent();
		List<Product> names = productService.findByNameContaining("%" + name + "%");
		names.addAll(labels);
		return new ResponseEntity<>(names,HttpStatus.OK);
		
		
	}
}
 