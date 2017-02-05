package com.shoparound.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=Shop.class)
public interface IShop extends Pojo {

	
	
}
