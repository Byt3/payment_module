package com.shoparound.api;

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
@RequestMapping("/users")
public class UserController {

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
	
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public IUser createCustomer(@RequestBody IUser user) {
//		
//		String fullName = user.getName() + " "+user.getSurname();
//		String email = user.getUsername();
//		
//		user = userService.save(user);
//		
//		String customerId = stripeManager.createCustomer(fullName, email);
//		if(customerId != null) {
//			user.setStripeId(customerId);
//			user = userService.save(user);
//		}
//		
//		return user;
//	}
	
}
