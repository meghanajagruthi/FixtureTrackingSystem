function logOutCheck() {
	bootbox.confirm("Are you sure u want to log out?", function(result) {
		if (result == true) {
			$.ajax({
				url : "logOut",
				type : "POST",
				contentType : "text/plain",
				success : function(e) {
					window.location.href = "http://localhost:8080/FMS";
				},
				async : false
			});
		}
	});
}
function validateNotifications(message) // For displaying error messages that
										// occured during validation
{
	console.log(message);
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title : "Elecnor FTS : Error!!",
		// (string | mandatory) the text inside the notification
		text : message,
		class_name : 'gritter-error'
	});
}
function validateForm() {
	/* Validation for text_field */
	if ($('#projectName').val() == '') {
		$('#projectName').attr("placeholder", "This field can't be empty.");
		$('#projectNameError').addClass("has-error");
		document.getElementById('projectName').focus();
		return false;
	}
	if ($('#projectNumber').val() == '') {
		$('#projectNumber').attr("placeholder", "This field can't be empty.");
		$('#projectNumberError').addClass("has-error");
		document.getElementById('projectNumber').focus();
		return false;
	}
	if ($('#startDate').val() == '') {
		$('#startDate').attr("placeholder", "This field can't be empty.");
		$('#startDateError').addClass("has-error");
		document.getElementById('startDate').focus();
		return false;
	}
	if ($('#endDate').val() == '') {
		$('#endDate').attr("placeholder", "This field can't be empty.");
		$('#endDateError').addClass("has-error");
		document.getElementById('endDate').focus();
		return false;
	}

	/* Validating Dates */
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
	if (!(date_regex.test($('#startDate').val()))) {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect start Date.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Incorrect start Date. <br>
		// </div>');
		return false;
	}
	if (!(date_regex.test($('#endDate').val()))) {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect end Date.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Incorrect end Date. <br>
		// </div>');
		return false;
	}

	/* Validate Select Box */
	if ($('#projManager').val() == "") {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Project Manager has to be selected.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Project Manager has to be
		// selected. <br> </div>');
		return false;
	}
	if ($('#projSupervisor').val() == "") {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Project Supervisor has to be selected.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Project Supervisor has to
		// be selected. <br> </div>');
		return false;
	}
	return true;
}

function compareDates() {
	var str1 = document.getElementById("startDate").value;
	var str2 = document.getElementById("endDate").value;
	var mon1 = parseInt(str1.substring(0, 2));
	var dt1 = parseInt(str1.substring(3, 5));
	var yr1 = parseInt(str1.substring(6, 10));
	var mon2 = parseInt(str2.substring(0, 2));
	var dt2 = parseInt(str2.substring(3, 5));
	var yr2 = parseInt(str2.substring(6, 10));
	var date1 = new Date(yr1, mon1, dt1);
	var date2 = new Date(yr2, mon2, dt2);

	if (date2 < date1) {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  End Date cannot be before Start Date.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> End Date cannot be before
		// Start Date. <br> </div>');
		document.getElementById("endDate").value = '';
		return false;
	} /* else { */
	/* $("#projectFormId").submit(); */
	/* return validateForm(); */
	/*
	 * showAlert("Submitting ..."); document.projectFormId.submit();
	 */
	/* } */
}

function isNumberKey(evt, id) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		$('#' + id).blur();
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>   Only Number Are Allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only Number Are Allowed.
		// <br> </div>');
		return false;
	}
	return true;
}

function showAlert(msg) {
	bootbox.dialog({
		message : msg,
		buttons : {
			"success" : {
				"label" : "OK",
				"className" : "btn-sm btn-primary"
			}
		}
	});
}

