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
import com.webmark.dto.CategoryVO;
import com.webmark.dto.UrlVO;

public class AddCategory implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		AccountVO vo = (AccountVO)session.getAttribute("account");
		String userid = vo.getUserid();
		String cat_name = request.getParameter("addCategoryName");
		
		MainDAO dao = MainDAO.getInstance();
		long result = dao.addCategory(userid, cat_name);
		
		String url = "";
		
		if(result != -1) {
			session.removeAttribute("categoryList");
			List<CategoryVO> list_C = dao.getCategoryList(userid);
			session.setAttribute("categoryList", list_C);
			
			List<UrlVO> list_U = dao.getUrlList(result);
			
			request.setAttribute("urlList", list_U);
			request.setAttribute("cat_no", Long.toString(result));
			
			url = "/main/markList.jsp";
		} else {
			
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
