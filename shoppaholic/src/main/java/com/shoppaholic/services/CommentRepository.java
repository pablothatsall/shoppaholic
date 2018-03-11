package com.shoppaholic.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.shoppaholic.shoppaholic.*;



@Service
public class CommentRepository {
	
	@Autowired
	CommentRepository commentRepository;
	
	List<Comment>findByCustomer(Customer customer){
		return commentRepository.findByCustomer(customer);
	}
	
	List<Comment>findByProduct(Product product){
		return commentRepository.findByProduct(product);
	}
	
}
