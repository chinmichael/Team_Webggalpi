package com.webmark.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmark.dao.LoginDAO;
import com.webmark.dao.MainDAO;
import com.webmark.dto.AccountVO;
import com.webmark.dto.CategoryVO;
/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String e_mail = request.getParameter("e_mail");
		
		AccountVO mVo =new AccountVO();
		mVo.setUserid(user_id);
		mVo.setUserpw(user_pw);
		mVo.setUsername(user_name);
		mVo.setUsernick(user_nick);
		mVo.setEmail(e_mail);
		
		LoginDAO mDao = LoginDAO.getInstance();
		int result = mDao.insertaccountwm(mVo);
		
		String url = "";
		
		if(result==1) {
			AccountVO vo = mDao.getMember(user_id);
			MainDAO dao = MainDAO.getInstance();
			List<CategoryVO> list = dao.getCategoryList(user_id);

			HttpSession session = request.getSession();
			session.setAttribute("account", vo);
			session.setAttribute("categoryList", list);
			session.setMaxInactiveInterval(24 * 60 * 60);
			
			request.setAttribute("message", "Success to join.");
			
			url = "/main/markList.jsp";
		}else {
			request.setAttribute("message", "Fail to join.");
			url = "/login/JoinForm.jsp";
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
