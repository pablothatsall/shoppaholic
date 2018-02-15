package com.shoppaholic.shoppaholic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product findOne(long id) {
		return productRepository.findOne(id);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	
	public void save(Product products) {
		productRepository.save(products);
	}
	
	
	public void delete(long id) {
		productRepository.delete(id);
	}
	
	public void delete(Product a) {
		productRepository.delete(a);
	}
	
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

	
}
