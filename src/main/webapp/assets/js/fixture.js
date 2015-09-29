var fixtureType = null;
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
function validateForm() {
	// Validation for text_field
	if ($('#fixtureType').val() == '') {
		$('#fixtureType').attr("placeholder", "These Field Can't Be Empty");
		$('#fixtureTypeError').addClass("has-error");
		document.addProject.fixtureType.focus();
		return false;
	} else {
		return true;
	}
}

function notifications(action, message) {
	var tMessage = null, cMessage = null, text = "";
	if (action == "ERROR") {
		tMessage = "Elecnor FTS : Error!!";
		text = "Unable to perform the action due to " + message
				+ " If this problem exists, please report it to Dev Team. ";
		cMessage = 'gritter-error';
	} else {
		tMessage = "Elecnor FTS : Success!!";
		text = "<b><font color=red>" + message + "</font></b> has been "
				+ action.toLowerCase() + "d Successfully";
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
function isNumberKey(evt, id) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		$('#' + id).blur();
		$('#lampQtyPerFixtureError').addClass("has-error");
		validateNotifications('</i> Error! </strong>  Only Number Are Allowed.');
		// showAlert('<div class="alert alert-danger"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only Number Are Allowed.
		// <br> </div>');
		return false;
	}
	$('#lampQtyPerFixtureError').removeClass("has-error");
	return true;
}

