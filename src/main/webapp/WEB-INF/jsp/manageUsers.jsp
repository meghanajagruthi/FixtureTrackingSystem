<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Elecnor FMS</title>
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />

<!-- CSS dependencies -->
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/datepicker.css">
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<link href="assets/css/font-awesome.css" rel="stylesheet">
<link href="assets/css/jquery.gritter.css" rel="stylesheet">

<!-- JS dependencies -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.gritter.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
<script src="assets/js/bootbox.js"></script>
<script src="assets/js/spin.min.js"></script>
<script src="assets/js/ladda.min.js"></script>
<link rel="stylesheet" href="assets/css/ladda-themeless.min.css">

<link rel="stylesheet" href="assets/css/font.css">

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css">
<link rel="stylesheet" href="assets/css/ace-rtl.min.css">
<link rel="stylesheet" href="assets/css/ace-skins.min.css">
<!-- Data Table -->
<link href="assets/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- JS dependencies -->

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<style type="text/css">
.jqstooltip {
	position: absolute;
	left: 0px;
	top: 0px;
	visibility: hidden;
	background: rgb(0, 0, 0) transparent;
	background-color: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,
		endColorstr=#99000000);
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";
	color: white;
	font: 10px arial, san serif;
	text-align: left;
	white-space: nowrap;
	padding: 5px;
	border: 1px solid white;
	z-index: 10000;
}

.jqsfield {
	color: white;
	font: 10px arial, san serif;
	text-align: left;
}
</style>
</head>

