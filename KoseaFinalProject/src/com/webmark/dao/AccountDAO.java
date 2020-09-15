package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.webmark.dto.AccountVO;

import util.DBManager;

public class AccountDAO {

	private AccountDAO() {

	}

	private static AccountDAO instance = new AccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}

	public int modifyAccount(AccountVO mVo) {
		int result = -1;
		String sql = "update accountwm user_pw= ?,user_name=?,user_nick = ?,e_mail= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserpw());
			pstmt.setString(2, mVo.getUsername());
			pstmt.setString(3, mVo.getUsernick());
			pstmt.setString(4, mVo.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}
