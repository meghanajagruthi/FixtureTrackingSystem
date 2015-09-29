<%@page import="com.elecnor.lighting.bean.UserProfile"%>
<%@page import="com.elecnor.lighting.bean.ProjectMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>FTS</title>
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<script type="text/javascript" src="assets/js/raiseIssue.js"></script>
<script type="text/javascript" src="assets/js/reportToIssueTracker.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
<style type="text/css">
.custCssWidth {
	max-width: none !important;
}
.dataTables_scrollBody::-webkit-scrollbar, ul.dropdown-menu.inner::-webkit-scrollbar
	{
	height: 15px;
	width: 7px;
	background-color: white;
	border: 1px solid lightgrey;
}
.dataTables_scrollBody::-webkit-scrollbar-thumb, ul.dropdown-menu.inner::-webkit-scrollbar-thumb
	{
	background-color: #428bca;
}

.dataTables_scrollBody::-webkit-scrollbar-thumb:hover, ul.dropdown-menu.inner::-webkit-scrollbar-thumb:hover
	{
	background-color: #428bca;
}

.dataTables_scrollBody::-webkit-scrollbar-thumb:active, ul.dropdown-menu.inner::-webkit-scrollbar-thumb:active
	{
	background-color: #428bca;
}
#sideMenuTable_length > label > select{
width: auto;
}
</style>
</head>

