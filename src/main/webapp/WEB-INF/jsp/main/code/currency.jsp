<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Currency Converter</title>
<link rel="icon" href="/img/icon.ico">
<link rel="shortcut icon" href="/img/icon.ico">
<link rel="stylesheet" type="text/css" href="/css/library/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jqueryui/jquery-ui.custom.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jalert/jalert.css" />
<link rel="stylesheet" type="text/css" href="/css/library/select2/select2.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/core.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/code.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/code/currency.css" />
<script type="text/javascript" src="/javascript/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/javascript/library/jqueryui/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="/javascript/library/jalert/jquery.jalert.packed.js"></script>
<script type="text/javascript" src="/javascript/library/select2/select2.min.js"></script>
<script type="text/javascript" src="/javascript/custom/core.js"></script>
<script type="text/javascript" src="/javascript/custom/currency.js"></script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-23673631-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
	<jsp:include page="../../tags/navbar.jsp" />
	<jsp:include page="../../tags/header.jsp" />

	<div id="wrapper" class="blue">
		<jsp:include page="../../tags/codeHeader.jsp"></jsp:include>
		<div id="currencyWrapper">
			<div class="image">
				<a href="https://openexchangerates.org/" target="_blank"><img id="openExchangeImage" alt="Open Exchange Logo" src="/img/openExchange.png" /></a>
			</div>
			<c:if test="${error}">
				<div class="not empty error">
					"${error}"
				</div>
			</c:if>
			<p class="info">
				<a href="https://openexchangerates.org/" target="_blank">Open Exchange</a> is a group that hosts
				a REST API for retrieving real-time currency information.  It include 150+ world-wide currencies,
				with information updated regularly.  I decided to create a little UI so that anyone can come here
				and convert between currencies; in order to do so I replicate this data nightly into a MySQL database,
				and then into a MongoDB document storage system.  On this page you can fill out the form and submit it,
				choosing from any of the currencies I currently have, and from any of the days that I have replicated
				this data so far.  Then I'll spit you back the answer.  Enjoy!
			</p>
			<form:form commandName="currencyForm" method="POST">
				<table id="currencyTable">
					<tr class="formInput">
						<td>
							<form:label path="timestamp">
								Date currency recorded:
							</form:label>
						</td>
						<td>
							<form:select path="timestamp" cssClass="select" items="${timestamps}" style="width:250px;">
							</form:select>
						</td>
					</tr>
					<tr class="formInput">
						<td>
							<form:label path="fromCurrencyCode">
								Currency to convert from:
							</form:label>
						</td>
						<td>
							<form:select path="fromCurrencyCode" cssClass="select" items="${currencies}" style="width:250px;">
							</form:select>
						</td>
					</tr>
					<tr class="formInput">
						<td>
							<form:label path="toCurrencyCode">
								Currency to convert to:
							</form:label>
						</td>
						<td>
							<form:select path="toCurrencyCode" cssClass="select" items="${currencies}" style="width:250px;">
							</form:select>
						</td>
					</tr>
					<tr class="formInput">
						<td>
							<form:label path="amountFrom">
								Amount:
							</form:label>
						</td>
						<td>
							<form:input path="amountFrom" cssClass="number" />
						</td>
					</tr>
					<tr class="formInput">
						<td>
							<form:label path="value">
								Value:
							</form:label>
						</td>
						<td>
							<form:input disabled="true" path="value" cssClass="select" />
						</td>
					</tr>
					<tr class="formInput">
						<td colspan="2">
							<button id="calculateButton" onclick="return calculate();">
								Calculate
							</button>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>