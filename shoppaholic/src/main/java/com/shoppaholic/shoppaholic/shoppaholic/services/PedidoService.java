package com.shoppaholic.shoppaholic.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Pedido;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.repositories.PedidoRepository;



@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido findById(long id) {
		return pedidoRepository.findById(id);
	}
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}
	
	public List<Pedido>findByTotalPrice(double price){
		return pedidoRepository.findByTotalPrice(price);
	}
	
	public List<Pedido> findByStatus(String status) {
		return pedidoRepository.findByStatus(status);
	}
	
	public List<Pedido> findByUser(String user) {
		return pedidoRepository.findByUser(user);
	}
	
	public List<Pedido> findByDate(String date) {
		return pedidoRepository.findByDate(date);
	}
	
	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void delete(long id) {
		pedidoRepository.delete(id);
	}
}
