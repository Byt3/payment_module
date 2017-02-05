package com.shoparound.managers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.shoparound.models.ISeller;
import com.shoparound.models.StripeAuthResponse;
import com.shoparound.services.SellerService;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;

@Service
public class StripeManager {

	private static Logger logger = Logger.getLogger(StripeManager.class);
	
	@Value("${stripe.client_secret}")
	private String CLIENT_SECRET;
	
	@Autowired
	private SellerService negozianteService;
	


	public String createCustomer(String fullName, String email, String stripeToken) {
	
		String customerId = null;
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("description", fullName);
		customerParams.put("email",email);
		customerParams.put("source",stripeToken);
		
		try {
			
			RequestOptions options = RequestOptions.builder().setApiKey(CLIENT_SECRET).build();
			
			Customer customerStripe = Customer.create(customerParams, options);
			customerId = customerStripe.getId();
			logger.info("ID: " +customerId);
			return customerStripe.getId();
		} catch (Exception e) {
			logger.error("createCustomer", e);
		}
		return customerId;
		
	}
	
	public void sendPaymentToCustomer(String customerId, Integer amount) {
		// Set your secret key: remember to change this to your live secret key in production
		// See your keys here: https://dashboard.stripe.com/account/apikeys
		
		// Charge the user's card:
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", amount); //centesimi
		params.put("currency", "eur");
		params.put("description", "Example charge");
		params.put("customer", customerId);

		try {
			RequestOptions options = RequestOptions.builder().setApiKey(CLIENT_SECRET).build();
			Charge charge = Charge.create(params, options);
			
		} catch (Exception e) {
			logger.error("sendPayment", e);
		} 
	}
	
	public void sendPaymentWithCard(String token, Integer amount) {
		
		// Charge the user's card:
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", amount); //centesimi
		params.put("currency", "eur");
		params.put("description", "Example charge");
		params.put("source", token);

		try {
			RequestOptions options = RequestOptions.builder().setApiKey(CLIENT_SECRET).build();
			Charge charge = Charge.create(params);
			
		} catch (Exception e) {
			logger.error("sendPayment", e);
		} 
	}

	
	public void createCreditCard(String stripeCustomerId, String stripeToken) {
		
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("source", stripeToken);
		
		try {
			
			RequestOptions options = RequestOptions.builder().setApiKey(CLIENT_SECRET).build();
			Customer cu = Customer.retrieve(stripeCustomerId, options);
			cu.update(customerParams, options);
			
		} catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
				| APIException e) {
			logger.error("createCreditCard", e);
		}
		
	}
	
	/* Standalone account creation for seller
	 * */
	@Value("${stripe.oauth.token.url}")
	private String TOKEN_URL;

	public void storeStripeUserId(String code) {

		try {
			RestTemplate restTemplate = new RestTemplate();

			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("client_secret", CLIENT_SECRET);
			map.add("grant_type", "authorization_code");
			map.add("code", code);
			

			ResponseEntity<StripeAuthResponse> response = restTemplate.postForEntity(TOKEN_URL, map, StripeAuthResponse.class);

			StripeAuthResponse stripeResponse = response.getBody();
			
			//TODO: get seller information to retrieve email and link to existing seller data

			ISeller negoziante = negozianteService.findOrCreate(stripeResponse.getStripeUserId());
			negoziante.setStripeId(stripeResponse.getStripeUserId());
			negoziante.setStripeToken(stripeResponse.getAccessToken());
			negoziante.setStripeRefreshToken(stripeResponse.getRefreshToken());
			negozianteService.save(negoziante);
			
		} catch (Exception e) {
			logger.error("storeStripeUserId", e);
		}

	}
	
}
