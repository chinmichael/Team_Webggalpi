package com.saeyan.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class AccountDAO {
	
	private AccountDAO() {
		
	}
	
	private static AccountDAO instance = new AccountDAO();
	
	public static AccountDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext  = new InitialContext();
		Context envContext  = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;

		}
	
	public int modifyAccount(AccountVO mVo) {
		int result = -1;
		String sql = "update accountwm user_pw= ?,user_name=?,user_nick = ?,e_mail= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,mVo.getUserpw());
			pstmt.setString(2,mVo.getUsername());
			pstmt.setString(3,mVo.getUsernick());
			pstmt.setString(4,mVo.getEmail());
			 result = pstmt.executeUpdate();
			}catch (Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return result;
			}
		

	
}
