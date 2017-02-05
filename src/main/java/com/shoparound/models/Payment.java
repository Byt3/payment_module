package com.shoparound.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.shoparound.enums.PaymentStatus;

@Entity
@Table(name="payment")
public class Payment extends EntityAbstract implements IPayment{

	@Column(name="transaction_id")
	private String transactionId;
	public Double price;
	@Column(name="stripe_user_id")
	public String stripeUserId;
	@Column(name="transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Enumerated(EnumType.ORDINAL)
	private PaymentStatus status;
	@Override
	public String getTransactionId() {
		return transactionId;
	}
	@Override
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public Double getPrice() {
		return price;
	}
	@Override
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String getStripeUserId() {
		return stripeUserId;
	}
	@Override
	public void setStripeUserId(String stripeUserId) {
		this.stripeUserId = stripeUserId;
	}
	@Override
	public Date getTransactionDate() {
		return transactionDate;
	}
	@Override
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public PaymentStatus getStatus() {
		return status;
	}
	@Override
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	
	
	
}
