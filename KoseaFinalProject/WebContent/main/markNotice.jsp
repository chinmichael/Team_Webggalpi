<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/main/markNav.jsp"></jsp:include>
	<main class="col bg-faded py-3 flex-grow-1">
	
	<%--notice contents --%>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Title</th>
						<th scope="col">Writer</th>
						<th scope="col">Date</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var = "pagingList" items = "${pagingList }">
					<tr>
						<th scope="row">${pagingList.getNotice_num() }</th>
						<td><a href = "/KoseaFinalProject/WebmarkServlet?command=notice_board&notice_num=${pagingList.getNotice_num()}">
						${pagingList.getNotice_title() }</a></td>
						<td>${pagingList.getUserid() }</td>
						<td>${pagingList.getWrite_date() }</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
		
		<%--notice add only by admin --%>
		
		<c:if test = "${account.getUsertype() == '1' }">
			<hr>
			<button type="button" class="btn btn-light btn-lg btn-block btn-sm"
				style="border-radius: 10px; box-shadow: none;"
				onclick="location.href='/KoseaFinalProject/main/noticeWrite.jsp'">
				<i class="fas fa-plus"></i>
			</button>
			
		</c:if>
		<hr>
		</div>
		<%--notice paging --%>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">

				<c:if test="${resMap.pageGroup > 1 }">
					<li class="page-item"><a class="page-link"
						aria-label="Previous" style = "color: gray;"
						href="javascript:fnGoPaging(${resMap.prePage })">
						<%-- href="javascript:fnGoPaging(<c:out values = '${resMap.prePage }'/>)">--%>
							<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				
				<c:forEach var = "i" begin = "${resMap.startPage }" end = "${resMap.endPage > resMap.total ? resMap.total : resMap.endPage }" varStatus="status">
					<c:choose>
						<c:when test = "${resMap.page eq i }">
							<li class="page-item"><a class="page-link" href="javascript:fnGoPaging(${i});" style = "color: gray;">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="javascript:fnGoPaging(${i});" style = "color: gray;">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${resMap.nextPage <= resMap.total }">
					<li class="page-item">
					<a class="page-link" href="javascript:fnGoPaging(${resMap.nextPage })"
					<%-- <c:out value='${resMap.nextPage }'/>--%>
						aria-label="Next" style = "color: gray;"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>

			</ul>
		</nav>

	</main>
	</div>
	
	<script>
		function fnGoPaging(page){
			location.href = "/KoseaFinalProject/WebmarkServlet?command=notice_list&page=" + page;
		}
	</script>
	<jsp:include page="/main/markBottom.jsp"></jsp:include>
</body>
</html>