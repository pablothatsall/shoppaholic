/*package com.shoppaholic.shoppaholic;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;



	@Component
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public class UserComponent {
 
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
			return customer.getId();
		}

	}
	 */

