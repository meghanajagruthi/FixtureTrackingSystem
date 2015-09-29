function doInit() {
	$
			.ajax({
				url : "dashboardDetails",
				type : "POST",
				contentType : "text/plain",
				success : function(e) {
					if (e == "Failed") {
						bootbox.confirm("Please select the Project!!!!!",
								function(result) {
									window.location.href = "login";
								});
					} else {
						mode = JSON.parse(e);
						$("#projectDetailInfo").html(
								mode.selectedProject.jobName + " _ "
										+ mode.selectedProject.jobNumber);
						$("#projectNameW").val(mode.selectedProject.jobName);
						$("#projectIdW").val(mode.selectedProject.jobNumber);

						var lastNameMang, lastNameSupr, startDateTemp, endDateTemp, firstNameManager;
						firstNameManager = startDateTemp = endDateTemp = lastNameMang = lastNameSupr = "";

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
						for (var t = 0; t < mode.projList.length; t++) {
							if (mode.projList[t].status == "ACTIVE") {
								oTableSideProjectTable.fnAddData([
										mode.projList[t].jobName,
										mode.projList[t].jobNumber,
										mode.projList[t].jobId ], false);
							}
						}
						oTableSideProjectTable.fnDraw();

					}
					getFixtureLampCountChart();
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
var fixLampCountSeries = "";
var fixLampCountLabel = "";
var stackedSeries = "";
function getFixtureLampCountLabel() {

	if (fixLampCountLabel == "") {
		fixLampCountLabel += '{"xAxis" :{"categories" : [';
		for (var i = 0; i < mode.aaData.length; i++) {
			if (i == mode.aaData.length - 1) {
				fixLampCountLabel += JSON.stringify(mode.aaData[i].fixtureType);
			} else {
				fixLampCountLabel += JSON.stringify(mode.aaData[i].fixtureType)
						+ ',';
			}
		}
		fixLampCountLabel += ']';
		if (mode.aaData.length > 10) {
			fixLampCountLabel += ',"min" : 0,"max" : 10';
		}

		fixLampCountLabel += '}}';
	}
	return fixLampCountLabel;
}

function getFixtureLampCountSeries(chartName) {
	if (chartName == "bar") {
		if (fixLampCountSeries == "") {
			fixLampCountSeries += '{"series":[{';
			fixLampCountSeries += '"name" : "Fix. On Order",';
			fixLampCountSeries += '"data" : [';
			for (var i = 0; i < mode.aaData.length; i++) {
				if (i == mode.aaData.length - 1) {
					fixLampCountSeries += mode.aaData[i].qtyPerBaseOrder;
				} else {
					fixLampCountSeries += mode.aaData[i].qtyPerBaseOrder + ',';
				}
			}
			fixLampCountSeries += ']},{';
			fixLampCountSeries += '"name" : "Fix. Received Good",';
			fixLampCountSeries += '"data" : [';
			for (var i = 0; i < mode.aaData.length; i++) {
				if (i == mode.aaData.length - 1) {
					fixLampCountSeries += mode.aaData[i].fixtureGood;
				} else {
					fixLampCountSeries += mode.aaData[i].fixtureGood + ',';
				}
			}
			fixLampCountSeries += ']';
			fixLampCountSeries += '}]}';
		}
		return fixLampCountSeries;
	} else if (chartName == "stacked") {
		if (stackedSeries == "") {
			stackedSeries += '{"series":[{';
			stackedSeries += '"name" : "Quantity Ordered",';
			stackedSeries += '"data" : [';
			if (mode.aaData != undefined) {
				for (var i = 0; i < mode.aaData.length; i++) {
					if (i == mode.aaData.length - 1) {
						stackedSeries += mode.aaData[i].fixtureQuantity;
					} else {
						stackedSeries += mode.aaData[i].fixtureQuantity + ',';
					}
				}
			}
			stackedSeries += ']},{';
			stackedSeries += '"name" : "Quantity Recieved Good",';
			stackedSeries += '"data" : [';
			if (mode.aaData != undefined) {
				for (var i = 0; i < mode.aaData.length; i++) {
					if (i == mode.aaData.length - 1) {
						stackedSeries += mode.aaData[i].fixtureGood;
					} else {
						stackedSeries += mode.aaData[i].fixtureGood + ',';
					}
				}
			}
			stackedSeries += ']';
			stackedSeries += '}]}';
		}
		return stackedSeries;
	}
}

function getFixtureLampCountChart() {
	var manS = getFixtureLampCountSeries("bar");
	var manL = getFixtureLampCountLabel();

	var manSeries = JSON.parse(manS);
	var manLabel = JSON.parse(manL);
	$('#fixtureLampStat')
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : 'Fixture Details'
						},
						xAxis : manLabel.xAxis,

						yAxis : {
							min : 0,
							title : {
								text : 'Units'
							}
						},
						tooltip : {
							headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
							pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
									+ '<td style="padding:0"><b>{point.y:.0f} Units</b></td></tr>',
							footerFormat : '</table>',
							shared : true,
							useHTML : true
						},
						plotOptions : {
							column : {
								pointPadding : 0.2,
								borderWidth : 0
							}
						},
						scrollbar : {
							enabled : true,
							barBackgroundColor : 'gray',
							barBorderRadius : 7,
							barBorderWidth : 0,
							buttonBackgroundColor : 'gray',
							buttonBorderWidth : 0,
							buttonBorderRadius : 7,
							trackBackgroundColor : 'none',
							trackBorderWidth : 1,
							trackBorderRadius : 8,
							trackBorderColor : '#CCC'
						},
						series : manSeries.series
					});

}
function setProjSelected(projId) {
	$("#projectIdSummary").val(projId);
	$("#selectProjectForDashBord").submit();
}

function getStackedChart() {
	var manS = getFixtureLampCountSeries("stacked");
	var manL = getFixtureLampCountLabel();

	var manSeries = JSON.parse(manS);
	var manLabel = JSON.parse(manL);
	$('#stackedBar')
			.highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : 'Ordered/Received Fixtures'
						},
						xAxis : manLabel.xAxis,
						yAxis : {
							min : 0,
							title : {
								text : 'Units'
							},
							stackLabels : {
								enabled : true,
								style : {
									fontWeight : 'bold',
									color : (Highcharts.theme && Highcharts.theme.textColor)
											|| 'gray'
								}
							}
						},
						scrollbar : {
							enabled : true,
							barBackgroundColor : 'gray',
							barBorderRadius : 7,
							barBorderWidth : 0,
							buttonBackgroundColor : 'gray',
							buttonBorderWidth : 0,
							buttonBorderRadius : 7,
							trackBackgroundColor : 'none',
							trackBorderWidth : 1,
							trackBorderRadius : 8,
							trackBorderColor : '#CCC'
						},

						tooltip : {
							formatter : function() {
								return '<b>' + this.x + '</b><br/>'
										+ this.series.name + ': ' + this.y
										+ '<br/>' + 'Total: '
										+ this.point.stackTotal;
							}
						},
						plotOptions : {
							column : {
								stacking : 'normal',
								dataLabels : {
									enabled : true,
									color : (Highcharts.theme && Highcharts.theme.dataLabelsColor)
											|| 'white'
								}
							}
						},
						series : manSeries.series

					});
}
$(function() {
	$('#loading').modal('show');
	oTableSideProjectTable = $('#sideMenuTable')
			.dataTable(
					{
						sDom : "lrtp",
						bSearchable : false,
						"sScrollY" : "450px",
				        "bPaginate" : true,
				        "bScrollCollapse": true,
						aoColumns : [
								{
									sClass : "center",
									fnRender : function(e) {
										return "<a  href=\"javascript:setProjSelected('"
												+ e.aData[2]
												+ "')\">"
												+ e.aData[0] + "</a>";
									}
								}, ]
					});
	doInit();
	$('#loading').modal('hide');
});
/**
 * Grid theme for Highcharts JS
 * 
 * @author Torstein Honsi
 */

