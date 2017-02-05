package com.shoparound.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shoparound.models.ISeller;
import com.shoparound.models.Seller;

public interface SellerRepository extends PagingAndSortingRepository<Seller, Long>{

	ISeller findOneByStripeId(String stripeUserId);

}
