package com.shoparound.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.shoparound.models.Payment;


public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

}
