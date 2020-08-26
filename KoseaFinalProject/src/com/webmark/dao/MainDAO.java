package com.webmark.dao;

public class MainDAO {
	
	private MainDAO() {
		
	}
	
	private static MainDAO instance = new MainDAO();
	
	public static MainDAO getInstance() {
		return instance;
	}

}
