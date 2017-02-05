package com.shoparound.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoparound.models.IUser;
import com.shoparound.models.User;
import com.shoparound.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public IUser findOrCreate(String stripeUserId) {
		IUser user = repository.findOneByStripeId(stripeUserId);
		if(user == null) {
			user = new User();
		}
		return user;
	}

	public IUser save(IUser user) {
		return repository.save((User) user);
	}

	public IUser get(Long userId) {
		return repository.findOne(userId);
	}
	
	
	
}
