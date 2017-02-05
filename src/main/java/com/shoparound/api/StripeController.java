package com.shoparound.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoparound.managers.StripeManager;
import com.shoparound.models.IUser;
import com.shoparound.services.UserService;

@RestController
@RequestMapping("/stripe")
public class StripeController {

	private static Logger logger = Logger.getLogger(StripeController.class);

	@Autowired
	private StripeManager stripeManager;
	
	@Autowired
	private UserService userService;



	/**
	 * 
	 * @param userId custom app parameter sent from app form
	 * @param stripeToken token idenfier for card details
	 * @param stripeTokenType
	 * @param stripeEmail
	 */
	@RequestMapping(value = "/sendPayment")
	public void sendPayment(
			@RequestParam("userId") Long userId,
			@RequestParam("amount") Integer amount) {
		logger.info("UserID: " +userId);
		
		IUser user = userService.get(userId);
		
		stripeManager.sendPaymentToCustomer(user.getStripeId(), amount);
	}

	/**
	 * 
	 * @param userId custom app parameter sent from app form
	 * @param stripeToken token idenfier for card details
	 * @param stripeTokenType
	 * @param stripeEmail
	 */
	@RequestMapping(value = "/sendPaymentWithCard")
	public void sendPaymentWithCard(
			@RequestParam("amount") Integer amount,
			@RequestParam("stripeToken") String stripeToken,
			@RequestParam("stripeTokenType") String stripeTokenType,
			@RequestParam("stripeEmail") String stripeEmail
			) {

		stripeManager.sendPaymentWithCard(stripeToken, amount);
	}

}