function checkErrorClass(divId, elementId) {
	if ($('#' + elementId).val() == '') {

		$('#' + elementId).attr("placeholder", "These field can't be empty");

		$('#' + divId).addClass("has-error");
	} else {
		$('#' + divId).removeClass("has-error");
	}
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

function submitController(e, laddaButtonId) {
	if (e == "SAVE-EDIT") {
		if ($("#submitButton").html().indexOf("Submit") != -1) {
			$("#actionFor").val("SAVE");
		} else if ($("#submitButton").html().indexOf("Update") != -1) {
			$("#actionFor").val("UPDATE");
		}
		if (!validateForm())
			return;
	} else {
		$("#actionFor").val(e);
	}
	if (laddaButtonId != undefined) {
		var l = Ladda.create(laddaButtonId);
		l.start();
	}
	// $("#fixtureFormId").submit();
	$.ajax({
		url : "fixtureActionController",
		type : "POST",
		data : $("#fixtureFormId").serialize(),
		success : function(result) {
			oTableFixtureTable.fnClearTable();
			oTableSideFixture.fnClearTable();
			getFixtureDetails();
			l.stop();
			if ($("#actionFor").val() == "DELETE") {
				notifications("DELETE", $("#fixtureType").val());
				resetForm();
				$("#myModal").modal("hide");
			} else if ($("#actionFor").val() == "SAVE"
					|| $("#actionFor").val() == "UPDATE") {
				notifications($("#actionFor").val(), $("#fixtureType").val());
				$("#fixtureFormId")[0].reset();
				resetForm();
				$("#addFixtureFormPanel").collapse("hide");

			}
		},
		error : function(result) {
			notifications("ERROR", result);
		}
	});
}

/* END */

function setFixtureSelected(e) {
	$("#fixtureNumber").val(e);
	submitController("SELECT");
	$("#fixtureFormId").submit();
}
/*
 * function submitController(e) { if (e == "SAVE-EDIT") { if
 * ($("#submitButton").html().indexOf("Submit") != -1) {
 * $("#actionFor").val("SAVE"); } else if
 * ($("#submitButton").html().indexOf("Update") != -1) {
 * $("#actionFor").val("UPDATE"); } } else { $("#actionFor").val(e); }
 * $("#fixtureFormId").submit(); }
 */
function initSelectBox() {
	/* Fixture Variant Init Starts */
	$('#fixtureVariant').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	$('#fixDescription').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	$('#fixManufacturer').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	$('#lampMadeBy').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	$('#lampCatalogNo').find('option').remove().end().append(
			'<option value="">--Select--</option>');
	var selectFixVariant = document.getElementById("fixtureVariant");
	for (var i = 0; i < mode.fixVariantList.length; i++) {
		var option = document.createElement("option");
		option.text = mode.fixVariantList[i].variantType;
		option.value = mode.fixVariantList[i].variantId;
		try {
			selectFixVariant.add(option, select.options[null]);
		} catch (e) {
			selectFixVariant.add(option, null);
		}

	}
	/* Fixture Variant Init Ends */
	/* Fixture Description Init Starts */
	var selectFixDesc = document.getElementById("fixDescription");
	for (var i = 0; i < mode.fixDescList.length; i++) {
		var option = document.createElement("option");
		option.text = mode.fixDescList[i].descType;
		option.value = mode.fixDescList[i].descId;
		try {
			selectFixDesc.add(option, select.options[null]);
		} catch (e) {
			selectFixDesc.add(option, null);
		}

	}
	/* Fixture Description Init Ends */
	/* Fixture Manufacturer Init Starts */
	var selectFixManufac = document.getElementById("fixManufacturer");
	for (var i = 0; i < mode.fixManufacList.length; i++) {
		var option = document.createElement("option");
		option.text = mode.fixManufacList[i].manufacturerType;
		option.value = mode.fixManufacList[i].manufacturerId;
		try {
			selectFixManufac.add(option, select.options[null]);
		} catch (e) {
			selectFixManufac.add(option, null);
		}

	}
	/* Fixture Manufacturer Init Ends */
	/* Lamp Manufacturer Init Starts */
	var selectLampManufac = document.getElementById("lampMadeBy");
	for (var i = 0; i < mode.fixLampManufList.length; i++) {
		var option = document.createElement("option");
		option.text = mode.fixLampManufList[i].manufacturerType;
		option.value = mode.fixLampManufList[i].manufacturerId;
		try {
			selectLampManufac.add(option, select.options[null]);
		} catch (e) {
			selectLampManufac.add(option, null);
		}

	}
	/* Lamp Manufacturer Init Ends */
	/* Lamp Catalog Number Init Starts */
	var selectLampCatalog = document.getElementById("lampCatalogNo");
	for (var i = 0; i < mode.fixLampCatalogList.length; i++) {
		var option = document.createElement("option");
		option.text = mode.fixLampCatalogList[i].catalogType;
		option.value = mode.fixLampCatalogList[i].catalogId;
		try {
			selectLampCatalog.add(option, select.options[null]);
		} catch (e) {
			selectLampCatalog.add(option, null);
		}

	}
	/* Lamp Catalog Number Init Ends */
	$('.selectpicker').selectpicker('refresh');

}
function fnFormatDetails(oTable, nTr) {
	oData = oTable.fnGetData(nTr);
	/*
	 * var billType = ""; if (oData.billType != undefined) { billType =
	 * oData.billType; }
	 */

	sOut = '<div class="tabbable" id="innerDetails"><ul class="nav nav-tabs" id="myTab"><li class="active"><a data-toggle="tab"href="#lampDetails"> <i class="yellow fa fa-lightbulb-o"></i>Lamp Details</a></li><li><a data-toggle="tab" href="#aEDesign"> <i class="green fa fa-pencil-square-o"></i> Design Details</a></li><li><a data-toggle="tab" href="#trackingDetails"> <i class="blue fa fa-location-arrow"></i> Tracking Details</a></li><li><a data-toggle="tab" href="#issueDetails"> <i class="red fa fa-exclamation-triangle"></i> Issue Details</a></li><li><a data-toggle="tab" href="#changeOrder"><i class="blue fa fa-refresh"></i> Change Order Details </a></li></ul><div class="tab-content"><div id="lampDetails" class="tab-pane in active"><div class="infobox-container"><div class="infobox infobox-yellow  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[7]
			+ '</span><div class="infobox-content">Lamp Made By</div></div></div><div class="infobox infobox-yellow  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[8]
			+ '</span><div class="infobox-content">Lamp Catalog Number</div></div></div><div class="infobox infobox-yellow  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[9]
			+ '</span><div class="infobox-content">Quantity / fixture</div></div></div></div></div><div id="aEDesign" class="tab-pane"><div class="infobox-container"><div class="infobox infobox-green  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[10]
			+ '</span><div class="infobox-content">A Sheet Count</div></div></div><div class="infobox infobox-green  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[11]
			+ '</span><div class="infobox-content">E Sheet Count</div></div></div><div class="infobox infobox-green  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[12]
			+ '</span><div class="infobox-content">Attic Count</div></div></div><div class="infobox infobox-green  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[13]
			+ '</span><div class="infobox-content">Spare Count</div></div></div><div class="infobox infobox-green  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[14]
			+ '</span><div class="infobox-content">Qty On Order</div></div></div></div></div><div id="trackingDetails" class="tab-pane"><div class="infobox-container"><div class="infobox infobox-blue  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[15]
			+ '</span><div class="infobox-content">Fixture Requested</div></div></div><div class="infobox infobox-blue  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[16]
			+ '</span><div class="infobox-content">Lamp Requested</div></div></div><div class="infobox infobox-blue  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[17]
			+ '</span><div class="infobox-content">Fixture Received Good</div></div></div><div class="infobox infobox-blue  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[18]
			+ '</span><div class="infobox-content">Lamp Received Good</div></div></div></div></div><div id="issueDetails" class="tab-pane"><div class="infobox infobox-red  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[19]
			+ '</span><div class="infobox-content">Issue Count</div></div></div></div><div id="changeOrder" class="tab-pane"><div class="infobox infobox-blue  "><div class="infobox-icon"><i class="icon-comments"></i></div><div class="infobox-data"><span class="infobox-data-number">'
			+ oData[20]
			+ '</span><div class="infobox-content">Change Order Sum</div></div></div></div></div></div>';
	return sOut;
}
function fnShowHide() {
	/*
	 * Get the DataTables object again - this is not a recreation, just a get of
	 * the object
	 */
	var oTable = $('#fixtureTable').dataTable();
	var bVis = false;
	for (var iCol = 7; iCol < 10; iCol++) {
		bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
		oTable.fnSetColumnVis(iCol, bVis ? false : true);
	}
	if (bVis == false) {
		document.getElementById("addMinus").innerHTML = " <i class='fa fa-minus-square-o bigger-130'></i>";
	} else {
		document.getElementById("addMinus").innerHTML = " <i class='fa fa-plus-square-o bigger-130'></i>";
	}
}
function setFixtureToEdit(e) {
	$("#addFixtureFormPanel").collapse("show");
	for (var t = 0; t < mode.aaData.length; t++) {
		if (e == mode.aaData[t].fixtureId) {
			$("#fixtureType").val(mode.aaData[t].fixtureType);
			try {
				$("#fixtureVariant").selectpicker("val",
						mode.aaData[t].fixtureVariant.variantId);
			} catch (a) {
				$("#fixtureVariant").selectpicker("val", "");
			}
			try {
				$("#fixDescription").selectpicker("val",
						mode.aaData[t].fixtureDescription.descId);
			} catch (a) {
				$("#fixDescription").selectpicker("val", "");
			}
			try {
				$("#fixManufacturer").selectpicker("val",
						mode.aaData[t].fixtureManufacturer.manufacturerId);
			} catch (a) {
				$("#fixManufacturer").selectpicker("val", "");
			}
			$("#fixrureCatalogNum").val(mode.aaData[t].fixrureCatalogNum);
			$("#additionalPart").val(mode.aaData[t].additionalPart);
			try {
				$("#lampMadeBy").selectpicker("val",
						mode.aaData[t].lampManufacturer.manufacturerId);
			} catch (a) {
				$("#lampMadeBy").selectpicker("val", "");
			}
			try {
				$("#lampCatalogNo").selectpicker("val",
						mode.aaData[t].lampCatalogNum.catalogId);
			} catch (a) {
				$("#lampCatalogNo").selectpicker("val", "");
			}
			$("#lampQtyPerFixture").val(mode.aaData[t].lampQtyPerFixture);
			$("#submitButton").html(
					"<i class='fa fa-thumbs-up bigger-110'></i> Update");
			$("#fixtureNumber").val(e);
			fixtureType = $("#fixtureType").val(mode.aaData[t].fixtureType);
			break;
		}
	}
}

function resetForm() {
	$('#fixtureType').attr("placeholder", "Fixture Type..");
	$('#fixrureCatalogNum').attr("placeholder", "Catalog Number..");
	$('#lampQtyPerFixture').attr("placeholder", "Quantity Per Fixture..");
	$('#fixtureTypeError').removeClass("has-error");
	$('#fixrureCatalogNumError').removeClass("has-error");
	$('#lampQtyPerFixtureError').removeClass("has-error");

	$("#submitButton").html(
			"<i class='fa fa-thumbs-o-up bigger-110'></i>Submit");
	$("#fixtureNumber").val(-1);
	$("#actionFor").val("");
	$("#fixtureVariant").selectpicker("val", "");
	$("#fixDescription").selectpicker("val", "");
	$("#fixManufacturer").selectpicker("val", "");
	$("#lampMadeBy").selectpicker("val", "");
	$("#lampCatalogNo").selectpicker("val", "");
	$('.selectpicker').selectpicker('refresh');
}

function getProjectDetailsForFixture() {

	$("#projectDetailInfo").html(
			mode.selectedProject.jobName + " _ "
					+ mode.selectedProject.jobNumber);
	$("#projectNameW").val(mode.selectedProject.jobName);
	$("#projectIdW").val(mode.selectedProject.jobNumber);

	var lastNameMang, lastNameSupr, firstNameManager, startDateTemp, endDateTemp;
	firstNameManager = lastNameMang = lastNameSupr = startDateTemp = endDateTemp = "";
	if (mode.selectedProject.manager != undefined
			&& mode.selectedProject.manager != null) {
		firstNameManager = mode.selectedProject.manager.firstName;
		if (mode.selectedProject.manager.lastName != undefined)
			lastNameMang = mode.selectedProject.manager.lastName;
		else
			lastNameMang = "";
	}
	if (mode.selectedProject.supervisor != undefined && mode.selectedProject.supervisor.lastName != undefined)
		lastNameSupr = mode.selectedProject.supervisor.lastName;
	else
		lastNameSupr = "";

	if (mode.selectedProject.startDate != undefined)
		startDateTemp = moment(new Date(mode.selectedProject.startDate))
				.format("MM-DD-YYYY");
	if (mode.selectedProject.endDate != undefined)
		endDateTemp = moment(new Date(mode.selectedProject.endDate)).format(
				"MM-DD-YYYY");

	$("#startDateW").val(startDateTemp);

	$("#endDateW").val(endDateTemp);

	$("#projManegerW").val(firstNameManager + " " + lastNameMang);
	if(mode.selectedProject.supervisor != undefined && mode.selectedProject.supervisor.firstName != undefined){
		$("#projSupervisorW").val(mode.selectedProject.supervisor.firstName + " " + lastNameSupr);
	}else{
		$("#projSupervisorW").val("" + " " + lastNameSupr);
	}
	
}

function getFixtureDetails() {
	$
			.ajax({
				url : "getFixtureDetails",
				type : "POST",
				contentType : 'text/plain',
				data : '{"mode": "' + mode + '"}',
				success : function(result) {
					if (result == "Failed") {

						bootbox.confirm("Please select the Project!!!!!",
								function(result) {
									window.location.href = "login";
								});
					} else {
						mode = JSON.parse(result);

						getProjectDetailsForFixture();
						initSelectBox();

						for (var t = 0; t < mode.aaData.length; t++) {
							var variantType, descType, manufacturerType, manufacturerTypeL, catalogType, lampQtyPerFixture, additionalPart;
							variantType = descType = manufacturerType = manufacturerTypeL = catalogType = lampQtyPerFixture = additionalPart = "";
							if (mode.aaData[t].status == 'ACTIVE') {
								oTableSideFixture.fnAddData([
										mode.aaData[t].fixtureType,
										mode.aaData[t].fixtureId ], false);

								if (mode.aaData[t].fixtureVariant != undefined)
									variantType = mode.aaData[t].fixtureVariant.variantType;
								if (mode.aaData[t].fixtureDescription != undefined)
									descType = mode.aaData[t].fixtureDescription.descType;
								if (mode.aaData[t].fixtureManufacturer != undefined)
									manufacturerType = mode.aaData[t].fixtureManufacturer.manufacturerType;
								if (mode.aaData[t].lampManufacturer != undefined)
									manufacturerTypeL = mode.aaData[t].lampManufacturer.manufacturerType;
								if (mode.aaData[t].lampCatalogNum != undefined)
									catalogType = mode.aaData[t].lampCatalogNum.catalogType;
								if (mode.aaData[t].lampQtyPerFixture != undefined)
									lampQtyPerFixture = mode.aaData[t].lampQtyPerFixture;
								if (mode.aaData[t].additionalPart == undefined
										|| mode.aaData[t].additionalPart == null)
									additionalPart = "";
								else
									additionalPart = mode.aaData[t].additionalPart;

								oTableFixtureTable.fnAddData([
										mode.aaData[t].fixtureType,
										mode.aaData[t].fixtureId, variantType,
										descType, manufacturerType,
										mode.aaData[t].fixrureCatalogNum,
										additionalPart, manufacturerTypeL,
										catalogType, lampQtyPerFixture,
										mode.aaData[t].aSheetCount,
										mode.aaData[t].eSheetCount,
										mode.aaData[t].attickCount,
										mode.aaData[t].spareCount,
										mode.aaData[t].qtyPerBaseOrder,
										mode.aaData[t].fixtureQuantity,
										mode.aaData[t].lampQuantity,
										mode.aaData[t].fixtureGood,
										mode.aaData[t].lampGood,
										mode.aaData[t].issueCount,
										mode.aaData[t].changeOrder ], false);
							}
						}
						oTableFixtureTable.fnDraw();
						oTableSideFixture.fnDraw();
					}
					$('#loading').modal('hide');
				},
				error : function() {
					$('#loading').modal('hide');
					bootbox
							.alert("Some Problem Occured. Please refresh the page and try again");
				}

			});
}
jQuery(function($) {
	$('#loading').modal('show');
	var anOpen = [];
	$('div.widget-body').on(
			'shown.bs.collapse',
			function() {
				$(this).parent("div").find(".glyphicon-chevron-down")
						.removeClass("glyphicon-chevron-down").addClass(
								"glyphicon-chevron-up");

			});

	$('div.widget-body').on(
			'hidden.bs.collapse',
			function() {
				$(this).parent("div").find(".glyphicon-chevron-up")
						.removeClass("glyphicon-chevron-up").addClass(
								"glyphicon-chevron-down");
			});

	$(".selectpicker").selectpicker();
	if (/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent)) {
		$('.selectpicker').selectpicker('mobile');
	}
	mode = "";
	oTableSideFixture = $("#sideMenuTable").dataTable(
			{
				sDom : "lrtp",
				bSearchable : false,
				"sScrollY" : "450px",
		        "bPaginate" : true,
		        "bScrollCollapse": true,
				
				aoColumns : [ {
					sClass : "center",
					fnRender : function(e) {
						return "<a  href=\"javascript:setFixtureSelected('"
								+ e.aData[1] + "')\">" + e.aData[0] + "</a>";
					}
				} ]
			});
	oTableFixtureTable = $("#fixtureTable")
			.dataTable(
					{
						"aaSorting" : [ [ 1, "asc" ] ],
						bFilter : false,
						bSearchable : false,
						aoColumns : [
								{
									"mData" : null,
									"sClass" : "control center",
									"sDefaultContent" : '<img src="assets/img/details_open.png'
											+ '">',
									"bSortable" : false
								},
								{
									sClass : "center",
									fnRender : function(e) {
										id = e.aData[1];
										return "<a  href=\"javascript:setFixtureSelected('"
												+ id
												+ "')\">"
												+ e.aData[0]
												+ "</a>";
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
									"bVisible" : false,
									fnRender : function(e) {
										return e.aData[7]
									}
								},
								{
									sClass : "center",
									"bVisible" : false,
									fnRender : function(e) {
										return e.aData[8]
									}
								},
								{
									sClass : "center",
									"bVisible" : false,
									fnRender : function(e) {
										return e.aData[9]
									}
								},
								{
									mData : null,
									sClass : "center",
									"bSortable" : false,

									fnRender : function(e) {
										return "<div class='pull-right action-buttons'><a class='blue' href=\"javascript:setFixtureToEdit('"
												+ id
												+ "')\"> <i class='fa fa-pencil bigger-130'></i></a> <a class='deleteConfirmDialog red' href='#' data-id="
												+ id
												+ " data-toggle='modal' data-target='#myModal' > <i class='fa fa-trash-o bigger-130'></i></a></div>"
									}
								} ]
					});
	$(document).on(
			"click",
			"#fixtureTable td.control",
			function() {
				var nTr = this.parentNode;
				var i = $.inArray(nTr, anOpen);

				if (i === -1) {
					$('img', this).attr('src', "assets/img/details_close.png");
					var nDetailsRow = oTableFixtureTable
							.fnOpen(nTr, fnFormatDetails(oTableFixtureTable,
									nTr), 'details');
					$('#innerDetails', nDetailsRow).slideDown();
					anOpen.push(nTr);
				} else {
					$('img', this).attr('src', "assets/img/details_open.png");
					$('#innerDetails', $(nTr).next()[0]).slideUp(function() {
						oTableFixtureTable.fnClose(nTr);
						anOpen.splice(i, 1);
					});
				}
			});
	getFixtureDetails();
	$(document).on("click", ".deleteConfirmDialog", function() {
		$("#fixtureNumber").val($(this).data("id"));
	});

	$("#sideMenuTable tbody tr").hover(function(e) {

		if ($(this).hasClass('row_selected')) {
			$(this).removeClass('row_selected');
		} else {
			oTableSideFixture.$('tr.row_selected').removeClass('row_selected');
			$(this).addClass('row_selected');
		}
	});

	$("thead input").keyup(function() {
		/* Filter on the column (the index) of this element */
		oTableSideFixture.fnFilter(this.value, $("thead input").index(this));
	});

	/*
	 * Support functions to provide a little bit of 'user friendlyness' to the
	 * textboxes in the footer
	 */
	$("thead input").each(function(i) {
		// asInitVals[i] = this.value;
	});

	$("thead input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});
	$("thead input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			// this.value = asInitVals[$("thead input").index(this)];
		}
	});
	$('#startDate').datepicker().on('changeDate', function(ev) {
		$('#startDate').datepicker('hide');
	});
	$('#endDate').datepicker().on('changeDate', function(ev) {
		$('#endDate').datepicker('hide');
	});

	$('#projectSelectShortCut').tooltip();
	$('#fixtureSelectShortCut').tooltip();
	$('#fixtureInDetailShortCut').tooltip();
	$('#dashboardShortcut').tooltip();

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

$(document)
.ready(
		function() {
	$('#sideMenuTable_wrapper > div.dataTables_paginate.paging_bootstrap').css('display','none');
})