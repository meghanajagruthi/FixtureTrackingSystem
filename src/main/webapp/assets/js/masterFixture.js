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
function notifications(action, message) {
	var tMessage = null, cMessage = null, text = "";
	if (action == "ERROR") {
		tMessage = "Elecnor FTS : Error!!";
		text = "Unable to complete the action due to " + message
				+ " If this problem exists, please report it to Dev Team. ";
		;
		cMessage = 'gritter-failure';
	} else {
		tMessage = "Elecnor FTS : Success!!";
		text = "A record of " + action + "has been saved Successfully";
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
function getTableDetailsForFixVar() {
	mode = "variant";
	$.ajax({
		url : "getfixVariantDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {
			modeVar = JSON.parse(result);
			for (var i = 0; i < modeVar.aaData.length; i++) {
				oTableFixtureVariantTable.fnAddData([ i + 1,
						modeVar.aaData[i].variantType ], false);
			}
			oTableFixtureVariantTable.fnDraw();
			$("#fixVarInfo").html(modeVar.aaData.length);
			oTableSideUserTable.fnAddData([ modeVar.aaData.length ]);

		}
	});
}

function getTableDetailsForFixDesc() {
	mode = "desc";
	$.ajax({
		url : "getfixDescriptionDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {
			modeDesc = JSON.parse(result);
			for (var i = 0; i < modeDesc.aaData1.length; i++) {
				oTableFixtureDescriptionTable.fnAddData([ i + 1,
						modeDesc.aaData1[i].descType ], false);
			}
			oTableFixtureDescriptionTable.fnDraw();
			$("#fixDescInfo").html(modeDesc.aaData1.length);
			oTableSideUserTable.fnAddData([ modeDesc.aaData1.length ]);

		}
	});
}

function getTableDetailsForFixManufact() {
	mode = "manufacturer";
	$.ajax({
		url : "getfixManufacturerDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {
			modeFixManf = JSON.parse(result);
			for (var i = 0; i < modeFixManf.aaData.length; i++) {
				oTableFixtureManufacturerTable.fnAddData([ i + 1,
						modeFixManf.aaData[i].manufacturerType ], false);
			}
			oTableFixtureManufacturerTable.fnDraw();
			$("#fixManfInfo").html(modeFixManf.aaData.length);
			oTableSideUserTable.fnAddData([ modeFixManf.aaData.length ]);

		}
	});
}

function getTableDetailsForLampManufact() {
	mode = "lampManufacturer";

	$.ajax({
		url : "getlampManufacturerDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {
			modeLampManf = JSON.parse(result);
			for (var i = 0; i < modeLampManf.aaData.length; i++) {
				oTableLampManufacturerTable.fnAddData([ i + 1,
						modeLampManf.aaData[i].manufacturerType ], false);
			}
			oTableLampManufacturerTable.fnDraw();
			$("#lampManfInfo").html(modeLampManf.aaData.length);
			oTableSideUserTable.fnAddData([ modeLampManf.aaData.length ]);
		}
	});
}

function getTableDetailsForLampCatalogNo() {
	mode = "lampCatalogNo";

	$.ajax({
		url : "getlampCatalogNoDetails",
		type : "POST",
		contentType : 'text/plain',
		data : '{"mode": "' + mode + '"}',
		success : function(result) {
			modeCatalog = JSON.parse(result);

			for (var i = 0; i < modeCatalog.aaData.length; i++) {
				oTableLampCatalogNoTable.fnAddData([ i + 1,
						modeCatalog.aaData[i].catalogType ], false);
			}
			oTableLampCatalogNoTable.fnDraw();
			$("#lampCatInfo").html(modeCatalog.aaData.length);
			oTableSideUserTable.fnAddData([ modeCatalog.aaData.length ]);

			$('#loading').modal('hide');
		}
	});
}

