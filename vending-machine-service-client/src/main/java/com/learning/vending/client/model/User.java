package com.learning.vending.client.model;

import com.learning.vending.client.metadata.UserType;

import lombok.Data;

@Data
public class User {
	
	
	private Integer id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private UserType type;
	
	private String firstName;
	
	private String lastName;
	
}
