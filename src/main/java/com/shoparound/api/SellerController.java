package com.shoparound.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoparound.managers.StripeManager;
import com.shoparound.models.IUser;
import com.shoparound.models.User;
import com.shoparound.services.UserService;

@RestController
@RequestMapping("/sellers")
public class SellerController {

	private static Logger logger = Logger.getLogger(SellerController.class);

	
	@Autowired
	private StripeManager stripeManager;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void createCustomer(@RequestParam("name") String name,
			@RequestParam("surname") String surname,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("stripeToken") String stripeToken) {
		
		String fullName = name + " "+surname;
		String email = username;
		IUser user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setPassword(password);
		user.setUsername(username);
		user = userService.save(user);
		
		String customerId = stripeManager.createCustomer(fullName, email, stripeToken);
		if(customerId != null) {
			user.setStripeId(customerId);
			user = userService.save(user);
		}
		
	}
	

	
	/*
	 * connector url to get token
	 * https://connect.stripe.com/oauth/authorize?response_type=code&client_id=ca_A3W3a5yBazqhcc3o3ngnGM1JOdmuXjfC&scope=read_write
	 * 
	 */
	//TODO: add parameters to identify seller?
	@RequestMapping(value = "/stripe/confirm")
	public void confirmUser(@RequestParam("code") String code) {
		logger.info("Code: " + code);
		stripeManager.storeStripeUserId(code);
	}
	
}
