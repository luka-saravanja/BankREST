package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/registration")
	private void createUser(@RequestBody User user)
	
	{
		userService.saveUser(user);
	}
}
