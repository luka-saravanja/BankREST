package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.AccountsRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.AccountService;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(value = "/user/accounts")
	private  List <Accounts> userAccounts()
	{
		org.springframework.security.core.Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		User user=userRepository.findByUsername(authentication.getName());
		
		 List<Accounts> userAccounts=accountsRepository.findByUser(user);
		 
		 return userAccounts;
		
	}
	
	@DeleteMapping(value = "/user/account")
	private void deleteUserAccount(@RequestParam("accountNumber") int accountNumber)
	{
		org.springframework.security.core.Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		User user=userRepository.findByUsername(authentication.getName());
		
		Accounts userAccount=accountsRepository.findByAccountNumber(accountNumber);
		
		if(userAccount.getUser() != user)
			throw new NullPointerException("This is not your account");
		
		accountsRepository.delete(userAccount);
		
		}
	
	@PostMapping("/user/accounts")
		public Accounts insertAccount(@RequestBody(required=true) Accounts account) {
			return this.accountService.insertAccount(account);
		}
	
	
	@PostMapping("/user/deposit")
	private void depositMoney(@RequestParam("accountNumber") int accountNumber,@RequestParam("amount") double amount)
	{
		accountService.depositMoney(accountNumber, amount);
	}
	
	@PostMapping("/user/transfer")
	private void transferMoney(int accountNumberSource,int accountNumberDestination,double amount)
	{
		accountService.transferMoney(accountNumberSource, accountNumberDestination, amount);
	}
	
//	@PostMapping("/user/account")
//	private void addAccount(@RequestParam("accountNumber") int accountNumber,@RequestParam("accountBalance")double accountBalance)
//	{
//		org.springframework.security.core.Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
//		User user=userRepository.findByUsername(authentication.getName());
//		
//		accountsRepository.createAccount(accountNumber, accountBalance, user.getUserId());
//	}

	
	

	    
	
	
	
}
