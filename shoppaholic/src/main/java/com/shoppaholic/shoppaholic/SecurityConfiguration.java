package com.shoppaholic.shoppaholic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserRepositoryAuthenticationProvider authenticationProvider;
	
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	 http.headers().frameOptions().disable();
		
 // Public pages
	 
 http.authorizeRequests().antMatchers("/").permitAll();
 http.authorizeRequests().antMatchers("/login").permitAll();
 http.authorizeRequests().antMatchers("/loginerror").permitAll();
 http.authorizeRequests().antMatchers("/logout").permitAll();
 http.authorizeRequests().antMatchers("/signUp").permitAll();
 http.authorizeRequests().antMatchers("/product/{id}").permitAll();
 http.authorizeRequests().antMatchers("/search/{searchtext}").permitAll();
 http.authorizeRequests().antMatchers("/payment").permitAll();
 http.authorizeRequests().antMatchers("/orderlist").permitAll();
 http.authorizeRequests().antMatchers("/order/{id}").permitAll();
 http.authorizeRequests().antMatchers("/list").permitAll();
 http.authorizeRequests().antMatchers("/cart/{id}").permitAll();//Esto solo para pruebas, hay que hacerlo privado que solo acceda el registrado
 http.authorizeRequests().antMatchers("/orderlist/{id}").permitAll();
 http.authorizeRequests().antMatchers("/admin/manageUser").permitAll();
 http.authorizeRequests().antMatchers("/admin").permitAll(); 
 http.authorizeRequests().antMatchers("/admin/addproduct").permitAll();
 http.authorizeRequests().antMatchers("/admin/editproduct").permitAll();
 
 
 // Private pages (all other pages)
 
 http.authorizeRequests().antMatchers("/cart").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/editprofile").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/userprofile/{id}").hasAnyRole("USER");
 
 //http.authorizeRequests().antMatchers("/admin/addProduct").hasAnyRole("ADMIN"); 
 //http.authorizeRequests().antMatchers("/admin/manageUser").hasAnyRole("ADMIN");
 //http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
 // Login form
 http.formLogin().loginPage("/login");
 http.formLogin().usernameParameter("email");
 http.formLogin().passwordParameter("password");
 http.formLogin().defaultSuccessUrl("/");
 http.formLogin().failureUrl("/loginerror");
 // Logout
 http.logout().logoutUrl("/logout");
 http.logout().logoutSuccessUrl("/");
 
 // Disable CSRF at the moment
 
 }
 
 @Override
 protected void configure(AuthenticationManagerBuilder auth)
         throws Exception {
     // Database authentication provider
     auth.authenticationProvider(authenticationProvider);
 }

}