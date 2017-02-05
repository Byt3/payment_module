package com.shoparound.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shoparound.models.Shop;

public interface ShopRepository extends PagingAndSortingRepository<Shop, Long>{

	

}
