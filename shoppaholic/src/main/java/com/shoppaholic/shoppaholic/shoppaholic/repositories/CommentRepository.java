package com.shoppaholic.shoppaholic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppaholic.shoppaholic.classes.Comment;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.classes.Product;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	List<Comment> findByCustomer(Customer customer);
	
	List<Comment> findByProduct(Product product);
	
	 
	
	
}
	  