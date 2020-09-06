//https://rwd337.tistory.com/206

/*
 * <Resource name="jdbc/myoracle" auth="Container"
              type="javax.sql.DataSource" driverClassName="oracle.jdbc.OracleDriver"
              url="jdbc:oracle:thin:@127.0.0.1:1521:ChinHR"
              username="webmark" password="kosea" maxTotal="20" maxIdle="10"
              maxWaitMillis="-1"/>
 * 
 */

package com.webmark.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dto.NoticePagingVO;

public class NoticeList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String parsePage = request.getParameter("page");
		
		if(parsePage == null) {
			parsePage = "1";
		}
		long initPage = Long.parseLong(parsePage);
		
		NoticePagingVO vo = new NoticePagingVO();
		vo.setPage(initPage);
		
	}

}
