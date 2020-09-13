package com.webmark.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webmark.dao.MainDAO;
import com.webmark.dto.NoticeVO;

public class NoticeWrite implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uploadPath = "C:\\webmark\\upload\\notice";
		int size = 10 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

		NoticeVO vo = new NoticeVO();
		vo.setUserid(multi.getParameter("noticeWriter"));
		vo.setNotice_title(multi.getParameter("noticeTitle"));
		vo.setNotice_contents(multi.getParameter("noticeContents"));

		boolean flg = false;

		if (multi.getFilesystemName("noticeAttach") != null) {
			String attach = multi.getFilesystemName("noticeAttach");
			vo.setNotice_attach(attach);
			flg = true;
		}

		MainDAO dao = MainDAO.getInstance();
		int result = dao.insertNotice(vo, flg);

		if (result == 0) {
			request.setAttribute("message", "input error");
		}

		String url = "/WebmarkServlet?command=notice_list";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);

		dispatcher.forward(request, response);

	}

}
