package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.UrlVO;

public class UrlList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long cat_no = Long.parseLong(request.getParameter("cat_no"));
		
		MainDAO dao = MainDAO.getInstance();
		List<UrlVO> list = dao.getUrlList(cat_no);
		
		request.setAttribute("urlList", list);
		String url = "/main/markList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
