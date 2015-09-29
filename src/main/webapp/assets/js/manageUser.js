function validateNotifications(message) //For displaying error messages that occurred during validation
{
    console.log(message);	
	 $.gritter.add({
		    // (string | mandatory) the heading of the notification
		    title: "Elecnor FTS : Error!!",
		    // (string | mandatory) the text inside the notification
		    text: message,
		    class_name:'gritter-error'
		   });
}

function notifications(action,message)
{
	var tMessage=null,cMessage=null,text="";
	if(action=="ERROR")
		{
		tMessage="Elecnor FTS : Error!!";
		text="Unable to perform the action due to "+message+" If this problem exists, please report it to Dev Team. ";
		cMessage='gritter-error';
		}
	else{
		tMessage="Elecnor FTS : Success!!";
		text="<b><font color=red>"+message+"</font></b> has been "+action +"d Successfully";
		cMessage='gritter-success';
	    }
	 $.gritter.add({
		    // (string | mandatory) the heading of the notification
		    title: tMessage,
		    // (string | mandatory) the text inside the notification
		    text: text,
		    class_name: cMessage
		   });
}
function validateForm() {

	/* Validation for text_field */
	if ($('#firstName').val() == '') {
		$('#firstName').attr("placeholder", "These Field Can't Be Empty");
		$('#firstNameError').addClass("has-error");
		document.manageUserFormId.firstName.focus();
		return false;
	}
	if ($('#emailId').val() == '') {
		$('#emailId').attr("placeholder", "These Field Can't Be Empty");
		$('#emailIdError').addClass("has-error");
		document.manageUserFormId.emailId.focus();
		return false;
	}
	if ($('#userId').val() == '') {
		$('#userId').attr("placeholder", "These Field Can't Be Empty");
		$('#userIdError').addClass("has-error");
		document.manageUserFormId.userId.focus();
		return false;
	}
	if ($('#password').val() == '') {
		$('#password').attr("placeholder", "These Field Can't Be Empty");
		$('#passwordError').addClass("has-error");
		document.manageUserFormId.password.focus();
		return false;
	}

	/* Validate Select Box */
	if ($('#role').val() == "") {
		validateNotifications('</i> Error! </strong>  Role has to be selected.');
		//showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i class="icon-remove"></i> </button>  <strong> <i class="icon-remove"></i> Error! </strong>  Role has to be selected. <br> </div>');
		return false;
	}
	if ($('#supervisorSelect').val() == "") {
		validateNotifications('</i> Error! </strong>  Supervisor has to be selected.');
		//showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i class="icon-remove"></i> </button>  <strong> <i class="icon-remove"></i> Error! </strong>  Role has to be selected. <br> </div>');
		return false;
	}
	return true;
}

function checkErrorClass(divId, elementId) {
	if ($('#' + elementId).val() == '') {

		$('#' + elementId).attr("placeholder", "These Field Can't Be Empty");

		$('#' + divId).addClass("has-error");
	} else {
		$('#' + divId).removeClass("has-error");
	}
}

//function showAlert(msg) {
//	bootbox.dialog({
//		message : msg,
//		buttons : {
//			"success" : {
//				"label" : "OK",
//				"className" : "btn-sm btn-primary"
//			}
//		}
//	});
//}

function validateEmail(email) {
	var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

	if (email == "") {
		return;
	}
	if (filter.test(email)) {
		return true;
	} else {
		document.getElementById("emailId").value = '';
		/* bootbox.alert("Please Enter valid Email ID of the User."); */
		validateNotifications('</i> Error! </strong>  Please enter the valid Email ID of User.');
		//showAlert('<div class="alert alert-danger"> <i class="icon-remove"></i> </button>  <strong> <i class="icon-remove"></i> Error! </strong>  Please Enter valid Email ID of the User. <br> </div>');
		return false;
	}
}

function submitController(e, laddaButtonId) {
	if (e == "SAVE-EDIT") {
		if ($("#submitButtonUser").html().indexOf("Submit") != -1) {
			$("#actionForUser").val("SAVE");
		} else if ($("#submitButtonUser").html().indexOf("Update") != -1) {
			$("#actionForUser").val("UPDATE");
		}
		if (!validateForm())
			return;
	} else {
		$("#actionForUser").val(e);
	}
	if (laddaButtonId != undefined) {
		var l = Ladda.create(laddaButtonId);
		l.start();
	}
	// $("#manageUserFormId").submit();
	$.ajax({
		url : "manageUserAction",
		type : "POST",
		data : $("#manageUserFormId").serialize(),
		success : function(result) {
			console.log("success");
			console.log(result);
			oTableUserTable.fnClearTable();
			oTableSideUserTable.fnClearTable();
			getUserDetails();
		    l.stop();
			if ($("#actionForUser").val() == "DELETE") {
				notifications("DELETE", $("#userId").val());
				$("#manageUserFormId")[0].reset();
				resetUserForm(true);
				$("#myModal").modal("hide");
			} else if ($("#actionForUser").val() == "SAVE"
					|| $("#actionForUser").val() == "UPDATE") {
				notifications($("#actionForUser").val(), $("#userId").val());
				$("#manageUserFormId")[0].reset();
				if($("#actionForUser").val()=="SAVE")
					resetUserForm(true);
					else
						resetUserForm(false);
				$("#addUserFormPanel").collapse("hide");
			}
		},
		error : function(xhr, ajaxOptions, thrownError) {
			notifications("ERROR",thrownError);
//			alert(xhr.status);
//			alert(thrownError);
		}

	});
}

