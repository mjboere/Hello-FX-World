package controllers;

import models.Account;

public class AccountController {

	Account a = new Account();
	
	public AccountController() {
		
	}

	public boolean validateLogin(String uid, String pwd){
		System.out.println("LoginController - Checking Login");     
				
		if (a.validateLogin(uid, pwd)) { 
			return true;
		} else {
			return false;
		}
	}
	
}
