<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Primes</title>
<link rel="icon" href="/img/icon.ico">
<link rel="shortcut icon" href="/img/icon.ico">
<link rel="stylesheet" type="text/css" href="/css/library/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/datatable/demo_table_jui.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jqueryui/jquery-ui.custom.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jalert/jalert.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/core.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/math.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/math/primes.css" />
<script type="text/javascript" src="/javascript/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/javascript/library/jqueryui/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="/javascript/library/jalert/jquery.jalert.packed.js"></script>
<script type="text/javascript" src="/javascript/library/json.min.js"></script>
<script type="text/javascript" src="/javascript/library/datatable/jquery.dataTables.js"></script>
<script type="text/javascript" src="/javascript/custom/core.js"></script>
<script type="text/javascript" src="/javascript/custom/primes.js"></script>
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
		<jsp:include page="../../tags/mathHeader.jsp"></jsp:include>
		<div class="info">
			<div id="mathIntro">
				<p>
					So this is my page on prime numbers.  I have a thread running on my website
					that is constantly finding prime numbers (starting with 2, and working its way up)
					and shoving them into a database.  You can see the most recent ones here (refresh the page to
					see new ones), or find a specific range of primes, or find a single prime.
				</p>
				<p>
					I use MongoDB in order to store and retrieve the values to make the process as fast as possible.
					Thus the load time for the tables below is relatively low, and you should be able to constantly
					see new numbers appearing in the first (Most Recent 10000) table.
				</p>
			</div>
		</div>
		<div class="info">
			<div class="primeSection">
				<div class="title">
					Most Recent 10000 Prime Numbers
				</div>
				<div class="datatable">
					<div id="containerEH">
						<div id="demo_jui">
							<table id="primeDataTable" class="datatable">
								<thead>
									<tr>
										<th>
											Cardinality (Order, i.e. 2nd/3rd)
										</th>
										<th>
											Prime Number
										</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="primeSection">
				<div class="title">
					Find a Range of Primes (Max 10000)
				</div>
				<div class="primeForm">
					<div class="primeInputWrapper">
						<label for="fromPrime" class="primeInputLabel">
							From:
						</label>
						<input type="text" name="fromPrime" id="fromPrime" class="primeInput" />
						<span class="error" id="fromPrimeError"></span>
					</div>
					<div class="primeInputWrapper">
						<label for="toPrime" class="primeInputLabel">
							To:
						</label>
						<input type="text" name="toPrime" id="toPrime" class="primeInput" />
						<span class="error" id="toPrimeError"></span>
					</div>
					<div class="primeInputWrapper">
						<button id="getRange" class="button" onclick="getPrimeRange();">
							Find
						</button>
					</div>
				</div>
				<div class="datatable">
					<div id="containerEH">
						<div id="demo_jui">
							<table id="primeRangeDataTable" class="datatable">
								<thead>
									<tr>
										<th>
											Cardinality (Order, i.e. 2nd/3rd)
										</th>
										<th>
											Prime Number
										</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="primeSection">
				<div class="title">
					Find a Single Prime
				</div>
				<div class="primeForm" id="findPrimeForm">
					<div class="primeInputWrapper">
						<label for="findPrime" class="primeInputLabel">
							Cardinality (Order, i.e. 2nd/3rd):
						</label>
						<input type="text" name="findPrime" id="findPrime" class="primeInput" />
					</div>
					<div class="primeInputWrapper">
						<button id="getPrime" class="button" onclick="findPrime();">
							Find
						</button>
					</div>
					<div class="primeInputWrapper">
						<label for="primeValue" class="primeInputLabel">
							Prime Value:
						</label>
						<input type="text" name="primeValue" id="primeValue" class="primeInput" disabled="disabled" />
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>