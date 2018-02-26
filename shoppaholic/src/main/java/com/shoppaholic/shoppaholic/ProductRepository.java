package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;


public interface ProductRepository extends JpaRepository<Product, Long> {

	Page <Product> findByName(String name, @PageableDefault(size = 8) Pageable page);
	Page <Product> findByNameContaining(String name, @PageableDefault(size = 8) Pageable page);
	List <Product> findByName(String name);

	Product findProductByName(String name);
	Product findById(long id);
	
	Page <Product> findByPrice(double price, @PageableDefault(size = 8) Pageable page);
	
	Page <Product> findByLabel(String label, @PageableDefault(size = 8) Pageable page);
	
	Page <Product> findByDescription(String description, @PageableDefault(size = 8) Pageable page);
	
	Page <Product> findByImageUrl(String imageUrl, @PageableDefault(size = 8) Pageable page);
	
}  