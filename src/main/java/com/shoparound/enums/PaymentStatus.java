package com.shoparound.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PaymentStatus {

	INSERITO(0),
	PENDING(1),
	COMPLETED(2),
	FAILED(3);
	
	private int value;
	
	PaymentStatus(int value) {
		this.value = value;
	}
	
	@JsonValue
	public int getValue(){
		return value;
	}
	
}
