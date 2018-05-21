package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Integer> {
	
	Accounts findByAccountNumber(int accountNumber);
	
	List<Accounts> findByUser(User user);
	
	void delete(Accounts account);
	
	List<Accounts> findAll();
	
	Accounts save(Accounts account);
	
	@Query("UPDATE Accounts SET account_balance=account_balance + ?1 WHERE account_number= ?2")
	public void depositMoney(@Param("amount") double amount,@Param("accountNumber") int accountNumber);
	
	@Query("UPDATE Accounts SET account_balance=account_balance - ?1 WHERE account_number= ?2")
	public void withdrawMoney(@Param("amount") double amount,@Param("accountNumber") int  accountNumber);
	
//	@Query("INSERT INTO Accounts (account_number,account_balance,user_id) VALUES (?1,?2,?3)")
//	public void createAccount(@Param("account_number") int accountNumber,@Param("account_balance")double accountBalance,@Param("user_id")Long userId);
	
	

}
