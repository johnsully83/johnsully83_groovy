var titleHeight = 0;

$(document).ready(function() {
	var fullWidth = $('#mathMenu').width();
	titleHeight = findLargestTitleHeight();
	
	$('#mathMenu li, #mathMenu li .mathSubtext').width(parseInt(fullWidth)/2-1);
	$('#mathMenu li').height(titleHeight);
	
	$("#mathMenu li").on('mouseover', function() {  
		$(this).stop().animate({height:6*titleHeight},{queue:false, duration:600, easing: 'linear'})  
	});  

	$("#mathMenu li").on('mouseout', function() {  
		$(this).stop().animate({height:titleHeight},{queue:false, duration:600, easing: 'linear'})  
	});  
});

function findLargestTitleHeight() {
	var height = 0;
	
	$('#mathMenu .mathHeader').each(function() {
		if($(this).height() > height) {
			height = $(this).height();
		}
	});
	
	return height;
}