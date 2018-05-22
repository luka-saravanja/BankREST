package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Role;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;

public interface RoleRepository extends JpaRepository<Role,Long> {
	
	Role findByUsers(User user);
	
	Role findByRoleId(long roleId);

}