function selectBoxSupervisor() {
	var e = document.getElementById("supervisorSelect");
	var lastName = "";
	for (var n = 0; n < mode.allUserList.length; n++) {
		if (mode.allUserList[n].lastName != undefined) {
			lastName = mode.allUserList[n].lastName;
		}
		var r = document.createElement("option");
		r.text = mode.allUserList[n].firstName + " " + lastName;
		r.value = mode.allUserList[n].sNo;
		if (mode.allUserList[n].role == "SUPERVISOR") {
			try {
				e.add(r, select.options[null]);
			} catch (i) {
				e.add(r, null);
			}
		}
	}
	$(".selectpicker").selectpicker("refresh");
}

function resetUserForm(check) {
	$('#firstName').attr("placeholder", "First Name...");
	$('#firstNamerror').removeClass("has-error");
	$('#emailId').attr("placeholder", "Email Id...");
	$('#emailIdError').removeClass("has-error");
	$('#userId').attr("placeholder", "User Id...");
	$('#userIdError').removeClass("has-error");
	$('#password').attr("placeholder", "Password...");
	$('#passwordError').removeClass("has-error");
	if(check)//checking whether the user has selected the reset form after update command..... 
	{
	$("#submitButtonUser").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$("#sNo").val(-1);
	$("#actionForUser").val("");
	}
	$("#supervisorSelect").selectpicker("val", "");
	$("#role").selectpicker("val", "");
}

function setUserToEdit(e) {

	$("#addUserFormPanel").collapse("show");

	for (var t = 0; t < mode.allUserList.length; t++) {
		if (e == mode.allUserList[t].sNo) {

			$("#firstName").val(mode.allUserList[t].firstName);

			var middleName, lastName, supervisorId;
			lastName = middleName = supervisorId = "";
			if (mode.allUserList[t].middleName != undefined)
				middleName = mode.allUserList[t].middleName;
			else
				middleName = "";
			$("#middleName").val(middleName);
			if (mode.allUserList[t].lastName != undefined)
				lastName = mode.allUserList[t].lastName;
			else
				lastName = "";
			$("#lastName").val(lastName);
			$("#emailId").val(mode.allUserList[t].emailId);
			$("#userId").val(mode.allUserList[t].userId);
			$("#password").val(mode.allUserList[t].password);
			$("#role").selectpicker("val", mode.allUserList[t].role);

			if (mode.allUserList[t].supervisorId != undefined)
				supervisorId = mode.allUserList[t].supervisorId;
			$("#supervisorSelect").selectpicker("val", supervisorId);

			$(".selectpicker").selectpicker("refresh");
			$("#submitButtonUser").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#sNo").val(e);
			break;
		}
	}
}

function getUserDetails() {

	mode = "user";

	$.ajax({
		url : "getUserDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {

			mode = JSON.parse(result);
			selectBoxSupervisor();
			var middleName, lastName;
			middleName = lastName = "";

			for (var t = 0; t < mode.allUserList.length; t++) {

				if (mode.allUserList[t].middleName == undefined
						|| mode.allUserList[t].middleName == null
						|| mode.allUserList[t].middleName == "")
					middleName = "";
				else
					middleName = mode.allUserList[t].middleName;

				if (mode.allUserList[t].lastName == undefined
						|| mode.allUserList[t].lastName == null)
					lastName = "";
				else
					lastName = mode.allUserList[t].lastName;

				if (mode.allUserList[t].status == "ACTIVE") {

					oTableSideUserTable.fnAddData(
							[ mode.allUserList[t].firstName, middleName,
									lastName ], false);

					oTableUserTable.fnAddData([ mode.allUserList[t].sNo,
							mode.allUserList[t].firstName, middleName,
							lastName, mode.allUserList[t].emailId,
							mode.allUserList[t].userId,
							mode.allUserList[t].role,
							mode.allUserList[t].supervisorName

					], false);
				}
			}
			oTableUserTable.fnDraw();
			oTableSideUserTable.fnDraw();

		}
	});
}

/* ...............inline scripts related to this page.............. */

