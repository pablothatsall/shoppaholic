package com.shoppaholic.shoppaholic;


import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.Product.Basic;

import java.util.List;

@Entity
public class Pedido {
	public interface Basic {}
	
	public interface Customers{}
	
	public interface Products{}
	
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	@JsonView(Basic.class)
		private double totalPrice;
	@JsonView(Basic.class)
    	private String status;
	@JsonView(Basic.class)
    	private String user;
	@JsonView(Basic.class)
    	private String date;
	@JsonView(Products.class)
	@ManyToMany
		private List<Product> productsofPedido = new ArrayList<>();
	protected Pedido() {
		// Used by SpringData
	}





	public Pedido(double totalPrice, String status, String user, String date, List<Product> productsofPedido) {
		super();
		this.totalPrice = totalPrice;
		this.status = status;
		this.user = user;
		this.date = date;
		this.productsofPedido = productsofPedido;
	}






	public List<Product> getList() {
		return productsofPedido;
	}

    public String getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }
    public void addProduct(Product product) {
    	this.productsofPedido.add(product);
    }
    
    
    
	public List<Product> getProductsofPedido() {
		return productsofPedido;
	}




	public void setProductsofPedido(List<Product> productsofPedido) {
		this.productsofPedido = productsofPedido;
	}





	@Override
	public String toString() {
		return String.format("Customer[id=%d, list='%s', totalPrice='%s', status='%s', user='%s', date='%s' ]",id, productsofPedido , totalPrice, status, user, date);
	}
}