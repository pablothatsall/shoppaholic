package com.shoppaholic.shoppaholic.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CommentRepository;



@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	List<Comment>findByCustomer(Customer customer){
		return commentRepository.findByCustomer(customer);
	}
	
	List<Comment>findByProduct(Product product){
		return commentRepository.findByProduct(product);
	}
	
}
