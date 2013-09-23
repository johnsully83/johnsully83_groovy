function getLogin() {
	window.location = "/guestbook/admin/getLogin";
}

$(function() {
	$('#submitButton').button({
		icons: {
			primary: "ui-icon-arrowthick-1-e"
		}
	});
	
	$('#country').bind('propertychange change', function() {
		$.ajax({
			type : "GET",
			url : "/guestbook/getStates?countryID="+$(this).val(),
			contentType : "text/html",
			success : function(data) {
				$('#state').html(data);
			}
		});
	});

	$('#state').bind('propertychange change', function() {
		$.ajax({
			type : "GET",
			url : "/guestbook/getCities?stateID="+$(this).val(),
			contentType : "text/html",
			success : function(data) {
				$('#city').html(data);
			}
		});
	});
});