$(document).ready(
		function() {
			$('#loading').modal('show');
			oTableFixtureVariantTable = $('#fixVariantTypeTable').dataTable({
				"bSearchable" : false,
				"bDestroy" : true,
				"bFilter" : true,
				"bInfo" : true,
				"bAutoWidth" : false,
				"aoColumns" : [ {
					"sClass" : "center",
					"fnRender" : function(oObj) {
						return oObj.aData[0];
					}
				}, {
					"sClass" : "center",
					"fnRender" : function(oObj) {
						return oObj.aData[1];
					}
				} ]
			});

			oTableFixtureDescriptionTable = $('#fixDescriptionTable')
					.dataTable({
						"bSearchable" : false,
						"bDestroy" : true,
						"bFilter" : true,
						"bInfo" : true,
						"bAutoWidth" : false,
						"aoColumns" : [ {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[0];
							}
						}, {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[1];
							}
						} ]
					});

			oTableFixtureManufacturerTable = $('#fixManufacturerTable')
					.dataTable({
						"bSearchable" : false,
						"bDestroy" : true,
						"bFilter" : true,
						"bInfo" : true,
						"bAutoWidth" : false,
						"aoColumns" : [ {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[0];
							}
						}, {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[1];
							}
						} ]
					});

			oTableLampManufacturerTable = $('#lampManufacturerTable')
					.dataTable({
						"bSearchable" : false,
						"bDestroy" : true,
						"bFilter" : true,
						"bInfo" : true,
						"bAutoWidth" : false,
						"aoColumns" : [ {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[0];
							}
						}, {
							"sClass" : "center",
							"fnRender" : function(oObj) {
								return oObj.aData[1];
							}
						} ]
					});

			oTableLampCatalogNoTable = $('#lampCatalogTable').dataTable({
				"bSearchable" : false,
				"bDestroy" : true,
				"bFilter" : true,
				"bInfo" : true,
				"bAutoWidth" : false,
				"aoColumns" : [ {
					"sClass" : "center",
					"fnRender" : function(oObj) {
						return oObj.aData[0];
					}
				}, {
					"sClass" : "center",
					"fnRender" : function(oObj) {
						return oObj.aData[1];
					}
				} ]
			});

			oTableSideUserTable = $('#sidePanelManageUserTable').dataTable(
					{
						sDom : "lrtp",
						aoColumns : [ {
							sClass : "center",
							bSort : false,
							fnRender : function(e) {
								if (e.iDataRow == 0) {
									return "Fixture Variant : "
											+ "<span class='badge badge-info'>"
											+ e.aData[0] + "</span>";
								} else if (e.iDataRow == 1) {
									return "Fixture Description : "
											+ "<span class='badge badge-info'>"
											+ e.aData[0] + "</span>";
								} else if (e.iDataRow == 2) {
									return "Fixture Manufacturer : "
											+ "<span class='badge badge-info'>"
											+ e.aData[0] + "</span>";
								} else if (e.iDataRow == 3) {
									return "Lamp Manufacturer : "
											+ "<span class='badge badge-info'>"
											+ e.aData[0] + "</span>";
								} else if (e.iDataRow == 4) {
									return "Lamp Catalog Num : "
											+ "<span class='badge badge-info'>"
											+ e.aData[0] + "</span>";
								}
							}
						} ]
					});
			getTableDetailsForFixVar();
			getTableDetailsForFixDesc();
			getTableDetailsForFixManufact();
			getTableDetailsForLampManufact();
			getTableDetailsForLampCatalogNo();
		});

$(document).on("click", ".deleteConfirmDialog", function() {
	$('#deletionRowId').val($(this).data('id'));
});

