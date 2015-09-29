function validateNotifications(message) // For displaying error messages that
										// occurred during validation
{
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title : "Elecnor FTS : Error!!",
		// (string | mandatory) the text inside the notification
		text : message,
		class_name : 'gritter-error'
	});
}
function resetIssueReportForm() {
	$("#relatedProject").selectpicker("val", "");
	$("#severity").selectpicker("val", "");
	$('#description').val("");
	$("#addnlComment").val("");
}

/*function getTableDetailsForIssue() {
	mode = "proj";
	$.ajax({
		url : "getProjDetailsForIssue",
		type : "POST",
		contentType : "text/plain",
		data : '{"mode": "' + mode + '"}',
		success : function(e) {
			mode = JSON.parse(e);
			if (mode.selectedUser == null || mode.selectedUser == undefined)
				return;
			projectListSelectBox();
		},
		async : false
	});
}*/

function checkLength(elementId) {
	if (elementId == "description") {

		$("#description").removeAttr('disabled');
		if (($("#" + elementId).val().length) >= 1000) {
			$("#description").attr('disabled', 'disabled');
			validateNotifications('</i> Error! </strong>  Cannot exceed limit of 1000 characters.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> You cannot exceed the
			// limit of 1000 characters. <br> </div>');
			return false;
		}
	} else if (elementId == "addnlComment") {
		$("#addnlComment").removeAttr('disabled');
		if ($("#" + elementId).val().length >= 500) {
			$("#addnlComment").attr('disabled', 'disabled');
			validateNotifications('</i> Error! </strong>  Cannot exceed limit of 500 characters.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> You cannot exceed the
			// limit of 500 characters. <br> </div>');
			return false;
		}
	}
}
function errorcheck() {
	/*if ($('#relatedProject').val() == "") {
		validateNotifications('</i> Error! </strong>  Project has to be selected.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Project has to be selected.
		// <br> </div>');
		return false;
	}
	if ($('#severity').val() == "") {
		validateNotifications('</i> Error! </strong>  Severity of the project has to be selected.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> severity of the project has
		// to be selected. <br> </div>');
		return false;
	}
	if ($('#description').val() == "") {
		validateNotifications('</i> Error! </strong>  sDescription of the project has to be filled.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Description of the project
		// has to be filled. <br> </div>');
		return false;
	}
*/
}

/*function projectListSelectBox() {
	var e = document.getElementById("relatedProject");
	for (var n = 0; n < mode.projList.length; n++) {
		var r = document.createElement("option");
		r.text = mode.projList[n].projectName + " " + " ["
				+ mode.projList[n].projectNumber + "]";
		r.value = mode.projList[n].projectName + " "
				+ mode.projList[n].projectId;
		try {
			e.add(r, select.options[null]);
		} catch (i) {
			e.add(r, null);
		}
	}
	$("#relatedProject").selectpicker("refresh");
}*/

/*function submitIssue() {
	var check = errorcheck();
	if (check == true) {
		$.ajax({
			type : "POST",
			url : "submitIssue",
			dataType : "json",
			traditional : true,
			data : $('#submitIssueForm').serialize(),
			success : function(data) {
				$('#reportIssueModal').modal('hide');
				bootbox.alert(data.reportStatus);
			},
			error : function(err) {
				$('#reportIssueModal').modal('hide');
				bootbox.alert("Error occured.");
			}
		});
	}
}*/

$(document).ready(function() {
	//getTableDetailsForIssue();
});
