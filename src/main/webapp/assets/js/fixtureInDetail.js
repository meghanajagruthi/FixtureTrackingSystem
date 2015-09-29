function fillTrackSummaryDetails(laddaButtonId)
{
	
	$("#fixtureSummary").val($("#fixtureQty").val());
	$("#lampSummary").val($("#lampQty").val());
	$("#dateSubmittedSummary").val($("#dateSubmitted").val());
	$("#dateApprovedSummary").val($("#dateApproved").val());
	$("#dateOnsiteSummary").val($("#dateNeededOnsite").val());
	$("#dateReleasedToVendorSummary").val($("#dateReleaseVendor").val());
	$("#dateEstimatedRecievedSummary").val($("#dateEstimatedReceived").val());
	$("#dateEstimatedDeliverySummary").val($("#dateEstimatedDelivery").val());
	$("#dateActualRecievedSummary").val($("#dateActualReceived").val());
	$("#dateActualDeliverySummary").val($("#dateActualDelivery").val());
    $("#fixtureRecievedGoodSummary").val($("#fixtureGood").val());	
    $("#lampRecievedGoodSummary").val($("#lampGood").val());
    
    if($("#finishButton").html().substr(0,6)=="Finish")
    	{
    	submitController('SAVE-EDIT','trackingForm',laddaButtonId);
    	}
	
}

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
function eSheetFormSubmitVaildation() {
	if ($('#eDesignCount').val() == '') {
		$('#eDesignCount').attr("placeholder", "This field can't be empty.");
		$('#eDesignCountError').addClass("has-error");
		document.getElementById('eDesignCount').focus();
		return false;
	} else {
		return true;
	}
}

function aSheetFormSubmitVaildation() {
	if ($('#aDesignCount').val() == '') {
		$('#aDesignCount').attr("placeholder", "This field can't be empty.");
		$('#aDesignCountError').addClass("has-error");
		document.aSheetFormId.aDesignCount.focus();
		return false;
	} else {
		return true;
	}
}

function atticSheetFormSubmitVaildation() {
	if ($('#atticStockCount').val() == '' && $('#spareCount').val() == '') {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  At least One Field Must Be Entered');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> At least One Field Must Be
		// Entered. <br> </div>');
		return false;
	} else {
		return true;
	}
}

