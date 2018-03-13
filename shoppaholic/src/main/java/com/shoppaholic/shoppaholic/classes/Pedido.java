package com.shoppaholic.shoppaholic.classes;


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
import com.shoppaholic.shoppaholic.classes.Product.Basic;

import java.util.List;
import java.util.Date;

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
		java.util.Date fecha = new Date();
		this.date = fecha.toGMTString();
	} 


 

	public Pedido(String status, String user, String date, List<Product> productsofPedido) {
		super();
		
		this.status = status;
		this.user = user;
		this.date = date;
		this.productsofPedido = productsofPedido;
		calculaprecio();
	}


	public void calculaprecio() {
        int suma=0;
        int x=this.getProductsofPedido().size();
        for (int i=0;i<x;i++){
            suma+=this.getProductsofPedido().get(i).getPrice();
        }
        this.totalPrice = suma;
	
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
    
    public void deleteProduct(Product product) {
    	this.productsofPedido.remove(product);
    }
    
	public List<Product> getProductsofPedido() {
		return productsofPedido;
	}


	


	public void setStatus(String status) {
		this.status = status;
	}




	public void setProductsofPedido(List<Product> productsofPedido) {
		this.productsofPedido = productsofPedido;
	}




	@Override
	public String toString() {
		return String.format("Customer[id=%d, list='%s', totalPrice='%s', status='%s', user='%s', date='%s' ]",id, productsofPedido , totalPrice, status, user, date);
	}
}