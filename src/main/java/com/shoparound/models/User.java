package com.shoparound.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends UserAbstract implements IUser {

	
	
}
