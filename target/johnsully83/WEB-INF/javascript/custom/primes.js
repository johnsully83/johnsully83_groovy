var primeTable = null;
var primeRangeTable = null;

function findPrime() {
	var formData = {};
	
	formData['findPrime']=$('#findPrime').val();
	
	$.ajax('/primes/findPrime', {
		type : 'GET',
		dataType : 'text',
		data : formData,
		success : function(data) {
			if(parseInt(data) < 0) {
				$('#findPrimeForm').jAlert('Sorry, I don\'t have that prime yet!  Please try again', 'fatal', 'errorAlert');
			} else {
				$('#primeValue').val(data);
			}
		},
		error : function(data) {
			$('#findPrimeForm').jAlert('Error, please try again.', 'fatal', 'errorAlert')
		}
	});
}

function createPrimeTable() {
	if(primeTable) {
		primeTable.fnDestroy();
		primeTable = null;
	}
	
	primeTable = $('#primeDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/primes/primeData",
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"aoColumns" : [{"sWidth": "250px"},
		               {"sWidth": "250px"}]
	});
}

function createPrimeRangeTable() {
	primeRangeTable = $('#primeRangeDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/primes/primeRangeData",
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"aoColumns" : [{"sWidth": "250px"},
		               {"sWidth": "250px"}]
	});
}

function getPrimeRange() {
	var fromPrime = $('#fromPrime').val();
	var toPrime = $('#toPrime').val();
	
	if(primeRangeTable) {
		primeRangeTable.fnDestroy();
		primeRangeTable = null;
	}
	
	primeRangeTable = $('#primeRangeDataTable').dataTable({
		"bServerSide" : true,
		"sAjaxSource" : "/primes/primeRangeData?fromPrime="+fromPrime+"&toPrime="+toPrime,
		"sServerMethod": "POST",
		"bProcessing" : true,
		"sPaginationType" : "full_numbers",
		"bJQueryUI" : true,
		"bRetrieve" : true,
		"bDestroy" : true,
		"bDeferRender" : true,
		"aoColumns" : [{"sWidth": "250px"},
		               {"sWidth": "250px"}]
	});
}

$(document).ready(function() {
	createPrimeTable();
	createPrimeRangeTable();
});