package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findById(long id);
	
	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
	
	List<Customer> findByAddress(String address);
	
	
	
	Customer findByMail(String mail); 
	
	List<Customer> findByTelephone(long telephone);
	
	List<Customer> findByImageUrl(String imageUrl);
	
}   