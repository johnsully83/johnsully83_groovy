$(function() {
	$('#accordion').accordion({
		collapsible: true,
		autoHeight: false, 
		active: false 
	});

	$('button.button').button({
		icons: {
			primary: "ui-icon-arrowthick-1-e"
		}
	});

	$("#navbar li").on('mouseover', function() {  
		$(this).stop().animate({height:'150px'},{queue:false, duration:600, easing: 'easeOutBounce'})  
	});  

	$("#navbar li").on('mouseout', function() {  
		$(this).stop().animate({height:'50px'},{queue:false, duration:600, easing: 'easeOutBounce'})  
	});  
});

function openPage(page) {
	if(page.indexOf("http") >= 0) {
		var newWindow = window.open(page);
	} else {
		location.href=page;
	}
}