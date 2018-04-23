package com.shoppaholic.shoppaholic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppaholic.shoppaholic.classes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findById(long id);
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByAddress(String address);
	
	
	
	
	Customer findByMail(String mail); 
	
	List<Customer> findByTelephone(long telephone);
	
	List<Customer> findByImageUrl(String imageUrl);
	
}   