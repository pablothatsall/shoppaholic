/*package com.shoppaholic.shoppaholic;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 @Override
 protected void configure(HttpSecurity http) throws Exception {

 // Public pages
 http.authorizeRequests().antMatchers("/").permitAll();
 http.authorizeRequests().antMatchers("/login").permitAll();
 http.authorizeRequests().antMatchers("/loginerror").permitAll();
 http.authorizeRequests().antMatchers("/logout").permitAll();
 http.authorizeRequests().antMatchers("/userprofile").permitAll();
 http.authorizeRequests().antMatchers("/signUp").permitAll();
 http.authorizeRequests().antMatchers("/product/{id}").permitAll();
 http.authorizeRequests().antMatchers("/search").permitAll();
 http.authorizeRequests().antMatchers("/payment").permitAll();
 http.authorizeRequests().antMatchers("/orderlist").permitAll();
 http.authorizeRequests().antMatchers("/order/{id}").permitAll();
 http.authorizeRequests().antMatchers("/list").permitAll();
 http.authorizeRequests().antMatchers("/editprofile").permitAll();
 http.authorizeRequests().antMatchers("/cart").permitAll();
 http.authorizeRequests().antMatchers("/orderlist").permitAll();
 http.authorizeRequests().antMatchers("/admin/addProduct").hasAnyRole("ADMIN");;
 http.authorizeRequests().antMatchers("/admin/manageUser").hasAnyRole("ADMIN");;
 // Private pages (all other pages)

 http.authorizeRequests().anyRequest().authenticated();
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
 http.csrf().disable();
 }
}*/