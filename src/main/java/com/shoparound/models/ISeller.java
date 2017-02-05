package com.shoparound.models;

public interface ISeller extends IUser {

	void setStripeRefreshToken(String stripeRefreshToken);

	String getStripeRefreshToken();

	void setStripeToken(String stripeToken);

	String getStripeToken();
	
}
