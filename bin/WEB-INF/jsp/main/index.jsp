<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<script type="text/javascript" src="/javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.buttonDiv').bind('click', function() {
			window.location.href="/test/getTest";
		});
	});
</script>
<style type="text/css">
.buttonDiv {
	width:100%;
	height:4em;
	background-color:#000;
	color:#FFF;
	text-align:center;
	margin:auto;
	border-radius:1em 1em;
	box-shadow:1em 1em 1em 1em #000;
}

#wrapper {
	color:#888;
}

.buttonDiv:hover {
	color:#000;
	background-color:#FFF;
}
</style>
</head>
<body>
	<div id="wrapper">Hello World!</div>
	<div class="buttonDiv" onclick='window.location.href="/test/getTest"'>Click here!</div>
</body>
</html>