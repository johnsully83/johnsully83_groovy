var countryTable = null;
var stateTable = null;
var cityTable = null;

var countryID = 0;
var stateID = 0;

function createCountryMouseBindings() {
	$('#countryDataTable tbody tr').bind('click', function() {
		if($(this).hasClass('selected')) {
			$(this).removeClass('selected');
			
			countryID = 0;
			createStateTable();
		} else {
			$('#countryDataTable').find('.selected').removeClass('selected');
			
			$(this).addClass('selected');
			
			countryID = $(this).find('.countryID').attr('id');
			createStateTable();
		}
	}).bind('mouseenter mousein', function() {
		$(this).addClass('hovering');
		$(this).find('td').addClass('hovering');
	}).bind('mouseleave mouseout', function() {
		$(this).removeClass('hovering');
		$(this).find('td').removeClass('hovering');
	}).hover(function() {
		$(this).addClass('hovering');
		$(this).find('td').addClass('hovering');
	}, function() {
		$(this).removeClass('hovering');
		$(this).find('td').removeClass('hovering');
	});
}

function createStateMouseBindings() {
	$('#stateDataTable tbody tr').bind('click', function() {
		if($(this).hasClass('selected')) {
			$(this).removeClass('selected');
			
			stateID = 0;
			createCityTable();
		} else {
			$('#stateDataTable').find('.selected').removeClass('selected');
			
			$(this).addClass('selected');
			
			stateID = $(this).find('.stateID').attr('id');
			createCityTable();
		}
	}).bind('mouseenter mousein', function() {
		$(this).addClass('hovering');
		$(this).find('td').addClass('hovering');
	}).bind('mouseleave mouseout', function() {
		$(this).removeClass('hovering');
		$(this).find('td').removeClass('hovering');
	}).hover(function() {
		$(this).addClass('hovering');
		$(this).find('td').addClass('hovering');
	}, function() {
		$(this).removeClass('hovering');
		$(this).find('td').removeClass('hovering');
	});
}

function createCountryTable() {
	if(countryTable) {
		countryTable.fnDestroy();
		countryTable = null;
	}
	
	countryTable = $('#countryDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/mongo/countryData",
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"aoColumns" : [{"sWidth": "250px"},
		               {"sWidth": "250px"}],
		fnDrawCallback: function() {
			createCountryMouseBindings();
		}
	});
}

function createStateTable() {
	if(stateTable) {
		stateTable.fnDestroy();
		stateTable = null;
		stateID = 0;
		createCityTable();
	}
	
	stateTable = $('#stateDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/mongo/stateData?countryID="+countryID,
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"bAutoWidth" : false,
		"aoColumns" : [{"sWidth": "250px"},
		               {"sWidth": "250px"}],
   		fnDrawCallback: function() {
			createStateMouseBindings();
		}
	});
}

function createCityTable() {
	if(cityTable) {
		cityTable.fnDestroy();
		cityTable = null;
	}
	
	cityTable = $('#cityDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/mongo/cityData?stateID="+stateID,
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"aoColumns" : [{"sWidth": "150px"},
		               {"sWidth": "150px"},
		               {"sWidth": "200px"}]
	});
}

$(document).ready(function() {
	createCountryTable();
	createStateTable();
	createCityTable();
});