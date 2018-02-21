package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByName(String name);
	
	List<Product> findById(Long id);
	
	List<Product> findByPrice(double price);
	
	List<Product> findByLabel(String label);
	
	List<Product> findByDescription(String description);
    
	List<Product> findByImageUrl(String imageUrl);
	
}