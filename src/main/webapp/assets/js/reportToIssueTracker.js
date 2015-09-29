/**
 * Anantha MeghanaJagruthi
 */

/*
 * var nowTemp = new Date(); var now = new Date(nowTemp.getFullYear(),
 * nowTemp.getMonth(), nowTemp .getDate(), 0, 0, 0, 0);
 * $("#dueDate").datepicker({ format : "mm-dd-yyyy", startDate: now
 * }).on('changeDate', function(ev) { $('#dueDate').datepicker('hide'); });
 */

function resetCreateIssueForm() {
	$("#issueSno").val("");
	$('#createIssueFormId')[0].reset();
	$("#createNewIssueHeaderId").text("Create New Issue");
	$("#createIssueButtonSpanId").text("Create");
	// code for resetting ace_file_input.
	/*var file_input = $('#uploadFile');
	file_input.ace_file_input('reset_input');*/
}

function validateUploadFile() {

	console.log("inside validate upload file");
	var totalFiles;
	var totalFilesSize = 0;
	var checkInputMethod = $("#uploadFile").data().ace_input_method;
	if (checkInputMethod == "drop") {
		totalFiles = $("#uploadFile").data('ace_input_files');
	} else {
		totalFiles = $('#uploadFile')[0].files;
	}
	for (var len = 0; len < totalFiles.length; len++) {
		totalFilesSize = totalFilesSize + totalFiles[len].size;
	}
	// validation for 5MB.
	if (totalFilesSize > 5 * Math.pow(2, 20)) {
		gritterWarningMsg("The attachement size cannot exceed 5MB.");
		/*var file_input = $('#uploadFile');
		file_input.ace_file_input('reset_input');*/
		return false;
	}

	return true;
}

function validateCreateIssueForm() {
	/* Validation for text_field */

	if ($('#applicationId').val() == null || $('#applicationId').val()=="") {
		validateNotifications('</i> Error! </strong>  Application has to be selected.');
		return false;
	}

	if ($('#issueTypeId').val() == null || $('#issueTypeId').val()=="") {
		validateNotifications('</i> Error! </strong>  Issue type has to be selected.');
		return false;
	}

	if ($('#summary').val() == "") {
		validateNotifications('</i> Error! </strong>  Summary cannot be empty');
		document.getElementById('summary').focus();
		return false;
	}

	if ($('#statusId').val() == null || $('#statusId').val() == "") {
		validateNotifications('</i> Error! </strong>  Status has to be selected.');
		return false;
	}

	return true;
}

function getDateByAddingNoOfDaysByExcludingWeekends(fromDate, days) {
	var count = 0;
	while (count < days) {
		fromDate.setDate(fromDate.getDate() + 1);
		if (fromDate.getDay() != 0 && fromDate.getDay() != 6) // Skip weekends
			count++;
	}
	return fromDate;
}

function setDueDatebasedOnSeverity() {

	console.log($("select[name='severityId'").find('option:selected').text().toLowerCase());
	var delDate=null;
	var curDate=new Date();
	if (($("select[name='severityId'").find('option:selected').text())
			.toLowerCase() == "low"
			&& ($("#dueDate").val() == "" || $("#issueSno").val() == "")) {
		
		delDate=moment(getDateByAddingNoOfDaysByExcludingWeekends(curDate, 10)).format("MM-DD-YYYY");
		console.log(delDate);
		
	} else if (($("select[name='severityId'").find('option:selected').text())
			.toLowerCase() == "normal"
			&& ($("#dueDate").val() == "" || $("#issueSno").val() == "")) {
		delDate= moment(getDateByAddingNoOfDaysByExcludingWeekends(curDate, 5)).format("MM-DD-YYYY");
						
	} else if (($("select[name='severityId'").find('option:selected').text())
			.toLowerCase() == "high"
			&& ($("#dueDate").val() == "" || $("#issueSno").val() == "")) {
		delDate= moment(getDateByAddingNoOfDaysByExcludingWeekends(curDate, 3)).format("MM-DD-YYYY");
	} else if (($("select[name='severityId'").find('option:selected').text())
			.toLowerCase() == "urgent"
			&& ($("#dueDate").val() == "" || $("#issueSno").val() == "")) {
		delDate= moment(getDateByAddingNoOfDaysByExcludingWeekends(curDate, 1)).format("MM-DD-YYYY");
	
	
	}
	   $("#dueDate").val(delDate);
}

function getLookUpDetailsToCreateIssue() {

	$("#createIssue").modal("show");
 

	getApplicationDetails();
	$("#startDate").val(moment(new Date()).format("MM-DD-YYYY"));
	$("#dueDate").val(moment(getDateByAddingNoOfDaysByExcludingWeekends(new Date(), 10)).format("MM-DD-YYYY"));
	
}

