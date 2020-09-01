<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/main/markNav.jsp"></jsp:include>

	<!-- content -->
	<main class="col bg-faded py-3 flex-grow-1">

		<ul class="list-group list-group-flush">
			<c:forEach var = "urlL" items = "${urlList }">
			<li class="list-group-item" style = "line-height: 40px;"><a href = "${urlL.url_address }" target = "_blank">${urlL.url_name }</a>
				<button type="button" class="btn btn-light float-right" style = "box-shadow:none;"><i class="fas fa-trash"></i></button>
				<button type="button" class="btn btn-light float-right" style = "box-shadow:none;"><i class="fas fa-edit"></i></button>
				<button type="button" class="btn btn-light float-right" style = "box-shadow:none;" onclick = "parent.location.href='${urlL.url_address }'"><i class="fas fa-map-marker-alt"></i></button>
			</li>
			</c:forEach>
		</ul>

	</main>

	</div>
	<!-- /contents -->

	<jsp:include page="/main/markBottom.jsp"></jsp:include>

</body>
</html>
