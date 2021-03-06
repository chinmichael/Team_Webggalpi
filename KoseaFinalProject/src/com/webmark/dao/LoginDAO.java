package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.webmark.dto.AccountVO;

import util.DBManager;

public class LoginDAO {
	private LoginDAO() {
	}

	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	public int userCheck(String user_id, String user_pw) {
		int result = -1;
		String sql = "select user_pw from accountwm where user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("user_pw").equals(user_pw)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public AccountVO getMember(String user_id) {
		AccountVO mVo = null;
		String sql = "select user_id, user_pw, user_name, user_nick, e_mail, user_type, to_char(create_date, 'yyyy/mm/dd') \"create_date\" from accountwm where user_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new AccountVO();
				mVo.setUserid(rs.getString("user_id"));
				mVo.setUsername(rs.getString("user_name"));
				mVo.setUserpw(rs.getString("user_pw"));
				mVo.setUsernick(rs.getString("user_nick"));
				mVo.setEmail(rs.getString("e_mail"));
				mVo.setUsertype(rs.getString("user_type"));
				mVo.setCreatedate(rs.getString("create_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}
	
	public int joinIDcheck(String userid) {
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select user_id from accountwm where user_id = ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			result = 1;
			
			if(rs.next()) {
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public int joinMailcheck(String email) {

		int result = -1;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select e_mail from accountwm where e_mail = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			result = 1;
			
			if(rs.next()) {
				result = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return result;
	}

	public int insertaccountwm(AccountVO mVo) {
		int result = -1;
		String sql = "insert into accountwm (user_id,user_pw,user_name,user_nick,e_mail) values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getUserid());
			pstmt.setString(2, mVo.getUserpw());
			pstmt.setString(3, mVo.getUsername());
			pstmt.setString(4, mVo.getUsernick());
			pstmt.setString(5, mVo.getEmail());
			pstmt.executeUpdate();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

}