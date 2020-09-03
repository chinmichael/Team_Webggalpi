package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmark.dao.MainDAO;
import com.webmark.dto.AccountVO;
import com.webmark.dto.SearchUrlVO;

public class SearchUrl implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String urlname = request.getParameter("urlSearch") == null ? "" : request.getParameter("urlSearch");
		
		if(urlname.isEmpty()) {
			request.setAttribute("message", "Please input search word.");
			
		} else {
			HttpSession session = request.getSession();
			AccountVO vo = (AccountVO) session.getAttribute("account");
			String userid = vo.getUserid();
			
			MainDAO dao = MainDAO.getInstance();
			List<SearchUrlVO> list = dao.searchUrl(userid, urlname);
			
			if(list.isEmpty()) {
				request.setAttribute("message", "There are no search results.");
			} else {
				request.setAttribute("urlList", list);
			}
			
		}
		
		String url = "/main/markList.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
