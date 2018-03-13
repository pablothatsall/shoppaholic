package com.shoppaholic.shoppaholic.security;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.shoppaholic.shoppaholic.classes.Customer;



	@Component
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public class CustomerComponent {
  
		private Customer customer;

		public Customer getLoggedUser() {
			return customer;
		}    
		  
		public void setLoggedUser(Customer customer) {
			this.customer = customer;
		}

		public boolean isLoggedUser() {
			return this.customer != null;
		}
		
		public long getIdLoggedUser(){
			return customer.getIdCustomer();
		}
		  
	}
	 
 