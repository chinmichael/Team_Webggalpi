<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- footer & bootstrap js -->

<footer>
	<h4 align="center" style="font-size: 15pt;">© Team Webggalpi</h4>
</footer>
</div>

<c:if test = "${empty account }">
		<script type = "text/javascript">
			window.onload = function() {
				alert("There is no login information.");
				location.href="/KoseaFinalProject/main/sampleaccount.jsp";
			};
		</script>
		
</c:if>

<c:if test="${not empty message }">
	<input type = "hidden" value = "${message }" id = "message">
	<script type="text/javascript">
		window.onload = function() {
			alert($("#message").val());
		};
	</script>
</c:if>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/KoseaFinalProject/resource/js/bootstrap.js"></script>
<script type="text/javascript"
	src="/KoseaFinalProject/resource/js/maincheck.js"></script>

</body>
</html>