<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Primes</title>
<jsp:include page="../../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/math.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/math/primes.css" />
<script type="text/javascript" src="/javascript/custom/primes.js"></script>
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