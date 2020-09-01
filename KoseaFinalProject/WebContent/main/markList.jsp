<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/main/markNav.jsp"></jsp:include>

	<!-- content -->
	<main class="col bg-faded py-3 flex-grow-1">
	
		<!-- url list -->
		
		<ul class="list-group list-group-flush">
			<c:forEach var = "urlL" items = "${urlList }">
			
			<li class="list-group-item" style = "line-height: 40px;"><a href = "${urlL.url_address }" target = "_blank">${urlL.url_name }</a>
				
				<!-- Button trigger modal -->
				
					<button type="button" class="btn btn-light float-right" data-toggle="modal" style = "box-shadow:none;"
						data-target="#trashUrlModal"><i class="fas fa-trash"></i></button> <!-- Modal -->
					<div class="modal fade" id="trashUrlModal" tabindex="-1"
						aria-labelledby="trashUrlModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="trashUrlModalLabel">Caution</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close" style = "outline: none;">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">Are you sure delete this URL?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal" style = "box-shadow:none;">Close</button>
									<button type="button" class="btn btn-danger" style = "box-shadow:none;">Delete</button>
								</div>
							</div>
						</div>
					</div>

					<!-- edit url -->

					<button type="button" class="btn btn-light float-right" style = "box-shadow:none;"
					data-toggle="modal" data-target="#editURLModal${urlL.url_num }"><i class="fas fa-edit"></i></button>
					
					<div class="modal fade" id="editURLModal${urlL.url_num }" tabindex="-1"
						aria-labelledby="editURLModal${urlL.url_num }Label" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="editURLModal${urlL.url_num }Label">Editing URL</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close" style="outline: none;">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<form>
									<div class="modal-body" style="height: 440px;">
										<label for="urlLink" class="col-form-label" >URL Link :</label>
										<input type="text" class="form-control" id="urlLink" onfocus="this.select()" value = "${urlL.url_address }">
										<br> <label for="urlName" class="col-form-label">URL Name :</label>
										<input type="text" class="form-control" id="urlName" value = "${urlL.url_name }">
										<br> <label for="urlTag" class="col-form-label">Tag (Divide by '#') :</label>
										<input type="text" class="form-control"id="urlTag" value = "${urlL.tag }">
										<br>

										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<label class="input-group-text" for="AccessUrl">Permit
													accessing at Board</label>
											</div>
											<select class="custom-select" id="AccessUrl">
												<option value="1" selected>Agree</option>
												<option value="0">Deny</option>
											</select>

										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											style="box-shadow: none;" data-dismiss="modal">Close</button>
										<input type="submit" class="btn btn-success"
											style="box-shadow: none;" value="Add">
									</div>
								</form>
							</div>
						</div>
					</div>
					
					<!-- move url -->
					
				<button type="button" class="btn btn-light float-right" style = "box-shadow:none;" onclick = "window.open('${urlL.url_address }')"><i class="fas fa-map-marker-alt"></i></button>
			</li>
			</c:forEach>
			
			<!-- add new url -->
			
			<li class="list-group-item">
				<button type="button" class="btn btn-light btn-lg btn-block" style = "border-radius: 10px; box-shadow:none;"
				data-toggle="modal" data-target="#addURLModal"><i class="fas fa-plus"></i></button>

				<div class="modal fade" id="addURLModal" tabindex="-1"
					aria-labelledby="addURLModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="addURLModalLabel">Adding URL</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close" style="outline: none;">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form>
								<div class="modal-body" style="height: 420px;">
									<label for="urlLink" class="col-form-label">URL Link :</label>
									<input type="text" class="form-control" id="urlLink">
									<br>
									<label for="urlName" class="col-form-label">URL Name :</label>
									<input type="text" class="form-control" id="urlName">
									<br>
									<label for="urlTag" class="col-form-label">Tag (Divide by '#') :</label>
									<input type="text" class="form-control" id="urlTag">
									<br><br>
									
									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<label class="input-group-text" for="AccessUrl">Permit accessing at Board</label>
										</div>
										<select class="custom-select" id="AccessUrl">
											<option value = "1" selected>Agree</option>
											<option value = "0">Deny</option>
										</select>

									</div>

								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										style="box-shadow: none;" data-dismiss="modal">Close</button>
									<input type="submit" class="btn btn-success"
										style="box-shadow: none;" value="Add">
								</div>
							</form>
						</div>
					</div>
				</div>

			</li>
			
		</ul>

	</main>

	</div>
	<!-- /contents -->

	<jsp:include page="/main/markBottom.jsp"></jsp:include>

</body>
</html>
