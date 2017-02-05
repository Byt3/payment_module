package com.shoparound.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoparound.models.ISeller;
import com.shoparound.models.Seller;
import com.shoparound.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public ISeller findOrCreate(String stripeUserId) {
		ISeller user = repository.findOneByStripeId(stripeUserId);
		if(user == null) {
			user = new Seller();
		}
		return user;
	}

	public ISeller save(ISeller user) {
		return repository.save((Seller) user);
	}

	public ISeller get(Long userId) {
		return repository.findOne(userId);
	}
	
	
	
}
