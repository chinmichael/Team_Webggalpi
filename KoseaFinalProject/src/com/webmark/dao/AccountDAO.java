package com.webmark.dao;

public class AccountDAO {
	
	private AccountDAO() {
		
	}
	
	private static AccountDAO instance = new AccountDAO();
	
	public static AccountDAO getInstance() {
		return instance;
	}

}
