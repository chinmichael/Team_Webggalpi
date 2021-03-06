<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>회원관리</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type ="text/javascript" src="script/member.js"></script>
<style>
body {
	color: #fff;
	background: #BBE309;
	font-family: 'Roboto', sans-serif;
}
.form-control {		
	min-height: 41px;
	box-shadow: none;
	border-color: #e1e4e5;
}
.form-control:focus {
	border-color: #49c1a2;
}
.form-control, .btn {        
	border-radius: 3px;
}
.signup-form {
	width: 400px;
	margin: 0 auto;
	padding: 30px 0;
}
.signup-form form {
	color: #9ba5a8;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.signup-form h2 {
	color: #333;
	font-weight: bold;
	margin-top: 0;
}
.signup-form hr {
	margin: 0 -30px 20px;
}    
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form label {
	font-weight: normal;
	font-size: 14px;
}
.signup-form .btn, .signup-form .btn:active {
	font-size: 16px;
	font-weight: bold;
	background: #49c1a2 !important;
	border: none;
	min-width: 140px;
}
.signup-form .btn:hover, .signup-form .btn:focus {
	background: #45aba6 !important;
}
.signup-form a {
	color: #fff;
	text-decoration: underline;
}
.signup-form a:hover {
	text-decoration: none;
}
.signup-form form a {
	color: #45aba6;
	text-decoration: none;
}	
.signup-form form a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
<div class="signup-form">
    <form action="/KoseaFinalProject/AccountModifyServlet" method="post" name="frm">
    <input type = "hidden" name = "user_id" value = "${account.getUserid() }">
		<h2>Account modify</h2>
		
		<hr>
 
        <div class="form-group">
			<label>Email Address</label>
        	<input type="email" class="form-control" name="e_mail" required="required"
        	value = "${account.getEmail() }">
        	<h6 style = "padding-left:10px; margin-top : 10px; color:red; font-size:10pt;">${messageMail}</h6>
        </div>
        <div class="form-group">
			<label>Name</label>
            <input type="text" class="form-control" name="user_name" required="required"
            value = "${account.getUsername() }">
        </div>
        <div class="form-group">
			<label>Nickname</label>
            <input type="text" class="form-control" name="user_nick" required="required"
            value = "${account.getUsernick() }">
        </div>
		<div class="form-group">
			<label>Password</label>
            <input type="password" class="form-control" name="user_pw" id="user_pw" required="required"
            value = "${account.getUserpw() }">
        </div>
        <div class="form-group">
			<label>Confirm Password</label>
            <input type="password" class="form-control" name="confirm_pw" id="confirm_pw" required="required">
        </div>
		<div class="form-group">
            <button type="submit" class="btn btn-primary btn-block btn-lg"
            onclick="return checkPW()">change Up</button>
        </div>
    </form>
</div>

<h4 style = "text-align : center;"><a href = "/KoseaFinalProject/main/markList.jsp">Return to List</a></h4>

<script type = "text/javascript">
	function checkPW() {
		var pw = document.getElementById("user_pw").value;
		var cfpw = document.getElementById("confirm_pw").value;
		
		if(pw != cfpw) {
			alert("Passwords do not match.");
			return false;
		}
		
		return true;
	}
</script>

<c:if test="${not empty message }">
	<input type = "hidden" value = "${message }" id = "message">
	<script type="text/javascript">
		window.onload = function() {
			alert($("#message").val());
		};
	</script>	
</c:if>
</body>
</html>