<body>

	<div class="navbar navbar-default navbar-fixed-top" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="login" class="navbar-brand"> <img
					src="assets/img/elecnorIcon.png" width="50px" height="27px"
					alt="Belco Logo" title="Home"><small style="color: #FE9A2E">
						<b> FMS </b>
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->


			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">

                <!--     <li id="ticketCenterId"><a
				href="javascript:redirectToIssueTrackerApp()"
				class="jarvismetro-tile big-cubes bg-color-blue"
				id="ticketCenterAnchorTagId"> <span class="iconbox"> <i
						class="fa  fa-ticket fa-2x"></i> <span class="shortcutAlign">
							
					</span>
				</span>
			</a></li> -->
					<li><a class="navbar-brand"
						title="Create Issue" id="ftsReportIssueAnchorId"
						onClick="getLookUpDetailsToCreateIssue();">
							<i class="fa fa-user"></i>
					</a></li>
					<%
						UserProfile user = (UserProfile) session
								.getAttribute("selectedUser");
					%>

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img src="assets/img/settings.png"
							alt="Settings"> <span class="user-info custCssWidth">
								<small>Welcome :</small> <%=user.getFirstName()%><strong><b>
										&nbsp; [<font style="color: rgb(46, 101, 137);"> <%
 	if (user != null) {
 %> <%=user.getRole()%> <%
 	}
 %></font> ]
								</b></strong>
						</span> &nbsp; <i class="fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

							<li><a href="masterFixture"> <i
									class="fa fa-pencil-square-o"></i> Master Database
							</a></li>

							<li class="divider"></li>

							<li><a href="logOut"> <i class="fa fa-power-off"></i>
									Logout
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<!-- Start  of Modal For issue/report Form-->
	<div id="createIssue" class="modal fade" tabindex="-1"
		aria-hidden="false" data-backdrop="static" data-keyboard="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="background: rgb(239, 243, 248);height:60px">
					<button type="button" class="close" data-dismiss="modal"
						onclick="resetCreateIssueForm();" style="opacity: 3 !important;">
						<span class="badge pull-right"
							style="position: relative; top: 8px;">×</span>
					</button>
					<h5 class="blue bigger col-md-6" id="createNewIssueHeaderId">
						<i class="fa fa-edit fa-fw txt-color-blue"></i> Create New Issue
					</h5>
					<div class='col-md-5' align="right">
					<button class="btn btn-sm btn-success ladda-button "
						data-style="expand-right"  onclick="redirectToIssueTracker();">
						<i class="fa fa-forward"></i> <span
							id="createNewIssueHeaderId">Access Issue Tracker </span>
					</button>
					</div>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-horizontal">
								<form id="createIssueFormId" name="createIssueFormId"
									method="POST" commandName="" >
									<input type="hidden" id="issueSno" name="issueSno">
									<div class="form-group">
										<label class="col-sm-2 control-label no-padding-right"
											for="form-field-1">Application<span
											style="color: #FF2600 !important">*</span></label>
										<div class="col-md-4">
											<select
												class="form-control selectpicker show-tick applicationId"
												id="applicationId" tabindex="-1" name="applicationId"
												onchange="getModuleListForSelApp(this.value);">
											</select>
										</div>
										<label class="col-sm-2 control-label " for="form-field-1">
											Module</label>
										<div class="col-md-4">
											<select class="form-control selectpicker show-tick"
												id="applicationModuleId" name="applicationModuleId">
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label " for="form-field-1">
											Project</label>
										<div class="col-md-4">
											<select class="form-control selectpicker show-tick"
												id="relatedProject" name="relatedProject">
											</select>
										</div>
										<label class="col-sm-2 control-label no-padding-right"
											for="form-field-1">Issue Type<span
											style="color: #FF2600 !important">*</span></label>
										<div class="col-md-4">
											<select class="form-control selectpicker show-tick"
												id="issueTypeId" name="issueTypeId">
											</select>
										</div>
									</div>
									<hr>
									<div class="form-group">
										<label class="col-sm-2 control-label " for="form-field-1">
											Summary<span style="color: #FF2600 !important">*</span>
										</label>
										<div class="col-md-10">
											<input type="text" class="form-control" id="summary"
												name="summary" placeholder="Summary">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label " for="form-field-1">
											Description</label>
										<div class="col-md-10">
											<textarea class="form-control" id="description"
												name="description" placeholder="Description" rows="3"
												style="resize: none"></textarea>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label " for="form-field-1">
											Status<span style="color: #FF2600 !important">*</span>
										</label>
										<div class="col-md-4">
											<select class="form-control selectpicker show-tick statusId"
												id="statusId" name="statusId" data-toggle="" tabindex="-1">
												<option value="8">New</option>
											</select>
										</div>
											<label class="col-sm-2 control-label " style="padding-left: 0px !important;"
									for="form-field-1"> <!-- <span type=""
										class=" btn btn-link popover-dismiss" id="popOverMessageExt"
										data-container="body" data-toggle="popover"
										data-placement="bottom"
										style="visibility: visible;padding: 0px !important;"
										data-content="The message " data-original-title="SLA (Service Level Agreement)"> -->
											<span class="glyphicon glyphicon-flash orange" id="popOverMessageExt"></span>
									<!-- </span> --> Severity </label>
										<div class="popover bottom" id="popoverID" role="tooltip" 
											style="top: 196px; left: 208px; display: none;max-width: 333px !important;">
											<div class="arrow"></div>
											<h3 class="popover-title">SLA (Service Level Agreement)</h3>
											<!-- <div class="popover-content"><div><b>Low :</b>due Date is 12 days</div><br>
											                             <div><b>Normal :</b>due Date is 17 days</div><br>
											                             <div><b>High :</b>due Date is 1 days</div>
											                             </div> -->
											 <div class="popover-content" style="width: 333px !important;">
											 <table class="center table table-striped table-bordered table-hover" style="  margin-bottom: 0px;">
											 <thead><tr><th></th><th>Low</th><th>Normal</th><th>High</th><th>Urgent</th></tr></thead>
											 <tbody>
											 <tr><td>Due date (working days)</td><td>10</td><td>5</td><td>3</td><td>1</td></tr>
											 </tbody>
											 </table>
											                             </div>                            
										</div>
										<div class="col-md-4">
											<select class="form-control selectpicker show-tick"
												id="severityId" name="severityId"
												onchange="setDueDatebasedOnSeverity();">
											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label " for="form-field-1">
											Reported Date</label>
										<div class="col-md-4">
											<input type="text" class="form-control" id="startDate"
												name="startDate" placeholder="Date">
										</div>
										<label class="col-sm-2 control-label" for="form-field-1">
											Due date </label>
										<div class="col-md-4">
											<input type="text" class="form-control" id="dueDate"
												name="dueDate" placeholder="Date" class="" readonly='true'>
										</div>
									</div>
									<div class="form-group" style="display: none"
										id="assigneeDivId">
										<label class="col-sm-2 control-label " for="form-field-1">
											Assignee </label>
										<div class="col-md-10">
											<select class="form-control " id="asigneeId" name="asigneeId">
											</select>
										</div>
									</div>
									<div class="form-group" style="display: none"
										id="estimateAndPercentageDoneDivId">
										<label class="col-sm-2 control-label " for="form-field-1">
											Estimate Time</label>
										<div class="col-md-4">
											<input type="text" class="form-control" id="estimatedTime"
												name="estimatedTime" placeholder="Estimate Time">
										</div>
										<label class="col-sm-2 control-label " for="form-field-1">
											Percentage Done </label>
										<div class="col-md-4">
											<input type="number" id="percentageDoneId"
												name="percentageDoneId" style="height: 34px !important;" />

										</div>
									</div>

									<div class="form-group">

										<label class="col-sm-2 control-label " for="form-field-1">
											Attachment</label>
										<div class="col-xs-10">

											<label class="ace-file-input ace-file-multiple"><input
												multiple="" type="file" id="uploadFile" name="uploadFile"><font
												color="red" size=1px>(max size: 5 MB)</font> <a
												class="remove" href="#"><i class=" ace-icon fa fa-times"></i></a></label>

										</div>


									</div>


								</form>
							</div>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-sm" data-dismiss="modal"
						onclick="resetCreateIssueForm();">
						<i class="ace-icon fa fa-times"></i> Cancel
					</button>
					<button class="btn btn-sm btn-success ladda-button"
						data-style="expand-right" onclick="reportThisIssue();">
						<i class="ace-icon fa fa-check"></i> <span
							id="createIssueButtonSpanId">Create</span>
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End  of Modal For issue/report Form-->
	<!-- End  of Modal For issue/report Form-->

	<!-- Start of modal for progress bar -->
	<div class="modal fade" id="loading" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		data-backdrop="static">
		<div class="modal-dialog"
			style="position: absolute; top: 30%; left: 27%;">
			<div class="modal-content">
				<div class="modal-body" style="background: #eff3f8">
					<div class="form-horizontal">
						<div class="progress progress-striped active">
							<div class="progress-bar" role="progressbar" aria-valuenow="45"
								aria-valuemin="0" aria-valuemax="100" style="width: 89%;">
								<span class="sr-only">45% Complete</span>
							</div>
						</div>
						<center>
							<div>
								<h4>Loading....</h4>
							</div>
						</center>
					</div>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- End of modal for progress bar -->

