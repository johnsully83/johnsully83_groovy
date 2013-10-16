<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>	
<html>
<head>
<title>Guestbook</title>
<jsp:include page="../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/guestbook.css" />
<script type="text/javascript" src="/javascript/custom/guestbook.js"></script>
<script type="text/javascript">
	$(function() {
		$('#country').val("${unitedStatesCountryID}")
		$('#state').val("${massachusettsStateID}")
	});
</script>
</head>
<body>
	<jsp:include page="../tags/navbar.jsp" />
	<jsp:include page="../tags/header.jsp" />
	<div id="wrapper" class="blue">
		<form:form commandName="guest" method="POST" action="/guestbook/save">
			<form:hidden path="pk" />
			<form:hidden path="dateAdded" />
			<form:hidden path="dateLastModified" />
			<form:hidden path="isDeleted" />
			<table id="guestTable">
				<tbody>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="name">
									Name:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:input path="name" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="name" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="city">
									City:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:select path="city">
									<form:options items="${cities}" />
								</form:select>
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="city" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="state">
									State:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:select path="state">
									<form:options items="${states}" />
								</form:select>
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="state" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="country">
									Country:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:select id="country" path="country">
									<form:options items="${countries}" />
								</form:select>
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="country" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="email">
									Email:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:input path="email" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="email" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
							<div class="label orange">
								<form:label path="age">
									Age:
								</form:label>
							</div>
						</td>
						<td>
							<div class="cellWrapper">
								<form:input path="age" />
							</div>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
							<form:errors path="age" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="labelWrapper">
						</td>
						<td>
							<div id="submitWrapper" class="cellWrapper">
								<input id="submitButton" type="submit" value="Submit" />
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div class="buttonWrapper">
			<button type="button" class="button" onclick="return getLogin();">Admin</button>
		</div>
	</div>
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>