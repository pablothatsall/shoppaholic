package com.shoppaholic.shoppaholic.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.shoppaholic.shoppaholic.classes.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	Pedido findById(Long id);
	
	List<Pedido> findByTotalPrice(double totalPrice);
	
	List<Pedido> findByStatus(String status);
	
	List<Pedido> findByUser(String user);
	
	List<Pedido> findByDate(String date);
	
	  
}    