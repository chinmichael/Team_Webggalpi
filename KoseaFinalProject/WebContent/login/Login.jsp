
<%@ page language ="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<style>
    body {
		font-family: 'Varela Round', sans-serif;
	}
	.modal-login {		
		color: #636363;
		width: 350px;
		margin: 80px auto 0;
	}
	.modal-login .modal-content {
		padding: 20px;
		border-radius: 5px;
		border: none;
	}
	.modal-login .modal-header {
		border-bottom: none;   
        position: relative;
        justify-content: center;
	}
	.modal-login h4 {
		text-align: center;
		font-size: 26px;
		margin: 30px 0 -15px;
	}
	.modal-login .form-control:focus {
		border-color: #70c5c0;
	}
	.modal-login .form-control, .modal-login .btn {
		min-height: 40px;
		border-radius: 3px; 
	}
	.modal-login .close {
        position: absolute;
		top: -5px;
		right: -5px;
	}	
	.modal-login .modal-footer {
		background: #ecf0f1;
		border-color: #dee4e7;
		text-align: center;
        justify-content: center;
		margin: 0 -20px -20px;
		border-radius: 5px;
		font-size: 13px;
	}
	.modal-login .modal-footer a {
		color: #999;
	}		
	.modal-login .avatar {
		position: absolute;
		margin: 0 auto;
		left: 0;
		right: 0;
		top: -70px;
		width: 95px;
		height: 95px;
		border-radius: 50%;
		z-index: 9;
		background: #60c7c1;
		padding: 15px;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
	.modal-login .avatar img {
		width: 100%;
	}
    .modal-login .btn {
        color: #fff;
        border-radius: 4px;
		background: #60c7c1;
		text-decoration: none;
		transition: all 0.4s;
        line-height: normal;
        border: none;
    }
	.modal-login .btn:hover, .modal-login .btn:focus {
		background: #45aba6;
		outline: none;
	}
	.trigger-btn {
		display: inline-block;
		margin: 100px auto;
	}
</style>

</head>
<body>

    <div class="text-center">
        <!-- Button HTML (to Trigger Modal) -->
        <a href="#myModal" class="trigger-btn" data-toggle="modal">Click to Open Login Modal</a>
        <br><br>
        <a href="/KoseaFinalProject/tempCover.jsp">Return to Home</a>
    </div>
    
    <!-- Modal HTML -->
    <div id="myModal" class="modal fade">
        <div class="modal-dialog modal-login">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="avatar">
                        <img src="/KoseaFinalProject/resource/image/avatar.png" alt="Avatar">
                    </div>				


    <h2 class="modal-body">Member Login</h2>
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
        &times;
    </button>

    <div class="modal-body">
<form action="/KoseaFinalProject/login.do" method="post" name="frm">
   <div class="form-group">
       <input type="text" class="form-control" name="userid" placeholder="Username"
       required="required">
   </div>
      <div class="form-group">
       <input type="password" class="form-control" name="userpw" placeholder="Password"
       required="required">
      </div> 
    </div>        
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-lg btn-block login-btn"
        onclick="return loginCheck()">Login</button>
    </div>
    <div class="text-center">
    	<a href="/KoseaFinalProject/login/JoinForm.jsp">아직 회원이 아니신가요?</a>
    </div>

</form>

<c:if test="${not empty message }">
	<input type = "hidden" value = "${message }" id = "message">
	<script type="text/javascript">
		window.onload = function() {
			alert($("#message").val());
		};
	</script>
</c:if>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="script/member.js"></script>
   
</body>

</html>