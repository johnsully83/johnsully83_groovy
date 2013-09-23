var titleHeight = 0;

$(document).ready(function() {
	var fullWidth = $('#codeMenu').width();
	titleHeight = findLargestTitleHeight();
	
	$('#codeMenu li, #codeMenu li .codeSubtext').width(parseInt(fullWidth)/5-1);
	$('#codeMenu li').height(titleHeight);
	
	$("#codeMenu li").on('mouseover', function() {  
		$(this).stop().animate({height:6*titleHeight},{queue:false, duration:600, easing: 'linear'})  
	});  

	$("#codeMenu li").on('mouseout', function() {  
		$(this).stop().animate({height:titleHeight},{queue:false, duration:600, easing: 'linear'})  
	});  
});

function findLargestTitleHeight() {
	var height = 0;
	
	$('#codeMenu .codeHeader').each(function() {
		if($(this).height() > height) {
			height = $(this).height();
		}
	});
	
	return height;
}