function successMsg(){
	
	$.gritter.add({
		// (string | mandatory) the heading of the notification
		title : "Elecnor FTS : Success!!",
		// (string | mandatory) the text inside the notification
		text : "Ticket has been reported successfully",
		class_name : 'gritter-success'
	});
	
}
function reportThisIssue() {
	if (!validateUploadFile()) {
		return;
	} else if (!validateCreateIssueForm()) {
		return;
	}
	console.log(new FormData($("#createIssueFormId")[0]));
	$.ajax({
		url : "reportToIssueTracker",
		data : new FormData($("#createIssueFormId")[0]),
		cache : false,
		contentType : false,
		processData : false,
		type : 'POST',
		success : function(result) {
			console.log("successfully issue is reported");
			console.log(typeof $("#uploadFile").val());
			console.log($("#uploadFile").val());
			console.log($("#attachmentUploadForm").serialize());
			console.log($("#uploadFile").val().trim());
			console.log($("#uploadFile").val().trim()!="");
			if($("#uploadFile").val().trim()!=""){
				var data = new FormData($("#attachmentUploadForm")[0]);
				console.log(data);
			}
			
			successMsg();
			resetCreateIssueForm();
			$("#createIssue").modal("hide");
		},
		error : function(error) {
			console.log("error");
			console.log(error);
		}
	});
}



$("#createIssueTab").one("click", function(){

	var e = document.getElementById("statusId");
	var r = document.createElement("option");
	r.text = "New";
	r.value = "8";
	try {
		/*if($('select#statusId option').length==0){*/
			e.add(r, select.options[null]);
		//}
		
	} catch (n) {
		e.add(r, null);
	}
	$(".selectpicker").selectpicker("refresh");
	
});

function getIssueTypesFromIssueTracker() {
	$.ajax({
		url : "getAllIssueTypesFromIssueTracker",
		type : "GET",
		success : function(result) {
			console.log("Types of issues ");
			var issueTypesList = JSON.parse(result);
			initializeSelectBoxesInForm("issueTypeId", issueTypesList);
		}
	});

}

function getSeveritiesFromIssueTracker() {

	$.ajax({
		url : "getAllSeverityFromIssueTracker",
		type : "GET",
		success : function(result) {
			var severities = JSON.parse(result);
			console.log("Severities of issues ");
			initializeSelectBoxesInForm("severityId", severities);
		}
	});
}

function getProjectsListFromIssueTracker(id) {
	var data = {
		"applicationId" : id
	};
	$.ajax({
		url : "getAllProjectsFromIssueTracker",
		method : "POST",
		data : data,
		success : function(result) {
			var tempResult = JSON.parse(result);
			initializeSelectBoxesInForm("relatedProject", tempResult);
		}
	});
}

function getApplicationDetails() {
	$
			.ajax({
				url : "RedirectedFromDownStreamApp/getApplicationDetailsFromIssueTracker",
				method : "POST",
				success : function(result) {
					var tempResult = JSON.parse(result);
					initializeSelectBoxesInForm("applicationId", tempResult);
				},
			complete:function(){
				
				getProjectsListFromIssueTracker($("#applicationId").val());
				getIssueTypesFromIssueTracker();
				getSeveritiesFromIssueTracker();
				getModulesListFromIssueTracker($("#applicationId").val());
			}
			});
}
function getModulesListFromIssueTracker(id) {
	var data = {
		"applicationId" : id
	};
	$.ajax({
		url : "getAllModulesFromIssueTracker",
		type : "POST",
		data : data,
		success : function(result) {
			var moduleList = JSON.parse(result);
			initializeSelectBoxesInForm("applicationModuleId", moduleList);
		},
		complete:function(){
			console.log("inside projects list");
			//getProjectsListFromEcosystem($("#applicationId").val());
		}
	});
}

function initializeSelectBoxesInForm(selectBoxId, values) {
	console.log(selectBoxId + " " );
	console.log(values);
	var n;
	$('#' + selectBoxId).empty();
	var e = document.getElementById(selectBoxId);
	
	var i=0;
	for (n in values) {
		i++
		if (values[n] == undefined)
			continue;
		var r = document.createElement("option");
		r.text = values[n];
		r.value = n;
		try {
			e.add(r, select.options[null]);
		} catch (n) {
			e.add(r, null);
		}
	}
	
	$(".selectpicker").selectpicker("refresh");

}

