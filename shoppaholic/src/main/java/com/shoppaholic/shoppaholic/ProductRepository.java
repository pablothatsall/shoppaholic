package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Customer> findByName(String name);
	
	List<Customer> findById(Long id);
	
	List<Customer> findByPrice(double price);
	
	List<Customer> findByLabel(String label);
	
	List<Customer> findByDescription(String description);
    
	List<Customer> findByImageUrl(String imageUrl);
	
}