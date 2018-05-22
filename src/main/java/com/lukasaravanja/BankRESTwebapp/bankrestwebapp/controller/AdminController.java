package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.AccountsRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;

@RestController
public class AdminController {
	
	@Autowired
	private AccountsRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(value = "/admin/users")
	public List<User> users()
	{
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/admin/accounts")
	public List<Accounts> accounts()
	{
		return accountRepository.findAll();
	}
	
	@DeleteMapping("/admin/users")
	public void deleteUser(@RequestParam("id") Long id)
	{
		org.springframework.security.core.Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		User admin=userRepository.findByUsername(authentication.getName());
		
		if(admin.getUserId() != id)
		{
			User deleteUser=userRepository.findByUserId(id);
			userRepository.delete(deleteUser);
		}
	}
	
	
}
