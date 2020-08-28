<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="http://localhost:8181/KoseaFinalProject/resource/css/bootstrap.css">

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

padding: 10px 0px;

color: #848484;
background-color: #EDF1F4;
}
</style>

</head>
<body>
	<!-- navigation -->
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><i class="far fa-bookmark"></i>&nbsp;&nbsp;WebMarker</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link" href="#">List
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Board</a></li>

				
			</ul>

			<ul class="navbar-nav mr-sm-3 mt-2 mt-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> <i
						class="fas fa-user-tag"></i>&nbsp; User nick &nbsp;
				</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Account</a> <a
							class="dropdown-item" href="#">Another action</a> 
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Logout</a>
					</div></li>
			</ul>
			

			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search" placeholder="Search" style = "height: calc(1.5em + 0.75rem - 5px); box-shadow:none;">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" style = "height: calc(1.5em + 0.75rem - 5px); line-height: 0; box-shadow:none;"><i class="fas fa-search-location"></i></button>
			</form>
		</div>
	</nav>

	<!-- category -->
	<div class="container-fluid">
		<div class="row min-vh-100 flex-column flex-md-row">

			<aside class="col-12 col-md-2 p-0 bg-light flex-shrink-1">
				<!-- <nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start py-2">
                <div class="collapse navbar-collapse "> -->
				<nav class="navbar navbar-expand-lg navbar-light bg-light flex-md-column flex-row align-items-start py-2">
					<a class="navbar-brand" href="#">Category</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<a class="nav-link active" href="#">Home <span
								class="sr-only">(current)</span></a> <a class="nav-link" href="#">Features</a>
							<a class="nav-link" href="#">Pricing</a> <a
								class="nav-link disabled" href="#" tabindex="-1"
								aria-disabled="true">Disabled</a>
						</div>
					</div>
				</nav>
			</aside>


			<!-- content -->

			<!-- /content -->
	</div>
	<!-- footer & bootstrap js -->
	<footer>
		<h4 align = "center" style = "font-size: 15pt;">© Team Webmark</h4>
	</footer>
	</div>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://localhost:8181/KoseaFinalProject/resource/js/bootstrap.js"></script>



</body>
</html>