package com.shoppaholic.shoppaholic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Customer> findById(Long id);
	
	List<Customer> findByTotalPrice(double totalPrice);
	
	List<Customer> findByStatus(String status);
	
	List<Customer> findByUser(String user);
	
	List<Customer> findByDate(String date);
	
}