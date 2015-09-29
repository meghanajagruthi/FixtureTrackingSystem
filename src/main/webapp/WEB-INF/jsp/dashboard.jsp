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

<link href="assets/css/font-awesome.css" rel="stylesheet">
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">

<!-- JS dependencies -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>

<script src="assets/js/bootbox.js"></script>
<link rel="stylesheet" href="assets/css/font.css">
<link href="assets/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css">
<link rel="stylesheet" href="assets/css/ace-rtl.min.css">
<link rel="stylesheet" href="assets/css/ace-skins.min.css">
<script src="assets/js/highstock.js"></script>
<script src="assets/js/exporting.js"></script>
<script type="text/javascript" src="assets/js/moment.min.js"></script>
<script type="text/javascript" src="assets/js/dashboard.js"></script>
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

.chart_radio_container {
	padding: 0 0 5px;
}

.chart_dropdown {
	float: right;
	padding: 0 0 5px;
}

.chart-head {
	height: 28px;
	margin-left: 15px;
	background: #f0f0f0;
	border: solid 1px #bbb;
	margin-bottom: 5px;
	padding: 5px;
	border-radius: 4px;
}

.chart_title {
	/* 	width: 100px; */
	margin: 0 auto;
	height: 16px;
	font-size: 16px;
	padding: 5px;
	text-shadow: 1px 1px 2px #ddd;
	font-weight: bold;
}
/* Radio Button */
.radio_container {
	-moz-user-select: none;
	-webkit-user-select: none; ' onselectstart ='return false;
	margin-top: -26px;
	float: right;
	font-size: 12px;
	position: relative;
	height: 28px;
	width: 140px;
	background: rgba(0, 0, 0, 0.2);
	border-radius: 3px;
	-webkit-box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.5), 0 1px
		rgba(255, 255, 255, 0.1);
	box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.5), 0 1px
		rgba(255, 255, 255, 0.1);
}

.switch {
	position: relative;
	margin: 20px auto;
	height: 28px;
	width: 140px;
	background: rgba(0, 0, 0, 0.60);
	border-radius: 3px;
	-webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px
		rgba(255, 255, 255, 0.1);
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px
		rgba(255, 255, 255, 0.1);
}

.switch-label {
	position: relative;
	z-index: 2;
	float: left;
	width: 68px;
	line-height: 28px;
	font-size: 12px;
	/*   font-weight: bold; */
	color: rgba(0, 0, 0, 0.5);
	text-align: center;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.4);
	cursor: pointer;
}

.switch-label:active {
	color: #000;
}

.switch-label-off {
	padding-left: 2px;
}

.switch-label-on {
	padding-right: 2px;
}

.switch-input {
	display: none;
}

.switch-input:checked+.switch-label {
	/*   font-weight: bold; */
	color: rgba(255, 255, 255, .9);
	text-shadow: 1px 1px rgba(0, 0, 0, 0.5);
	-webkit-transition: 0.15s ease-out;
	-moz-transition: 0.15s ease-out;
	-o-transition: 0.15s ease-out;
	transition: 0.15s ease-out;
}

.switch-input:checked+.switch-label-on            ~ .switch-selection {
	/* Note: left: 50% doesn't transition in WebKit */
	left: 70px;
}

