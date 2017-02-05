package com.shoparound.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="shop")
public class Shop extends EntityAbstract implements IShop {

	private String email;
	private String sito;
	private String orari;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSito() {
		return sito; 
	}
	public void setSito(String sito) {
		this.sito = sito;
	}
	public String getOrari() {
		return orari;
	}
	public void setOrari(String orari) {
		this.orari = orari;
	}
	
	
}
