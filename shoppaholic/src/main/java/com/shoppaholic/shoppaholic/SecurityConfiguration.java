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
 http.authorizeRequests().antMatchers("/product/{id}").permitAll();
 http.authorizeRequests().antMatchers("/search/{searchtext}").permitAll();
 http.authorizeRequests().antMatchers("/payment").permitAll();
 http.authorizeRequests().antMatchers("/orderlist").permitAll();
 http.authorizeRequests().antMatchers("/register").permitAll();
 
 
 
 // Private pages (all other pages)
 
 http.authorizeRequests().antMatchers("/cart/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/editprofile").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/userprofile/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/editprofile/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/userprofile").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/order/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/orderlist/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/payment/{id}").hasAnyRole("USER");
 http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("ADMIN");
 http.authorizeRequests().antMatchers("/admin/*").hasAnyRole("ADMIN");
 
 
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