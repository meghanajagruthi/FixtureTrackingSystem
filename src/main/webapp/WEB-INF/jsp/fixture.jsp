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
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<script src="assets/js/spin.min.js"></script>
<script src="assets/js/ladda.min.js"></script>
<link rel="stylesheet" href="assets/css/ladda-themeless.min.css">

<!-- JS dependencies -->
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.gritter.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>



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
<script type="text/javascript" src="assets/js/moment.min.js"></script>
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

<body>
<%@ include file="/header.jsp" %>

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
								<th>Fixture Types</th>
							</tr>
							<tr>
								<th><input type="text" name="search_engine"
									class="search_init" /></th>
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
						<li class="active">Fixture</li>
					</ul>
					<!-- .breadcrumb -->

				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							Fixture <small> <i class="fa fa-double-angle-right"></i>
								Add &amp; Select
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div class="row">
						<div class="col-sm-12">
							<!-- <div class="tabbable" id="innerDetails">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a data-toggle="tab"
										href="#lampDetails"> <i class="yellow fa fa-lightbulb-o"></i>
											Lamp Details
									</a></li>

									<li><a data-toggle="tab" href="#aEDesign"> <i
											class="green fa fa-pencil-square-o"></i> Design Details
									</a></li>
									<li><a data-toggle="tab" href="#trackingDetails"> <i
											class="blue fa fa-location-arrow"></i> Tracking Details
									</a></li>
									<li><a data-toggle="tab" href="#issueDetails"> <i
											class="red fa fa-exclamation-triangle"></i> Issue Details
									</a></li>
									<li><a data-toggle="tab" href="#changeOrder"><i
											class="blue fa fa-refresh"></i> Change Order Details </a></li>

								</ul>

								<div class="tab-content">
									<div id="lampDetails" class="tab-pane in active">
										<div class="infobox-container">
											<div class="infobox infobox-yellow  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">Philips</span>
													<div class="infobox-content">Lamp Made By</div>
												</div>
											</div>
											<div class="infobox infobox-yellow  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">Certion -001</span>
													<div class="infobox-content">Lamp Catalog Number</div>
												</div>
											</div>
											<div class="infobox infobox-yellow  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">2</span>
													<div class="infobox-content">Quantity / fixture</div>
												</div>
											</div>
										</div>
									</div>
									<div id="aEDesign" class="tab-pane">

										<div class="infobox-container">
											<div class="infobox infobox-green  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">A Sheet Count</div>
												</div>
											</div>
											<div class="infobox infobox-green  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">E Sheet Count</div>
												</div>
											</div>
											<div class="infobox infobox-green  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Attic Count</div>
												</div>
											</div>
											<div class="infobox infobox-green  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Spare Count</div>
												</div>
											</div>
											<div class="infobox infobox-green  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Qty On Order</div>
												</div>
											</div>

										</div>

									</div>
									<div id="trackingDetails" class="tab-pane">
										<div class="infobox-container">
											<div class="infobox infobox-blue  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Fixture Requested</div>
												</div>
											</div>
											<div class="infobox infobox-blue  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Lamp Requested</div>
												</div>
											</div>

											<div class="infobox infobox-blue  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Fixture Recieved Good</div>
												</div>
											</div>
											<div class="infobox infobox-blue  ">
												<div class="infobox-icon">
													<i class="icon-comments"></i>
												</div>

												<div class="infobox-data">
													<span class="infobox-data-number">32</span>
													<div class="infobox-content">Lamp Recieved Good</div>
												</div>
											</div>
										</div>
									</div>
									<div id="issueDetails" class="tab-pane">
										<div class="infobox infobox-red  ">
											<div class="infobox-icon">
												<i class="icon-comments"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">32</span>
												<div class="infobox-content">Issue Count</div>
											</div>
										</div>

									</div>
									<div id="changeOrder" class="tab-pane">
										<div class="infobox infobox-blue  ">
											<div class="infobox-icon">
												<i class="icon-comments"></i>
											</div>

											<div class="infobox-data">
												<span class="infobox-data-number">32</span>
												<div class="infobox-content">Change Order Sum</div>
											</div>
										</div>
									</div>


								</div>
							</div> -->
							<!-- /span -->
						</div>
						<!-- /row -->

						<div class="">

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
																placeholder="Start Date.." readonly="readonly" autocomplete="off">
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
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#addFixtureFormPanel"> Add Fixture / Lamp :</a>
											</h4>
										</div>
										<div id="addFixtureFormPanel" class="panel-collapse collapse">
											<div class="panel-body">
												<form class="form-horizontal well col-md-12 "
													id="fixtureFormId" commandName="fixtureFormModel"
													method="post" action="fixtureController" role="form"
													id="fixtureForm" name="addProject">
													<input type="hidden" name="actionFor" id="actionFor">
													<input type="hidden" name="fixtureNumber"
														id="fixtureNumber">

													<div class="row">
														<div class="col-sm-8 widget-container-span ui-sortable">
															<div class="widget-box">
																<div class="widget-header">
																	<h5>Fixture Details</h5>
																</div>
																<div class="widget-body">
																	<div class="widget-main">
																		<div class="form-group">
																			<label for="fixtureTypeLabel"
																				class="col-md-2 control-label">Fixture Type</label>
																			<div class="col-md-4" id="fixtureTypeError">
																				<input type="text" class="form-control"
																					id="fixtureType" name="fixtureType"
																					placeholder="Fixture Type.."
																					onkeydown="checkErrorClass('fixtureTypeError',this.id)">
																			</div>
																			<label for="fixtureVariantLabel"
																				class="col-md-2 control-label">Fixture
																				Variant</label>
																			<div class="col-sm-4">
																				<select class="form-control selectpicker show-tick"
																					data-live-search="true" title='Select...'
																					id="fixtureVariant" name="fixtureVariantTrans">
																					<option value="">--Select--</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group">
																			<label for="fixDescriptionLabel"
																				class="col-md-2 control-label">Fixture
																				Description</label>
																			<div class="col-sm-4">
																				<select
																					class="form-control selectpicker show-tick show-tick"
																					data-live-search="true" id="fixDescription"
																					name="fixDescriptionTrans">
																					<option value="">--Select--</option>
																				</select>
																			</div>
																			<label for="fixManufacturerLabel"
																				class="col-md-2 control-label">Made By</label>
																			<div class="col-md-4">
																				<select class="form-control selectpicker show-tick"
																					data-live-search="true" id="fixManufacturer"
																					name="fixManufacturerTrans">
																					<option value="">--Select--</option>
																				</select>
																			</div>
																		</div>

																		<div class="form-group">
																			<label for="fixtureCatalogNoLabel"
																				class="col-md-2 control-label">Catalog
																				Number </label>
																			<div class="col-md-4" id="fixrureCatalogNumError">
																				<input type="text" class="form-control"
																					id="fixrureCatalogNum" name="fixrureCatalogNum"
																					placeholder="Catalog Number..">
																			</div>
																			<label for="fixtureAddtnlPartLabel"
																				class="col-md-2 control-label">Additional
																				Parts</label>
																			<div class="col-md-4">
																				<input type="text" class="form-control"
																					id="additionalPart" name="additionalPart"
																					placeholder="Additional Parts.." required>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="col-sm-4 widget-container-span ui-sortable"
															style="line-height: 1.8">
															<div class="widget-box">
																<div class="widget-header">
																	<h5>Lamp Details</h5>
																</div>

																<div class="widget-body">
																	<div class="widget-main">
																		<div class="form-group">
																			<label for="lampMadeByLabel"
																				class="col-md-4 control-label">Made By</label>
																			<div class="col-sm-8">
																				<select class="form-control selectpicker show-tick"
																					data-live-search="true"
																					title='Choose Lamp Manuf...' id="lampMadeBy"
																					name="lampMadeByTrans">
																					<option value="">--Select--</option>
																				</select>
																			</div>

																		</div>
																		<div class="form-group">
																			<label for="lampCatalogNoLabel"
																				class="col-md-4 control-label">Catalog
																				Number</label>
																			<div class="col-md-8">
																				<select class="form-control selectpicker show-tick"
																					data-live-search="true"
																					title='Choose Lamp Catalog...' id="lampCatalogNo"
																					name="lampCatalogNoTrans">
																					<option value="">--Select--</option>
																				</select>
																			</div>
																		</div>
																		<div class="form-group">
																			<label for="lampQuantityLabel"
																				class="col-md-4 control-label">Quantity /
																				Fixture</label>
																			<div class="col-md-8" id="lampQtyPerFixtureError">
																				<input type="text" class="form-control"
																					id="lampQtyPerFixture" name="lampQtyPerFixture"
																					placeholder="Quantity Per Fixture.."
																					onkeypress="return isNumberKey(event,this.id)">
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="row"></div>
														<div class="form-actions">
															<div class="col-md-offset-4 col-md-4">
																<button class="btn btn-info ladda-button" type="button"
																      data-style="expand-right"  data-size="xl"
																	id="submitButton"
																	onclick="submitController('SAVE-EDIT',this);">
																	<i class="fa fa-thumbs-o-up bigger-110"></i> Submit
																</button>

																&nbsp; &nbsp; &nbsp;
																<button class="btn btn-warning" type="reset"
																	onclick="resetForm();">
																	<i class="fa fa-undo bigger-110"></i> Reset
																</button>
															</div>
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
													href="#fixtureDetailPanel"> Fixture List : </a>
											</h4>
										</div>
										<div id="fixtureDetailPanel"
											class="panel-collapse collapse in">
											<div class="panel-body">
												<table cellpadding="0" cellspacing="0" border="0"
													class="table table-striped table-bordered"
													id="fixtureTable">
													<thead>
														<tr>
															<th></th>
															<th>Fix Type</th>
															<th>Fix Variant</th>
															<th>Fix Desc</th>
															<th>Fix Made By</th>
															<th>Fix Catalog No</th>
															<th>Fix Addit. Parts</th>
															<th>Made By(L)</th>
															<th>Catalog No(L)</th>
															<th>Quantilty/Fixture(L)</th>
															<th class='action-buttons'><a class='green'
																id='addMinus' href='javascript:fnShowHide()'> <i
																	class='fa fa-plus-square-o bigger-130'></i></a></th>
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
		<!-- Fixture JS -->
		<script src="assets/js/fixture.js"></script>

		<!-- ace scripts -->

		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			
		</script>


		<div class="tooltip top in" style="display: none;">
			<div class="tooltip-inner"></div>
		</div>
</body>
</html>