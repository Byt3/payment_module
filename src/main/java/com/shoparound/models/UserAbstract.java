package com.shoparound.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserAbstract extends EntityAbstract implements IUser {

	private String name;
	private String surname;
	@Column(name="stripe_id")
	private String stripeId;
	private String username;
	private String password;

	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getSurname() {
		return surname;
	}
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String getStripeId() {
		return stripeId;
	}
	@Override
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
}
