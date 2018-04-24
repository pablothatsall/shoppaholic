package com.shoppaholic.shoppaholic.restcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.fasterxml.jackson.annotation.JsonView;
import com.shoppaholic.shoppaholic.*;
import com.shoppaholic.shoppaholic.classes.Product;
import com.shoppaholic.shoppaholic.security.UserRepositoryAuthenticationProvider;
import com.shoppaholic.shoppaholic.services.*;

@Configuration
@Order(1)
public class RestSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider userRepoAuthProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/api/**");
		
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/logIn").authenticated();
		
		// URLs that need authentication to access to it
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/customers").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/editCustomer/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/order/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/deleteFromCart/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addToCart/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/paycart/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/myorders/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addnewcomment/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/customer/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/editcustomer/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/newcomment/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/products").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/productGetComments/{id}").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/topproducts/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/toplabelproducts/**").hasRole("USER");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/admin/**").hasRole("ADMIN");
		
		// Other URLs can be accessed without authentication
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/login").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/product/{id}").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/products").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/topproducts").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/comments").permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/firstproducts").permitAll();
		// Disable CSRF protection (it is difficult to implement with ng2)
		http.csrf().disable();

		// Use Http Basic Authentication
		http.httpBasic();

		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {	});
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Database authentication provider
		auth.authenticationProvider(userRepoAuthProvider);
	}
}