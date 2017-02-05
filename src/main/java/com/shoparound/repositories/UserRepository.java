package com.shoparound.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shoparound.models.IUser;
import com.shoparound.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

	IUser findOneByStripeId(String stripeUserId);

}
