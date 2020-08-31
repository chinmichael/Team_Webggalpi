
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<title>회원가입 화면</title>

<style>
#wrap {
	width: 530px;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

#title {
	background-color: skyblue
}
</style>
</head>
<script type="text/javascript">
                     function email_change() {
                    	 if(document.join.email.options[document.join.email.selectedIndex].value == ''){
                    		 document.join.mail2.disabled = true;
                    		 document.join.mail2.value = "";
                    	 }
                    	 if(document.join.email.options[document.join.email.selectedIndex].value == '9'){
                    		 document.join.mail2.disabled = false;
                    		 document.join.mail2.value = "";
                    		 document.join.mail2.focus();
                    	 }else{
                    		 document.join.mail2.disabled = true;
                    		    
                    	     document.join.mail2.value = document.join.email.options[document.join.email.selectedIndex].value;
                    	 }
                     }
                     </script>
<body>
	<div id="wrap">
		<br> <br> <b><font size="6" color="gray"><i
				class="fas fa-baby"></i>m회원가입</font></b> <br> <br> <br>

		<form name="join">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="id" maxlength="20"> <input
						type="button" value="중복확인"></td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="password" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="name" maxlength="30"></td>
				</tr>
				<tr>
					<td id="title">닉네임</td>
					<td><input type="text" name="nickname" maxlength="50">
					</td>
				</tr>


				<tr>
					<td id="title">이메일</td>
					<td><input type="text" name="mail1" value="이메일" maxlength="30"
						onfocus="this.value='';">@ <input type="text" name="mail2"
						value="" disabled> <select name="email"
						onchange="email_change()">

							<option value="">선택하세요</option>
							<option value="9">직접입력</option>
							<option value="google.com">google.com</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>

					</select></td>

				</tr>

			</table>
			<br> <input type="submit" value="가입" /> <input type="button"
				value="취소">


		</form>
	</div>
</body>



</html>