function trackingForm1Validation() {

	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
	if ($('#dateSubmitted').val() !== '') {
		if (!(date_regex.test($('#dateSubmitted').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Submitted Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Submitted
			// Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateApproved').val() !== '') {
		if (!(date_regex.test($('#dateApproved').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Approved Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Approved
			// Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateNeededOnsite').val() !== '') {
		if (!(date_regex.test($('#dateNeededOnsite').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Needed On Site Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Needed On
			// Site Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateReleaseVendor').val() !== '') {
		if (!(date_regex.test($('#dateReleaseVendor').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Release Vendor Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Release
			// Vendor Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateEstimatedReceived').val() !== '') {
		if (!(date_regex.test($('#dateEstimatedReceived').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Estimate Received Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Estimated
			// Received Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateEstimatedDelivery').val() !== '') {
		if (!(date_regex.test($('#dateEstimatedDelivery').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Estimated Delivery Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Estimated
			// Delivery Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateActualReceived').val() !== '') {
		if (!(date_regex.test($('#dateActualReceived').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Actual Received Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Actual
			// Received Date. <br> </div>');
			return false;
		}
	}
	if ($('#dateActualDelivery').val() !== '') {
		if (!(date_regex.test($('#dateActualDelivery').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Actual Delivery Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Actual
			// Delivery Date. <br> </div>');
			return false;
		}
	}
	/*
	 * if ($('#fixPmInformedDate').val() !== '') { if
	 * (!(date_regex.test($('#fixPmInformedDate').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Pm Team
	 * Informed Date. <br> </div>'); return false; } } if
	 * ($('#fixRecorderDate').val() !== '') { if
	 * (!(date_regex.test($('#fixRecorderDate').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Fixture
	 * Recorder Date. <br> </div>'); return false; } } if
	 * ($('#fixVendorInformedDate').val() !== '') { if
	 * (!(date_regex.test($('#dateVendorInformed_1').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Vendor
	 * Informed Date. <br> </div>'); return false; } } if
	 * ($('#lampPmInformedDate').val() !== '') { if
	 * (!(date_regex.test($('#lampPmInformedDate').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Lamp PM
	 * Informed Date. <br> </div>'); return false; } } if
	 * ($('#lampRecorderDate').val() !== '') { if
	 * (!(date_regex.test($('#lampRecorderDate').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Lamp
	 * Recorder Date. <br> </div>'); return false; } } if
	 * ($('#lampVendorInformedDate').val() !== '') { if
	 * (!(date_regex.test($('#lampVendorInformedDate').val()))) { showAlert('<div
	 * class="alert alert-danger"> <i class="icon-remove"></i> </button>
	 * <strong> <i class="icon-remove"></i> Error! </strong> Incorrect Vendor
	 * Informed Date. <br> </div>'); return false; } }
	 */
	if ($('#fixtureQty').val() == '' && $('#lampQty').val() == '') {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  At least fixture or lamp must be entered.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> At least fixture or lamp
		// must be entered. <br> </div>');
		return false;
	} else {
		return true;
	}

}

function issueFormSubmitVaildation() {
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
	if ($('#issueDate').val() !== '') {
		if (!(date_regex.test($('#issueDate').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Issue Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Issue Date.
			// <br> </div>');
			return false;
		}
	}
	if ($('#resolvedDate').val() !== '') {
		if (!(date_regex.test($('#resolvedDate').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Resolved Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Resolved
			// Date. <br> </div>');
			return false;
		}
	}

	// Validation for text area
	if ($('#issueProb').val().trim() == '') {
		$('#issueProbb').attr("placeholder", "This field can't be empty.");
		$('#issueProbError').addClass("has-error");
		document.getElementById('issueProb').focus();
		return false;
	} else {
		return true;
	}
}

function changeOrderFormSubmitVaildation() {
	var date_regex = /^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/;
	if ($('#changeOrderDate').val() !== '') {
		if (!(date_regex.test($('#changeOrderDate').val()))) {
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>  Incorrect Change Order Date.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Incorrect Change Order
			// Date. <br> </div>');
			return false;
		}
	}

	if ($('#quantity').val() == '') {
		$('#quantity').attr("placeholder", "This field can't be empty.");
		$('#quantityError').addClass("has-error");
		document.getElementById('quantity').focus();
		return false;
	} else {
		return true;
	}
}

function compareDates() {
	var str1 = document.getElementById("dateSubmitted").value;
	var str2 = document.getElementById("dateApproved").value;
	var mon1 = parseInt(str1.substring(0, 2));
	var dt1 = parseInt(str1.substring(3, 5));
	var yr1 = parseInt(str1.substring(6, 10));
	var mon2 = parseInt(str2.substring(0, 2));
	var dt2 = parseInt(str2.substring(3, 5));
	var yr2 = parseInt(str2.substring(6, 10));
	var date1 = new Date(yr1, mon1, dt1);
	var date2 = new Date(yr2, mon2, dt2);

	if (date2 < date1) {
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>   Date Approved cannot be before Date Submitted.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Date Approved cannot be
		// before Date Submitted. <br> </div>');
		document.getElementById("dateApproved").value = '';
		return false;
	} /* else { */
	/* $("#projectFormId").submit(); */
	/* return validateForm(); */
	/*
	 * showAlert("Submitting ..."); document.projectFormId.submit();
	 */
	/* } */
}

function popUpToReceivedDate() {
	// set number of days to add
	var formDate = document.getElementById("dateReleaseVendor").value;
	var interval = 56;
	var startDate = new Date(Date.parse(formDate));
	/* var expDate = startDate; */
	var expDate = startDate.setDate(startDate.getDate() + interval);
	/* expDate.setDate(startDate.getDate() + interval); */
	document.getElementById("dateEstimatedReceived").value = moment(expDate)
			.format("MM/DD/YYYY");
};

function popUpToDeliveryDate() {
	var formDate = document.getElementById("dateReleaseVendor").value;
	var interval = 63;
	var startDate = new Date(Date.parse(formDate));
	var expDate = startDate;
	expDate.setDate(startDate.getDate() + interval);
	document.getElementById("dateEstimatedDelivery").value = moment(
			new Date(expDate)).format("MM/DD/YYYY");
	;
};

function isNumberKey(evt, id) {

	var charCode = (evt.which) ? evt.which : event.keyCode;

	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		$('#' + id).blur();

		$("#eDesignCountError").addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$("#aDesignCountError").addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#atticStockCountError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#spareCountError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#quantityErrorChngOrdr').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#fixtureQtyError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#lampQtyError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#fixtureGoodError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#lampGoodError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#badFixQtyError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;

		$('#badLampQtyError').addClass("has-error");
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Only number is allowed.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only number is allowed.
		// <br> </div>');
		return false;
	}

	return true;
}

// function showAlert(msg) {
// bootbox.dialog({
// message : msg,
// buttons : {
// "success" : {
// "label" : "OK",
// "className" : "btn-sm btn-primary"
// }
// }
// });
// }

function checkErrorClass(divId, elementId) {
	if ($('#' + elementId).val() == '') {
		$('#' + elementId).attr("placeholder", "This field can't be empty.");
		$('#' + divId).addClass("has-error");
	} else {
		$('#' + divId).removeClass("has-error");
		$("#" + elementId).removeAttr('disabled');
		if ($("#" + elementId).val().length >= 500) {
			$("#" + elementId).attr('disabled', 'disabled');
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> You cannot exceed the limit of 500 characters.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> You cannot exceed the
			// limit of 500 characters. <br> </div>');
			return false;
		}
	}
}

function setFixtureSelected(e) {
	$("#fixtureNumber").val(e);
	$("#selectFixtureFormId").submit();
}

function resetFormESheet() {
	$('#eDesignCount').attr("placeholder", "E Sheet Count..");
	$('#eDesignCountError').removeClass("has-error");
	$("#submitButtonESheet").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$("#eDesignId").val(-1);
	$("#actionForESheet").val("");
}

function resetFormASheet() {
	$('#aDesignCount').attr("placeholder", "A Sheet Count..");
	$('#aDesignCountError').removeClass("has-error");
	$("#submitButtonASheet").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$("#aDesignId").val(-1);
	$("#actionForASheet").val("");
}

function resetFormAtticStock() {
	$("#submitButtonAtticStock").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$("#atticStockId").val(-1);
	$("#actionForAtticStock").val("");
}

function resetFormIssue() {
	$("#submitButtonIssue").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$('#issueProb').attr("placeholder", "Issue / Problem...");
	$('#issueProbError').removeClass("has-error");
	$("#issueId").val(-1);
	$("#actionForIssue").val("");

}

function resetFormChangeOrder() {
	$('#quantity').attr("placeholder", "Quantity..");
	$('#quantity').removeClass("has-error");

	$("#submitBtnChngOrder").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Submit");
	$("#changeOrderId").val(-1);
	$("#actionForChngOrdr").val("");
}
function resetFormTracking() {
	$('#fixtureGood').attr("placeholder", "Fixture Good...");
	$('#fixtureGoodError').removeClass("has-error");
	$('#lampGood').attr("placeholder", "Lamp Good...");
	$('#lampGoodError').removeClass("has-error");

	$("#submitButtonTrackingNew").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Save");
	$("#submitButtonTrackingEstimate").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Save");
	$("#submitButtonTrackingDelivered").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i> Save");
	

	if($("#step4").hasClass('active'))
	{
		 $("#step4").removeClass('active');
	}
	else if($("#step3").hasClass('active'))
	{
		 $("#step3").removeClass('active');
	}
	else if($("#step2").hasClass('active'))
	{
		 $("#step2").removeClass('active');
	}
	if(!$("#step1").hasClass('active'))
	{
	   $("#step1").addClass('active');
	   $("#finishButton").html("<i class='fa fa-arrow-right icon-on-right'></i> Next");
	}
	
	$("#trackingIdUI").val(-1);
	$("#actionForTracking").val("");
}

function submitController(e, formId, laddaButtonId) {
	var l;
	if (formId == "eSheetFormId") {
		if (e == "SAVE-EDIT") {
			if ($("#submitButtonESheet").html().indexOf("Submit") != -1) {
				$("#actionForESheet").val("SAVE");
			} else if ($("#submitButtonESheet").html().indexOf("Update") != -1) {
				$("#actionForESheet").val("UPDATE");
			}
			if (!eSheetFormSubmitVaildation())
				return;
		} else {
			$("#actionForESheet").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("eSheetAction", formId, l);
	} else if (formId == "aSheetFormId") {
		if (e == "SAVE-EDIT") {
			if ($("#submitButtonASheet").html().indexOf("Submit") != -1) {
				$("#actionForASheet").val("SAVE");
			} else if ($("#submitButtonASheet").html().indexOf("Update") != -1) {
				$("#actionForASheet").val("UPDATE");
			}
			if (!aSheetFormSubmitVaildation())
				return;
		} else {
			$("#actionForASheet").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("aSheetAction", formId, l);
	} else if (formId == "atticStockFormId") {
		if (e == "SAVE-EDIT") {
			if ($("#submitButtonAtticStock").html().indexOf("Submit") != -1) {
				$("#actionForAtticStock").val("SAVE");
			} else if ($("#submitButtonAtticStock").html().indexOf("Update") != -1) {
				$("#actionForAtticStock").val("UPDATE");
			}
			if (!atticSheetFormSubmitVaildation())
				return;
		} else {
			$("#actionForAtticStock").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("attStockAction", formId, l);
	} else if (formId == "issueFormId") {

		if (e == "SAVE-EDIT") {
			if ($("#submitButtonIssue").html().indexOf("Submit") != -1) {
				$("#actionForIssue").val("SAVE");
			} else if ($("#submitButtonIssue").html().indexOf("Update") != -1) {
				$("#actionForIssue").val("UPDATE");
			}
			if (!issueFormSubmitVaildation())
				return;
		} else {

			$("#actionForIssue").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("issueAction", formId, l);
	} else if (formId == "chngOdrFormId") {
		if (e == "SAVE-EDIT") {
			if ($("#submitBtnChngOrder").html().indexOf("Submit") != -1) {
				$("#actionForChngOrdr").val("SAVE");
			} else if ($("#submitBtnChngOrder").html().indexOf("Update") != -1) {
				$("#actionForChngOrdr").val("UPDATE");
			}
			if (!changeOrderFormSubmitVaildation())
				return;
		} else {
			$("#actionForChngOrdr").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("changeOrderAction", formId, l);
	} else if (formId == "trackingForm") {
		if (e == "SAVE-EDIT") {
			if($("#finishButton").html().indexOf("Finish") != -1)
			{
				if (!trackingForm1Validation())
					return;
				
				else if ($("#submitButtonTrackingNew").html().indexOf("Save") != -1) {
					$("#actionForTracking").val("SAVE");
					
				} else if ($("#submitButtonTrackingNew").html().indexOf("Update") != -1) {
					$("#actionForTracking").val("UPDATE");
					
				}
			
			}
			else if ($("#submitButtonTrackingNew").html().indexOf("Save") != -1) {
				$("#actionForTracking").val("SAVE");
			} else if ($("#submitButtonTrackingNew").html().indexOf("Update") != -1) {
				$("#actionForTracking").val("UPDATE");
			}
			if (!trackingForm1Validation())
				return;
		} else {
			$("#actionForTracking").val(e);
		}
		// code for ladda style on buttons
		if (laddaButtonId != undefined) {
			l = Ladda.create(laddaButtonId);
			l.start();
		}
		submitFormAjax("trackingController", formId, l);
	} else if (formId == '') {
		$('#myModal').modal('hide');
		if (formIdGlobal == "eSheetFormId") {
			$("#actionForESheet").val(e);
			submitFormAjax("eSheetAction", formIdGlobal);
		} else if (formIdGlobal == "aSheetFormId") {
			$("#actionForASheet").val(e);
			submitFormAjax("aSheetAction", formIdGlobal);
		} else if (formIdGlobal == "atticStockFormId") {
			$("#actionForAtticStock").val(e);
			submitFormAjax("attStockAction", formIdGlobal);
		} else if (formIdGlobal == "issueFormId") {
			$("#actionForIssue").val(e);
			submitFormAjax("issueAction", formIdGlobal);
		} else if (formIdGlobal == "chngOdrFormId") {
			$("#actionForChngOrdr").val(e);
			submitFormAjax("changeOrderAction", formIdGlobal);
		} else if (formIdGlobal == "trackingForm") {
			$("#actionForTracking").val(e);
			submitFormAjax("trackingController", formIdGlobal);
		}
	} else {
		console.log("Form Id Not Matched");
	}
}

function setESheetToEdit(e) {
	for (var t = 0; t < modeSheet.eDesignList.length; t++) {
		if (e == modeSheet.eDesignList[t].eDesignId) {
			$("#eDesignCount").val(modeSheet.eDesignList[t].eDesignCount);
			$("#eDesignNum").val(modeSheet.eDesignList[t].eDesignNum);
			$("#eDesignDesc").val(modeSheet.eDesignList[t].eDesignDesc);
			$("#eDesignArea").val(modeSheet.eDesignList[t].eDesignArea);
			$("#eDesignLocation").val(modeSheet.eDesignList[t].eDesignLocation);
			$("#comments").val(modeSheet.eDesignList[t].comments);
			$("#submitButtonESheet").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#eDesignId").val(e);
			break;
		}
	}
}

function setASheetToEdit(e) {
	for (var t = 0; t < modeSheet.aDesignList.length; t++) {
		if (e == modeSheet.aDesignList[t].aDesignId) {
			$("#aDesignCount").val(modeSheet.aDesignList[t].aDesignCount);
			$("#aDesignNum").val(modeSheet.aDesignList[t].aDesignNum);
			$("#aDesignDesc").val(modeSheet.aDesignList[t].aDesignDesc);
			$("#aDesignArea").val(modeSheet.aDesignList[t].aDesignArea);
			$("#aDesignLocation").val(modeSheet.aDesignList[t].aDesignLocation);
			$("#aSheetComments").val(modeSheet.aDesignList[t].aSheetComments);
			$("#submitButtonASheet").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#aDesignId").val(e);
			break;
		}
	}
}

function setAtticStockToEdit(e) {
	for (var t = 0; t < modeSheet.atticStockList.length; t++) {
		if (e == modeSheet.atticStockList[t].atticStockId) {
			$("#atticStockCount").val(
					modeSheet.atticStockList[t].atticStockCount);
			$("#spareCount").val(modeSheet.atticStockList[t].spareCount);
			$("#submitButtonAtticStock").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#atticStockId").val(e);
			break;
		}
	}
}

function setIssueToEdit(e) {

	$("#issueDetailsPanel").collapse("show");

	for (var t = 0; t < modeIssue.issueList.length; t++) {
		if (e == modeIssue.issueList[t].issueId) {
			$("#issueProb").val(modeIssue.issueList[t].issueProb);
			$("#assignedTo").val(modeIssue.issueList[t].assignedTo);
			$("#issueStatus").selectpicker("val",
					modeIssue.issueList[t].issueStatus);
			var issueDate, resolvedDate;
			issueDate = resolvedDate = '';
			if (modeIssue.issueList[t].issueDate == null
					|| modeIssue.issueList[t].issueDate == undefined)
				issueDate = "";
			else
				issueDate = moment(new Date(modeIssue.issueList[t].issueDate))
						.format("MM/DD/YYYY");

			if (modeIssue.issueList[t].resolvedDate == null
					|| modeIssue.issueList[t].resolvedDate == undefined)
				resolvedDate = "";
			else
				resolvedDate = moment(
						new Date(modeIssue.issueList[t].resolvedDate)).format(
						"MM/DD/YYYY");

			$("#issueDate").val(issueDate);
			$("#resolvedDate").val(resolvedDate);
			$("#submitButtonIssue").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#issueId").val(e);
			break;
		}
	}
}
function sumOfGoodBad(val1, val2) {

	var value1 = document.getElementById(val1).value;
	var value2 = document.getElementById(val2).value;
	var sum = parseFloat(value1) + parseFloat(value2);
	return sum;
}

function fixtureEmpty() {
	if ($('#fixtureQty').val() == '') {
		$(fixtureGood).blur();
		$(badFixtureQty).blur();
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Please enter fixture quantity first.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Please enter fixture
		// quantity first. <br> </div>');
		document.getElementById('fixtureGood').value = "";
		document.getElementById('badFixtureQty').value = "";
		return false;
	}
}

function LampEmpty() {
	if ($('#lampQty').val() == '') {
		$(lampGood).blur();
		$(badLampQty).blur();
		validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Please enter Lamp quantity first.');
		// showAlert('<div class="alert alert-danger" style="margin-top:2%"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Please enter Lmap quantity
		// first. <br> </div>');
		document.getElementById('lampGood').value = "";
		document.getElementById('badLampQty').value = "";
		return false;
	}
}

function checkFixGoodVal(divId) {
	if (divId == 'fixtureGood') {
		var valueGood = parseInt(document.getElementById('fixtureGood').value);
		var fixQty = parseInt(document.getElementById('fixtureQty').value);
		if (valueGood > fixQty) {
			document.getElementById('fixtureGood').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong> Value entered is more than Fixture Quantity.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Value entered is more
			// than Fixture Quantity. <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	} else if (divId == 'lampGood') {
		var valueGood = parseInt(document.getElementById('lampGood').value);
		var lampQty = parseInt(document.getElementById('lampQty').value);
		if (valueGood > lampQty) {
			document.getElementById('lampGood').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>Value entered is more than Lamp Quantity.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Value entered is more
			// than Lamp Quantity. <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	}

	else if (divId == 'badFixtureQty') {
		var valueGood = parseInt(document.getElementById('badFixtureQty').value);
		var lampQty = parseInt(document.getElementById('fixtureQty').value);
		if (valueGood > lampQty) {
			document.getElementById('badFixtureQty').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>Value entered is more than Fixture Quantity.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Value entered is more
			// than Fixture Quantity. <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	} else if (divId == 'badLampQty') {
		var valueGood = parseInt(document.getElementById('badLampQty').value);
		var lampQty = parseInt(document.getElementById('lampQty').value);
		if (valueGood > lampQty) {
			document.getElementById('badLampQty').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>Value entered is more than Lamp Quantity.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Value entered is more
			// than Lamp Quantity. <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	}

}

function checkFixBadVal(divId) {
	if (divId == 'badFixtureQty') {
		var fixQty = document.getElementById('fixtureQty').value;
		var fixQtyBadVal = document.getElementById('badFixtureQty').value;
		var fixQtyGoodVal = document.getElementById('fixtureGood').value;
		var sumGoodBad = sumOfGoodBad("fixtureGood", "badFixtureQty");

		$(divId).blur();
		if (sumGoodBad > fixQty) {
			document.getElementById('badFixtureQty').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>Please check fixture bad value!!.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i> Error! </strong> Please check fixture
			// bad value!!! <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	}

	if (divId == 'badLampQty') {
		var lampQty = document.getElementById('lampQty').value;
		var sumGoodBadLamp = sumOfGoodBad("lampGood", "badLampQty");
		if (sumGoodBadLamp > lampQty) {
			document.getElementById('badLampQty').value = "";
			validateNotifications('<strong> <i class="icon-remove"></i> Error! </strong>Please check lamp bad value!!.');
			// showAlert('<div class="alert alert-danger" style="margin-top:2%">
			// <i class="icon-remove"></i> </button> <strong> <i
			// class="icon-remove"></i>Error! </strong> Please check lamp bad
			// value!!! <br> </div>');
			this.focus();
			return;
		} else {
			return;
		}
	}
}

function setBadFixtureDetails(e) {
	$
			.ajax({
				url : "getBadLampDetails",
				type : "POST",
				contentType : 'text/plain',
				data : '{"mode": "' + e + '"}',
				success : function(result) {
					modeIssue = JSON.parse(result);
					var fixRecorderDateTemp, fixPmInformedDateTemp, fixVendorInformedDateTemp;
					fixRecorderDateTemp = fixPmInformedDateTemp = fixVendorInformedDateTemp = "";
					for (var i = 0; i < 2; i++) {
						if (modeIssue.badLampList[i].type == "FIXTURE") {
							$("#badFixtureQty").val(
									modeIssue.badLampList[i].badFixtureQty);
							$("#fixVendor")
									.val(modeIssue.badLampList[i].vendor);
							$("#fixPictureTaken").val(
									modeIssue.badLampList[i].pictureTaken);
							$("#fixIssue").val(modeIssue.badLampList[i].issue);
							if (modeIssue.badLampList[i].fixtureRecorderDate != undefined
									&& modeIssue.badLampList[i].fixtureRecorderDate != "") {
								fixRecorderDateTemp = moment(
										new Date(
												modeIssue.badLampList[i].fixtureRecorderDate))
										.format("MM/DD/YYYY");
							}
							if (modeIssue.badLampList[i].pmInformedDate != undefined
									&& modeIssue.badLampList[i].pmInformedDate != "") {
								fixPmInformedDateTemp = moment(
										new Date(
												modeIssue.badLampList[i].pmInformedDate))
										.format("MM/DD/YYYY");
							}
							if (modeIssue.badLampList[i].vendorInformedDate != undefined
									&& modeIssue.badLampList[i].vendorInformedDate != "") {
								fixVendorInformedDateTemp = moment(
										new Date(
												modeIssue.badLampList[i].vendorInformedDate))
										.format("MM/DD/YYYY");
							}
							$("#fixRecorderDate").val(fixRecorderDateTemp);
							$("#fixPmInformedDate").val(fixPmInformedDateTemp);
							$("#fixVendorInformedDate").val(
									fixVendorInformedDateTemp);
						}
						if (modeIssue.badLampList[i].type == "LAMP") {
							$("#badLampQty").val(
									modeIssue.badLampList[i].badLampQty);
							$("#lampVendor").val(
									modeIssue.badLampList[i].vendor);
							$("#lampPictureTaken").val(
									modeIssue.badLampList[i].pictureTaken);
							$("#lampIssue").val(modeIssue.badLampList[i].issue);
							$("#lampRecorderDate").val(fixRecorderDateTemp);
							$("#lampPmInformedDate").val(fixPmInformedDateTemp);
							$("#ampVendorInformedDate").val(
									fixVendorInformedDateTemp);

						}

					}
				}
			});
}
/*
 * (function(doc) { var fixQty = doc.getElementById('fixtureQty').value;
 * 
 * var fixQtyGood = doc.getElementById('fixtureGood'); var fixQtyGoodVal =
 * fixQtyGood.value; console.log(fixQtyGoodVal); var fixQtyBad =
 * doc.getElementById('badFixtureQty'); var fixQtyBadVal = fixQtyBad.value;
 * console.log(fixQtyBadVal);
 * 
 * var sumGoodBad = sumOfGoodBad("fixtureGood", "badFixtureQty");
 * 
 * fixQtyGood.addEventListener('blur', function() { if (this.value > fixQty) {
 * alert('Cannot exceed Fixture Quantity'); this.focus(); return; } else {
 * alert('Good to go'); } });
 * 
 * fixQtyBad.addEventListener('blur', function() { if ((fixQtyBadVal >
 * fixQtyGood) || (sumGoodBad > fixQty)) { alert('Please check values!!!');
 * this.focus(); } }); })(document);
 */

/* Ankur Changes */
function setTrackingToEdit(e) {
	$("#trackingDetailsPanel").collapse("show");

	for (var t = 0; t < tracking.trackingList.length; t++) {
		if (e == tracking.trackingList[t].trackingId) {
			$("#submitButtonTrackingNew").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#submitButtonTrackingEstimate").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#submitButtonTrackingDelivered").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");

			$("#trackingIdUI").val(e);
			if (tracking.trackingList[t].lampQty != undefined) {
				$('#lampQty').val(tracking.trackingList[t].lampQty);
				$('#lampSummary').val(tracking.trackingList[t].lampQty);
			}
			if (tracking.trackingList[t].fixtureQty != undefined) {
				$('#fixtureQty').val(tracking.trackingList[t].fixtureQty);
				$('#fixtureSummary').val(tracking.trackingList[t].fixtureQty);
			}
			if (tracking.trackingList[t].fixtureGood != undefined) {
				$('#fixtureGood').val(tracking.trackingList[t].fixtureGood);
				$('#fixtureRecievedGoodSummary').val(
						tracking.trackingList[t].fixtureGood);
			}
			if (tracking.trackingList[t].lampGood != undefined) {
				$('#lampGood').val(tracking.trackingList[t].lampGood);
				$('#lampRecievedGoodSummary').val(
						tracking.trackingList[t].lampGood);

			}
			if (tracking.trackingList[t].dateSubmitted != undefined) {
				$('#dateSubmitted')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateSubmitted))
										.format("MM/DD/YYYY"));
				$('#dateSubmittedSummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateSubmitted))
										.format("MM/DD/YYYY"));
			}
			if (tracking.trackingList[t].dateReleaseVendor != undefined) {
				$('#dateReleaseVendor')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateReleaseVendor))
										.format("MM/DD/YYYY"));
				$('#dateReleasedToVendorSummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateReleaseVendor))
										.format("MM/DD/YYYY"));

			}
			if (tracking.trackingList[t].dateNeededOnsite != undefined) {
				$('#dateNeededOnsite')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateNeededOnsite))
										.format("MM/DD/YYYY"));
				$('#dateOnsiteSummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateNeededOnsite))
										.format("MM/DD/YYYY"));
			}
			if (tracking.trackingList[t].dateEstimatedReceived != undefined) {
				$('#dateEstimatedReceived')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateEstimatedReceived))
										.format("MM/DD/YYYY"));
				$('#dateEstimatedRecievedSummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateEstimatedReceived))
										.format("MM/DD/YYYY"));
			}
			if (tracking.trackingList[t].dateEstimatedDelivery != undefined) {
				$('#dateEstimatedDelivery')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateEstimatedDelivery))
										.format("MM/DD/YYYY"));
				$('#dateEstimatedDeliverySummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateEstimatedDelivery))
										.format("MM/DD/YYYY"));
			}
			if (tracking.trackingList[t].dateApproved != undefined) {
				$('#dateApproved').val(
						moment(new Date(tracking.trackingList[t].dateApproved))
								.format("MM/DD/YYYY"));
				$('#dateApprovedSummary').val(
						moment(new Date(tracking.trackingList[t].dateApproved))
								.format("MM/DD/YYYY"));
			}
			if (tracking.trackingList[t].dateActualReceived != undefined) {
				$('#dateActualReceived')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateActualReceived))
										.format("MM/DD/YYYY"));
				$('#dateActualRecievedSummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateActualReceived))
										.format("MM/DD/YYYY"));
			}

			if (tracking.trackingList[t].dateActualDelivery != undefined) {
				$('#dateActualDelivery')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateActualDelivery))
										.format("MM/DD/YYYY"));
				$('#dateActualDeliverySummary')
						.val(
								moment(
										new Date(
												tracking.trackingList[t].dateActualDelivery))
										.format("MM/DD/YYYY"));
			}
			break;
		}
	}
	setBadFixtureDetails(e);
}
function setChangeOrderToEdit(e) {

	$("#changeOrderDetailsPanel").collapse("show");
	for (var i = 0; i < modeChange.changeOdrList.length; i++) {

		if (e == modeChange.changeOdrList[i].changeOrderId) {
			$("#mmcPco").val(modeChange.changeOdrList[i].mmcPco);
			$("#gcrfi").val(modeChange.changeOdrList[i].gcrfi);
			$("#changeOrderComments").val(
					modeChange.changeOdrList[i].changeOrderComments);
			$("#quantity").val(modeChange.changeOdrList[i].quantity);
			$("#newQuantity").val(modeChange.changeOdrList[i].newQuantity);

			var changeOrderDate = "";
			if (modeChange.changeOdrList[i].changeOrderDate == undefined
					|| modeChange.changeOdrList[i].changeOrderDate == null)
				changeOrderDate = "";
			else
				changeOrderDate = moment(
						new Date(modeChange.changeOdrList[i].changeOrderDate))
						.format("MM/DD/YYYY");

			$("#changeOrderDate").val(changeOrderDate);
			$("#submitBtnChngOrder").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#changeOrderId").val(e);
			break;
		}
	}
}

function convertor2Int(value) {
	var v = value == "" || value == undefined ? 0 : value;
	return +v;
}

// To be modified Later with addition of global variable
function newQuantityValue(val) {
	$("#newQuantity").val(convertor2Int(val) + convertor2Int(quantityONOrderF));
}

function doInit() {
	$
			.ajax({
				url : "fixtureInDetailInit",
				type : "POST",
				contentType : "text/plain",
				success : function(e) {

					if (e == "Failed") {

						bootbox.confirm("Please select the Fixture!!!!!",
								function(result) {
									window.location.href = "fixture";
								});
					} else {
						var mode = JSON.parse(e);

						$("#projectDetailInfo").html(
								mode.selectedProject.jobName + " _ "
										+ mode.selectedProject.jobNumber);
						$("#projectNameW").val(mode.selectedProject.jobName);
						$("#projectIdW").val(mode.selectedProject.jobNumber);

						var lastNameMang, lastNameSupr, firstNameManager, startDateTemp, endDateTemp;
						startDateTemp = endDateTemp = firstNameManager = lastNameMang = lastNameSupr = "";

						if (mode.selectedProject.manager != undefined
								&& mode.selectedProject.manager != null) {
							firstNameManager = mode.selectedProject.manager.firstName;
							if (mode.selectedProject.manager.lastName != undefined)
								lastNameMang = mode.selectedProject.manager.lastName;
							else
								lastNameMang = "";
						}
						if (mode.selectedProject.supervisor.lastName != undefined)
							lastNameSupr = mode.selectedProject.supervisor.lastName;
						else
							lastNameSupr = "";

						if (mode.selectedProject.startDate != undefined)
							startDateTemp = moment(
									new Date(mode.selectedProject.startDate))
									.format("MM-DD-YYYY");
						if (mode.selectedProject.endDate != undefined)
							endDateTemp = moment(
									new Date(mode.selectedProject.endDate))
									.format("MM-DD-YYYY");
						$("#startDateW").val(startDateTemp);
						$("#endDateW").val(endDateTemp);
						$("#projManegerW").val(
								firstNameManager + " " + lastNameMang);
						$("#projSupervisorW").val(
								mode.selectedProject.supervisor.firstName + " "
										+ lastNameSupr);

						// Fixture Widget

						try {
							$("#fixtureDetailInfo").html(
									mode.selectedFixture.fixtureType);
						} catch (e) {
						}
						try {
							$("#fixtureTypeW").val(
									mode.selectedFixture.fixtureType);
						} catch (e) {
						}
						try {
							$("#fixtureVariantW")
									.val(
											mode.selectedFixture.fixtureVariant.variantType);
						} catch (e) {
						}
						try {
							$("#fixDescriptionW")
									.val(
											mode.selectedFixture.fixtureDescription.descType);
						} catch (e) {
						}
						try {
							$("#fixtureCatalogNoW").val(
									mode.selectedFixture.fixrureCatalogNum);
						} catch (e) {
						}
						try {
							$("#lampCatalogNoW")
									.val(
											mode.selectedFixture.lampCatalogNum.catalogType);
						} catch (e) {
						}

						try {
							$("#lampQuantityW").val(
									mode.selectedFixture.lampQtyPerFixture);
						} catch (e) {
						}
						try {
							// Fixture and lamp details widget
							quantityONOrderF = mode.fixMaster.qtyPerBaseOrder;
						} catch (e) {
						}
						try {
							$("#quantityONOrderF").val(
									mode.fixMaster.qtyPerBaseOrder);
						} catch (e) {
						}
						try {
							$("#requiredF").val(mode.fixMaster.fixtureQuantity);
						} catch (e) {
						}
						try {
							$("#recievedF").val(mode.fixMaster.fixtureGood);
						} catch (e) {
						}
						try {
							$("#changeOrderF").val(mode.fixMaster.changeOrder);
						} catch (e) {
						}

						try {
							$("#quantityONOrderL").val(
									mode.fixMaster.fixtureType);
						} catch (e) {
						}
						try {
							$("#requiredL").val(mode.fixMaster.lampQuantity);
						} catch (e) {
						}
						try {
							$("#recievedL").val(mode.fixMaster.lampGood);
						} catch (e) {
						}
						try {
							$("#changeOrderL").val(mode.fixMaster.fixtureType);
						} catch (e) {
						}
						try {
							$("#newQuantity").val(quantityONOrderF);
						} catch (e) {
						}

					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					bootbox.confirm({
						message : "Please select the Fixture!!!!!",
						buttons : {
							"success" : {
								"label" : "OK",
								"className" : "btn-sm btn-danger"
							}
						}
					});
				}
			});

}
function getSheetDetails() {
	$
			.ajax({
				url : "getSheetDetails",
				type : "POST",
				contentType : 'text/plain',
				success : function(result) {
					modeSheet = JSON.parse(result);

					var eDesignNum, eDesignDesc, eDesignArea, eDesignLocation, comments;
					eDesignNum = eDesignDesc = eDesignArea = eDesignLocation = comments = "";

					oTableESheetTable.fnClearTable();
					oTableASheetTable.fnClearTable();
					oTableAtticStockTable.fnClearTable();

					for (var i = 0; i < modeSheet.eDesignList.length; i++) {

						if (modeSheet.eDesignList[i].eDesignNum != undefined)
							eDesignNum = modeSheet.eDesignList[i].eDesignNum;
						if (modeSheet.eDesignList[i].eDesignDesc != undefined)
							eDesignDesc = modeSheet.eDesignList[i].eDesignDesc;
						if (modeSheet.eDesignList[i].eDesignArea != undefined)
							eDesignArea = modeSheet.eDesignList[i].eDesignArea;
						if (modeSheet.eDesignList[i].eDesignLocation != undefined)
							eDesignLocation = modeSheet.eDesignList[i].eDesignLocation;
						if (modeSheet.eDesignList[i].comments != undefined)
							comments = modeSheet.eDesignList[i].comments;

						oTableESheetTable.fnAddData([
								modeSheet.eDesignList[i].eDesignId,
								modeSheet.eDesignList[i].eDesignCount,
								eDesignNum, eDesignDesc, eDesignArea,
								eDesignLocation, comments ], false);
					}
					oTableESheetTable.fnDraw();

					var aDesignNum, aDesignDesc, aDesignArea, aDesignLocation, aSheetComments;
					aDesignNum = aDesignDesc = aDesignArea = aDesignLocation = aSheetComments = "";

					for (var i = 0; i < modeSheet.aDesignList.length; i++) {

						if (modeSheet.aDesignList[i].aDesignNum != undefined)
							aDesignNum = modeSheet.aDesignList[i].aDesignNum;
						if (modeSheet.aDesignList[i].aDesignDesc != undefined)
							aDesignDesc = modeSheet.aDesignList[i].aDesignDesc;
						if (modeSheet.aDesignList[i].aDesignArea != undefined)
							aDesignArea = modeSheet.aDesignList[i].aDesignArea;
						if (modeSheet.aDesignList[i].aDesignLocation != undefined)
							aDesignLocation = modeSheet.aDesignList[i].aDesignLocation;
						if (modeSheet.aDesignList[i].aSheetComments == undefined
								|| modeSheet.aDesignList[i].aSheetComments == null)
							aSheetComments = "";
						else
							aSheetComments = modeSheet.aDesignList[i].aSheetComments;

						oTableASheetTable.fnAddData([
								modeSheet.aDesignList[i].aDesignId,
								modeSheet.aDesignList[i].aDesignCount,
								aDesignNum, aDesignDesc, aDesignArea,
								aDesignLocation, aSheetComments ], false);
					}
					oTableASheetTable.fnDraw();

					var spareCount, atticStockCount;
					spareCount = atticStockCount = "";
					for (var i = 0; i < modeSheet.atticStockList.length; i++) {

						if (modeSheet.atticStockList[i].spareCount == undefined)
							spareCount = "";
						else
							spareCount = modeSheet.atticStockList[i].spareCount;

						if (modeSheet.atticStockList[i].atticStockCount == undefined)
							atticStockCount = "";
						else
							atticStockCount = modeSheet.atticStockList[i].atticStockCount;

						oTableAtticStockTable.fnAddData([
								modeSheet.atticStockList[i].atticStockId,
								atticStockCount, spareCount ], false);
					}
					oTableAtticStockTable.fnDraw();
					/*
					 * for ( var i = 0; i < modeSheet.sheetSummary.length; i++) {
					 * oTableSheetSummaryTable.fnAddData([
					 * modeSheet.sheetSummary[i][0],
					 * modeSheet.sheetSummary[i][1],
					 * modeSheet.sheetSummary[i][2],
					 * modeSheet.sheetSummary[i][3],
					 * modeSheet.sheetSummary[i][4],
					 * modeSheet.sheetSummary[i][5],
					 * 
					 * ]); }
					 */
				}
			});
}

function getIssueDetails() {
	$.ajax({
		url : "getIssueDetails",
		type : "POST",
		contentType : 'text/plain',
		success : function(result) {
			modeIssue = JSON.parse(result);

			var assignedTo, issueDate, resolvedDate, issueStatus;
			assignedTo = issueDate = resolvedDate = issueStatus = "";

			/* Changes By ANkur */
			oTableIssueTable.fnClearTable();
			for (var t = 0; t < modeIssue.issueList.length; t++) {

				if (modeIssue.issueList[t].assignedTo == null
						|| modeIssue.issueList[t].assignedTo == undefined)
					assignedTo = "";
				else
					assignedTo = modeIssue.issueList[t].assignedTo;

				if (modeIssue.issueList[t].issueDate == null
						|| modeIssue.issueList[t].issueDate == undefined)
					issueDate = "";
				else
					issueDate = moment(
							new Date(modeIssue.issueList[t].issueDate)).format(
							"MM/DD/YYYY");

				if (modeIssue.issueList[t].resolvedDate == null
						|| modeIssue.issueList[t].resolvedDate == undefined)
					resolvedDate = "";
				else
					resolvedDate = moment(
							new Date(modeIssue.issueList[t].resolvedDate))
							.format("MM/DD/YYYY");

				if (modeIssue.issueList[t].issueStatus == null
						|| modeIssue.issueList[t].issueStatus == undefined)
					issueStatus = "";
				else
					issueStatus = modeIssue.issueList[t].issueStatus;

				oTableIssueTable.fnAddData([ modeIssue.issueList[t].issueId,
						modeIssue.issueList[t].issueProb, assignedTo,
						issueStatus, issueDate, resolvedDate ], false);
			}
			oTableIssueTable.fnDraw();

		}
	});
}

function getChangeOrderDetails() {
	$
			.ajax({
				url : "getChangeOrderDetails",
				type : "POST",
				contentType : 'text/plain',
				success : function(result) {
					modeChange = JSON.parse(result);

					oTableChangeOrderTable.fnClearTable();
					for (var t = 0; t < modeChange.changeOdrList.length; t++) {

						var changeOrderComments, changeOrderDate, gcrfi, mmcPco, newQuantity;
						changeOrderComments = changeOrderDate = gcrfi = mmcPco = newQuantity = "";

						if (modeChange.changeOdrList[t].changeOrderComments == null
								|| modeChange.changeOdrList[t].changeOrderComments == undefined)
							changeOrderComments = "";
						else
							changeOrderComments = modeChange.changeOdrList[t].changeOrderComments;

						if (modeChange.changeOdrList[t].gcrfi == null
								|| modeChange.changeOdrList[t].gcrfi == undefined)
							gcrfi = "";
						else
							gcrfi = modeChange.changeOdrList[t].gcrfi;

						if (modeChange.changeOdrList[t].mmcPco == null
								|| modeChange.changeOdrList[t].mmcPco == undefined)
							mmcPco = "";
						else
							mmcPco = modeChange.changeOdrList[t].mmcPco;

						if (modeChange.changeOdrList[t].newQuantity == null
								|| modeChange.changeOdrList[t].newQuantity == undefined)
							newQuantity = "";
						else
							newQuantity = convertor2Int(modeChange.changeOdrList[t].newQuantity);

						if (modeChange.changeOdrList[t].changeOrderDate == null
								|| modeChange.changeOdrList[t].changeOrderDate == undefined)
							changeOrderDate = "";
						else
							changeOrderDate = moment(
									new Date(
											modeChange.changeOdrList[t].changeOrderDate))
									.format("MM/DD/YYYY");

						oTableChangeOrderTable.fnAddData([
								modeChange.changeOdrList[t].changeOrderId,
								mmcPco, gcrfi,
								modeChange.changeOdrList[t].quantity,
								newQuantity, changeOrderDate,
								changeOrderComments ], false);
					}
					oTableChangeOrderTable.fnDraw();
				}
			});
}
function getTrackingDetails() {
	mode = "trackingDetails";
	$
			.ajax({
				url : "getTrackingDetails",
				type : "POST",
				contentType : 'text/plain',
				data : '{"mode": "' + mode + '"}',
				success : function(result) {
					tracking = JSON.parse(result);
					oTableTrackingTable.fnClearTable();
					var lampQty, fixtureQty, fixtureGood, lampGood, dateSubmitted, dateReleaseVendor, dateNeededOnsite, dateEstimatedReceived, dateEstimatedDelivery, dateApproved, dateActualReceived, dateActualDelivery;
					for (var t = 0; t < tracking.trackingList.length; t++) {
						lampQty = fixtureQty = fixtureGood = lampGood = dateSubmitted = dateReleaseVendor = dateNeededOnsite = dateEstimatedReceived = dateEstimatedDelivery = dateApproved = dateActualReceived = dateActualDelivery = "";

						if (tracking.trackingList[t].lampQty != undefined) {
							lampQty = tracking.trackingList[t].lampQty;
						}
						if (tracking.trackingList[t].fixtureQty != undefined) {
							fixtureQty = tracking.trackingList[t].fixtureQty;
						}
						if (tracking.trackingList[t].fixtureGood != undefined) {
							fixtureGood = tracking.trackingList[t].fixtureGood;
						}
						if (tracking.trackingList[t].lampGood != undefined) {
							lampGood = tracking.trackingList[t].lampGood;
						}
						if (tracking.trackingList[t].dateSubmitted != undefined) {
							dateSubmitted = moment(
									new Date(
											tracking.trackingList[t].dateSubmitted))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateReleaseVendor != undefined) {
							dateReleaseVendor = moment(
									new Date(
											tracking.trackingList[t].dateReleaseVendor))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateNeededOnsite != undefined) {
							dateNeededOnsite = moment(
									new Date(
											tracking.trackingList[t].dateNeededOnsite))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateEstimatedReceived != undefined) {
							dateEstimatedReceived = moment(
									new Date(
											tracking.trackingList[t].dateEstimatedReceived))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateEstimatedDelivery != undefined) {
							dateEstimatedDelivery = moment(
									new Date(
											tracking.trackingList[t].dateEstimatedDelivery))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateApproved != undefined) {
							dateApproved = moment(
									new Date(
											tracking.trackingList[t].dateApproved))
									.format("MM/DD/YYYY");
						}
						if (tracking.trackingList[t].dateActualReceived != undefined) {
							dateActualReceived = moment(
									new Date(
											tracking.trackingList[t].dateActualReceived))
									.format("MM/DD/YYYY");
						}

						if (tracking.trackingList[t].dateActualDelivery != undefined) {
							dateActualDelivery = moment(
									new Date(
											tracking.trackingList[t].dateActualDelivery))
									.format("MM/DD/YYYY");
						}
						oTableTrackingTable.fnAddData([
								tracking.trackingList[t].trackingId,
								fixtureQty, lampQty, dateApproved,
								dateEstimatedReceived, dateActualReceived,
								fixtureGood, lampGood, dateSubmitted,
								dateReleaseVendor, dateNeededOnsite,
								dateEstimatedDelivery, dateActualDelivery ],
								false);
					}
					oTableTrackingTable.fnDraw();
				}
			});
}

$(document)
		.ready(
				function() {
					$('#loading').modal('show');
					// getWidgetDetails();
					doInit();
					$("#dateSubmitted").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateSubmitted").datepicker("hide");
								$('#dateSubmittedError').removeClass(
										"has-error");
								return compareDates();
							});
					$('#dateSubmitted').keydown(function() {
						$('#dateSubmitted').datepicker("hide");
					});

					$("#dateApproved").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateApproved").datepicker("hide");
								$('#dateApprovedError')
										.removeClass("has-error");
								return compareDates();
							});
					$('#dateApproved').keydown(function() {
						$('#dateApproved').datepicker("hide");
					});

					$("#dateNeededOnsite").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateNeededOnsite").datepicker("hide");
								$('#dateNeededOnsiteError').removeClass(
										"has-error");
							});
					$('#dateNeededOnsite').keydown(function() {
						$('#dateNeededOnsite').datepicker("hide");
					});

					$("#dateReleaseVendor").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateReleaseVendor").datepicker("hide");
								$('#dateReleaseVendorError').removeClass(
										"has-error");
								return popUpToReceivedDate(),
										popUpToDeliveryDate();
							});
					$('#dateReleaseVendor').keydown(function() {
						$('#dateReleaseVendor').datepicker("hide");
					});

					$("#dateEstimatedReceived").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateEstimatedReceived").datepicker("hide");
								$('#dateEstimatedReceivedError').removeClass(
										"has-error");
							});
					$('#dateEstimatedReceived').keydown(function() {
						$('#dateEstimatedReceived').datepicker("hide");
					});

					$("#dateEstimatedDelivery").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateEstimatedDelivery").datepicker("hide");
								$('#dateEstimatedDeliveryError').removeClass(
										"has-error");
							});
					$('#dateEstimatedDelivery').keydown(function() {
						$('#dateEstimatedDelivery').datepicker("hide");
					});

					$("#dateActualReceived").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateActualReceived").datepicker("hide");
								$('#dateActualReceivedError').removeClass(
										"has-error");
							});
					$('#dateActualReceived').keydown(function() {
						$('#dateActualReceived').datepicker("hide");
					});

					$("#dateActualDelivery").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateActualDelivery").datepicker("hide");
								$('#dateActualDeliveryError').removeClass(
										"has-error");
							});
					$('#dateActualDelivery').keydown(function() {
						$('#dateActualDelivery').datepicker("hide");
					});

					$("#datePmTeamInformed").datepicker().on(
							"changeDate",
							function(e) {
								$("#datePmTeamInformed").datepicker("hide");
								$('#datePmTeamInformedError').removeClass(
										"has-error");
							});
					$('#datePmTeamInformed').keydown(function() {
						$('#datePmTeamInformed').datepicker("hide");
					});

					$("#dateVendorInformed_1").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateVendorInformed_1").datepicker("hide");
								$('#dateVendorInformed_1Error').removeClass(
										"has-error");
							});
					$('#dateVendorInformed_1').keydown(function() {
						$('#dateVendorInformed_1').datepicker("hide");
					});

					$("#fixtureRecorderDate").datepicker().on(
							"changeDate",
							function(e) {
								$("#fixtureRecorderDate").datepicker("hide");
								$('#fixtureRecorderDateError').removeClass(
										"has-error");
							});
					$('#fixtureRecorderDate').keydown(function() {
						$('#fixtureRecorderDate').datepicker("hide");
					});

					$("#datePmTeamInformed_1").datepicker().on(
							"changeDate",
							function(e) {
								$("#datePmTeamInformed_1").datepicker("hide");
								$('#datePmTeamInformed_1Error').removeClass(
										"has-error");
							});
					$('#datePmTeamInformed_1').keydown(function() {
						$('#datePmTeamInformed_1').datepicker("hide");
					});

					$("#dateVendorInformed_2").datepicker().on(
							"changeDate",
							function(e) {
								$("#dateVendorInformed_2").datepicker("hide");
								$('#dateVendorInformed_2Error').removeClass(
										"has-error");
							});
					$('#dateVendorInformed_2').keydown(function() {
						$('#dateVendorInformed_2').datepicker("hide");
					});

					$("#fixtureRecorderDate_1").datepicker().on(
							"changeDate",
							function(e) {
								$("#fixtureRecorderDate_1").datepicker("hide");
								$('#fixtureRecorderDate_1Error').removeClass(
										"has-error");
							});
					$('#fixtureRecorderDate_1').keydown(function() {
						$('#fixtureRecorderDate_1').datepicker("hide");
					});

					$("#issueDate").datepicker().on("changeDate", function(e) {
						$("#issueDate").datepicker("hide");
						$('#issueDateError').removeClass("has-error");
					});
					$('#issueDate').keydown(function() {
						$('#issueDate').datepicker("hide");
					});

					$("#resolvedDate").datepicker().on(
							"changeDate",
							function(e) {
								$("#resolvedDate").datepicker("hide");
								$('#resolvedDateError')
										.removeClass("has-error");
							});
					$('#resolvedDate').keydown(function() {
						$('#resolvedDate').datepicker("hide");
					});

					$("#changeOrderDate").datepicker().on(
							"changeDate",
							function(e) {
								$("#changeOrderDate").datepicker("hide");
								$('#changeOrderDateError').removeClass(
										"has-error");
							});
					$('#changeOrderDate').keydown(function() {
						$('#changeOrderDate').datepicker("hide");
					});

					oTableSideFixture = $('#sidePanelFixtureInDetailTable')
							.dataTable(
									{

										sDom : "lrtp",
										bSearchable : false,
										
										sDom : "lrtp",
										bSearchable : false,
										"sScrollY" : "450px",
								        "bPaginate" : true,
								        "bScrollCollapse": true,
								        
										aoColumns : [ {
											sClass : "center",
											fnRender : function(e) {
												return "<a  href=\"javascript:setFixtureSelected('"
														+ e.aData[1]
														+ "')\">"
														+ e.aData[0] + "</a>";
											}
										} ]
									});
					$("#sidePanelFixtureInDetailTable tbody tr").hover(
							function(e) {

								if ($(this).hasClass('row_selected')) {
									$(this).removeClass('row_selected');
								} else {
									oTableSideFixture.$('tr.row_selected')
											.removeClass('row_selected');
									$(this).addClass('row_selected');
								}
							});

					$("#sidePanelFixtureInDetailTable thead input").keyup(
							function() {
								/*
								 * Filter on the column (the index) of this
								 * element
								 */
								oTableSideFixture.fnFilter(this.value, $(
										"thead input").index(this));
							});

					/*
					 * Support functions to provide a little bit of 'user
					 * friendlyness' to the textboxes in the footer
					 */
					$("#sidePanelFixtureInDetailTable thead input").each(
							function(i) {
								// asInitVals[i] = this.value;
							});

					$("#sidePanelFixtureInDetailTable thead input").focus(
							function() {
								if (this.className == "search_init") {
									this.className = "";
									this.value = "";
								}
							});
					$("#sidePanelFixtureInDetailTable thead input").blur(
							function(i) {
								if (this.value == "") {
									this.className = "search_init";
									this.value = asInitVals[$("thead input")
											.index(this)];
								}
							});

					$.ajax({
						url : "fixtureInDetailDefaultAction",
						dataType : "json",
						traditional : true,
						type : "GET",
						success : function(result) {
							ankur = result;
							for (var t = 0; t < result.fixture.length; t++) {
								oTableSideFixture.fnAddData([
										result.fixture[t].fixtureType,
										result.fixture[t].fixtureId ], false);
							}
							oTableSideFixture.fnDraw();
						},
						error : function(XMLHttpRequest, textStatus,
								errorThrown) {
							/*
							 * bootbox .dialog({ message : "Oops! Could Not Load
							 * the Page.Please refresh", buttons : { "success" : {
							 * "label" : "OK", "className" : "btn-sm btn-danger" } }
							 * });
							 */
						},
						complete : function() {
							// alert("complete");
							//
						}
					});

					oTableESheetTable = $('#eSheetTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														id = oObj.aData[0];
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[3];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[4];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[5];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[6];
													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setESheetToEdit('"
																+ id
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ id
																+ ":eSheetFormId"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});

					oTableASheetTable = $('#aSheetTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														idAsheet = oObj.aData[0];
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[3];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[4];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[5];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[6];
													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setASheetToEdit('"
																+ idAsheet
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ idAsheet
																+ ":aSheetFormId"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});

					oTableAtticStockTable = $('#attickStockTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														idAtticStock = oObj.aData[0];
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setAtticStockToEdit('"
																+ idAtticStock
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ idAtticStock
																+ ":atticStockFormId"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});
					oTableIssueTable = $('#issueTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														idIssue = oObj.aData[0];
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[3];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[4];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[5];
													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setIssueToEdit('"
																+ idIssue
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ idIssue
																+ ":issueFormId"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});

					oTableTrackingTable = $('#trackingTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														ankur = oObj;
														trackingSheetId = oObj.aData[0];
														return trackingSheetId;
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[3];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[4];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[5];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[6];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[7];
													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setTrackingToEdit('"
																+ trackingSheetId
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ trackingSheetId
																+ ":trackingForm"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});

					oTableChangeOrderTable = $('#changeOrderTable')
							.dataTable(
									{
										"bSearchable" : false,
										"bDestroy" : true,
										"bFilter" : true,
										"bInfo" : true,
										"bAutoWidth" : true,
										"aoColumns" : [
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														idChangeOrder = oObj.aData[0];
														return oObj.aData[1];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[2];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[3];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[4];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[5];
													}
												},
												{
													"sClass" : "center",
													"fnRender" : function(oObj) {
														return oObj.aData[6];

													}
												},
												{
													"mData" : null,

													"sClass" : "center",
													"fnRender" : function(oObj) {
														return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setChangeOrderToEdit('"
																+ idChangeOrder
																+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
																+ idChangeOrder
																+ ":chngOdrFormId"
																+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>";
													}
												} ]
									});
					$('#loading').modal('hide');
					
					$('#sidePanelFixtureInDetailTable_wrapper > div.dataTables_paginate.paging_bootstrap').css('display','none');
				});

