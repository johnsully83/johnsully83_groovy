$(document).ready(function() {
	$('select.select').select2();
});

function calculate() {
	var formData = {};
	
	formData['timestamp']=$('#timestamp').val();
	formData['fromCurrencyCode']=$('#fromCurrencyCode').val();
	formData['toCurrencyCode']=$('#toCurrencyCode').val();
	formData['amountFrom']=$('#amountFrom').val();
	
	$.ajax('/mongo/currencyValue', {
		type : 'GET',
		dataType : 'text',
		data : formData,
		success : function(data) {
			if(parseInt(data) < 0) {
				$('#currencyForm').jAlert('Error, missing data necessary for calculation.  Please try a different currency/date', 'fatal', 'errorAlert')
			} else {
				$('#value').val(data);
			}
		},
		error : function(data) {
			$('#currencyForm').jAlert('Error, please try again.', 'fatal', 'errorAlert')
		}
	});
	
	return false;
}