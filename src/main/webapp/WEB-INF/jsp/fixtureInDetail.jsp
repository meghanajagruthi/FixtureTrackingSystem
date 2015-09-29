<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Elecnor FMS</title>

<!-- CSS dependencies -->
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/jquery.gritter.css">
<link rel="stylesheet" type="text/css" href="assets/css/datepicker.css">
<link href="assets/css/font-awesome.css" rel="stylesheet">
<link href="assets/css/bootstrap-select.min.css" rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/favicon.ico" />
<!-- JS dependencies -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.gritter.min.js"></script>

<script type="text/javascript" src="assets/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap-datepicker.js"></script>
<script type="text/javascript" src="assets/js/moment.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/dataTables.bootstrap.js"></script>
<script src="assets/js/jquery.nestable.js"></script>
<script src="assets/js/spin.min.js"></script>
<script src="assets/js/ladda.min.js"></script>
<link rel="stylesheet" href="assets/css/ladda-themeless.min.css">
<%
	session = request.getSession(false);
	System.out.println("Session CHecking  ");
	if (session == null) {
		return;
	}
%>

<script type="text/javascript">
	jQuery(
			function($) {
				$('#dateNeededOnsite').datepicker().on('changeDate',
						function(ev) {
							$('#dateNeededOnsite').datepicker('hide');
						});
				$('#dateReleaseVendor').datepicker().on('changeDate',
						function(ev) {
							$('#dateReleaseVendor').datepicker('hide');
						});
				$('#dateEstimatedReceived').datepicker().on('changeDate',
						function(ev) {
							$('#dateEstimatedReceived').datepicker('hide');
						});
				$('#dateEstimatedDelivery').datepicker().on('changeDate',
						function(ev) {
							$('#dateEstimatedDelivery').datepicker('hide');
						});
				$('#dateActualReceived').datepicker().on('changeDate',
						function(ev) {
							$('#dateActualReceived').datepicker('hide');
						});

				$('#dateActualDelivery').datepicker().on('changeDate',
						function(ev) {
							$('#dateActualDelivery').datepicker('hide');
						});
				$('#dateSubmitted').datepicker().on('changeDate', function(ev) {
					$('#dateSubmitted').datepicker('hide');
				});

				$('#dateApproved').datepicker().on('changeDate', function(ev) {
					$('#dateApproved').datepicker('hide');
				});

				$('#issueDate').datepicker().on('changeDate', function(ev) {
					$('#issueDate').datepicker('hide');
				});

				$('#resolvedDate').datepicker().on('changeDate', function(ev) {
					$('#resolvedDate').datepicker('hide');
				});

				$('#changeOrderDate').datepicker().on('changeDate',
						function(ev) {
							$('#changeOrderDate').datepicker('hide');
						});
				$('#fixRecorderDate').datepicker().on('changeDate',
						function(ev) {
							$('#fixRecorderDate').datepicker('hide');
						});
				$('#fixPmInformedDate').datepicker().on('changeDate',
						function(ev) {
							$('#fixPmInformedDate').datepicker('hide');
						});
				$('#fixVendorInformedDate').datepicker().on('changeDate',
						function(ev) {
							$('#fixVendorInformedDate').datepicker('hide');
						});

				$('#lampRecorderDate').datepicker().on('changeDate',
						function(ev) {
							$('#lampRecorderDate').datepicker('hide');
						});
				$('#lampPmInformedDate').datepicker().on('changeDate',
						function(ev) {
							$('#lampPmInformedDate').datepicker('hide');
						});
				$('#lampVendorInformedDate').datepicker().on('changeDate',
						function(ev) {
							$('#lampVendorInformedDate').datepicker('hide');
						});

				$('#projectSelectShortCut').tooltip();
				$('#fixtureSelectShortCut').tooltip();
				$('#manageUserShortCut').tooltip();
				$('#summaryShortCut').tooltip();

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

					if (parseInt(off2.left) < parseInt(off1.left)
							+ parseInt(w1 / 2))
						return 'right';
					return 'left';
				}

				$('.dialogs,.comments').slimScroll({
					height : '300px'
				});

				//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
				//so disable dragging when clicking on label
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
					stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
						$(ui.item).css('z-index', 'auto');
					}
				});
				$('#tasks').disableSelection();
				$('#tasks input:checkbox').removeAttr('checked').on('click',
						function() {
							if (this.checked)
								$(this).closest('li').addClass('selected');
							else
								$(this).closest('li').removeClass('selected');
						});
			})
</script>

<script src="assets/js/bootbox.js"></script>
<link rel="stylesheet" href="assets/css/font.css">

<!-- ace styles -->

<link rel="stylesheet" href="assets/css/ace.min.css">
<link rel="stylesheet" href="assets/css/ace-rtl.min.css">
<link rel="stylesheet" href="assets/css/ace-skins.min.css">
<!-- Data Table -->
<link href="assets/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- JS dependencies -->


<!--[if lte IE 8]>
		  <link rel="stylesheet" href="asse ts/css/ace-ie.min.css" />
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
#sidePanelFixtureInDetailTable_length > label > select{
width: auto;
}
</style>
</head>

