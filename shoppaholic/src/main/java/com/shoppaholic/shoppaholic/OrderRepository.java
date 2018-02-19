package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	List<Customer> findByList(String list);
	
	List<Customer> findByTotalPrice(double totalPrice);
	
	List<Customer> findByStatus(String status);
	
	List<Customer> findByUser(String user);
	
	List<Customer> findByDate(String date);
	
}