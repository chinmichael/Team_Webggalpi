package com.webmark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.saeyan.dto.AccountVO;

public class MemberDAO {
private MemberDAO() {
}

private static MemberDAO instance = new MemberDAO();

public static MemberDAO getInstance() {
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

public int userCheck(String user_id, String user_pw) {
int result = -1;
String sql = "select user_pw from member where user_id=?";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	conn = getConnection();
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, user_id);
	rs = pstmt.executeQuery();
	if(rs.next()) {
		if(rs.getString("user_pw")!=null && rs.getString("user_pw").equals("user_pw")) {
			result = 1;
		}else {
			result = 0;
		}
	}else {
		result = -1;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
 try {
	 if(rs != null) rs.close();
	 if(pstmt != null) pstmt.close();
	 if(conn != null) conn.close(); 
 } catch (Exception e) {
	 e.printStackTrace();
 }
	}
return result;	 
}
public AccountVO getMember(String user_id) {
	AccountVO mVo = null;
	String sql = "select * from accountwm where user_id=?";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			mVo = new AccountVO();
			mVo.setUserid(rs.getString("user_id"));
			mVo.setUsername(rs.getString("user_name"));
			mVo.setUserpw(rs.getString("user_pw"));
			mVo.setUsernick(rs.getString("user_nick"));
			mVo.setEmail(rs.getString("e_mail"));
			mVo.setCreatedate(rs.getString("create_date"));
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 return mVo;
}
public int insertaccountwm(AccountVO mVo) {
	int result = -1;
	String sql = "insert into accountwm (user_id,user_pw,user_name,user_nick,e_mail) values(?,?,?,?,?)";
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,mVo.getUserid());
		pstmt.setString(2,mVo.getUserpw());
		pstmt.setString(3,mVo.getUsername());
		pstmt.setString(4,mVo.getUsernick());
		pstmt.setString(5,mVo.getEmail());
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