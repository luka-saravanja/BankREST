package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;

import antlr.collections.List;

public interface UserService {
	User findByUsername(String username);
	
	
	public void save(User user);
	
	
}


