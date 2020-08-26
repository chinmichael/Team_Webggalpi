package com.webmark.dao;

public class LoginDAO {
	
	private LoginDAO() {
		
	}
	
	private static LoginDAO instance = new LoginDAO();
	
	public static LoginDAO getInstance() {
		return instance;
	}

}
