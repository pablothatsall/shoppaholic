package com.shoppaholic.shoppaholic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String list;
	private double totalPrice;
    private String status;
    private String user;
    private String date;

	protected Order() {
		// Used by SpringData
	}

	public Order(String list, String status, String user, String date, double totalPrice) {
		this.list = list;
		this.totalPrice = totalPrice;
        this.status = status;
        this.user = user;
        this.date = date;
	}

	public String getList() {
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

	@Override
	public String toString() {
		return String.format("Customer[id=%d, list='%s', totalPrice='%s', status='%s', user='%s', date='%s' ]",id, list, totalPrice, status, user, date);
	}
}