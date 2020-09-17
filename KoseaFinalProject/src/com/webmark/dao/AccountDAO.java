package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webmark.dto.AccountVO;

import util.DBManager;

public class AccountDAO {

	private AccountDAO() {

	}

	private static AccountDAO instance = new AccountDAO();

	public static AccountDAO getInstance() {
		return instance;
	}
	
	public int checkMail(String email, String userid) {
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select user_id from accountwm where e_mail = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(!userid.equals(rs.getString("user_id"))) {
					result = 0;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return result;
	}

	public int modifyAccount(AccountVO mVo) {
		int result = -1;
		String sql = "update accountwm set user_pw= ?,user_name=?,user_nick = ?,e_mail= ? where user_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserpw());
			pstmt.setString(2, mVo.getUsername());
			pstmt.setString(3, mVo.getUsernick());
			pstmt.setString(4, mVo.getEmail());
			pstmt.setString(5, mVo.getUserid());

			pstmt.execute();
			result = 1;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	public AccountVO changeInfo (String userid) {
		AccountVO vo = new AccountVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select user_id, user_pw, user_name, user_nick, e_mail, user_type, to_char(create_date, 'yyyy/mm/dd') \"create_date\" from accountwm where user_id = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setUserid(rs.getString("user_id"));
				vo.setUserpw(rs.getString("user_pw"));
				vo.setUsername(rs.getString("user_name"));
				vo.setUsernick(rs.getString("user_nick"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setUsertype(rs.getString("user_type"));
				vo.setCreatedate(rs.getString("create_date"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}

}
