package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Customer> findByName(String name);
	
	List<Customer> findByPrice(double price);
    
    List<Customer> findByLabel(String label);
	
	List<Customer> findByDescription(String description);
    
    List<Customer> findByDate(String pDate);
    
    List<Customer> finByImageUrl(String imageUrl);
	
}