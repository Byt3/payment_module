package com.shoparound.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="seller")
public class Seller extends UserAbstract implements ISeller{

	@Column(name="stripe_token")
	private String stripeToken;
	@Column(name="stripe_refresh_token")
	private String stripeRefreshToken;
	@ManyToOne(targetEntity=Shop.class)
	@JoinColumn(name="negozio")
	public IShop negozio;
	
	@Override
	public String getStripeToken() {
		return stripeToken;
	}
	@Override
	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}
	@Override
	public String getStripeRefreshToken() {
		return stripeRefreshToken;
	}
	@Override
	public void setStripeRefreshToken(String stripeRefreshToken) {
		this.stripeRefreshToken = stripeRefreshToken;
	}
	
	
}
