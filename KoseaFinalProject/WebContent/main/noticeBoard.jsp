<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/main/markNav.jsp"></jsp:include>
	<main class="col-md-8 bg-faded py-3 flex-grow-1">

		<%--notice contents --%>
		<div class="table-responsive">
			<table class="table table-borderless">
					<tr class="table-active">
						<td><h4 style = "padding-top: 3px;">${noticeCon.getNotice_title() }</h4></td>
					</tr>
					<tr class="table-light">
						<td>
						<c:if test = "${not empty noticeCon.getNotice_attach() }">
							<a href="/KoseaFinalProject/download.jsp?filename=${noticeCon.getNotice_attach() }">
							<i class="fas fa-paperclip"></i>&nbsp;${noticeCon.getNotice_attach() }</a>
						</c:if>
						</td>
						<td style = "color: gray; text-decoration: none; padding : 8px; margin-top : 0px; text-align: right;">
						<i class="fas fa-pencil-alt"></i>&nbsp;${noticeCon.getUserid() }&nbsp;&nbsp;&nbsp;
						<i class="far fa-calendar-alt"></i>&nbsp;&nbsp;${noticeCon.getWrite_date() }</td>
					</tr>

					<tr>
						<td style = "padding-top: 20px; padding-bottom : 20px;">${noticeCon.getNotice_contents() }</td>
					</tr>
					<tr>
					</tr>

			</table>
		</div>
		<hr>
		<%--button --%>
		<c:choose>
			<c:when
				test="${noticeCon.getUserid() == account.getUserid() || (empty noticeCon.getUserid() && account.getUsertype == '1') }">
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;" data-toggle="modal"
					data-target="#editURLModal${urlL.url_num }">
					<i class="fas fa-trash"></i>
				</button>

				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none; margin-left: 5px; margin-right: 5px;"
					data-toggle="modal" data-target="#editURLModal${urlL.url_num }">
					<i class="fas fa-edit"></i>
				</button>

				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;"
					onclick = "location.href='/KoseaFinalProject/WebmarkServlet?command=notice_list'">
					<i class="fas fa-list"></i>
				</button>

			</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;"
					onclick = "location.href='/KoseaFinalProject/WebmarkServlet?command=notice_list'">
					<i class="fas fa-list"></i>&nbsp; List
				</button>
			</c:otherwise>
		</c:choose>
	</main>
		</div>
		<jsp:include page="/main/markBottom.jsp"></jsp:include>
</body>
</html>