</head>
<body>
	<%@ include file="/header.jsp" %>
	
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar sidebar-fixed" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success" id="projectSelectShortCut"
							data-toggle="tooltip" data-placement="bottom"
							title="Select Project" onclick="location.href = 'login';">
							<i class="fa fa-folder"></i>
						</button>

						<button class="btn btn-info" id="fixtureSelectShortCut"
							data-toggle="tooltip" data-placement="bottom"
							title="Select Fixture" onclick="location.href = 'fixture';">
							<i class="fa fa-pencil"></i>
						</button>

						<button class="btn btn-warning" id="fixtureInDetailShortCut"
							data-toggle="tooltip" data-placement="bottom"
							title="View Fixture In Detail"
							onclick="location.href = 'fixtureInDetail';">
							<i class="fa fa-group"></i>
						</button>
						<button class="btn btn-danger" id="dashboardShortcut"
							data-toggle="tooltip" data-placement="bottom" title="Dashboard"
							onclick="location.href = 'dashboard';">
							<i class="fa fa-bar-chart-o"></i>
						</button>

					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="fa fa-double-angle-left" data-fa
						fa1="fa fa-double-angle-left" data-fa
						fa2="fa fa-double-angle-right"></i>
				</div>

				<div id="sidePanelManageUser" class="panel-collapse collapse in">

					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered"
						id="sidePanelTableMangUser">
						<thead>
							<tr>
								<th class="center">User List</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>

				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>
					<ul class="breadcrumb">
						<li><i class="fa fa-home home-fa fa"></i> <a href="login">Home</a></li>
						<li class="active">Users</li>
					</ul>
					<!-- .breadcrumb -->
				</div>
				<div class="page-content">
					<div class="page-header">
						<h1>
							Manage User <small> <i class="fa fa-double-angle-right"></i>
								Add &amp; Select
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<div class="row">
						<div class="col-xs-12">
							<div class="panel-group" id="accordion">
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#addUserFormPanel"> Add Users : </a>
										</h4>
									</div>
									<div id="addUserFormPanel" class="panel-collapse collapse">
										<div class="panel-body">
											<form class="form-horizontal well col-md-10 col-md-offset-1"
												method="post" action="manageUserAction" role="form"
												id="manageUserFormId" name="manageUserFormId"
												commandName="manageUserForm">
												<div class="form-group">
													<input type="hidden" id="actionForUser"
														name="actionForUser"> <input type="hidden"
														id="sNo" name="sNo"> <label for="firstNameLabel"
														class="col-md-2 control-label">First Name:</label>
													<div class="col-md-4" id="firstNameError">
														<input type="text" class="form-control" id="firstName"
															name="firstName" placeholder="First Name.." onkeydown="checkErrorClass('firstNameError',this.id)">
													</div>
													<label for="middleNameLabel" class="col-md-2 control-label">Middle
														Name:</label>
													<div class="col-md-4">
														<input type="text" class="form-control" id="middleName"
															name="middleName" placeholder="Middle Name..">
													</div>
												</div>
												<div class="form-group">
													<label for="lastNameLabel" class="col-md-2 control-label">Last
														Name:</label>
													<div class="col-sm-4">
														<input type="text" id="lastName" id="datepicker"
															class="form-control hasDatepicker" name="lastName"
															placeholder="Last Name..">
													</div>
													<label for="emailIdLabel" class="col-md-2 control-label">Email
														Id: </label>
													<div class="col-md-4" id="emailIdError">
														<input type="text" class="form-control" id="emailId"
															name="emailId" placeholder="Email Id.." onchange="javascript:validateEmail(this.value);"
															 onkeydown="checkErrorClass('emailIdError',this.id)">
													</div>
												</div>
												<div class="form-group">
													<label for="userIdLabel" class="col-md-2 control-label">User
														Id:</label>
													<div class="col-sm-4" id="userIdError">
														<input type="text" id="userId" id="datepicker"
															class="form-control hasDatepicker" name="userId"
															placeholder="User Id.." onkeydown="checkErrorClass('userIdError',this.id)">
													</div>
													<label for="passwordLabel" class="col-md-2 control-label">Password:
													</label>
													<div class="col-md-4" id="passwordError">
														<input type="password" class="form-control" id="password"
															name="password" placeholder="Password.." onkeydown="checkErrorClass('passwordError',this.id)">
													</div>
												</div>
												<div class="form-group">
													<label for="roleLabel" class="col-md-2 control-label">Role:</label>
													<div class="col-sm-4">
														<select class="form-control selectpicker show-tick"
															id="role" name="role">
															<option value="">--Select--</option>
															<option value="ADMIN">Admin</option>
															<option value="MANAGER">Manager</option>
															<option value="SUPERVISOR">Supervisor</option>
														</select>
													</div>
													<label for="supervisiorLabel"
														class="col-md-2 control-label">Supervisor:</label>
													<div class="col-md-4">
														<select class="form-control selectpicker show-tick"
															id="supervisorSelect" name="supervisorSelect">
															<option value="">--Select--</option>
														</select>
													</div>
												</div>

												<div class="form-actions">
													<div class="col-md-offset-4 col-md-9">
														<button class="btn btn-info ladda-button" type="button"
														      data-style="expand-right" data-size="xl"
															id="submitButtonUser" name="submitButtonUser"
															onclick="submitController('SAVE-EDIT',this);">
															<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
														</button>

														&nbsp; &nbsp; &nbsp;
														<button class="btn btn-warning" type="reset"
															onclick="resetUserForm();">
															<i class="fa fa-undo bigger-110"></i> Reset
														</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#userTablePanel"> User List : </a>
										</h4>
									</div>
									<div id="userTablePanel" class="panel-collapse collapse in">
										<div class="panel-body">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="manageUserTable">
												<thead>
													<tr>
														<th>First Name</th>
														<th>Middle Name</th>
														<th>Last Name</th>
														<th>Email</th>
														<th>User Id</th>
														<th>Role</th>
														<th>Supervisor</th>
														<!-- <th>Submitted By</th>  -->
														<th></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->

		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
				id="ace-settings-btn">
				<i class="fa fa-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<!-- <div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide" style="display: none;">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
						<div class="dropdown dropdown-colorpicker">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#"><span
								class="btn-colorpicker"
								style="background-color: rgb(67, 142, 185);"></span></a>
							<ul class="dropdown-menu dropdown-caret">
								<li><a class="colorpick-btn selected" href="#"
									style="background-color: #438EB9;" data-color="#438EB9"></a></li>
								<li><a class="colorpick-btn" href="#"
									style="background-color: #222A2D;" data-color="#222A2D"></a></li>
								<li><a class="colorpick-btn" href="#"
									style="background-color: #C6487E;" data-color="#C6487E"></a></li>
								<li><a class="colorpick-btn" href="#"
									style="background-color: #D0D0D0;" data-color="#D0D0D0"></a></li>
							</ul>
						</div>
					</div>
					<span>&nbsp; Choose Skin</span>
				</div> -->

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-navbar"> <label class="lbl"
						for="ace-settings-navbar"> Fixed Navbar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-sidebar"> <label class="lbl"
						for="ace-settings-sidebar"> Fixed Sidebar</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-breadcrumbs"> <label class="lbl"
						for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-rtl"> <label class="lbl"
						for="ace-settings-rtl"> Right To Left (rtl)</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2"
						id="ace-settings-add-container"> <label class="lbl"
						for="ace-settings-add-container"> Inside <b>.container</b>
					</label>
				</div>
			</div>
		</div>
		<!-- /#ace-settings-container -->
	</div>
	<!-- /.main-container-inner -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="fa fa-double-angle-up fa fa-only bigger-110"></i>
	</a>
	<!-- /.main-container -->
	<script src="assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->

	<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/jquery.slimscroll.min.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script type="text/javascript" src="assets/js/manageUser.js"></script>

	<div class="tooltip top in" style="display: none;">
		<div class="tooltip-inner"></div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<h4 class='smaller'>
							<i class='fa fa-warning-sign red'></i> Delete it?
						</h4>
					</h4>
				</div>
				<div class="modal-body">
					<div class="alert alert-info bigger-110">These items will be
						permanently deleted and cannot be recovered. Only Admin can
						recover it.</div>

					<div class="space-6"></div>

					<p class="bigger-110 bolder center grey">
						<i class="fa fa-hand-o-right blue bigger-120"></i> Are you sure?
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-xs" data-dismiss="modal">
						<i class=' bigger-110'></i>&#10006; Cancel
					</button>
					<button type="button" class="btn btn-danger btn-xs"
						onclick="submitController('DELETE');">
						<i class='fa fa-trash-o bigger-110'></i>&nbsp; Delete
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/dataTables.bootstrap.js"></script>
</body>
</html>