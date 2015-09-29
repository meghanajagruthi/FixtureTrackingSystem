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
<link rel="stylesheet" type="text/css" href="assets/css/jquery.gritter.css">

<link href="assets/css/font-awesome.css" rel="stylesheet">

<!-- JS dependencies -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="assets/js/jquery.gritter.min.js"></script>
<script src="assets/js/bootbox.js"></script>
<link rel="stylesheet" href="assets/css/font.css">

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css">
<link rel="stylesheet" href="assets/css/ace-rtl.min.css">
<link rel="stylesheet" href="assets/css/ace-skins.min.css">
<!-- Data Table -->
<link href="assets/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- JS dependencies -->
<script type="text/javascript" language="javascript"
	src="assets/js/jquery.dataTables.min.js"></script>

<script src="assets/js/dataTables.bootstrap.js"></script>
<script src="assets/js/jquery.nestable.js"></script>
<script src="assets/js/masterFixture.js"></script>

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="assets/js/ace-extra.min.js"></script>

<%
	session = request.getSession(false);
	if (session == null) {
		return;
	}
%>

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
	<%@ include file="/header.jsp"%>

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
					<button type="button" class="btn btn-danger btn-xs">
						<i class='fa fa-trash-o bigger-110'></i>&nbsp; Delete
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

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
					<i class="fa fa-double-angle-left"
						data-icon1="fa fa-double-angle-left"
						data-icon2="fa fa-double-angle-right"></i>
				</div>

				<div id="sidePanelFixtureInDetail"
					class="panel-collapse collapse in">

					<table cellpadding="0" cellspacing="0" border="0"
						class="table table-striped table-bordered "
						id="sidePanelManageUserTable">
						<thead>
							<tr>
								<th class="center">Total Count</th>
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
						<li class="active">MasterFixture</li>
					</ul>
					<!-- .breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Fixture <small> <i class="fa fa-double-angle-right"></i>
								Details
							</small>
						</h1>
					</div>
					<!-- /.page-header -->

					<!-- PAGE CONTENT BEGINS -->

					<div class="row">
						<div class="col-md-12">

							<div class="tabbable">
								<ul class="nav nav-tabs" id="myTab">

									<li class="active"><a data-toggle="tab"
										href="masterFixture.jsp#fixVariant" id="1">Fixture Variant<span
											class="badge badge-info" id="fixVarInfo"></span>
									</a></li>
									<li><a data-toggle="tab" href="masterFixture.jsp#fixDesc"
										id="2"> Fixture Description <span class="badge badge-info"
											id="fixDescInfo"></span></a></li>
									<li><a data-toggle="tab"
										href="masterFixture.jsp#fixManufct" id="3"> Fixture
											Manufacturer <span class="badge badge-info" id="fixManfInfo"></span>
									</a></li>
									<li><a data-toggle="tab"
										href="masterFixture.jsp#lampManufct" id="4"> Lamp
											Manufacturer <span class="badge badge-info" id="lampManfInfo"></span>
									</a></li>
									<li><a data-toggle="tab"
										href="masterFixture.jsp#lampManufctCatalog"> Lamp
											Manufacturer Catalog No <span class="badge badge-info"
											id="lampCatInfo"></span>
									</a></li>
								</ul>
								<div class="tab-content">
									<div id="fixVariant" class="tab-pane in active">
										<div class="panel-body">
											<form class="form-inline well col-md-8 col-md-offset-2"
												action="fixtureVariantAction" commandName="fixtureVariant"
												id="fixVariantForm" method="post" role="form"
												name="fixVariantForm">
												<input type="hidden" name="actionFor" id="actionFor">
												<input type="hidden" name="deletionRowId" id="deletionRowId">
												<div class="form-group col-md-11 " id="fixVarDiv">
													<label for="fixtureVariantLabel"
														class="col-md-3 control-label">Fixture Variant</label>
													<div class="col-md-9 controls"
														style="margin-left: 1; width: 55%"
														id="fixVariantTypeError">
														<input type="text" class="form-control"
															id="fixVariantType" name="fixVariantType"
															placeholder="Variant..."
															onkeydown="checkErrorClass('fixVariantTypeError',this.id)">
														<p class="help-block"></p>
													</div>
													<button class="btn btn-info" type="button"
														style="line-height: 1; font-weight: bold;"
														onclick="fixVariantTypesubmitController()">
														<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
													</button>
												</div>
											</form>
											<!-- </form> -->
										</div>
										<div class="panel-body" id="panel-footer">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="fixVariantTypeTable">
												<thead>
													<tr>
														<th>Variant #</th>
														<th>Variant Type</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>

									<div id="fixDesc" class="tab-pane">
										<div class="panel-body">
											<form class="form-inline well col-md-8 col-md-offset-2"
												action="fixtureDescAction" method="post" role="form"
												name="fixtureDescriptionForm" id="fixtureDescriptionForm">
												<div class="form-group col-md-11 ">
													<label for="fixtureDescriptionLabel" class="col-md-3">Description</label>
													<div class="col-md-9" style="margin-left: 1; width: 55%"
														id="fixDescriptionError">
														<input type="text" class="form-control"
															id="fixDescription" name="fixDesc"
															placeholder="Description..."
															onkeydown="checkErrorClass('fixDescriptionError',this.id)">
													</div>
													<button class="btn btn-info" type="button"
														style="line-height: 1; font-weight: bold;"
														onclick="fixDescErrorsubmitController()">
														<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
													</button>
												</div>
											</form>
											<!-- </form> -->
										</div>
										<div class="panel-body">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="fixDescriptionTable">
												<thead>
													<tr>
														<th>Description #</th>
														<th>Description Type</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<div id="fixManufct" class="tab-pane">
										<div class="panel-body">
											<form class="form-inline well col-md-8 col-md-offset-2"
												action="fixManufacturerAction" method="post" role="form"
												name="fixManufacturerForm" id="fixManufacturerForm">
												<div class="form-group col-md-11 ">
													<label for="fixtureManufacturerLabel" class="col-md-3 ">Manufacturer</label>
													<div class="col-md-9" style="margin-left: 1; width: 55%"
														id="fixManufacturerError">
														<input type="text" class="form-control"
															id="fixManufacturer" name="fixManufacturer"
															placeholder="Manufacturer..."
															onkeydown="checkErrorClass('fixManufacturerError',this.id)">
													</div>
													<button class="btn btn-info" type="button"
														style="line-height: 1; font-weight: bold;"
														onclick="fixManufacturersubmitController()">
														<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
													</button>
												</div>
											</form>
											<!-- </form> -->
										</div>
										<div id="panel-footer" class="panel-body">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="fixManufacturerTable">
												<thead>
													<tr>
														<th>Manufacturer #</th>
														<th>Manufacturer Desc</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<div id="lampManufct" class="tab-pane">
										<div class="panel-body">
											<form class="form-inline well col-md-8 col-md-offset-2"
												action="lampManufactAction" method="post" role="form"
												name="lampManufacturerForm" id="lampManufacturerForm">
												<div class="form-group col-md-12 ">
													<label for="lampManufacturerLabel" class="col-md-4">
														Lamp Manufacturer</label>
													<div class="col-md-8" style="margin-left: 1; width: 48%"
														id="lampManufacturerError">
														<input type="text" class="form-control"
															id="lampManufacturer" name="lampManufacturer"
															placeholder="Manufacturer..."
															onkeydown="checkErrorClass('lampManufacturerError',this.id)">
													</div>
													<button class="btn btn-info" type="button"
														style="line-height: 1; font-weight: bold;"
														onclick="lampManufacturersubmitController()">
														<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
													</button>
												</div>
											</form>
											<!-- </form> -->
										</div>
										<div id="panel-footer">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="lampManufacturerTable">
												<thead>
													<tr>
														<th>Manufacturer #</th>
														<th>Manufacturer Desc</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<div id="lampManufctCatalog" class="tab-pane">
										<div class="panel-body">
											<form class="form-inline well col-md-8 col-md-offset-2"
												action="lampCatalogAction" method="post" role="form"
												name="lampCatalogForm" id="lampCatalogForm">
												<div class="form-group col-md-12 ">
													<label for="lampManufacturerCatalogLabel" class="col-md-4">
														Catalog Number</label>
													<div class="col-md-8" style="margin-left: 1; width: 48%"
														id="lampCatalogError">
														<input type="text" class="form-control" id="lampCatalog"
															name="lampCatalog" placeholder="Catalog No..."
															onkeydown="checkErrorClass('lampCatalogError',this.id)">
													</div>
													<button class="btn btn-info" type="button"
														style="line-height: 1; font-weight: bold;"
														onclick="lampCatalogsubmitController()">
														<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
													</button>
												</div>
											</form>
											<!-- </form> -->

										</div>
										<div id="panel-footer">
											<table cellpadding="0" cellspacing="0" border="0"
												class="table table-striped table-bordered"
												id="lampCatalogTable">
												<thead>
													<tr>
														<th>Catalog #</th>
														<th>Catalog Desc</th>
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
						<!-- End col md12 -->
						<!-- /span -->
					</div>
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

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<div class="tooltip top in" style="display: none;">
		<div class="tooltip-inner"></div>
	</div>
</body>
</html>