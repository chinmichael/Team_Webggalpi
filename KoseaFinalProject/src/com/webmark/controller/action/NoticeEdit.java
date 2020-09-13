package com.webmark.controller.action;

import java.io.File;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webmark.dao.MainDAO;
import com.webmark.dto.NoticeVO;

public class NoticeEdit implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uploadPath = "C:\\webmark\\upload\\notice";
		int size = 10 * 1024 * 1024;

		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());

		NoticeVO vo = new NoticeVO();
		vo.setNotice_num(Long.parseLong(multi.getParameter("noticeNumEdit")));
		vo.setUserid(multi.getParameter("noticeWriterE"));
		vo.setNotice_title(multi.getParameter("noticeTitleE"));
		vo.setNotice_contents(multi.getParameter("noticeContentsE"));

		if (multi.getParameter("noticeAttachFlg").equals("true")) {
			if (multi.getParameter("noticeBeforeAttach") != null) {
				String savedPath = "C:\\webmark\\upload\\notice";
				String filename = multi.getParameter("noticeBeforeAttach");
				String path = savedPath.trim() + "//" + filename.trim();
				File file = new File(path);
				if (file.exists()) {
					file.delete();
				}
			}

			if (multi.getFilesystemName("noticeAttachE") != null) {

				String attach = multi.getFilesystemName("noticeAttachE");
				vo.setNotice_attach(attach);
			}
		} else {
			vo.setNotice_attach(multi.getParameter("noticeBeforeAttach"));
		}

		MainDAO dao = MainDAO.getInstance();
		int result = dao.editNotice(vo);

		if (result != 1) {
			request.setAttribute("message", "input error");
		}

		NoticeVO vo2 = dao.getNoticeContents(vo.getNotice_num());

		request.setAttribute("noticeCon", vo2);
		String url = "/main/noticeBoard.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
