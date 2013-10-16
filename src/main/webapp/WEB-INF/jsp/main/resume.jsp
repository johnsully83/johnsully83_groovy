<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Resume</title>
<jsp:include page="../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/resume.css" />
</head>
<body>
	<jsp:include page="../tags/navbar.jsp" />
	<jsp:include page="../tags/header.jsp" />

	<div id="wrapper" class="blue">
		<div id="pdf">
			<object type="application/pdf" data="/pdf/currentResume.pdf#scrollbar=0&navpanes=0" width="975" height="1300"></object>
		</div>
	</div>
	
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>