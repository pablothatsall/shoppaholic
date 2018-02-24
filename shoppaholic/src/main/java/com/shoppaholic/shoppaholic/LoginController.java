package com.shoppaholic.shoppaholic;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private CustomerComponent customerComponent;
 
	@RequestMapping("/logIn")
	public ResponseEntity<Customer> logIn() {

		if (!customerComponent.isLoggedUser()) {
			log.info("Not user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			Customer loggedUser = customerComponent.getLoggedUser();
			log.info("Logged as " + loggedUser.getMail());
			return new ResponseEntity<>(loggedUser, HttpStatus.OK);
		}
	}

	@RequestMapping("/logout")
	public ResponseEntity<Boolean> logOut(HttpSession session) {

		if (!customerComponent.isLoggedUser()) {
			log.info("No user logged");
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			session.invalidate();
			log.info("Logged out");
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
	}

}