package com.shoparound.models;

import java.util.Date;

import com.shoparound.enums.PaymentStatus;

public interface IPayment {

	void setStatus(PaymentStatus status);

	PaymentStatus getStatus();

	void setTransactionDate(Date transactionDate);

	Date getTransactionDate();

	void setStripeUserId(String stripeUserId);

	String getStripeUserId();

	void setPrice(Double price);

	Double getPrice();

	void setTransactionId(String transactionId);

	String getTransactionId();

	
}