function resetForm(check) {

	$('#projectName').attr("placeholder", "Project Name..");
	$('#projectNumber').attr("placeholder", "Project Number..");
	$('#startDate').attr("placeholder", "Start Date..");
	$('#endDate').attr("placeholder", "End Date..");
	$('#projectNameError').removeClass("has-error");
	$('#projectNumberError').removeClass("has-error");
	$('#startDateError').removeClass("has-error");
	$('#endDateError').removeClass("has-error");
	$('#submitButton').removeAttr('disabled');
	if (check)// checking whether the user has selected the reset form after
				// update command.....
	{
		$("#submitButton").html(
				"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
		$("#projectId").val(-1);

		console.log($("#actionFor").val());
		$("#actionFor").val("");
	}
	$("#projManager").selectpicker("val", "");
	$("#projSupervisor").selectpicker("val", "");
	$('.selectpicker').selectpicker('refresh');

}
function checkValidProjectId(projIdToCheck, id) {
	$("#actionFor").val("UPDATE");

	for (var t = 0; t < mode.aaData.length; t++) {
		var projIdString = String(mode.aaData[t].jobNumber);

		if ($('#' + projIdToCheck).val().toUpperCase() == (projIdString)
				.toUpperCase()) {
			$('#projectNumberError').addClass("has-error");
			$('#submitButton').attr('disabled', 'disabled');
			$('#' + id).blur();
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Project Number already exists.It may have been deleted earlier.. <br>');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Project Number already
			// exists.It may have been deleted earlier.. <br> </div>');
			/* document.getElementById("startDate").blur(); */
			break;
		} else {
			$('#projectNumberError').removeClass("has-error");
			$('#submitButton').removeAttr('disabled');
		}
	}
}

function checkErrorClass(divId, elementId) {
	if ($('#' + elementId).val() == '') {

		$('#' + elementId).attr("placeholder", "This field can't be empty ");

		$('#' + divId).addClass("has-error");
	} else {

		$('#' + divId).removeClass("has-error");
	}
}
function notifications(action, message) {
	var tMessage = null, cMessage = null, text = "";
	if (action == "ERROR") {
		tMessage = "Elecnor FTS : Error!!";
		text = "Unable to perform the action due to " + message
				+ " If this problem exists, please report it to Dev Team. ";
		cMessage = 'gritter-error';
	} else {
		tMessage = "Elecnor FTS : Success!!";
		text = "<b><font color=red>" + message + "</font></b> " + action
				+ "D Successfully";
		cMessage = 'gritter-success';
	}
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title : tMessage,
		// (string | mandatory) the text inside the notification
		text : text,
		class_name : cMessage
	});
}
// function notifications(error)
// {
// $.gritter.add({
// // (string | mandatory) the heading of the notification
// title:"error",
// // (string | mandatory) the text inside the notification
// text: 'Unable to add user due to -'+error+'If this problem exists, please
// report it to Dev Team.',
// class_name: 'gritter-error'
// });
// }
function submitController(e, laddaButtonId) {
	console.log(e);
	if (e == "SAVE-EDIT") {
		if ($("#submitButton").html().indexOf("Submit") != -1) {
			$("#actionFor").val("SAVE");
		} else if ($("#submitButton").html().indexOf("Update") != -1) {
			$("#actionFor").val("UPDATE");
		}
		if (!validateForm())
			return;
	} else {
		$("#actionFor").val(e);

	}
	console.log("Submit Form");
	var l;
	if (laddaButtonId != undefined) {
		l = Ladda.create(laddaButtonId);
		l.start();
	}

	// $("#projectFormId").submit();
	$.ajax({
		url : "projectActionController",
		type : "POST",
		data : $("#projectFormId").serialize(),
		success : function(result) {
			if (l != undefined) {
				l.stop();
			}

			oTableProjectTable.fnClearTable();
			oTableSideProject.fnClearTable();
			getTableDetails();
			if ($("#actionFor").val() == "DELETE") {
				notifications("DELETE", $("#projectName").val());
				resetForm(true);
				$("#myModal").modal("hide");
			} else if ($("#actionFor").val() == "SAVE"
					|| $("#actionFor").val() == "UPDATE") {
				notifications($("#actionFor").val(), $("#projectName").val());
				$("#projectFormId")[0].reset();
				if ($("#actionFor").val() == "SAVE")
					resetForm(true);
				else
					resetForm(false);
				$("#addProjectFormPanel").collapse("hide");

			}
		},
		error : function(result) {

			notifications("ERROR", result);

			if (l != undefined) {
				l.stop();
			}
			console.log("error");

		}

	});
}
function initSelectBox() {
	var lastName = "";
	var e = document.getElementById("projSupervisor");
	var t = document.getElementById("projManager");
	$('#projSupervisor').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	$('#projManager').find('option').remove().end().append(
			'<option value="">--Select--</option>');

	for (var n = 0; n < mode.userList.length; n++) {
		lastName = "";
		var r = document.createElement("option");
		if (mode.userList[n].lastName != undefined) {
			lastName = mode.userList[n].lastName;
		}
		r.text = mode.userList[n].firstName + " " + lastName + " ["
				+ mode.userList[n].userId + "]";
		r.value = mode.userList[n].sNo;
		if (mode.userList[n].status == "INACTIVE") {
			r.style.display = "none";
		}
		if (mode.userList[n].role == "SUPERVISOR") {
			try {
				e.add(r, select.options[null]);
			} catch (i) {
				e.add(r, null);
			}
		} else if (mode.userList[n].role == "MANAGER") {
			try {
				t.add(r, select.options[null]);
			} catch (i) {
				t.add(r, null);
			}
		}
	}
	$(".selectpicker").selectpicker("refresh");
}
function getTableDetails() {
	mode = "proj";
	$
			.ajax({
				url : "getProjDetails",
				type : "POST",
				contentType : "text/plain",
				data : '{"mode": "' + mode + '"}',
				success : function(e) {
					mode = JSON.parse(e);
					console.log("initial");
					console.log(mode);
					if (mode.selectedUser == null
							|| mode.selectedUser == undefined)
						return;
					// initSelectBox();

					var check = false;

					for (var t = 0; t < mode.aaData.length; t++) {
						var managerFirstName, jobNumber,startDateTemp, enddateTemp, managerLastName, supervisorLastName,supervisorFirstName;
						managerFirstName = jobNumber=startDateTemp = enddateTemp = managerLastName = supervisorLastName = supervisorFirstName= "";
						check = false;
						
						if (mode.selectedUser.role == "ADMIN") {
							check = true;
						}
						if (mode.selectedUser.role == "MANAGER") {
							if (mode.aaData[t].manager != undefined
									&& mode.aaData[t].manager.userId == mode.selectedUser.userId)
								check = true;
						}
						if (mode.selectedUser.role == "SUPERVISOR") {

							if (mode.aaData[t].supervisor.userId == mode.selectedUser.userId) {
								check = true;
							}

						}
						
						if(mode.aaData[t].jobNumber!=undefined&&mode.aaData[t].jobNumber!=null){
							jobNumber=mode.aaData[t].jobNumber;
						}
						if (mode.aaData[t].status == "ACTIVE" && check) {

							if (mode.aaData[t].manager != undefined
									&& mode.aaData[t].manager != null) {
								managerFirstName = mode.aaData[t].manager.firstName;
								if (mode.aaData[t].manager.lastName != undefined
										&& mode.aaData[t].manager.lastName != null) {
									managerLastName = mode.aaData[t].manager.lastName;
								}
							}
							
							if(mode.aaData[t].supervisor!=undefined&&mode.aaData[t].supervisor!=null){
								if (mode.aaData[t].supervisor.lastName != undefined
										&& mode.aaData[t].supervisor.lastName != null) {
									supervisorLastName = mode.aaData[t].supervisor.lastName;
								}
								if (mode.aaData[t].supervisor.firstName != undefined
										&& mode.aaData[t].supervisor.firstName != null) {
									supervisorFirstName = mode.aaData[t].supervisor.firstName;
								}
							}
							
							if (mode.aaData[t].startDate != undefined
									&& mode.aaData[t].startDate != null) {
								startDateTemp = moment(
										new Date(mode.aaData[t].startDate))
										.format("MM-DD-YYYY");
							}

							if (mode.aaData[t].endDate != undefined
									&& mode.aaData[t].endDate != null) {
								enddateTemp = moment(
										new Date(mode.aaData[t].endDate))
										.format("MM-DD-YYYY");
							}

							oTableSideProject.fnAddData([
									mode.aaData[t].jobName,
									jobNumber,
									mode.aaData[t].jobId ], false);

							oTableProjectTable

							.fnAddData([ mode.aaData[t].jobName,
							             jobNumber,
									mode.aaData[t].jobId, startDateTemp,
									enddateTemp, managerFirstName,
									supervisorFirstName,
									managerLastName, supervisorLastName ],
									false);

							check = false;
						}
					}
					oTableProjectTable.fnDraw();
					oTableSideProject.fnDraw();
					if (mode.projId != undefined && mode.projId != null
							&& mode.projId.trim() != "") {
						setProjSelected(mode.projId);
					}
					$('#loading').modal('hide');
				},
				error : function() {
					$('#loading').modal('hide');
					errorNotification();
				}
			});

}
function setProjSelected(e) {
	$("#projectId").val(e);
	$("#actionFor").val("SELECT");
	$("#projectFormId").submit();

}
function setProjToEdit(e) {
	$("#addProjectFormPanel").collapse("show");
	for (var t = 0; t < mode.aaData.length; t++) {
		if (e == mode.aaData[t].jobId) {
			console.log("supervisor");
			console.log(mode.aaData[t]);
			$("#projectName").val(mode.aaData[t].jobName);
			$("#projectNumber").val(mode.aaData[t].jobNumber);
			$("#startDate").val(
					moment(new Date(mode.aaData[t].startDate)).format(
							"MM/DD/YYYY"));
			$("#endDate").val(
					moment(new Date(mode.aaData[t].endDate)).format(
							"MM/DD/YYYY"));
			$("#projManager").selectpicker("val", mode.aaData[t].manager.sNo);
			// console.log(mode.aaData[t].supervisor.sNo);
			if (mode.aaData[t].supervisor.sNo != null
					|| mode.aaData[t].supervisor.sNo != undefined) {
				// console.log("entered here"+mode.aaData[t].supervisor.sNo);
				$("#projSupervisor").selectpicker("val",
						mode.aaData[t].supervisor.sNo);
			} else {
				console.log("entered there" + mode.aaData[t].supervisor.sNo);
				$("#projSupervisor").selectpicker("val", "");
			}
			$("#submitButton").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#projectId").val(e);
			break;
		}
	}
}
try {
	ace.settings.check("breadcrumbs", "fixed");
} catch (e) {
}
$(document)
		.ready(
				function() {
					/*
					 * $('#projectName').keypress(function() {
					 * document.getElementById('projectName').removeAttribute("style");
					 * }); $('#projectNumber').keypress(function() {
					 * document.getElementById('projectNumber').removeAttribute("style");
					 * });
					 */
					// Loading image
					$('#loading').modal('show');
					$(".selectpicker").selectpicker();

					$("#startDate").datepicker().on("changeDate", function(e) {
						$("#startDate").datepicker("hide");
						$('#startDateError').removeClass("has-error");
						return compareDates();
					});
					$('#startDate').keydown(function() {
						/* setTimeout(function() { */
						$('#startDate').datepicker("hide");
						/* },1500); */
					});
					$("#endDate").datepicker().on("changeDate", function(e) {
						$("#endDate").datepicker("hide");
						$('#endDateError').removeClass("has-error");
						return compareDates();
					});
					$('#endDate').keydown(function() {
						$('#endDate').datepicker("hide");
					});
					$("#projectSelectShortCut").tooltip();
					$("#fixtureSelectShortCut").tooltip();
					$("#fixtureInDetailShortCut").tooltip();
					$('#dashboardShortcut').tooltip();
					oTableSideProject = $("#sidePanelTableProject")
							.dataTable(
									{
										sDom : "lrtp",
										bSearchable : false,
										"sScrollY" : "450px",
								        "bPaginate" : true,
								        "bScrollCollapse": true,
										aoColumns : [ {
											sClass : "center",
											fnRender : function(e) {
												return "<a  href=\"javascript:setProjSelected('"
														+ e.aData[2]
														+ "')\">"
														+ e.aData[0]
														+ " ["
														+ e.aData[1]
														+ "]"
														+ "</a>";
											}
										} ]
									});
					oTableProjectTable = $("#projectTable")
							.dataTable(
									{
										bFilter : false,
										bSearchable : false,
										aoColumns : [
												{
													sClass : "center",
													fnRender : function(e) {
														id = e.aData[2];
														return "<a  href=\"javascript:setProjSelected('"
																+ id
																+ "')\">"
																+ e.aData[0]
																+ "</a>";
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[1];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[3];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[4];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[5] + " "
																+ e.aData[7];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[6] + " "
																+ e.aData[8];
													}
												} ]
									});
					getTableDetails();

					
					$('#sidePanelTableProject_wrapper > div.dataTables_paginate.paging_bootstrap').css('display','none');
					
				});

$(document).on(
		"click",
		".deleteConfirmDialog",
		function() {
			console.log("Delete Button Clicked");

			if (mode.selectedUser.role == "ADMIN"
					|| mode.selectedUser.role == "SUPERVISOR") {
				console.log(mode.selectedUser.role);
				$("#projectId").val($(this).data("id"));
			} else {
				bootbox.alert("You are not allowed to perform this action");
			}
		});
$("#sidePanelTableProject tbody tr").hover(function(e) {
	if ($(this).hasClass("row_selected")) {
		$(this).removeClass("row_selected");
	} else {
		oTableSideProject.$("tr.row_selected").removeClass("row_selected");
		$(this).addClass("row_selected");
	}
});
$("#sidePanelTableProject thead input").keyup(function() {
	oTableSideProject.fnFilter(this.value, $("thead input").index(this));
});
$("#sidePanelTableProject thead input").each(function(e) {
});
$("#sidePanelTableProject thead input").focus(function() {
	if (this.className == "search_init") {
		this.className = "";
		this.value = "";
	}
});
$("#sidePanelTableProject thead input").blur(function(e) {
	if (this.value == "") {
		this.className = "search_init";
		this.value = asInitVals[$("thead input").index(this)];
	}
});