</head>
<body>
	<%@ include file="/header.jsp"%>
	<form action="fixtureController" id="selectFixtureFormId" method="post">
		<input type="hidden" id="fixtureNumber" name="fixtureNumber">
		<input type="hidden" name="actionFor" value="select">
	</form>
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
						onclick="submitController('DELETE','');">
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
				ace.settings.check('main-container', 'fixed');
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
						ace.settings.check('sidebar', 'fixed');
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
						id="sidePanelFixtureInDetailTable">
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
						ace.settings.check('sidebar', 'collapsed');
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
						<li><a href="fixture" id="fixture">Fixture</a></li>
						<li class="active" id="fixtureInDetail">FixtureInDetail</li>
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
						<div class="row">
							<div class="col-xs-12 col-sm-6 widget-container-span ui-sortable"
								style="margin-left: 1.24%; width: 48.73%">
								<div class="widget-box">
									<div class="widget-header">
										<h5>
											Selected Project <span class="badge badge-info"
												id="projectDetailInfo"></span>
										</h5>
										<div class="widget-toolbar">
											<a href="fixtureInDetail.jsp#"> </a> <a href="#projectDetail"
												data-toggle="collapse"> <i
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
																placeholder="Start Date.." readonly="readonly"
																autocomplete="off">
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
							<div class="col-xs-12 col-sm-6 widget-container-span ui-sortable"
								style="width: 48.73%">
								<div class="widget-box">
									<div class="widget-header">
										<h5>
											Selected Fixture <span class="badge badge-info"
												id="fixtureDetailInfo"></span>
										</h5>
										<div class="widget-toolbar">
											<a href="fixtureInDetail.jsp#"> </a> <a href="#fixtureDetail"
												data-toggle="collapse"> <i
												class="servicedrop glyphicon glyphicon-chevron-down"></i>
											</a>
										</div>
									</div>
									<div class="widget-body collapse" id="fixtureDetail">
										<div class="widget-main">
											<div class="panel-body alert alert-info">
												<div class="form-horizontal">
													<div class="form-group">
														<label for="fixtureTypeWLb" class="col-md-2 control-label">Fixture
															Type:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="fixtureTypeW"
																name="fixtureTypeW" placeholder="Fixture Type.."
																readonly="readonly">
														</div>
														<label for="fixtureVariantWLb"
															class="col-md-2 control-label">Fixture Variant:</label>
														<div class="col-sm-4">
															<input type="text" class="form-control"
																id="fixtureVariantW" name="fixtureVariantW"
																placeholder="Fixture Variant.." readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="fixDescriptionWLb"
															class="col-md-2 control-label">Fixture
															Description:</label>
														<div class="col-sm-4">
															<input type="text" class="form-control"
																id="fixDescriptionW" name="fixDescriptionW"
																placeholder="Fixture Desc.." readonly="readonly">
														</div>
														<label for="fixtureCatalogNoWLb"
															class="col-md-2 control-label">Catalog Number:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="fixtureCatalogNoW" name="fixtureCatalogNoW"
																placeholder="Catalog #.." readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="lampCatalogNoWLb"
															class="col-md-2 control-label">Lamp Catalog#:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="lampCatalogNoW" name="lampCatalogNoW"
																placeholder="Lamp Catalog #.." readonly="readonly">
														</div>
														<label for="lampQuantityWLb"
															class="col-md-2 control-label">Qty / Fixture:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="lampQuantityW" name="lampQuantityW"
																placeholder="Qty / Fixture.." readonly="readonly">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12 col-sm-6 widget-container-span ui-sortable"
								style="margin-left: 1.24%; width: 48.73%">
								<div class="widget-box">
									<div class="widget-header">
										<h5>Fixture Details</h5>
										<div class="widget-toolbar">
											<a href="fixtureInDetail.jsp#"> </a> <a
												href="#fixtureDetails" data-toggle="collapse"> <i
												class="servicedrop glyphicon glyphicon-chevron-up"></i>
											</a>
										</div>
									</div>
									<div class="widget-body collapse in" id="fixtureDetails">
										<div class="widget-main ">
											<div class="panel-body alert alert-info">
												<div class="form-horizontal">
													<div class="form-group">
														<label for="quantityONOrderlb"
															class="col-md-2 control-label">Quantity Order:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="quantityONOrderF" name="quantityONOrderF"
																placeholder="Quantity on Order.." readonly="readonly">
														</div>
														<label for="" recievedlb" class="col-md-2 control-label">Required:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="requiredF"
																name="requiredF" placeholder="Required.."
																readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="releasedlb" class="col-md-2 control-label">Received
															Good:</label>
														<div class="col-sm-4">
															<input type="text" id="recievedF"
																class="form-control hasDatepicker" name="recievedF"
																placeholder="Received.." readonly="readonly"
																autocomplete="off">
														</div>
														<label for="changeOrderlb" class="col-md-2 control-label">Change
															Order:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="changeOrderF"
																name="changeOrderF" placeholder="Change Order.."
																readonly="readonly">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-xs-12 col-sm-6 widget-container-span ui-sortable"
								style="width: 48.73%">
								<div class="widget-box">
									<div class="widget-header">
										<h5>Lamp Details</h5>
										<div class="widget-toolbar">
											<a href="fixtureInDetail.jsp#"> </a> <a
												href="#projectDetails" data-toggle="collapse"> <i
												class="servicedrop glyphicon glyphicon-chevron-up"></i>
											</a>
										</div>
									</div>
									<div class="widget-body collapse in" id="projectDetails">
										<div class="widget-main ">
											<div class="panel-body alert alert-info">
												<div class="form-horizontal">
													<div class="form-group">
														<label for="quantityONOrderlb"
															class="col-md-2 control-label">Quantity Order:</label>
														<div class="col-md-4">
															<input type="text" class="form-control"
																id="quantityONOrderL" name="quantityONOrderL"
																placeholder="Quantity on Order.." readonly="readonly">
														</div>
														<label for="" recievedlb" class="col-md-2 control-label">Required:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="requiredL"
																name="requiredL" placeholder="Required.."
																readonly="readonly">
														</div>
													</div>
													<div class="form-group">
														<label for="releasedlb" class="col-md-2 control-label">Received
															Good:</label>
														<div class="col-sm-4">
															<input type="text" id="recievedL"
																class="form-control hasDatepicker" name="recievedL"
																placeholder="Received.." readonly="readonly"
																autocomplete="off">
														</div>
														<label for="changeOrderlb" class="col-md-2 control-label">Change
															Order:</label>
														<div class="col-md-4">
															<input type="text" class="form-control" id="changeOrderL"
																name="changeOrderL" placeholder="Change Order.."
																readonly="readonly">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12">
							<div class="col-xs-12 dd" id="nestable">
								<ol class="dd-list">
									<li class="dd-item" id="sheetsID" data-id="1">
										<div class="dd-handle">Electrical / Architectural Design</div>
										<ol class="dd-list">
											<li class="dd-item" data-id="2">
												<!-- Sheet Details -->
												<div class="row">
													<div class="col-xs-12">
														<div class="panel-group">
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse" href="#sheetDetailsPanel">
																			Add Details : </a>
																	</h4>
																</div>
																<div id="sheetDetailsPanel"
																	class="panel-collapse collapse in">
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-12">
																				<div class="tabbable">
																					<ul class="nav nav-tabs" id="myTab">
																						<li class="active"><a data-toggle="tab"
																							href="fixtureInDetail.jsp#ESheetId"> E Sheet
																						</a></li>

																						<li><a data-toggle="tab"
																							href="fixtureInDetail.jsp#ASheetId"> A Sheet
																						</a></li>
																						<li><a data-toggle="tab"
																							href="fixtureInDetail.jsp#atticStockIdDiv">
																								Attic / Spare </a></li>
																					</ul>
																					<div class="tab-content">
																						<div id="ESheetId" class="tab-pane in active">
																							<div class="panel-body">
																								<form action="eSheetAction"
																									commandName="eSheetForm" method="post"
																									id="eSheetFormId"
																									class="form-horizontal well col-md-10 col-md-offset-1"
																									role="form" name="eSheetFormId">
																									<input type="hidden" name="actionForESheet"
																										id="actionForESheet"> <input
																										type="hidden" name="eDesignId" id="eDesignId">
																									<div class="form-group">
																										<label for="eSheetCount"
																											class="col-md-2 control-label">Count:</label>
																										<div class="col-md-4" id="eDesignCountError">
																											<input type="text" class="form-control"
																												id="eDesignCount" name="eDesignCount"
																												placeholder="E Sheet Count.."
																												onkeydown="checkErrorClass('eDesignCountError',this.id)"
																												onkeypress="return isNumberKey(event,this.id)">
																										</div>
																										<label for="eSheetDWG"
																											class="col-md-2 control-label">DWG:</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="eDesignNum" name="eDesignNum"
																												placeholder="Dwg..">
																										</div>
																									</div>
																									<div class="form-group">
																										<label for="eSheetDescription"
																											class="col-md-2 control-label">Description:</label>
																										<div class="col-sm-4">
																											<input type="text" id="eDesignDesc"
																												class="form-control" name="eDesignDesc"
																												placeholder="Description..">
																										</div>
																										<label for="eSheetArea"
																											class="col-md-2 control-label">Area:</label>
																										<div class="col-sm-4">
																											<input type="text" id="eDesignArea"
																												class="form-control" name="eDesignArea"
																												placeholder="Area..">
																										</div>
																									</div>
																									<div class="form-group">
																										<label for="eSheetlocation"
																											class="col-md-2 control-label">Location:</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="eDesignLocation" name="eDesignLocation"
																												placeholder="Location..">
																										</div>
																										<label for="eSheetComment"
																											class="col-md-2 control-label">Comments:</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="comments" name="comments"
																												placeholder="Comment..">
																										</div>
																									</div>
																									<div class="form-actions">
																										<div class="col-md-offset-4 col-md-9">
																											<button class="btn btn-info ladda-button" type="button"
																												id="submitButtonESheet" 
																												data-style="expand-right" data-size="xl"
																												onclick="submitController('SAVE-EDIT','eSheetFormId',this);">
																												<i class="fa fa-thumbs-o-up bigger-110"></i>
																												Submit
																											</button>
																											&nbsp; &nbsp; &nbsp;
																											<button class="btn btn-warning" type="reset"
																												onclick="resetFormESheet()">
																												<i class="fa fa-undo bigger-110"></i> Reset
																											</button>
																										</div>
																									</div>
																								</form>
																							</div>
																							<div id="panel-footer">
																								<table cellpadding="0" cellspacing="0"
																									border="0"
																									class="table table-striped table-bordered"
																									id="eSheetTable">
																									<thead>
																										<tr>
																											<th>Count</th>
																											<th>Dwg</th>
																											<th>Description</th>
																											<th>Area</th>
																											<th>Location</th>
																											<th>Comments</th>
																											<th></th>
																										</tr>
																									</thead>
																									<tbody>
																									</tbody>
																								</table>
																							</div>
																						</div>

																						<!-- ======Changes By Ashutosh Starts Here====== -->
																						<div id="ASheetId" class="tab-pane">
																							<div class="panel-body">
																								<form action="aSheetAction" method="post"
																									commandName="aSheetForm" id="aSheetFormId"
																									class="form-horizontal well col-md-10 col-md-offset-1"
																									role="form" name="aSheetFormId">
																									<input type="hidden" name="actionForASheet"
																										id="actionForASheet"> <input
																										type="hidden" name="aDesignId" id="aDesignId">
																									<div class="form-group">
																										<label for="aSheetDWGLabel"
																											class="col-md-2 control-label">Count:</label>
																										<div class="col-md-4" id="aDesignCountError">
																											<input type="text" class="form-control"
																												id="aDesignCount" name="aDesignCount"
																												placeholder="A Sheet Count.."
																												onkeydown="checkErrorClass('aDesignCountError',this.id)"
																												onkeypress="return isNumberKey(event,this.id)">
																										</div>
																										<label for="aSheetDescLabel"
																											class="col-md-2 control-label">DWG:</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="aDesignNum" name="aDesignNum"
																												placeholder="DWG..">
																										</div>
																									</div>
																									<div class="form-group">
																										<label for="aSheetAreaLabel"
																											class="col-md-2 control-label">Description:</label>
																										<div class="col-sm-4">
																											<input type="text" id="aDesignDesc"
																												class="form-control" name="aDesignDesc"
																												placeholder="Description..">
																										</div>
																										<label for="aSheetOtherLabel"
																											class="col-md-2 control-label">Area:</label>
																										<div class="col-sm-4">
																											<input type="text" id="aDesignArea"
																												class="form-control" name="aDesignArea"
																												placeholder="Area..">
																										</div>
																									</div>
																									<div class="form-group">
																										<label for="aSheetQtyLabel"
																											class="col-md-2 control-label">Location:</label>
																										<div class="col-sm-4">
																											<input type="text" id="aDesignLocation"
																												class="form-control" name="aDesignLocation"
																												placeholder="Location..">
																										</div>
																										<label for="aSheetDateLabel"
																											class="col-md-2 control-label">Comments:</label>
																										<div class="col-sm-4">
																											<input type="text" id="aSheetComments"
																												class="form-control" name="aSheetComments"
																												placeholder="Comments..">
																										</div>
																									</div>
																									<div class="form-actions">
																										<div class="col-md-offset-4 col-md-9">
																											<button class="btn btn-info ladda-button" type="button"
																												id="submitButtonASheet"
																												data-style="expand-right" data-size="xl"
																												onclick="submitController('SAVE-EDIT','aSheetFormId',this)">
																												<i class="fa fa-thumbs-o-up bigger-110"></i>
																												Submit
																											</button>

																											&nbsp; &nbsp; &nbsp;
																											<button class="btn btn-warning" type="reset"
																												onclick="resetFormASheet()">
																												<i class="fa fa-undo bigger-110"></i> Reset
																											</button>
																										</div>
																									</div>
																								</form>
																							</div>
																							<div id="panel-footer">
																								<table cellpadding="0" cellspacing="0"
																									border="0"
																									class="table table-striped table-bordered"
																									id="aSheetTable">
																									<thead>
																										<tr>
																											<th>Count</th>
																											<th>Dwg</th>
																											<th>Description</th>
																											<th>Area</th>
																											<th>Location</th>
																											<th>Comments</th>
																											<th></th>
																										</tr>
																									</thead>
																									<tbody>
																									</tbody>
																								</table>
																							</div>
																						</div>
																						<!-- ======Changes By Ashutosh Ends Here====== -->
																						<div id="atticStockIdDiv" class="tab-pane">
																							<div class="panel-body">
																								<form action="attStockAction" method="post"
																									commandName="attStockForm"
																									id="atticStockFormId"
																									class="form-horizontal well col-md-10 col-md-offset-1"
																									role="form">
																									<input type="hidden" name="actionForAtticStock"
																										id="actionForAtticStock"> <input
																										type="hidden" name="atticStockId"
																										id="atticStockId">
																									<div class="form-group">
																										<label for="aSheetDWGLabel"
																											class="col-md-2 control-label">Attic
																											Stock Count:</label>
																										<div class="col-md-4"
																											id="atticStockCountError">
																											<input type="text" class="form-control"
																												id="atticStockCount" name="atticStockCount"
																												placeholder="Attick Count.."
																												onkeypress="return isNumberKey(event,this.id)">
																										</div>
																										<label for="aSheetAreaLabel"
																											class="col-md-2 control-label">Spare
																											Count:</label>
																										<div class="col-sm-4" id="spareCountError">
																											<input type="text" id="spareCount"
																												class="form-control" name="spareCount"
																												placeholder="Spare Count.."
																												onkeypress="return isNumberKey(event,this.id)">
																										</div>
																									</div>
																									<div class="form-actions">
																										<div class="col-md-offset-4 col-md-9">
																											<button class="btn btn-info ladda-button" type="button"
																												id="submitButtonAtticStock"
																												data-style="expand-right" data-size="xl"
																												onclick="submitController('SAVE-EDIT','atticStockFormId',this)">
																												<i class="fa fa-thumbs-o-up bigger-110"></i>
																												Submit
																											</button>
																											&nbsp; &nbsp; &nbsp;
																											<button class="btn btn-warning" type="reset"
																												onclick="resetFormAtticStock()">
																												<i class="fa fa-undo bigger-110"></i> Reset
																											</button>
																										</div>
																									</div>
																								</form>
																							</div>
																							<div id="panel-footer">
																								<table cellpadding="0" cellspacing="0"
																									border="0"
																									class="table table-striped table-bordered"
																									id="attickStockTable">
																									<thead>
																										<tr>
																											<th>Attic Stock Count</th>
																											<th>Spare Count</th>
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
																			<!-- End col md12 -->
																			<!-- /span -->
																		</div>
																		<!--End row div  -->
																	</div>
																</div>
															</div>
														</div>
													</div>
													<!-- /.col -->
												</div> <!-- /.Sheet Details -->
											</li>
										</ol>
									</li>
								</ol>
							</div>
						</div>
						<!--  TRACKING SHEET STARTS HERE by Ashraf   -->

						<div class="col-xs-12">
							<div class="col-xs-12 dd" id="tractable">
								<ol class="dd-list">
									<li class="dd-item" data-id="1" id="trackingAjaxCall">
										<div class="dd-handle">Tracking</div>
										<ol class="dd-list">
											<li class="dd-item" data-id="2">
												<!-- Sheet Details -->
												<div class="row">
													<div class="col-xs-12">
														<div class="panel-group" id="accordio">
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse" data-parent="#accordio"
																			href="#trackingDetailsPanel"> Add Tracking
																			Details : </a>
																	</h4>
																</div>
																<div id="trackingDetailsPanel"
																	class="panel-collapse collapse">
																	<div class="row-fluid">
																		<div class="span12 ">
																			<div class=" panel-body">
																				<form role="form" action="trackingController"
																					commandName="trackingBeanId" id="trackingForm"
																					method="post">
																					<input type="hidden" id="trackingIdUI"
																						name="trackingIdUI"> <input type="hidden"
																						id="actionForTracking" name="actionForTracking">
																					<div class="widget-body panel-body">
																						<div class="widget-main">
																							<div id="fuelux-wizard" class="row-fluid"
																								data-target="#step-container">
																								<ul class="wizard-steps">
																									<li data-target="#step1" class="active myClass"><span
																										class="step">1</span> <span class="title"
																										id="change">New Request</span></li>

																									<li data-target="#step2" class="myClass"><span
																										class="step">2</span> <span class="title">Estimated</span></li>

																									<li data-target="#step3" class="myClass"><span
																										class="step">3</span> <span class="title">Delivered</span></li>

																									<li data-target="#step4" class="myClass"><span
																										class="step">4</span> <span class="title">Summary</span></li>
																								</ul>
																							</div>

																							<hr>
																							<div
																								class="step-content row-fluid position-relative"
																								id="step-container">
																								<div class="step-pane active" id="step1">
																									<h3 class="lighter block green"></h3>
																									<div class="row" id="backToStep1">
																										<div class="col-md-12">
																											<div class="tabbable">
																												<!-- CHANGETO -->
																												<div class="">
																													<div id="issuesDiv"
																														class="tab-pane in active">
																														<!-- CHANGETO -->
																														<div class="row">
																															<div
																																class="form-horizontal well col-md-10 col-md-offset-1">
																																<div class="form-group">
																																	<label for="fixturelb"
																																		class="col-md-2 control-label">Fixture
																																	</label>
																																	<div class="col-md-4"
																																		id="fixtureQtyError">
																																		<input type="text"
																																			class="form-control" id="fixtureQty"
																																			name="fixtureQty"
																																			placeholder="Fixture.."
																																			onkeypress="return isNumberKey(event,this.id)">
																																	</div>
																																	<label for="lamplb"
																																		class="col-md-2 control-label">Lamp
																																	</label>
																																	<div class="col-sm-4" id="lampQtyError">
																																		<input type="text"
																																			class="form-control hasDatepicker"
																																			id="lampQty" name="lampQty"
																																			placeholder="Lamp.."
																																			autocomplete="off"
																																			onkeypress="return isNumberKey(event,this.id)">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="dateSubmittedlb"
																																		class="col-md-2 control-label">Date
																																		Submitted</label>
																																	<div class="col-md-4"
																																		id="dateSubmittedError">
																																		<input type="text"
																																			class="form-control"
																																			id="dateSubmitted"
																																			name="dateSubmitted"
																																			placeholder="Date Submitted.."
																																			onchange="javascript:trackingForm1DateValidation(this.value);">
																																	</div>
																																	<label for="dateApprovedlb"
																																		class="col-md-2 control-label">Date
																																		Approved</label>
																																	<div class="col-sm-4"
																																		id="dateApprovedError">
																																		<input type="text"
																																			class="form-control hasDatepicker"
																																			id="dateApproved" name="dateApproved"
																																			placeholder="Date Approved.."
																																			onchange="javascript:trackingForm1DateValidation(this.value);"
																																			onchange="trackingForm1DateValidation()"
																																			autocomplete="off">
																																	</div>
																																</div>
																																<div class="form-actions">
																																	<div class="col-md-offset-4 col-md-9">
																																		<button class="btn btn-info ladda-button"
																																			type="button"
																																			id="submitButtonTrackingNew"
																																			data-style="expand-right" data-size="xl"
																																			onclick="submitController('SAVE-EDIT','trackingForm',this);">
																																			<i
																																				class="fa fa-thumbs-o-up bigger-110"></i>
																																			Save
																																		</button>

																																		&nbsp; &nbsp; &nbsp;
																																		<button class="btn btn-warning"
																																			type="reset"
																																			onclick="resetFormTracking();">
																																			<i class="fa fa-undo bigger-110"></i>
																																			Reset
																																		</button>
																																	</div>
																																</div>
																															</div>
																														</div>

																													</div>
																												</div>
																											</div>
																										</div>
																										<!-- End col md12 -->
																										<!-- /span -->
																									</div>
																								</div>

																								<div class="step-pane" id="step2">

																									<div class="row">
																										<div class="col-md-12">
																											<div class="tabbable">
																												<div class="">
																													<div id="issuesDiv"
																														class="tab-pane in active">
																														<div class="row">
																															<div
																																class="form-horizontal well col-md-10 col-md-offset-1">
																																<div class="form-group">
																																	<label for="dateOnsitelb"
																																		class="col-md-2 control-label">Date
																																		Needed Onsite:</label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateNeededOnsite"
																																			name="dateNeededOnsite"
																																			placeholder="Date  Needed Onsite..">
																																	</div>
																																	<label for="dateReleasedToVendorlb"
																																		class="col-md-2 control-label">Date
																																		Released To Vendor:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateReleaseVendor"
																																			class="form-control"
																																			name="dateReleaseVendor"
																																			placeholder="Date Released To Vendor..">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="dateEstimatedRecievedlb"
																																		class="col-md-2 control-label">Date
																																		Estimated Received: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateEstimatedReceived"
																																			name="dateEstimatedReceived"
																																			placeholder="Date Estimated Received..">
																																	</div>
																																	<label for="dateEstimatedDeliverylb"
																																		class="col-md-2 control-label">Date
																																		Estimated Delivery:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateEstimatedDelivery"
																																			class="form-control"
																																			name="dateEstimatedDelivery"
																																			placeholder="Date Estimated Delivery..">
																																	</div>
																																</div>
																																<div class="form-actions">
																																	<div class="col-md-offset-4 col-md-9">
																																		<button class="btn btn-info ladda-button"
																																		data-style="expand-right" data-size="xl"
																																			type="button"
																																			id="submitButtonTrackingEstimate"
																																			onclick="submitController('SAVE-EDIT','trackingForm',this);">
																																			<i
																																				class="fa fa-thumbs-o-up bigger-110"></i>
																																			Save
																																		</button>

																																		&nbsp; &nbsp; &nbsp;
																																		<button class="btn btn-warning"
																																			type="reset"
																																			onclick="resetFormTracking();">
																																			<i class="fa fa-undo bigger-110"></i>
																																			Reset
																																		</button>
																																	</div>
																																</div>
																															</div>
																														</div>

																													</div>
																												</div>
																											</div>
																										</div>
																										<!-- End col md12 -->
																										<!-- /span -->
																									</div>
																								</div>

																								<div class="step-pane" id="step3">
																									<div class="center">
																										<h3 class="blue lighter"></h3>
																									</div>
																									<div class="row">
																										<div class="col-md-12">
																											<div class="tabbable">
																												<div class="">
																													<div id="issuesDiv"
																														class="tab-pane in active">
																														<div class="row">
																															<div
																																class="form-horizontal well col-md-10 col-md-offset-1">

																																<div class="form-group">
																																	<label for="dateActualRecievedlb"
																																		class="col-md-2 control-label">Date
																																		Actual Received: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateActualReceived"
																																			name="dateActualReceived"
																																			placeholder="Date Actual Received..">
																																	</div>
																																	<label for="dateActualDeliverylb"
																																		class="col-md-2 control-label">Date
																																		Actual Delivery:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateActualDelivery"
																																			class="form-control"
																																			name="dateActualDelivery"
																																			placeholder="Date Actual Delivery..">
																																	</div>
																																</div>
																																<hr>
																																<div class="form-group">
																																	<label for="fixtureRecievedGoodlb"
																																		class="col-md-2 control-label">Fixture
																																		Recv. Good: </label>
																																	<div class="col-md-4"
																																		id="fixtureGoodError">
																																		<input type="text"
																																			class="form-control" id="fixtureGood"
																																			name="fixtureGood"
																																			placeholder="Fixture Received Good.."
																																			onkeypress="return isNumberKey(event,this.id),fixtureEmpty()"
																																			onchange="checkFixGoodVal('fixtureGood');">
																																	</div>
																																	<div
																																		style="position: absolute; left: 53%; top: 36%; bottom: 10%; height: 30%; border-left: 1px solid #E6E6E6"></div>
																																	<label for="lampRecievedGoodlb"
																																		class="col-md-2 control-label">Lamp
																																		Recv. Good: </label>
																																	<div class="col-md-4"
																																		id="lampGoodError">
																																		<input type="text"
																																			class="form-control" id="lampGood"
																																			name="lampGood"
																																			placeholder="Lamp Received Good.."
																																			onkeypress="return isNumberKey(event,this.id),LampEmpty()"
																																			onchange="checkFixGoodVal('lampGood');">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="badlb"
																																		class="col-md-2 control-label">Bad:</label>
																																	<div class="col-sm-4"
																																		id="badFixQtyError">
																																		<input type="text" id="badFixtureQty"
																																			class="form-control"
																																			name="badFixtureQty"
																																			placeholder="Bad.."
																																			onkeypress="return isNumberKey(event,this.id),fixtureEmpty()"
																																			onchange="checkFixBadVal('badFixtureQty'),checkFixGoodVal('badFixtureQty');"
																																			onblur="checkFixBadVal('badFixtureQty')">
																																		<a data-toggle="modal"
																																			href="#badFormModalFixture"
																																			class="glyphicon glyphicon-folder-open"
																																			style="position: absolute; top: 10px; left: 82.4%"></a>
																																	</div>
																																	<label for="badlb"
																																		class="col-md-2 control-label">Bad:</label>
																																	<div class="col-sm-4"
																																		id="badLampQtyError">
																																		<input type="text" id="badLampQty"
																																			class="form-control"
																																			name="badLampQty" placeholder="Bad.."
																																			onkeypress="return isNumberKey(event,this.id),LampEmpty()"
																																			onchange="checkFixBadVal('badLampQty'),checkFixGoodVal('badLampQty');">
																																		<a data-toggle="modal"
																																			href="#badFormModalLamp"
																																			class="glyphicon glyphicon-folder-open"
																																			style="position: absolute; top: 10px; left: 82.4%"></a>
																																	</div>
																																</div>
																																<div class="form-actions">
																																	<div class="col-md-offset-4 col-md-9">
																																		<button class="btn btn-info ladda-button"
																																		data-style="expand-right" data-size="xl"
																																			type="button"
																																			id="submitButtonTrackingDelivered"
																																			onclick="submitController('SAVE-EDIT','trackingForm',this);">
																																			<i
																																				class="fa fa-thumbs-o-up bigger-110"></i>
																																			Save
																																		</button>

																																		&nbsp; &nbsp; &nbsp;
																																		<button class="btn btn-warning"
																																			type="reset"
																																			onclick="resetFormTracking();">
																																			<i class="fa fa-undo bigger-110"></i>
																																			Reset
																																		</button>
																																	</div>
																																</div>
																															</div>
																														</div>
																													</div>
																												</div>
																											</div>
																										</div>
																										<!-- End col md12 -->
																										<!-- /span -->
																									</div>
																								</div>
																								<div class="step-pane" id="step4">
																									<div class="center">
																										<h3 class="green"></h3>
																									</div>
																									<div class="row">
																										<div class="col-md-12">
																											<div class="tabbable">
																												<div class="">
																													<div id="issuesDiv"
																														class="tab-pane in active">
																														<div class="row">
																															<div
																																class="form-horizontal well col-md-10 col-md-offset-1">

																																<div class="form-group">
																																	<label for="fixturelb"
																																		class="col-md-2 control-label">Fixture
																																	</label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="fixtureSummary"
																																			placeholder="Fixture.."
																																			readonly="readonly">
																																	</div>
																																	<label for="lamplb"
																																		class="col-md-2 control-label">Lamp
																																	</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			class="form-control hasDatepicker"
																																			id="lampSummary" placeholder="Lamp.."
																																			readonly="readonly"
																																			autocomplete="off">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="dateSubmittedlb"
																																		class="col-md-2 control-label">Date
																																		Submitted</label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateSubmittedSummary"
																																			placeholder="Date Submitted.."
																																			readonly="readonly">
																																	</div>
																																	<label for="dateApprovedlb"
																																		class="col-md-2 control-label">Date
																																		Approved</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			class="form-control hasDatepicker"
																																			id="dateApprovedSummary"
																																			placeholder="Date Approved.."
																																			readonly="readonly"
																																			autocomplete="off">
																																	</div>
																																</div>
																																<hr>
																																<div class="form-group">
																																	<label for="dateOnsitelb"
																																		class="col-md-2 control-label">Date
																																		Needed Onsite:</label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateOnsiteSummary"
																																			placeholder="Date  Needed Onsite.."
																																			readonly="readonly">
																																	</div>
																																	<label for="dateReleasedToVendorlb"
																																		class="col-md-2 control-label">Date
																																		Released To Vendor:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateReleasedToVendorSummary"
																																			class="form-control"
																																			placeholder="Date Released To Vendor.."
																																			readonly="readonly">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="dateEstimatedRecievedlb"
																																		class="col-md-2 control-label">Date
																																		Estimated Received: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateEstimatedRecievedSummary"
																																			placeholder="Date Estimated Received.."
																																			readonly="readonly">
																																	</div>
																																	<label for="dateEstimatedDeliverylb"
																																		class="col-md-2 control-label">Date
																																		Estimated Delivery:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateEstimatedDeliverySummary"
																																			class="form-control"
																																			placeholder="Date Estimated Delivery.."
																																			readonly="readonly">
																																	</div>
																																</div>
																																<hr>
																																<div class="form-group">
																																	<label for="dateActualRecievedlb"
																																		class="col-md-2 control-label">Date
																																		Actual Received: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="dateActualRecievedSummary"
																																			placeholder="Date Actual Received.."
																																			readonly="readonly">
																																	</div>
																																	<label for="dateActualDeliverylb"
																																		class="col-md-2 control-label">Date
																																		Actual Delivery:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="dateActualDeliverySummary"
																																			class="form-control"
																																			placeholder="Date Actual Delivery.."
																																			readonly="readonly">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="fixtureRecievedGoodlb"
																																		class="col-md-2 control-label">Fixture
																																		Recv. Good: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="fixtureRecievedGoodSummary"
																																			placeholder="Fixture Received Good.."
																																			readonly="readonly">
																																	</div>
																																	<div
																																		style="position: absolute; left: 53%; top: 72%; bottom: 10%; height: 20%; border-left: 1px solid #E6E6E6"></div>
																																	<label for="lampRecievedGoodlb"
																																		class="col-md-2 control-label">Lamp
																																		Recv. Good: </label>
																																	<div class="col-md-4">
																																		<input type="text"
																																			class="form-control"
																																			id="lampRecievedGoodSummary"
																																			placeholder="Lamp Received Good.."
																																			readonly="readonly">
																																	</div>
																																</div>
																																<div class="form-group">
																																	<label for="badlb"
																																		class="col-md-2 control-label">Bad
																																		Fixture:</label>
																																	<div class="col-sm-4">
																																		<input type="text"
																																			id="badFixtureSummary"
																																			class="form-control"
																																			placeholder="Bad Fixture.."
																																			readonly="readonly"> <a
																																			data-toggle="modal"
																																			href="#badFormModalFixture" 
																																			class="glyphicon glyphicon-folder-open"
																																			style="position: absolute; top: 10px; left: 82.4%"></a>

																																	</div>
																																	<label for="badlb"
																																		class="col-md-2 control-label">Bad
																																		Lamp:</label>
																																	<div class="col-sm-4">
																																		<input type="text" id="badLampSummary"
																																			class="form-control"
																																			placeholder="Bad Lamp.."
																																			readonly="readonly"> <a
																																			data-toggle="modal"
																																			href="#badFormModalLamp"
																																			class="glyphicon glyphicon-folder-open"
																																			style="position: absolute; top: 10px; left: 82.4%"></a>
																																	</div>
																																</div>
																															</div>
																														</div>

																													</div>
																												</div>
																											</div>
																										</div>
																										<!-- End col md12 -->
																										<!-- /span -->
																									</div>
																								</div>
																							</div>
																							<hr>
																							<div class="row-fluid wizard-actions">
																								<button class="btn btn-prev" disabled="disabled"
																									onclick="myFunctionn()" type="button">
																									<i class="fa fa-arrow-left"></i> Prev
																								</button>

																								<button class="btn btn-success btn-next"
																									onclick="myFunction(this)" type="button" id="finishButton"
																									data-last="Finish ">
																									Next <i class="fa fa-arrow-right icon-on-right"></i>
																								</button>
																							</div>
																						</div>
																						<!-- /widget-main -->
																					</div>
																					<!-- /widget-body -->

																					<!-- Modal start for Fixture Recived  Bad -->
																					<div class="modal fade" id="badFormModalFixture"
																						tabindex="-1" role="dialog"
																						aria-labelledby="myModalLabel" aria-hidden="true">
																						<div class="modal-dialog" style="width: 1000px">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" align="center">Bad
																										Fixture</h4>
																								</div>
																								<div class="modal-body" style="width: 1000px">
																									<div class="row">
																										<div id="badFixture"
																											class="form-horizontal well col-md-10 col-md-offset-1">
																											<div class="form-group">
																												<label for="vendorlb"
																													class="col-md-2 control-label">Vendor
																												</label>
																												<div class="col-md-4">
																													<input type="text" class="form-control"
																														id="fixVendor" name="fixVendor"
																														placeholder="Vendor...">
																												</div>
																												<label for="pictureTakenlb"
																													class="col-md-2 control-label">Picture
																													Taken </label>
																												<div class="col-md-4">
																													<input type="text"
																														class="form-control hasDatePicker"
																														id="fixPictureTaken"
																														name="fixPictureTaken"
																														placeholder="Picture Taken...">
																												</div>
																											</div>
																											<div class="form-group">
																												<label for="issueProblemlb"
																													class="col-md-2 control-label">
																													Issue / Problem </label>
																												<div class="col-sm-4">
																													<input type="text" id="fixIssue"
																														class="form-control" name="fixIssue"
																														placeholder="Issue / Problem...">
																												</div>
																												<label for="fixtureRecorderDatelb"
																													class="col-md-2 control-label">
																													Fixture Recorder Date </label>
																												<div class="col-md-4 ">
																													<input type="text" class="form-control"
																														id="fixRecorderDate"
																														name="fixRecorderDate"
																														placeholder="Fixture Recorder Date...">
																												</div>
																											</div>
																											<div class="form-group">
																												<label for="datePmTeamInformedlb"
																													class="col-md-2 control-label">Date
																													PM Team Informed </label>
																												<div class="col-md-4">
																													<input type="text" class="form-control"
																														id="fixPmInformedDate"
																														name="fixPmInformedDate"
																														placeholder="Date PM Team Informed...">
																												</div>
																												<label for="dateVendorInformed_1lb"
																													class="col-md-2 control-label">Date
																													Vendor Informed </label>
																												<div class="col-md-4">
																													<input type="text"
																														class="form-control hasDatePicker"
																														id="fixVendorInformedDate"
																														name="fixVendorInformedDate"
																														placeholder="Date Vendor Informed...">
																												</div>
																											</div>
																											<div class="form-actions">
																												<div class="col-md-offset-4 col-md-9">
																													<button class="btn btn-info" type="button"
																														data-dismiss="modal">
																														<i class="fa fa-thumbs-o-up bigger-110"></i>
																														OK
																													</button>
																													&nbsp; &nbsp; &nbsp;
																													<button class="btn btn-warning"
																														type="reset">
																														<i class="fa fa-undo bigger-110"></i>
																														Reset
																													</button>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div>
																								<!-- /.modal-content -->
																							</div>
																							<!-- /.modal-dialog -->
																						</div>
																						<!-- End Modal For Material Budget Form -->
																						<!-- Tracking Received END by Ashraf-->
																					</div>
																					<!-- Modal End for Fixture Recived  Bad -->

																					<!-- Modal start for Lamp Recived  Bad -->
																					<div class="modal fade" id="badFormModalLamp"
																						tabindex="-1" role="dialog"
																						aria-labelledby="myModalLabel" aria-hidden="true">
																						<div class="modal-dialog" style="width: 1000px">
																							<div class="modal-content">
																								<div class="modal-header">
																									<button type="button" class="close"
																										data-dismiss="modal" aria-hidden="true">&times;</button>
																									<h4 class="modal-title" align="center">Bad
																										Lamp</h4>
																								</div>
																								<div class="modal-body" style="width: 1000px">
																									<div class="row">
																										<div id="lamp"
																											class="form-horizontal well col-md-10 col-md-offset-1">
																											<div class="form-group">
																												<label for="vendorlb"
																													class="col-md-2 control-label">Vendor
																												</label>
																												<div class="col-md-4">
																													<input type="text" class="form-control"
																														id="lampVendor" name="lampVendor"
																														placeholder="Vendor...">
																												</div>
																												<label for="pictureTakenlb"
																													class="col-md-2 control-label">Picture
																													Taken </label>
																												<div class="col-md-4">
																													<input type="text"
																														class="form-control hasDatePicker"
																														id="lampPictureTaken"
																														name="lampPictureTaken"
																														placeholder="Picture Taken...">
																												</div>
																											</div>
																											<div class="form-group">
																												<label for="issueProblemlb"
																													class="col-md-2 control-label">
																													Issue / Problem </label>
																												<div class="col-sm-4">
																													<input type="text" id="lampIssue"
																														class="form-control" name="lampIssue"
																														placeholder="Issue / Problem...">
																												</div>
																												<label for="fixtureRecorderDatelb"
																													class="col-md-2 control-label">
																													Lamp Recorder Date </label>
																												<div class="col-md-4 ">
																													<input type="text" class="form-control"
																														id="lampRecorderDate"
																														name="lampRecorderDate"
																														placeholder="Lamp Recorder Date...">
																												</div>
																											</div>
																											<div class="form-group">
																												<label for="datePmTeamInformedlb"
																													class="col-md-2 control-label">Date
																													PM Team Informed </label>
																												<div class="col-md-4">
																													<input type="text" class="form-control"
																														id="lampPmInformedDate"
																														name="lampPmInformedDate"
																														placeholder="Date PM Team Informed...">
																												</div>
																												<label for="dateVendorInformed_2lb"
																													class="col-md-2 control-label">Date
																													Vendor Informed </label>
																												<div class="col-md-4">
																													<input type="text"
																														class="form-control hasDatePicker"
																														id="lampVendorInformedDate"
																														name="lampVendorInformedDate"
																														autocomplete="off"
																														placeholder="Date Vendor Informed...">
																												</div>
																											</div>
																											<div class="form-actions">
																												<div class="col-md-offset-4 col-md-9">
																													<button class="btn btn-info" type="button"
																														data-dismiss="modal">
																														<i class="fa fa-thumbs-o-up bigger-110"></i>
																														Ok
																													</button>
																													&nbsp; &nbsp; &nbsp;
																													<button class="btn btn-warning"
																														type="reset">
																														<i class="fa fa-undo bigger-110"></i>
																														Reset
																													</button>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div>
																								<!-- /.modal-content -->
																							</div>
																							<!-- /.modal-dialog -->
																						</div>
																						<!-- End Modal For Material Budget Form -->
																						<!-- Tracking Received END by Ashraf-->
																					</div>
																					<!-- Modal End for Lamp Recived  Bad -->

																				</form>
																			</div>
																		</div>
																	</div>
																</div>
															</div>

															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse" data-parent="#accordio"
																			href="#trackingTableDetailPanel"> Tracking List :
																		</a>
																	</h4>
																</div>
																<div id="trackingTableDetailPanel"
																	class="panel-collapse 	">
																	<div class="panel-body">
																		<table cellpadding="0" cellspacing="0" border="0"
																			class="table table-striped table-bordered"
																			id="trackingTable">
																			<thead>
																				<tr>
																					<th>Trac. Id</th>
																					<th>Fixture</th>
																					<th>Lamp</th>
																					<th>Approval Date</th>
																					<th>Estimate Received Date</th>
																					<th>Actual Received Date</th>
																					<th>Fixture Good</th>
																					<th>Lamp Good</th>
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
												</div> <!-- /.col --> <!-- /.Sheet Details -->
											</li>
										</ol>
									</li>
								</ol>
							</div>
						</div>

						<!--  TRACKING SHEET END HERE  by Ashraf    -->

						<!--  ISSUE SHEET STARTS HERE BY ABHISHEK   -->

						<div class="col-xs-12">
							<div class="col-xs-12 dd" id="issueTableDiv">
								<ol class="dd-list">
									<li class="dd-item" data-id="1" id="issueIdForPanel">
										<div class="dd-handle">Fixture Issues</div>
										<ol class="dd-list">
											<li class="dd-item" data-id="2">
												<!-- Issue Details -->
												<div class="row">
													<div class="col-xs-12">
														<div class="panel-group" id="issueCollapse">
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse" data-parent="#issueCollapse"
																			href="#issueDetailsPanel"> Add Issue Details : </a>
																	</h4>
																</div>
																<div id="issueDetailsPanel"
																	class="panel-collapse collapse">
																	<div class="panel-body">
																		<form action="issueAction" method="post"
																			commandName="issueForm" id="issueFormId"
																			class="form-horizontal well col-md-10 col-md-offset-1"
																			role="form">
																			<input type="hidden" id="actionForIssue"
																				name="actionForIssue"> <input type="hidden"
																				id="issueId" name="issueId">

																			<div class="form-group">
																				<label for="assignedToLb"
																					class="col-md-2 control-label">Issue /
																					Problem</label>
																				<div class="col-md-10" id="issueProbError">
																					<textarea style="resize: none" class="form-control"	id="issueProb" name="issueProb"	onkeydown="checkErrorClass('issueProbError',this.id)" placeholder="Issue / Problem........."></textarea>
																				</div>
																			</div>
																			<div class="form-group">
																				<label for="assignedToLb"
																					class="col-md-2 control-label">Assigned To</label>
																				<div class="col-md-4">
																					<input type="text" class="form-control"
																						id="assignedTo" name="assignedTo"
																						placeholder="Assigned To..">
																				</div>
																				<label for="issueDateLb"
																					class="col-md-2 control-label">Issue Status</label>
																				<div class="col-sm-4">
																					<select class="form-control selectpicker"
																						id="issueStatus" name="issueStatus">
																						<option value="New">New</option>
																						<option value="Pending">Pending</option>
																						<option value="Resolved">Resolved</option>
																					</select><br />
																				</div>
																			</div>
																			<div class="form-group">
																				<label for="assignedToLb"
																					class="col-md-2 control-label">Issue Date</label>
																				<div class="col-md-4">
																					<input type="text" class="form-control"
																						id="issueDate" name="issueDate"
																						placeholder="Issue Date..">
																				</div>
																				<label for="issueDateLb"
																					class="col-md-2 control-label">Resolved
																					Date </label>
																				<div class="col-sm-4">
																					<input type="text"
																						class="form-control hasDatepicker"
																						id="resolvedDate" name="resolvedDate"
																						placeholder="Resolved Date.." autocomplete="off">
																				</div>
																			</div>
																			<div class="form-actions">
																				<div class="col-md-offset-4 col-md-9">
																					<button class="btn btn-info ladda-button" type="button"
																					     data-style="expand-right" data-size="xl"
																						id="submitButtonIssue" name="submitButtonIssue"
																						onclick="submitController('SAVE-EDIT','issueFormId',this)">
																						<i class="fa fa-thumbs-o-up bigger-110"></i>
																						Submit
																					</button>

																					&nbsp; &nbsp; &nbsp;
																					<button class="btn btn-warning" type="reset"
																						onclick="resetFormIssue()">
																						<i class="fa fa-undo bigger-110"></i> Reset
																					</button>
																				</div>
																			</div>
																		</form>
																		<!--End row div  -->
																	</div>
																</div>
															</div>
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse" data-parent="#issueCollapse"
																			href="#issueTablePanel"> Issue List : </a>
																	</h4>
																</div>
																<div id="issueTablePanel"
																	class="panel-collapse">
																	<div class="panel-body">
																		<table cellpadding="0" cellspacing="0" border="0"
																			class="table table-striped table-bordered"
																			id="issueTable">
																			<thead>
																				<tr>
																					<th>Fixture Issue</th>
																					<th>Assigned To</th>
																					<th>Issue Status</th>
																					<th>Issue Date</th>
																					<th>Resolved Date</th>
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
														<!-- /.col -->
													</div>
												</div> <!-- /.Sheet Details -->
											</li>
										</ol>
									</li>
								</ol>
							</div>
						</div>
						<!--  Issue sheet ends here  by Abhishek    -->


						<!--Fixture Changes By Abhishek starts from here  -->

						<div class="col-xs-12">
							<div class="col-xs-12 dd" id="fixtureChangeTable">
								<ol class="dd-list">
									<li class="dd-item" data-id="1" id="changeOrderAjaxCall">
										<div class="dd-handle">Change Request / Change Order</div>
										<ol class="dd-list">
											<li class="dd-item" data-id="2">
												<div class="row">
													<div class="col-xs-12">
														<div class="panel-group" id="changeOrderCollapse">
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse"
																			data-parent="#changeOrderCollapse"
																			href="#changeOrderDetailsPanel"> Add Fixture
																			changes : </a>
																	</h4>
																</div>
																<div id="changeOrderDetailsPanel"
																	class="panel-collapse collapse">
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-12">
																				<div class="tabbable">
																					<div class="tab-content">
																						<div class="tab-pane in active">
																							<div class="row">
																								<form action="changeOrderAction" method="post"
																									id="chngOdrFormId" name="chngOdrFormId"
																									commandName="changeOrderForm"
																									class="form-horizontal well col-md-10 col-md-offset-1"
																									role="form">
																									<input type="hidden" id="actionForChngOrdr"
																										name="actionForChngOrdr"> <input
																										type="hidden" id="changeOrderId"
																										name="changeOrderId">
																									<div class="form-group">
																										<label for="MMCPCO#"
																											class="col-md-2 control-label">
																											PCO#</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="mmcPco" name="mmcPco"
																												placeholder=" PCO #..">
																										</div>
																										<label for="GCRFI#"
																											class="col-md-2 control-label">GCRFI#</label>
																										<div class="col-md-4">
																											<input type="text" class="form-control"
																												id="gcrfi" name="gcrfi"
																												placeholder=" GCRFI #.."><br />
																										</div>
																										<label for="fixChngQtyLb"
																											class="col-md-2 control-label">Quantity</label>
																										<div class="col-sm-4"
																											id="quantityErrorChngOrdr">
																											<input type="text" id="quantity"
																												class="form-control" name="quantity"
																												placeholder="Quantity.."
																												onkeydown="checkErrorClass('quantityError',this.id)"
																												onkeypress="return isNumberKey(event,this.id);"
																												onkeyup="newQuantityValue(this.value);"><br />
																										</div>
																										<label for="fixChngQtyNewLb"
																											class="col-md-2 control-label">New
																											Quantity</label>
																										<div class="col-sm-4">
																											<input type="text" id="newQuantity"
																												class="form-control" name="newQuantity"
																												placeholder="Auto Populated.."
																												readonly="readonly"><br />
																										</div>
																										<label for="fixChngdatelb"
																											class="col-md-2 control-label">Date</label>
																										<div class="col-sm-4">
																											<input type="text"
																												class="form-control hasDatepicker"
																												id="changeOrderDate" name="changeOrderDate"
																												placeholder="Date.." autocomplete="off"><br />
																										</div>
																										<label for="fixChngCommentLb"
																											class="col-md-2 control-label">Comment</label>
																										<div class="col-sm-4">
																											<input type="text" id="changeOrderComments"
																												class="form-control"
																												name="changeOrderComments"
																												placeholder="Comment.."><br />
																										</div>
																									</div>
																									<div class="form-actions">
																										<div class="col-md-offset-4 col-md-9">
																											<button class="btn btn-info ladda-button" type="button"
																												id="submitBtnChngOrder"
																												name="submitBtnChngOrder"
																												data-style="expand-right" data-size="xl"
																												onclick="submitController('SAVE-EDIT','chngOdrFormId',this)">
																												<i class="fa fa-thumbs-o-up bigger-110"></i>
																												Submit
																											</button>

																											&nbsp; &nbsp; &nbsp;
																											<button class="btn btn-warning" type="reset"
																												onclick="resetFormChangeOrder()">
																												<i class="fa fa-undo bigger-110"></i> Reset
																											</button>
																										</div>
																									</div>
																								</form>
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<!-- End col md12 -->
																		<!-- /span -->
																	</div>
																	<!--End row div  -->
																</div>
															</div>
															<div class="panel panel-default">
																<div class="panel-heading">
																	<h4 class="panel-title">
																		<a data-toggle="collapse"
																			data-parent="#changeOrderCollapse"
																			href="#changeOrderTablePanel"> Change Order List
																			: </a>
																	</h4>
																</div>
																<div id="changeOrderTablePanel"
																	class="panel-collapse ">
																	<div class="panel-body">
																		<table cellpadding="0" cellspacing="0" border="0"
																			class="table table-striped table-bordered"
																			id="changeOrderTable">
																			<thead>
																				<tr>
																					<th>PCO #</th>
																					<th>GCRFI #</th>
																					<th>Quantity</th>
																					<th>New Quantity</th>
																					<th>Change Order Date</th>
																					<th>Comments</th>
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
											</li>
										</ol>
									</li>
								</ol>
							</div>
						</div>
						<!--  fixture changes ends here  HERE  by Abhishek    -->
					</div>

					<!-- PAGE CONTENT ENDS -->

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
	<script src="assets/js/fuelux.wizard.min.js"></script>

	<!-- ace scripts -->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script src="assets/js/fixtureInDetail.js"></script>
	<!-- inline scripts related to this page -->

	<script type="text/javascript">
		jQuery(function($) {
			$(".selectpicker").selectpicker();
			$('#projectSelectShortCut').tooltip();
			$('#projectSelectShort').tooltip();
			$('#fixtureSelectShortCut').tooltip();
			$('#fixtureInDetailShortCut').tooltip();
			$('#dashboardShortcut').tooltip();
			$('.dd').nestable();
			$('#nestable').nestable('collapseAll');
			$('#tractable').nestable('collapseAll');
			$('#issueTableDiv').nestable('collapseAll');
			$('#fixtureChangeTable').nestable('collapseAll');
			var $validation = false;
			$('#fuelux-wizard')
					.ace_wizard()
					.on('change', function(e, info) {
						if (info.step == 1 && $validation) {
							if (!$('#validation-form').valid())
								return false;
						}
					})
					.on(
							'finished',
							function(e) {
								bootbox
										.dialog({
											message : "Thank you! Your information was successfully saved!",
											buttons : {
												"success" : {
													"label" : "OK",
													"className" : "btn-sm btn-primary"
												}
											}
										});
							}).on('stepclick', function(e) {
						//return false;//prevent clicking on steps
					});

			$('.dd-handle a').on('mousedown', function(e) {
				e.stopPropagation();
			});

			$('#recent-box [data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('.tab-content')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}

			$('.dialogs,.comments').slimScroll({
				height : '300px'
			});

			//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
			//so disable dragging when clicking on label
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
				stop : function(event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
					$(ui.item).css('z-index', 'auto');
				}
			});
			$('#tasks').disableSelection();
			$('#tasks input:checkbox').removeAttr('checked').on('click',
					function() {
						if (this.checked)
							$(this).closest('li').addClass('selected');
						else
							$(this).closest('li').removeClass('selected');
					});

		})
	</script>

	<div class="tooltip top in" style="display: none;">
		<div class="tooltip-inner"></div>
	</div>

	<script>
		jQuery(function($) {
			$(document)
					.ready(
							function() {
								$('div.widget-body')
										.on(
												'shown.bs.collapse',
												function() {
													$(this)
															.parent("div")
															.find(
																	".glyphicon-chevron-down")
															.removeClass(
																	"glyphicon-chevron-down")
															.addClass(
																	"glyphicon-chevron-up");

												});

								$('div.widget-body')
										.on(
												'hidden.bs.collapse',
												function() {
													$(this)
															.parent("div")
															.find(
																	".glyphicon-chevron-up")
															.removeClass(
																	"glyphicon-chevron-up")
															.addClass(
																	"glyphicon-chevron-down");
												});
							});
		});

		function myFunction(laddaButtonId) {
			document.getElementById("change").innerHTML = "Approved";
			fillTrackSummaryDetails(laddaButtonId);
			
		}

		function myFunctionn() {
			document.getElementById("change").innerHTML = "New Request";
			
		}
	</script>



</body>
</html>