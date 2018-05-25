package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.Accounts;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.dao.model.User;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.AccountsRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.repository.UserRepository;
import com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service.UserService;

@RestController
public class AdminController {

	@Autowired
	private AccountsRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/admin/users")
	public List<User> users() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/admin/accounts")
	public List<Accounts> accounts() {
		return accountRepository.findAll();
	}

	@DeleteMapping("/admin/users")
	public boolean deleteUser(@RequestParam("id") Long id) {

		if (userService.checkUser().getUserId() != id) {
			User deleteUser = userRepository.findByUserId(id);
			userRepository.delete(deleteUser);
			return true;
		}
		return false;
	}

	@PostMapping("/admin/user/role")
	public User setUserRole(@RequestBody User user, @RequestParam Long roleId) {
		userService.setUserRole(user, roleId);
		return userRepository.findByUserId(user.getUserId());
	}
	
	@GetMapping("/admin/user")
	public User getUser(@RequestParam String username) {
		return userRepository.findByUsername(username);
	}
	}

