package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
	
	Accounts findByAccountNumber(int accountNumber);

}
