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
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.CommentRepository;



@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	public List<Comment>findByCustomer(Customer customer){
		return commentRepository.findByCustomer(customer);
	}
	
	public List<Comment>findByProduct(Product product){
		return commentRepository.findByProduct(product);
	}
	
	public void save(Comment comment) {
		commentRepository.save(comment);
	}
	
	public void delete(List<Comment> comments) {
		commentRepository.delete(comments);
	}
	
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
}
