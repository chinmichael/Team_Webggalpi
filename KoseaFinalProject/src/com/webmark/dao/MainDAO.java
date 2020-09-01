package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.webmark.dto.AccountVO;
import com.webmark.dto.CategoryVO;
import com.webmark.dto.UrlVO;

import util.DBManager;

public class MainDAO {
	
	private MainDAO() {
		
	}
	
	private static MainDAO instance = new MainDAO();
	
	public static MainDAO getInstance() {
		return instance;
	}
	
	public AccountVO sampleAccount (String userid) {
		
		String sql = "select user_id, user_pw, user_name, user_nick, e_mail, to_char(create_date, 'yyyy/mm/dd') \"create_date\" from accountwm where user_id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		AccountVO vo = new AccountVO();
		
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
				vo.setCreatedate(rs.getString("create_date"));

			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return vo;
	}
	
	public List<CategoryVO> getCategoryList (String userid) {
		
		String sql = "select * from category where user_id = ?";
		
		List<CategoryVO> list = new Vector<CategoryVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CategoryVO vo = new CategoryVO();
				
				vo.setCat_name(rs.getString("cat_name"));
				vo.setCat_no(rs.getLong("cat_num"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public List<UrlVO> getUrlList (long cat_no) {
		
		String sql = "select url_num, url_address, url_name, url_access, tag from urlwm where cat_num = ?";
		
		List<UrlVO> list = new Vector<UrlVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, cat_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UrlVO vo = new UrlVO();
				
				vo.setUrl_num(rs.getLong("url_num"));
				vo.setUrl_address(rs.getString("url_address"));
				vo.setUrl_name(rs.getString("url_name"));
				vo.setUrl_access(rs.getString("url_access"));
				vo.setTag(rs.getString("tag"));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	

}
