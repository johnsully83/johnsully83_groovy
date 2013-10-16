$(function() {
	var methods = ['encrypt', 'decrypt'];
	$('form').each(function (index) {
		var algorithm = $(this).prop('name');
		var form = $(this);
		
		$.each(methods, function(index, value) {
			 var method = this;
			 
			 form.find('button.'+method).on('click', function() {
				var value = form.find('input[name="'+method+'value"]').val();
				var encryptionKey = form.find('input[name="encryptionKey"]').val();
				
				var formData = {value: value, encryptionKey: encryptionKey, method: method};
				
				$.ajax({
					url : '/crypto/'+algorithm,
					type : 'POST',
					data : formData,
					cache: false,
					success : function(data) {
						if(data.success) {
							$(form).find('div#'+method+'.result').text(data.result);
							$(form).find('input[name="encryptionKey"]').val(data.encryptionKey);
						} else {
							$(form).jAlert('Error, please try again.', 'fatal', 'errorAlert');
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$(form).jAlert('Error, please try again.\n'+jqXHR+'\n'+textStatus+'\n'+errorThrown, 'fatal', 'errorAlert');
					}
				});
				
				return false;
			 });
		});
	});
});