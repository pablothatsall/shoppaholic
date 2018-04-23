package com.shoppaholic.shoppaholic.classes;

import java.util.ArrayList;
import java.util.Arrays;
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
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Customer {
	public interface Basic {
	}

	public interface Orders {
	}

	public interface Products {
	}
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonView(Basic.class)
	private String firstName;
	@JsonView(Basic.class)
	private String lastName;
	@JsonView(Basic.class)
	private String mail;
	private String password;
	@JsonView(Basic.class)
	private String address;
	@JsonView(Basic.class)
	private long telephone;
	@JsonView(Basic.class)
	private String imageUrl;
	@JsonView(Orders.class)
	@OneToMany
	private List<Pedido> myOrders = new ArrayList<>();
	@OneToOne
	private Pedido myCart;
	@JsonView(Basic.class)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	private boolean idLogged;

	protected Customer() {
		// Used by SpringData
	}

	public Customer(String firstName) {
		this.firstName=firstName;
		// Used by SpringData
	}
	
	public Customer(String firstName, String lastName, String mail, String password, String address, long telephone,
			String imageUrl, List<Pedido> myOrders, Pedido cart, String... roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password =  new BCryptPasswordEncoder().encode(password);
		this.address = address;
		this.telephone = telephone;
		this.imageUrl = imageUrl;
		this.myOrders = myOrders;
		this.myCart = cart;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public long getIdCustomer() {
		return id;
	}

	public void setIdCustomer(long id_customer) {
		this.id = id_customer;
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

	public List<Pedido> getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(List<Pedido> myOrders) {
		this.myOrders = myOrders;
	}

	public Pedido getMyCart() {
		return myCart;
	}

	public void setMyCart(Pedido myCart) {
		this.myCart = myCart;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public boolean idLogged() {
		return idLogged;
	}
	
	 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isIdLogged() {
		return idLogged;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setIdLogged(boolean isIdLogged) {
		this.idLogged = isIdLogged;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail
				+ ", password=" + password + ", address=" + address + ", telephone=" + telephone + ", imageUrl="
				+ imageUrl + ", myOrders=" + myOrders + ", myCart=" + myCart + ", roles=" + roles + ", idLogged="
				+ idLogged + "]";
	}


}