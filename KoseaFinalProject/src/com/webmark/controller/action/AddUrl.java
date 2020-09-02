package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webmark.dao.MainDAO;
import com.webmark.dto.UrlVO;

public class AddUrl implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String tag = request.getParameter("urlTag") == null ? "none" : request.getParameter("urlTag");
		
		UrlVO vo = new UrlVO();
		vo.setUrl_address(request.getParameter("urlLink"));
		vo.setUrl_name(request.getParameter("urlName"));
		vo.setUrl_access(request.getParameter("AccessUrl"));
		vo.setTag(tag);
		
		long cat_no = Long.parseLong(request.getParameter("cat_no"));
		
		MainDAO dao = MainDAO.getInstance();
		int result = dao.addUrl(cat_no, vo);
		
		if(result == 1) {
			
		} else {
			request.setAttribute("message", "URL name is already in this category");
		}
		
		List<UrlVO> list = dao.getUrlList(cat_no);
		
		request.setAttribute("urlList", list);
		request.setAttribute("cat_no", Long.toString(cat_no));
		String url = "/main/markList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
