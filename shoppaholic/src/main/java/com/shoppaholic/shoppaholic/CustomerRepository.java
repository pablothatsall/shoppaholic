package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByAddress(String address);
	
	List<Customer> findByPassword(String password);
	
	
	Customer findByMail(String mail); 
	
	List<Customer> findByTelephone(long telephone);
	
	List<Customer> findByImageUrl(String imageUrl);
	
} 