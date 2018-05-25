package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleId(Long roleId);

}
