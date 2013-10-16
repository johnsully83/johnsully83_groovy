<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>	
<html>
<head>
<jsp:include page="../../tags/coreDependencies.jsp" />
<title>Guestbook</title>
<link rel="stylesheet" type="text/css" href="/css/custom/guestbook.css" />
<script type="text/javascript" src="/javascript/custom/guestbook.js"></script>
</head>
<body>
	<jsp:include page="../../tags/navbar.jsp" />
	<jsp:include page="../../tags/header.jsp" />
	<div id="wrapper" class="blue">
		<form:form commandName="loginForm" method="POST" action="/guestbook/admin/login">
			<table id="guestTable">
				<tbody>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="username">
									Username:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:input path="username" />
							</div>
						</td>
					</tr>
					<tr>
						<td />
						<td>
							<form:errors path="username" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="password">
									Password:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:input path="password" />
							</div>
						</td>
					</tr>
					<tr>
						<td />
						<td>
							<form:errors path="password" cssClass="error" />
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>