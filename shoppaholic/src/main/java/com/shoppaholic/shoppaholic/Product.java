package com.shoppaholic.shoppaholic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product{
	public interface Basic {}
	
	public interface Customers{}
	
	public interface Pedidos{}
	
	@JsonView(Basic.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
	@JsonView(Basic.class)
		private String name;
	@JsonView(Basic.class)
    	private double price;
	@JsonView(Basic.class)
		private String description;
	@JsonView(Basic.class)
		private String imageUrl;
	@JsonView(Basic.class)
		private String label;
	@JsonView(Basic.class)
    	private String pDate;
	@OneToMany
		private List<Comment> comments  = new ArrayList<>();
	
	private boolean idLogged;
	
		protected Product() {
		// Used by SpringData
	}

	public Product(String name, double price, String description, String label, String pDate, String imageUrl, List<Comment> comments) {
		this.name = name;
		this.price = price;
        this.description = description;
        this.label = label;
        this.pDate = pDate;
        this.imageUrl = imageUrl;
        this.comments = comments;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getPdate() {
        return pDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    
	public boolean isIdLogged() {
		return idLogged;
	}

	public void setIdLogged(boolean idLogged) {
		this.idLogged = idLogged;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return String.format("Product[id=%d, name='%s',price='%s', description='%s', label='%s', pDate='%s', telephone='%s' ]",id, name, price, description, label, pDate);
	}
}