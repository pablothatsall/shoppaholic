package com.shoppaholic.shoppaholic;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private ArrayList<Product> list;
	private double totalPrice;
    private String status;
    private String user;
    private String date;

	protected Order() {
		// Used by SpringData
	}

	public Order(ArrayList<Product> list, String status, String user, String date, double totalPrice) {
		this.list = list;
		this.totalPrice = totalPrice;
        this.status = status;
        this.user = user;
        this.date = date;
	}

	public ArrayList<Product> getList() {
		return list;
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
    	this.list.add(product);
    }
	@Override
	public String toString() {
		return String.format("Customer[id=%d, list='%s', totalPrice='%s', status='%s', user='%s', date='%s' ]",id, list, totalPrice, status, user, date);
	}
}