package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUsername(String username);
}
