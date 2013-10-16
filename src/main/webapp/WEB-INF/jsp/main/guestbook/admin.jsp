<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Guestbook</title>
<jsp:include page="../../tags/coreDependencies.jsp" />
<script type="text/javascript" src="/javascript/custom/guestbook.js"></script>
<script type="text/javascript">
	$(function() {
		$('#country').val("${unitedStatesCountryID}")
		$('#state').val("${massachusettsStateID}")
	});
</script>
</head>
<body>
	<jsp:include page="../../tags/navbar.jsp" />
	<jsp:include page="../../tags/header.jsp" />
	<div id="wrapper" class="blue">
		<div>ADMIN PAGE</div>
	</div>
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>