/*function redirectToIssueTrackerApp() {
console.log("Inside redirection");
	$
			.ajax({
				type : 'POST',
				url : 'redirectToIssueTrackerApp',
				async : false,
				success : function(result) {

					var responseDetails = JSON.parse(result);
					console.log(responseDetails);
					if (responseDetails.ajaxResult == "success") {
						$("#redirectToIssueTrackerFormId").prop("action",
								responseDetails.issueTrackerUrl);
						$("#emailidForIssueTracker").val(
								responseDetails.emailId);
						$("#passwordForIssueTracker").val(
								responseDetails.password);
						$("#appIdForIssueTracker").val(
								responseDetails.applicationId);

						if ($("#emailidForIssueTracker").val() != ""
								&& $("#passwordForIssueTracker").val() != ""
								&& $("#appIdForIssueTracker").val() != "") {
							$("#redirectToIssueTrackerFormId").submit();
						}

					} else {
						gritterForErrorMsgs("Some Problem Occured. Please refresh the page and try again. If this problem persists, please contact Dev Team.");
					}
				},
				error : function() {
					gritterForErrorMsgs("Some Problem Occured. Please refresh the page and try again. If this problem persists, please contact Dev Team.");
				}
			});

}
*/
/*$('#uploadFile').ace_file_input({
	style : 'well',
	btn_choose : 'Drop files here or click to choose',
	btn_change : null,
	no_icon : 'ace-icon fa fa-cloud-upload',
	droppable : true,
	thumbnail : 'small'// large | fit
	// ,icon_remove:null//set null, to hide remove/reset button
	*//**
	 * ,before_change:function(files, dropped) { //Check an example below //or
	 * examples/file-upload.html return true; }
	 *//*
	*//**
	 * ,before_remove : function() { return true; }
	 *//*
	,
	preview_error : function(filename, error_code) {
		// name of the file that failed
		// error_code values
		// 1 = 'FILE_LOAD_FAILED',
		// 2 = 'IMAGE_LOAD_FAILED',
		// 3 = 'THUMBNAIL_FAILED'
		// alert(error_code);
	}

}).on('change', function() {
	// console.log($(this).data('ace_input_files'));
	// console.log($(this).data('ace_input_method'));
});

// $('#uploadFile')
// .ace_file_input('show_file_list', [
// {type: 'image', name: 'name of image', path:
// 'http://path/to/image/for/preview'},
// {type: 'file', name: 'hello.txt'}
// ]);

// dynamically change allowed formats by changing allowExt && allowMime function
$('#id-file-format').removeAttr('checked').on(
		'change',
		function() {
			var whitelist_ext, whitelist_mime;
			var btn_choose
			var no_icon
			if (this.checked) {
				btn_choose = "Drop images here or click to choose";
				no_icon = "ace-icon fa fa-picture-o";

				whitelist_ext = [ "jpeg", "jpg", "png", "gif", "bmp" ];
				whitelist_mime = [ "image/jpg", "image/jpeg", "image/png",
						"image/gif", "image/bmp" ];
			} else {
				btn_choose = "Drop files here or click to choose";
				no_icon = "ace-icon fa fa-cloud-upload";

				whitelist_ext = null;// all extensions are acceptable
				whitelist_mime = null;// all mimes are acceptable
			}
			var file_input = $('#uploadFile');
			file_input.ace_file_input('update_settings', {
				'btn_choose' : btn_choose,
				'no_icon' : no_icon,
				'allowExt' : whitelist_ext,
				droppable : true,
				'allowMime' : whitelist_mime
			})
			file_input.ace_file_input('reset_input');

			file_input.off('file.error.ace').on('file.error.ace',
					function(e, info) {
						// console.log(info.file_count);//number of selected
						// files
						// console.log(info.invalid_count);//number of invalid
						// files
						// console.log(info.error_list);//a list of errors in
						// the following format

						// info.error_count['ext']
						// info.error_count['mime']
						// info.error_count['size']

						// info.error_list['ext'] = [list of file names with
						// invalid extension]
						// info.error_list['mime'] = [list of file names with
						// invalid mimetype]
						// info.error_list['size'] = [list of file names with
						// invalid size]

						*//**
						 * if( !info.dropped ) { //perhapse reset file field if
						 * files have been selected, and there are invalid files
						 * among them //when files are dropped, only valid files
						 * will be added to our file array
						 * e.preventDefault();//it will rest input }
						 *//*
						// if files have been selected (not dropped), you can
						// choose to reset input
						// because browser keeps all selected files anyway and
						// this cannot be changed
						// we can only reset file field to become empty again
						// on any case you still should check files with your
						// server side script
						// because any arbitrary file can be uploaded by user
						// and it's not safe to rely on browser-side measures
					});

		});
*/