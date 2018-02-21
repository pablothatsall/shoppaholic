package com.shoppaholic.shoppaholic;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Product{
	public interface Basic {}
	
	public interface Customers{}
	
	public interface Orders{}
	
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
	
		protected Product() {
		// Used by SpringData
	}

	public Product(String name, double price, String description, String label, String pDate, String imageUrl) {
		this.name = name;
		this.price = price;
        this.description = description;
        this.label = label;
        this.pDate = pDate;
        this.imageUrl = imageUrl;
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

	@Override
	public String toString() {
		return String.format("Product[id=%d, name='%s',price='%s', description='%s', label='%s', pDate='%s', telephone='%s' ]",id, name, price, description, label, pDate);
	}
}