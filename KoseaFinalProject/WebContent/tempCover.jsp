<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body style = "background-color: #BDBDBD;">

	<jsp:include page="/coverTop.jsp"></jsp:include>
	<div class="container-fluid">
		

		<div class="jumbotron" style = "margin-top : 0px; margin-bottom : 50px; background-color:#BDBDBD; text-align: center;">

			<figure class="figure">
				<img src="/KoseaFinalProject/resource/image/coverLogo2.jpg" class="figure-img img-fluid rounded" alt="...">
				<figcaption class="figure-caption">Welcome to our Webgalpi site!</figcaption>
			</figure>

			
			<c:choose>
				<c:when test = "${empty account }">
					<hr class="my-4">
					<p>Do you have any Webgalpi ID yet?</p>
					<a class="btn btn-dark btn-lg" href="#" role="button">Sign Up</a>
				</c:when>
				<c:otherwise>
					<hr class="my-4">
					<p>Have a good day!!</p>
					<a class="btn btn-dark btn-lg" href="/KoseaFinalProject/main/markList.jsp" role="button">Go Webgalpi List!!</a>

				</c:otherwise>
			</c:choose>
			
		</div>


		<jsp:include page="/coverBottom.jsp"></jsp:include>
</body>
</html>