package com.shoppaholic.shoppaholic.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.classes.Customer.Basic;

	
	@Entity
	public class Comment {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		@OneToOne
		private Customer customer;
		
		private String comment;
		
		private String date;
		
		@ManyToOne
		private Product product;
		
		private boolean idLogged;
		
		public Comment() {
			super();
		}

		public Comment(Customer customer, String comment, String date, Product product) {
			super();
			this.customer = customer;
			this.comment = comment;
			this.date = date;
			this.product = product;
		}

		public long getId() {
			return id;
		}


		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		
		
		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		@Override
		public String toString() {
			return "Comment [id=" + id + ", customer=" + customer + ", comment=" + comment + ", date=" + date + "]";
		}
		
		
		

}
	
