package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.AccountsRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private AccountsRepository accountsRepository;

	@Autowired
	private UserRepository userRepository;

	public void depositMoney(int accountNumber, double amount) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());

		Accounts account = accountsRepository.findByAccountNumber(accountNumber);
		if (Objects.isNull(account))
			throw new NullPointerException("There is no account with that id");
		else if (!account.getUser().equals(user))
			throw new NullPointerException("This is not your account");
		account.setAccountBalance(account.getAccountBalance() + amount);
		accountsRepository.save(account);

	}

	public void transferMoney(int accountNumberSource, int accountNumberDestination, double amount) {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User userSource = userRepository.findByUsername(authentication.getName());

		Accounts accountSource = accountsRepository.findByAccountNumber(accountNumberSource);
		Accounts accountDestination = accountsRepository.findByAccountNumber(accountNumberDestination);

		if (Objects.isNull(accountSource))
			throw new NullPointerException("There is no account with that id");
		else if (accountSource.getAccountBalance() < amount)
			throw new NullPointerException("You dont have enough money");
		else if (!accountSource.getUser().equals(userSource))
			throw new NullPointerException("You can not use someone else account");

		accountsRepository.withdrawMoney(amount, accountNumberSource);
		accountsRepository.save(accountSource);

		accountsRepository.depositMoney(amount, accountNumberDestination);
		accountsRepository.save(accountDestination);

	}

	public Accounts insertAccount(Accounts account) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User currentUser = this.userRepository.findByUsername(auth.getName());

		account.setUser(currentUser);

		this.accountsRepository.save(account);

		return this.accountsRepository.findByAccountNumber(account.getAccountNumber());

	}
}
