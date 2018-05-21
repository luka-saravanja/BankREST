package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void saveUser(User user)
	{	
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		
		
	}
}
