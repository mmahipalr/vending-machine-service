package com.learning.vending.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.learning.vending.common.Password;
import com.learning.vending.jdbcdao.SignUpDao;
import com.learning.vending.model.User;
import com.learning.vending.service.SignUpService;

public class SignUpServiceImpl implements SignUpService{

	@Autowired
	SignUpDao signUpDao;
	
	@Override
	@Transactional
	public int createUser(User user) {
		String hashedPassword = Password.getHashedPassword(user, user.getPassword());
		user.setPassword(hashedPassword);
		return signUpDao.createUser(user);
	}

}
