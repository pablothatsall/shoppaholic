package com.shoppaholic.shoppaholic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.Customer.Basic;

	
	@Entity
	public class Comment {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		private Customer customer;
		
		private String comment;
		
		private String date;

		public Comment(Customer customer, String comment, String date) {
			super();
			this.customer = customer;
			this.comment = comment;
			this.date = date;
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

		@Override
		public String toString() {
			return "Comment [id=" + id + ", customer=" + customer + ", comment=" + comment + ", date=" + date + "]";
		}
		
		
		

}
	
