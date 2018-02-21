package com.shoppaholic.shoppaholic;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Customer {
	public interface Basic {}
	
	public interface Orders{}
	
	public interface Products{}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonView(Basic.class)
	private String firstName;
	@JsonView(Basic.class)
	private String lastName;
	@JsonView(Basic.class)
    private String mail;
	@JsonView(Basic.class)
    private String password;
	@JsonView(Basic.class)
    private String address;
	@JsonView(Basic.class)
    private long telephone;
	@JsonView(Basic.class)
    private String imageUrl;
	@JsonView(Orders.class)
    @OneToMany(cascade = CascadeType.ALL)
	private List<Order> myOrders = new ArrayList<>();
	



	protected Customer() {
		// Used by SpringData
	}

	public Customer(String firstName, String lastName, String mail, String password, String address, long phone, String imageUrl, List<Order> myOrders, String rol) {
		this.firstName = firstName;
		this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.address = address;
        this.telephone = phone;
        this.imageUrl = imageUrl;
        this.telephone = phone;
        this.myOrders = myOrders;
        
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public long getTelephone() {
        return telephone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

	public String getLastName() {
		return lastName;
	}
	
	public List<Order> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<Order> myOrders) {
		this.myOrders = myOrders;
	}
	



	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s', mail='%s', address='%s', telephone='%s' ]",id, firstName, lastName, mail, address, telephone);
	}
}