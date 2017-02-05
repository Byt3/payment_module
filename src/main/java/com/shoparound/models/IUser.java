package com.shoparound.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=User.class)
public interface IUser extends Pojo {

	
	void setPassword(String password);

	String getPassword();

	void setUsername(String username);

	String getUsername();

	void setStripeId(String stripeId);

	String getStripeId();

	void setSurname(String surname);

	String getSurname();

	void setName(String name);

	String getName();

	

}
