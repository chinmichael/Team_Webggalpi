<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
<link rel="stylesheet"
	href="/KoseaFinalProject/resource/css/bootstrap.css">

<style type="text/css">

html, body {
height: 100%;
margin: 0;
padding: 0;
}

.container-fluid {
min-height: 94%; 
position: relative;
}


footer {
position: absolute;
bottom: 0;
right: 0;
width: 100%;
height: 50px;

padding: 12px 0px;

color: #848484;
background-color: #EDF1F4;
}
</style>

</head>
<body>
	<!-- navigation -->
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><i class="far fa-bookmark"></i>&nbsp;&nbsp;Webggalpi</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="/KoseaFinalProject/main/markList.jsp">List
						 <span class="sr-only">(current)</span> 
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Community</a></li>

				
			</ul>

			<ul class="navbar-nav mr-sm-3 mt-2 mt-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <i
						class="fas fa-user-tag"></i>&nbsp; ${account.usernick} &nbsp;
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Account</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="/KoseaFinalProject/WebmarkServlet?command=logout">Logout</a>
					</div></li>
			</ul>
			

			<form class="form-inline my-2 my-lg-0" method = "post" action = "/KoseaFinalProject/WebmarkServlet?command=search_url">
				<input class="form-control mr-sm-2" type="text" name = "urlSearch" placeholder="Search" style = "height: calc(1.5em + 0.75rem - 5px); box-shadow:none;">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" style = "height: calc(1.5em + 0.75rem - 5px); line-height: 0; box-shadow:none;"><i class="fas fa-search-location"></i></button>
			</form>
		</div>
	</nav>

	<!-- category -->
	<div class="container-fluid">
		<div class="row min-vh-100 flex-column flex-md-row">

			<aside class="col-12 col-md-2 p-0 bg-light flex-shrink-1"
				style="overflow: auto;">
				<!-- <nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start py-2">
                <div class="collapse navbar-collapse "> -->
				<nav
					class="navbar navbar-expand-lg navbar-light bg-light flex-md-column flex-md-row align-items-start py-2">
					<a class="navbar-brand" href="/KoseaFinalProject/main/markList.jsp"><i class="fas fa-swatchbook"></i>
						&nbsp;Category</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">

						<div class="navbar-nav">
							<ul
								class="flex-md-column navbar-nav w-100 justify-content-between">
								
								<!-- Notice -->
								
								<li class="nav-item"><a class="nav-link"
										href=#>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-bullhorn"></i>&nbsp;
											Noitce
									</a></li>

								<!-- add category menu -->

								<li class="nav-item"><a class="nav-link" href=# id = "addCatModal">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
										class="fas fa-plus-circle"></i>&nbsp; Add New Category
								</a>
								<jsp:include page="/main/addCatModal.jsp" />
								</li>

								<!-- delete category menu -->

								<li class="nav-item"><a class="nav-link" href=# id = "delCatModal">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i
										class="fas fa-minus-circle"></i>&nbsp; Delete Category
								</a>
								<jsp:include page="/main/deleteCatModal.jsp" />
								</li>
									
									
								<!-- category list -->	

								<c:forEach var="category" items="${categoryList }">
									<li class="nav-item"><a class="nav-link"
										href="/KoseaFinalProject/WebmarkServlet?command=url_list&cat_no=${category.cat_no }">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fas fa-folder"></i>&nbsp;
											${category.cat_name}
									</a></li>
								</c:forEach>

							</ul>
						</div>
					</div>
				</nav>
			</aside>

			<!-- /navigation -->

