package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.AccountsRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.AccountService;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.UserService;

@RestController
public class UserController {


	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user/accounts")
	private List<Accounts> userAccounts() {

		List<Accounts> userAccounts = accountsRepository.findByUser(userService.checkUser());

		return userAccounts;

	}

	@DeleteMapping(value = "/user/account")
	private void deleteUserAccount(@RequestParam("accountNumber") int accountNumber) {

		Accounts userAccount = accountsRepository.findByAccountNumber(accountNumber);

		if (userAccount.getUser() != userService.checkUser())
			throw new NullPointerException("This is not your account");

		accountsRepository.delete(userAccount);

	}

	@PostMapping("/user/accounts")
	public Accounts insertAccount(@RequestBody(required = true) Accounts account) {
		return this.accountService.insertAccount(account);
	}

	@PostMapping("/user/deposit")
	private void depositMoney(@RequestParam("accountNumber") int accountNumber, @RequestParam("amount") double amount) {
		accountService.depositMoney(accountNumber, amount);
	}

	@PostMapping("/user/transfer")
	private void transferMoney(@RequestParam("accountNumberSource") int accountNumberSource,
			@RequestParam("accountNumberDestination") int accountNumberDestination,
			@RequestParam("amount") double amount) {
		
		accountService.transferMoney(accountNumberSource, accountNumberDestination, amount);
	}
}