<!-- hidden form using for redirecting to Issue Tracker application starts-->
<div style="display: none">
<form action="" method="POST" id="redirectToIssueTrackerFormId" target="_blank">
<input type="hidden" name="emailidForIssueTracker" id="emailidForIssueTracker">
<input type="hidden" name="passwordForIssueTracker" id="passwordForIssueTracker">
<input type="hidden" name="appIdForIssueTracker" id="appIdForIssueTracker">
</form>
</div>
<!-- hidden form using for redirecting to Issue Tracker application ends -->

</body>
<script type="text/javascript">
function redirectToIssueTracker(){
	$
	.ajax({
		type : 'POST',
		url : 'redirectToIssueTrackerApp',
		async : false,
		success : function(result) {
			
			var responseDetails = JSON.parse(result);
			if (responseDetails.ajaxResult == "success") {
				$("#redirectToIssueTrackerFormId").prop("action",responseDetails.issueTrackerUrl);
				$("#emailidForIssueTracker").val(responseDetails.emailId);
				/* $("#passwordForIssueTracker").val(responseDetails.password); */
				$("#appIdForIssueTracker").val(responseDetails.applicationId);
				
				if($("#emailidForIssueTracker").val() != "" && $("#appIdForIssueTracker").val() != ""){
					$("#redirectToIssueTrackerFormId").submit();
				}
				
			} else {
				$.gritter.add({
					// (string | mandatory) the heading of the notification
					title : "Elecnor FTS : Error!!",
					// (string | mandatory) the text inside the notification
					text : "Some Problem Occured. Please refresh the page and try again. If this problem persists, please contact Dev Team.",
					class_name : 'gritter-error'
				});
			}
		},
		error : function() {
			$.gritter.add({
				// (string | mandatory) the heading of the notification
				title : "Elecnor FTS : Error!!",
				// (string | mandatory) the text inside the notification
				text : "Some Problem Occured. Please refresh the page and try again. If this problem persists, please contact Dev Team.",
				class_name : 'gritter-error'
			});
		}
	});
	
}
</script>
</html>