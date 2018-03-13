package com.shoppaholic.shoppaholic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Customer;
import com.shoppaholic.shoppaholic.repositories.CustomerRepository;
@Service
public class CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer findOne(long id) {
		return customerRepository.findById(id);
	}
	
	public List<Customer> findByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}
	
	public List<Customer> findByFirstName(String firstName) {
		return customerRepository.findByFirstName(firstName);
	}
	
	public List<Customer> findByAddress(String address) {
		return customerRepository.findByAddress(address);
	}
	
	public Customer findByMail(String mail) {
		return customerRepository.findByMail(mail);
	}
	
	public List<Customer> findByTelephone(long telephone) {
		return customerRepository.findByTelephone(telephone);
	}
	
	public List<Customer> findByImageUrl(String imageUrl) {
		return customerRepository.findByImageUrl(imageUrl);
	}
	
}