jQuery(function($) {
	$('#projectSelectShortCut').tooltip();
	$('#fixtureSelectShortCut').tooltip();
	$('#fixtureInDetailShortCut').tooltip();
	$('#dashboardShortcut').tooltip();
	$('.dd').nestable();
	$('#nestable').nestable({});
	$('#nestable').nestable('collapseAll');
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

function fixVariantTypesubmitController(e) {
	// Validation for text_field

	if ($('#fixVariantType').val() == '') {
		$('#fixVariantType').attr("placeholder", "This field can't be empty");
		$('#fixVariantTypeError').addClass("has-error");
		document.fixVariantForm.fixVariantType.focus();
		return false;
	} else {
		$("#actionFor").val(e);
	}

	$('#loading').modal('show');
	$.ajax({
		type : "POST",
		url : "fixtureVariantAction",
		dataType : "json",
		traditional : true,
		data : $('#fixVariantForm').serialize(),
		success : function(data) {
			oTableFixtureVariantTable.fnClearTable();
			oTableFixtureVariantTable.fnDraw();
			oTableSideUserTable.fnClearTable();
			oTableSideUserTable.fnDraw();
			$('#fixVariantType').val('');
			$('#fixVariantType').attr("placeholder", "Variant...");
			$('#fixVariantTypeError').removeClass("has-error");
			getTableDetailsForFixVar();
			getTableDetailsForLampCatalogNo();
			notifications($("#actionFor").val(), 'FIXTURE VARIANT');
			$("#fixVarInfo").html(modeVar.aaData.length);
		},
		error : function(err) {
			notifications($("#actionFor").val(), err);
		},

		complete : function() {
			$('#loading').modal('hide');
		}
	});
}

function fixDescErrorsubmitController(e) {
	// Validation for text_field
	if ($('#fixDescription').val() == '') {
		$('#fixDescription').attr("placeholder", "This field can't be empty");
		$('#fixDescriptionError').addClass("has-error");
		document.fixtureDescriptionForm.fixDescription.focus();
		return false;
	} else {
		$("#actionFor").val(e);
	}
	$('#loading').modal('show');
	$.ajax({
		type : "POST",
		url : "fixtureDescAction",
		dataType : "json",
		traditional : true,
		data : $('#fixtureDescriptionForm').serialize(),
		success : function(data) {

			notifications($("#actionFor").val(), 'FIXTURE DESCRIPTION');
			oTableFixtureDescriptionTable.fnClearTable();
			oTableFixtureDescriptionTable.fnDraw();
			oTableSideUserTable.fnClearTable();
			oTableSideUserTable.fnDraw();
			$('#fixDescription').val('');
			$('#fixDescription').attr("placeholder", "Description...");
			$('#fixDescriptionError').removeClass("has-error");
			getTableDetailsForFixDesc();
			getTableDetailsForLampCatalogNo();
			$("#fixDescInfo").html(modeDesc.aaData1.length);
		},
		error : function(err) {
			notifications($("#actionFor").val(), err);
		},
		complete : function() {
			$('#loading').modal('hide');
		}
	});
}

function fixManufacturersubmitController(e) {
	// Validation for text_field
	if ($('#fixManufacturer').val() == '') {
		$('#fixManufacturer').attr("placeholder", "This field can't be empty");
		$('#fixManufacturerError').addClass("has-error");
		document.fixManufacturerForm.fixManufacturer.focus();
		return false;
	} else {
		$("#actionFor").val(e);
	}
	$('#loading').modal('show');
	$.ajax({
		type : "POST",
		url : "fixManufacturerAction",
		dataType : "json",
		traditional : true,
		data : $('#fixManufacturerForm').serialize(),
		success : function(data) {
			notifications($("#actionFor").val(), 'FIXTURE MANUFACTURER');
			oTableFixtureManufacturerTable.fnClearTable();
			oTableFixtureManufacturerTable.fnDraw();
			oTableSideUserTable.fnClearTable();
			oTableSideUserTable.fnDraw();
			$('#fixManufacturer').val('');
			$('#fixManufacturer').attr("placeholder", "Manufacturer...");
			$('#fixManufacturerError').removeClass("has-error");
			getTableDetailsForFixManufact();
			getTableDetailsForLampCatalogNo();
			$("#fixManfInfo").html(modeFixManf.aaData.length);
		},
		error : function(err) {
			notifications("ERROR", err);
		},
		complete : function() {
			$('#loading').modal('hide');
		}
	});
}

function lampManufacturersubmitController(e) {
	// Validation for text_field
	if ($('#lampManufacturer').val() == '') {
		$('#lampManufacturer').attr("placeholder", "This field can't be empty");
		$('#lampManufacturerError').addClass("has-error");
		document.lampManufacturerForm.lampManufacturer.focus();
		return false;
	} else {
		$("#actionFor").val(e);
	}
	$('#loading').modal('show');
	$.ajax({
		type : "POST",
		url : "lampManufactAction",
		dataType : "json",
		traditional : true,
		data : $('#lampManufacturerForm').serialize(),
		success : function(data) {
			notifications($("#actionFor").val(), 'LAMP MANUFACTURER');
			oTableLampManufacturerTable.fnClearTable();
			oTableLampManufacturerTable.fnDraw();
			oTableSideUserTable.fnClearTable();
			oTableSideUserTable.fnDraw();
			$('#lampManufacturer').val('');
			$('#lampManufacturer').attr("placeholder", "Manufacturer...");
			$('#lampManufacturerError').removeClass("has-error");
			getTableDetailsForLampManufact();
			getTableDetailsForLampCatalogNo();
			$("#lampManfInfo").html(modeLampManf.aaData.length);
		},
		error : function(err) {
			notifications("ERROR", err);

		},
		complete : function() {
			$('#loading').modal('hide');
		}
	});
}

function lampCatalogsubmitController(e) {
	// Validation for text_field
	if ($('#lampCatalog').val() == '') {
		$('#lampCatalog').attr("placeholder", "This field can't be empty");
		$('#lampCatalogError').addClass("has-error");
		document.lampCatalogForm.lampCatalog.focus();
		return false;
	} else {
		$("#actionFor").val(e);
	}
	$('#loading').modal('show');
	$.ajax({
		type : "POST",
		url : "lampCatalogAction",
		dataType : "json",
		traditional : true,
		data : $('#lampCatalogForm').serialize(),
		success : function(data) {
			notifications($("#actionFor").val(), 'LAMP CATALOG LOG');
			oTableLampCatalogNoTable.fnClearTable();
			oTableLampCatalogNoTable.fnDraw();
			oTableSideUserTable.fnClearTable();
			oTableSideUserTable.fnDraw();
			$('#lampCatalog').val('');
			$('#lampCatalog').attr("placeholder", "Catalog No...");
			$('#lampCatalogError').removeClass("has-error");
			getTableDetailsForLampCatalogNo();
			$("#lampCatInfo").html(modeCatalog.aaData.length);
		},
		error : function(err) {
			notifications("ERROR", err);
		},
		complete : function() {
			$('#loading').modal('hide');
		}
	});
}

function checkErrorClass(divId, elementId) {
	if ($('#' + elementId).val() == '') {
		$('#' + elementId).attr("placeholder", "This field can't be empty");
		$('#' + divId).addClass("has-error");
	} else {
		$('#' + divId).removeClass("has-error");
	}
}

function isNumberKey(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		validateNotifications('</i> Error! </strong>  Only Number Are Allowed.');
		// showAlert('<div class="alert alert-danger"> <i
		// class="icon-remove"></i> </button> <strong> <i
		// class="icon-remove"></i> Error! </strong> Only Number Are Allowed.
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
