package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
public class Accounts {
	
	@Id
	private int accountNumber;
	
	private BigDecimal accountBalance;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId",nullable = false)
	private User user;

	public int getAccountNumber() {
		return accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public User getUser() {
		return user;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Accounts [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", user=" + user
				+ "]";
	}
	
	

}
