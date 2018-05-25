package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/registration")
	private User createUser(@Valid @RequestBody User user)
	
	{
		userService.saveUser(user);
		return this.userRepository.findByUsername(user.getUsername());
	}
	
}
