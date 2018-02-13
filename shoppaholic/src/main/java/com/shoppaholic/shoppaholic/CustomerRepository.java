package com.shoppaholic.shoppaholic;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
	
	List<Customer> findByFirstName(String firstName);
    
    List<Customer> findByAddress(String address);
	
	List<Customer> findByPassword(String password);
    
    List<Customer> findByMail(String mail);
	
	List<Customer> findByTelephone(long telephone);
    
    List<Customer> finByImageUrl(String imageUrl);
	
}