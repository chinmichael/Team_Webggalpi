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

public class DeleteCategory implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long cat_no = Long.parseLong(request.getParameter("delCategoryGroup"));
		
		MainDAO dao = MainDAO.getInstance();
		dao.deleteCategory(cat_no);
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("categoryList");
		
		AccountVO vo = (AccountVO)session.getAttribute("account");
		String userid = vo.getUserid();
		
		List<CategoryVO> list = dao.getCategoryList(userid);
		session.setAttribute("categoryList", list);
		
		String url = "/main/markList.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