.switch-selection {
	display: block;
	position: absolute;
	z-index: 1;
	top: 2px;
	left: 2px;
	width: 68px;
	height: 24px;
	background: #65bd63;
	border-radius: 3px;
	background-image: -webkit-linear-gradient(top, #a1c500, #2d6000);
	background-image: -moz-linear-gradient(top, #a1c500, #2d6000));
	background-image: -o-linear-gradient(top, #a1c500, #2d6000);
	background-image: linear-gradient(to bottom, #a1c500, #2d6000);
	-webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.7), 1px 1px 1px
		rgba(0, 0, 0, 0.6);
	box-shadow: inset 0 1px rgba(255, 255, 255, 0.7), 1px 1px 1px
		rgba(0, 0, 0, 0.6);
	-webkit-transition: left 0.15s ease-out;
	-moz-transition: left 0.15s ease-out;
	-o-transition: left 0.15s ease-out;
	transition: left 0.15s ease-out;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp"%>
	<form action="selectProjectForDashBord" id="selectProjectForDashBord" method="post">
		<input type="hidden" name="projectIdSummary" id="projectIdSummary">
	</form>
	<!-- #dialog-confirm -->
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
				<div id="sidePanelFixture" class="panel-collapse collapse in">

					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered " id="sideMenuTable">
						<thead>
							<tr>
								<th class="center">Project List</th>
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
							ace.settings.check('breadcrumbs', 'fixed');
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="fa fa-home home-fa fa"></i> <a href="login">Home</a></li>
						<li class="active">Dashboard</li>
					</ul>
					<!-- .breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Dashboard <small> <i class="fa fa-double-angle-right"></i>
								Add &amp; Select
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="row">
							<div
								class="col-xs-12 col-sm-12 widget-container-span ui-sortable">
								<div class="widget-box">
									<div class="widget-header">
										<h5>
											Project Details <span class="badge badge-info"
												id="projectDetailInfo"></span>
										</h5>
										<div class="widget-toolbar">
											<a href="fixtureInDetail.jsp#" data-action="reload"> </a> <a
												href="#projectDetail" data-toggle="collapse"> <i
												class="servicedrop glyphicon glyphicon-chevron-down"></i>
											</a>
										</div>
									</div>
									<div class="widget-body collapse" id="projectDetail">
										<div class="widget-main ">
											<div class="panel-body alert alert-info">
												<div class="form-horizontal">
													<div class="form-group">
														<label for="projectNameWLb" class="col-md-2 control-label">Project
															Name:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="projectNameW"
																name="projectNameW" placeholder="Project Name.."
																readonly="readonly">
														</div>
														<label for="projectIdWLb" class="col-md-2 control-label">Project
															Number:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="projectIdW"
																name="projectIdW" placeholder="Project #.."
																readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="startDateWLb" class="col-md-2 control-label">Start
															Date:</label>
														<div class="col-sm-4">
															<input type="text" id="startDateW"
																class="form-control hasDatepicker" name="startDateW"
																placeholder="Start Date.." readonly="readonly">
														</div>
														<label for="endDateWLb" class="col-md-2 control-label">End
															Date:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="endDateW"
																name="endDateW" placeholder="End Date.."
																readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="projManegerWLb" class="col-md-2 control-label">Project
															Manager:</label>
														<div class="col-sm-4">
															<input type="text" class="form-control" id="projManegerW"
																name="projManegerW" placeholder="Proj Mang.."
																readonly="readonly">
														</div>
														<label for="projSupervisorWLb"
															class="col-md-2 control-label">Project
															Supervisor:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="projSupervisorW" name="projSupervisorW"
																placeholder="Proj Supr.." readonly="readonly">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<br> <br>
							<div class="col-xs-12">
								<div class="tab-content">
									<div class="tabbable">
										<ul class="nav nav-tabs" id="myTab">
											<li class="active"><a data-toggle="tab"
												href="#fixtureLampCount"
												onclick="getFixtureLampCountChart()"> Fixture Lamp Count
											</a></li>

											<li><a data-toggle="tab" href="#otherGraph"
												onclick="getStackedChart()"> Ordered/Recieved </a></li>
										</ul>

										<div class="tab-content">
											<div id="fixtureLampCount" class="tab-pane in active">

												<div id="fixtureLampStat"
													style="margin-top: 10px; width: auto;"></div>
											</div>

											<div id="otherGraph" class="tab-pane">
												<div id="stackedBar" style="margin-top: 10px; width: auto;"></div>
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
									<select id="skin-colorpicker" class="hide"
										style="display: none;">
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
							</div>
 -->
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
			</div>
			<!-- /.main-container -->
			<script src="assets/js/typeahead-bs2.min.js"></script>

			<!-- page specific plugin scripts -->

			<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->

			<script src="assets/js/jquery-ui-1.10.3.custom.min.js"></script>
			<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
			<script src="assets/js/jquery.slimscroll.min.js"></script>
			<!-- JS dependencies -->
			<script type="text/javascript" language="javascript"
				src="assets/js/jquery.dataTables.min.js"></script>
			<script src="assets/js/dataTables.bootstrap.js"></script>
			<!-- ace scripts -->

			<script src="assets/js/ace-elements.min.js"></script>
			<script src="assets/js/ace.min.js"></script>
			<!-- inline scripts related to this page -->

			<div class="tooltip top in" style="display: none;">
				<div class="tooltip-inner"></div>
			</div>
</body>
</html>