package com.shoppaholic.shoppaholic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
    private double price;
	private String description;
    private String imageUrl;
    private String label;
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