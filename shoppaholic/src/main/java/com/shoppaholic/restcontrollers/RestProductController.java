package com.shoppaholic.restcontrollers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.services.*;
import com.shoppaholic.shoppaholic.*;

@RestController
public class RestProductController {

	@Autowired
	private ProductService productService;

	//NOT WORKING BTW
	@RequestMapping("/api/product/{id}")
	public ResponseEntity<Product> getArtistSongs(@PathVariable long id) throws Exception{
		Product p=productService.findOne(id);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}


}
 