Highcharts.theme = {
	colors : [ '#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5',
			'#64E572', '#FF9655', '#FFF263', '#6AF9C4' ],
	chart : {
		backgroundColor : {
			linearGradient : {
				x1 : 0,
				y1 : 0,
				x2 : 1,
				y2 : 1
			},
			stops : [ [ 0, 'rgb(255, 255, 255)' ], [ 1, 'rgb(240, 240, 255)' ] ]
		},
		borderWidth : 2,
		plotBackgroundColor : 'rgba(255, 255, 255, .9)',
		plotShadow : true,
		plotBorderWidth : 1
	},
	title : {
		style : {
			color : '#000',
			font : 'bold 16px "Trebuchet MS", Verdana, sans-serif'
		}
	},
	subtitle : {
		style : {
			color : '#666666',
			font : 'bold 12px "Trebuchet MS", Verdana, sans-serif'
		}
	},
	xAxis : {
		gridLineWidth : 1,
		lineColor : '#000',
		tickColor : '#000',
		labels : {
			style : {
				color : '#000',
				font : '11px Trebuchet MS, Verdana, sans-serif'
			}
		},
		title : {
			style : {
				color : '#333',
				fontWeight : 'bold',
				fontSize : '12px',
				fontFamily : 'Trebuchet MS, Verdana, sans-serif'

			}
		}
	},
	yAxis : {
		minorTickInterval : 'auto',
		lineColor : '#000',
		lineWidth : 1,
		tickWidth : 1,
		tickColor : '#000',
		labels : {
			style : {
				color : '#000',
				font : '11px Trebuchet MS, Verdana, sans-serif'
			}
		},
		title : {
			style : {
				color : '#333',
				fontWeight : 'bold',
				fontSize : '12px',
				fontFamily : 'Trebuchet MS, Verdana, sans-serif'
			}
		}
	},
	legend : {
		itemStyle : {
			font : '9pt Trebuchet MS, Verdana, sans-serif',
			color : 'black'

		},
		itemHoverStyle : {
			color : '#039'
		},
		itemHiddenStyle : {
			color : 'gray'
		}
	},
	labels : {
		style : {
			color : '#99b'
		}
	},

	navigation : {
		buttonOptions : {
			theme : {
				stroke : '#CCCCCC'
			}
		}
	}
};
// Apply the theme
var highchartsOptions = Highcharts.setOptions(Highcharts.theme);


$(document)
.ready(
		function() {
	$('#sideMenuTable_wrapper > div.dataTables_paginate.paging_bootstrap').css('display','none');
})