$(document)
		.ready(
				function() {
					$('#loading').modal('show');
					oTableSideUserTable = $('#sidePanelTableMangUser')
							.dataTable(
									{
										"sDom" : "lrtp",
										"bSearchable" : false,
										"bDestroy" : true,
										aoColumns : [ {
											sClass : "center",
											fnRender : function(e) {
												return e.aData[0] + " "
														+ e.aData[1] + " "
														+ e.aData[2];
											}
										} ]
									});

					oTableUserTable = $('#manageUserTable ')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										aoColumns : [
												{
													sClass : "center",
													fnRender : function(e) {
														idUser = e.aData[0];
														return e.aData[1];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[2];
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
														return e.aData[5];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[6];
													}
												},
												{
													sClass : "center",
													fnRender : function(e) {
														return e.aData[7];
													}
												},
												{
													mData : null,
													sClass : "center",
													fnRender : function(e) {
														// Commenting Old Return
														// Statement-- Removing
														// Delete Funcionality
														/*
														 * return "<div
														 * class='pull-right
														 * action-buttons'><a
														 * class='blue'
														 * href=\"javascript:setUserToEdit('" +
														 * idUser + "')\"> <i
														 * class='fa fa-pencil
														 * bigger-130'></i></a>
														 * <a
														 * class='deleteConfirmDialog
														 * red' href='#'
														 * data-id=" + idUser + "
														 * data-toggle='modal'
														 * data-target='#myModal' >
														 * <i class='fa
														 * fa-trash-o
														 * bigger-130'></i></a></div>";
														 */
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setUserToEdit('"
																+ idUser
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a></div>";

													}
												} ]
									});
					getUserDetails();
					$('#loading').modal('hide');
				});

$(document).on("click", ".deleteConfirmDialog", function() {
	$("#sNo").val($(this).data("id"));
});

$(".selectpicker").selectpicker();
/*
 * if (/Android|webOS|iPhone|iPad|iPod|BlackBerry/i .test(navigator.userAgent)) {
 * $('.selectpicker').selectpicker('mobile'); }
 */
jQuery(function($) {
	$('#projectSelectShortCut').tooltip();
	$('#fixtureSelectShortCut').tooltip();
	$('#fixtureInDetailShortCut').tooltip();
	$('#dashboardShortcut').tooltip();
	$('#recent-box [data-rel="tooltip"]').tooltip({
		placement : tooltip_placement
	});

	function tooltip_placement(context, source) {
		var $source = $(source);
		var $parent = $source.closest('.tab-content');
		var off1 = $parent.offset();
		var w1 = $parent.width();
		var off2 = $source.offset();
		var w2 = $source.width();
		if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
			return 'right';
		return 'left';
	}

	$('.dialogs,.comments').slimScroll({
		height : '300px'
	});

	// Android's default browser somehow is confused when tapping on label which
	// will lead to dragging the task
	// so disable dragging when clicking on label
	var agent = navigator.userAgent.toLowerCase();
	if ("ontouchstart" in document && /applewebkit/.test(agent)
			&& /android/.test(agent))
		$('#tasks').on('touchstart', function(e) {
			var li = $(e.target).closest('#tasks li');
			if (li.length == 0)
				return;
			var label = li.find('label.inline').get(0);
			if (label == e.target || $.contains(label, e.target))
				e.stopImmediatePropagation();
		});

	$('#tasks').sortable({
		opacity : 0.8,
		revert : true,
		forceHelperSize : true,
		placeholder : 'draggable-placeholder',
		forcePlaceholderSize : true,
		tolerance : 'pointer',
		stop : function(event, ui) {// just for Chrome!!!! so that dropdowns on
			// items don't appear below other items
			// after being moved
			$(ui.item).css('z-index', 'auto');
		}
	});
	$('#tasks').disableSelection();
	$('#tasks input:checkbox').removeAttr('checked').on('click', function() {
		if (this.checked)
			$(this).closest('li').addClass('selected');
		else
			$(this).closest('li').removeClass('selected');
	});
});

$("#sidePanelTableMangUser tbody tr").hover(function(e) {

	if ($(this).hasClass('row_selected')) {
		$(this).removeClass('row_selected');
	} else {
		oTable.$('tr.row_selected').removeClass('row_selected');
		$(this).addClass('row_selected');
	}
});

$("thead input").keyup(function() {
	/* Filter on the column (the index) of this element */
	oTable.fnFilter(this.value, $("thead input").index(this));
});

/*
 * Support functions to provide a little bit of 'user friendlyness' to the
 * textboxes in the footer
 */

$("thead input").each(function(i) {
	/* asInitVals[i] = this.value; */
});

$("thead input").focus(function() {
	/*
	 * if (this.className == "search_init") { this.className = ""; this.value =
	 * ""; }
	 */
});
$("thead input").blur(function(i) {
	/*
	 * if (this.value == "") { this.className = "search_init"; this.value =
	 * asInitVals[$("thead input").index(this)]; }
	 */
});
