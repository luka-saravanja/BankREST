package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",updatable = false,nullable = false)
	private Long userId;
	
	@Column(name = "username",unique = true)
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = " role")
	private String role;

	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY,
				mappedBy="accounts")
	private Set<Accounts> accounts=new HashSet<>();
	
	public User()
	{}
	
	

	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public Set<Accounts> getAccounts() {
		return accounts;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setAccounts(Set<Accounts> accounts) {
		this.accounts = accounts;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", accounts=" + accounts + "]";
	}
	
	
	
	
	
	

}
