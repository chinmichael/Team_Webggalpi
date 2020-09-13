package com.webmark.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;

public class NoticeDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long notice_num = Long.parseLong(request.getParameter("notice_num"));
		
		MainDAO dao = MainDAO.getInstance();
		dao.deleteNotice(notice_num);
		
		String url = "/WebmarkServlet?command=notice_list";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
