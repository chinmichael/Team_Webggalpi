<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/main/markNav.jsp"></jsp:include>

	<!-- content -->
	<main class="col bg-faded py-3 flex-grow-1">

		<div class="btn-group">
			<button type="button" class="btn btn-secondary dropdown-toggle"
				data-toggle="dropdown" data-display="static" aria-haspopup="true"
				aria-expanded="false">Left-aligned but right aligned when
				large screen</button>
			<div class="dropdown-menu dropdown-menu-lg-right">
				<button class="dropdown-item" type="button">Action</button>
				<button class="dropdown-item" type="button">Another action</button>
				<button class="dropdown-item" type="button">Something else
					here</button>
			</div>
		</div>


	</main>

	</div>
	<!-- /contents -->

	<jsp:include page="/main/markBottom.jsp"></jsp:include>

</body>
</html>