$(document).on("click", ".deleteConfirmDialog", function() {
	var value = $(this).data("id");
	formIdGlobal = value.split(":")[1];
	var value1 = value.split(":")[0];
	if (formIdGlobal == "eSheetFormId") {
		$("#eDesignId").val(value1);
	} else if (formIdGlobal == "aSheetFormId") {
		$("#aDesignId").val(value1);
	} else if (formIdGlobal == "atticStockFormId") {
		$("#atticStockId").val(value1);
	} else if (formIdGlobal == "issueFormId") {
		$("#issueId").val(value1);
	} else if (formIdGlobal == "chngOdrFormId") {
		$("#changeOrderId").val(value1);
	} else if (formIdGlobal == "trackingForm") {
		$("#trackingIdUI").val(value1);
	}

});

jQuery('#sheetsID').one('click', function() {
	getSheetDetails();
});

jQuery('#issueIdForPanel').one('click', function() {
	getIssueDetails();
});

jQuery('#changeOrderAjaxCall').one('click', function() {
	getChangeOrderDetails();
});
jQuery('#trackingAjaxCall').one('click', function() {
	getTrackingDetails();
});

/* Modification By ANkur Starts */
function notifications(action, message) {

	var tMessage = null, cMessage = null, text = "";
	if (action == "ERROR") {
		tMessage = "error!!";
		text = message;
		cMessage = 'gritter-failure';
	} else {
		tMessage = "Elecnor FTS : Success!!";
		text = action.toLowerCase() + "d Successfully";
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
function submitFormAjax(urlToCall, formId, l) {
	// $('#loading').modal('show');
	$
			.ajax({
				url : urlToCall,
				/*
				 * dataType : "json", traditional : true,
				 */
				type : "POST",
				data : $('#' + formId).serialize(),
				success : function(result) {
					if (l != undefined) {
						l.stop();
					}
					if (formId == "issueFormId") {
						notifications($("#actionForIssue").val());
						getIssueDetails();
						resetFormIssue();
						$('#' + formId)[0].reset();
						$("#issueDetailsPanel").collapse("hide");
					} else if (formId == "eSheetFormId") {
						notifications($("#actionForESheet").val());
						getSheetDetails();
						resetFormESheet();
						$('#' + formId)[0].reset();
					} else if (formId == "aSheetFormId") {
						notifications($("#actionForASheet").val());
						getSheetDetails();
						resetFormASheet();
						$('#' + formId)[0].reset();
					} else if (formId == "atticStockFormId") {
						notifications($("#actionForAtticStock").val());
						getSheetDetails();
						resetFormAtticStock();
						$('#' + formId)[0].reset();
					} else if (formId == "chngOdrFormId") {
						notifications($("#actionForChngOrdr").val());
						getChangeOrderDetails();
						resetFormChangeOrder();
						$('#' + formId)[0].reset();
						$("#changeOrderDetailsPanel").collapse("hide");
					} else if (formId = "trackingForm") {
						notifications($("#actionForTracking").val());
						getTrackingDetails();
						resetFormTracking();
						$('#' + formId)[0].reset();

						$("#trackingDetailsPanel").collapse("hide");

					}

					/*
					 * bootbox .dialog({ message : "Operation Successful!!",
					 * buttons : { "success" : { "label" : "OK", "className" :
					 * "btn-sm btn-primary" } } });
					 */
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					if (l != undefined) {
						l.stop();
					}
					console.log(errorThrown);
					bootbox
							.dialog({
								message : "Oops! Your information could not be saved! Please reload the page and try again.",
								buttons : {
									"success" : {
										"label" : "OK",
										"className" : "btn-sm btn-danger"
									}
								}
							});
				},
				complete : function() {
					if (l != undefined) {
						l.stop();
					}
					doInit();
					$('#loading').modal('hide');
				}
			});
}

/* Modification By ANkur Ends */

