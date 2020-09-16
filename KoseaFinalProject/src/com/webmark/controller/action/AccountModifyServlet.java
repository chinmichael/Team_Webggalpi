package com.webmark.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webmark.dao.AccountDAO;
import com.webmark.dto.AccountVO;
/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/Account.do")
public class AccountModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	RequestDispatcher dispatcher = request
			.getRequestDispatcher("join.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String user_nick = request.getParameter("user_nick");
		String e_mail = request.getParameter("e_mail");
		
		AccountVO mVo =new AccountVO();
		mVo.setUserid(userid);
		mVo.setUserpw(user_pw);
		mVo.setUsername(user_name);
		mVo.setUsernick(user_nick);
		mVo.setEmail(e_mail);
		
		AccountDAO dao = AccountDAO.getInstance();
		int result = dao.modifyAccount(mVo);
		
		if(result==1) {
			AccountVO vo = dao.changeInfo(mVo.getUserid());
			HttpSession session = request.getSession();
			session.setAttribute("account", vo);
			
			request.setAttribute("message", "Success to change information.");
		}else {
			request.setAttribute("message", "Fail to change information.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/account/AccountModify.jsp");
		dispatcher.forward(request, response);
		
//		doGet(request, response);
	}

}
