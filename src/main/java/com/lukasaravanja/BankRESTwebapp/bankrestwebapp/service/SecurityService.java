package com.lukasaravanja.BankRESTwebapp.bankrestwebapp.service;

public interface SecurityService {
	 String findLoggedInUsername();

	 void autologin(String username, String password);
}
