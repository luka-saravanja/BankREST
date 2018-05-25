package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Role;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.RoleRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public void saveUser(User user) {
		Set<Role> roles = new HashSet<>();
		Role role = roleRepository.findByRoleId((long) 0);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		if (Objects.nonNull(userRepository.findByUsername(user.getUsername())))
			throw new NullPointerException("That username is already taken");
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);

	}

	public User checkUser() {
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());

		return user;

	}
	
	public void setUserRole(User user,Long roleId) {
		Set<Role> roles = new HashSet<>();
		Role role = roleRepository.findByRoleId(roleId);
		roles.add(role);
		user.setRoles(roles);
		userRepository.save(user);

	}
}
