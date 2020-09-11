$(document).ready(function(){
	
    $("#addCatModal").click(function(){
        $("#addCategoryModal").modal("show");
    });

	$("#addCatBtn").click(function(){

		var addcat = $("#addCategoryName").val();
		var check = true;

		if(addcat == "") {
			alert("Please input category name");
			$("#addCategoryName").focus();

			check = false;
			}

		if(check) {
			$("#AddCatFrm").submit();
		}
	});

	$("#addCatModal2").click(function(){
        $("#addCategoryModal2").modal("show");
    });

	$("#addCatBtn2").click(function(){

		var addcat = $("#addCategoryName2").val();
		var check = true;

		if(addcat == "") {
			alert("Please input category name");
			$("#addCategoryName2").focus();

			check = false;
			}

		if(check) {
			$("#AddCatFrm2").submit();
		}
	});


	$("#delCatModal").click(function(){
        $("#delCategoryModal").modal("show");
    });

	$("#delCatBtn").click(function(){

		var delcat = $("#delCategoryGroup").val();
		var check = true;

		if(delcat == '-1') {
			alert("Please select category");
			$("#delCategoryGroup").focus();

			check = false;
			}

		if(check) {
			$("#DelCatFrm").submit();
		}
	});

	$("#addUModal").click(function(){
        $("#addURLModal").modal("show");
    });

	$("#addUrlBtn").click(function(){

		var link = $("#urlLink").val();
		var name = $("#urlName").val();
		var tag = $("#urlTag").val();
		var check = true;

		if(link == '' || link == null) {
			alert("Please input url address");
			$("#urlLink").focus();

			check = false;
			return;
			}
		if(name == '' || name == null) {
			alert("Please input url name");
			$("#urlName").focus();

			check = false;
			return;
			}


		if(check) {
			$("#addUrlFrm").submit();
		}
	});

	$("#editUrlBtn").click(function(){

		var link = $("#urlLinkE").val();
		var name = $("#urlNameE").val();
		var tag = $("#urlTagE").val();
		var check = true;

		if(link == '' || link == null) {
			alert("Please input url address");
			$("#urlLinkE").focus();

			check = false;
			return;
			}
		if(name == '' || name == null) {
			alert("Please input url name");
			$("#urlNameE").focus();

			check = false;
			return;
			}


		if(check) {
			$("#editUrlFrm").submit();
		}

	});

  $("#noticeWriteBtn").click(function(){

		var title = $("#noticeTitle").val();
		var check = true;

		if(title == '' || title == null) {
			alert("Please input notice title");
			$("#noticeTitle").focus();

			check = false;
			return;
			}

		if(check) {
			$("#noticeWFrm").submit();
		}

	});


});
