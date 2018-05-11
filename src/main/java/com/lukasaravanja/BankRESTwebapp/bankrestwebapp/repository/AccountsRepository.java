package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;

@Repository("accountsRepository")
public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
	
	Accounts findByAccountNumber(int accountNumber);

}
