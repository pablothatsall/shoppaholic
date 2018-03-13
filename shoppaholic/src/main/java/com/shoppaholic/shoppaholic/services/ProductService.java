package com.shoppaholic.shoppaholic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.ProductRepository;



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
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public void delete(long id) {
		productRepository.delete(id);
	}
	
	public Page<Product>findByPrice(double price , Pageable page){
		return productRepository.findByPrice(price,page);
	}
	
	public Page<Product>findByLabel(String label,Pageable page){
		return productRepository.findByLabel(label,page);
	}
	
	public Page<Product>findByDescription(String description,Pageable page){
		return productRepository.findByDescription(description,page);
	}
	
	public Page<Product>findByImageUrl(String imageUrl,Pageable page){
		return productRepository.findByImageUrl(imageUrl,page);
	}
	
	public Page<Product>findByScore(int score,Pageable page){
		return productRepository.findByScore(score,page);
	}
	
	public Page<Product>findTop5ByOrderByScoreDesc(Pageable page){
		return productRepository.findTop5ByOrderByScoreDesc(page);
	}
	
	public Page<Product> findByLabelOrderByScoreDesc(String label,Pageable page){
		return productRepository.findByLabel(label,page);
	}
	
	
}
