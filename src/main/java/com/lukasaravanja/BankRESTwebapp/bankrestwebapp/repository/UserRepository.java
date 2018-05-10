package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username);
}
