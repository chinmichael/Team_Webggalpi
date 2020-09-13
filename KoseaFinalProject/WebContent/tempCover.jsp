<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test = "${not empty account }">
<h1><a href = "/KoseaFinalProject/main/markList.jsp">메인 리스트로</a></h1>
<br>
<h1><a href = "/KoseaFinalProject/WebmarkServlet?command=logout">로그아웃</a></h1>
</c:when>
<c:otherwise>
<h1><a href = "/KoseaFinalProject/main/sampleaccount.jsp">임시 로그인으로</a></h1>
</c:otherwise>
</c:choose>

</body>
</html>