<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mongo DB</title>
<link rel="icon" href="/img/icon.ico">
<link rel="shortcut icon" href="/img/icon.ico">
<link rel="stylesheet" type="text/css" href="/css/library/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/datatable/demo_table_jui.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jqueryui/jquery-ui.custom.min.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/core.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/code.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/code/mongoDb.css" />
<script type="text/javascript" src="/javascript/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/javascript/library/jqueryui/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="/javascript/library/json.min.js"></script>
<script type="text/javascript" src="/javascript/library/datatable/jquery.dataTables.js"></script>
<script type="text/javascript" src="/javascript/custom/core.js"></script>
<script type="text/javascript" src="/javascript/custom/mongoDb.js"></script>
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
		
		<div class="info" id="mongoIntro">
			<p>
				So this page has a couple of examples utilizing the super fast object/document storage engine called 
				<a href="http://www.mongodb.org/" target="_blank">MongoDB</a>.  It is a NOSQL database, which means it is
				the opposite of a traditional relational database; every object is stored with a key that is a unique identifier.
				There is no relationship between different objects in the database.  In fact, it is better to consider a 
				NOSQL 'table' as a collection of items (a Map, specifically), where each item in the collection has a key,
				which is a sort of hash-like String representation, and where the object is some number of fields
				with values.
			</p>
			<p>
				Anyways what I decided to do with this is display all of the Countries and States in my MySQL databases by replicating 
				them to a MongoDB database nightly (they are originally replicated from the Yahoo GeoPlanet API nightly) and then display
				them in the following UI.  The whole point of it is that every time you sort, search, or change in some way what data is shown, 
				every record in the database is pulled and displayed.  This is ALOT of database calls happening incredibly quickly 
				and immediately.
			</p>
			<p>
				If your interested in getting some help with MongoDB, etc., please feel free to sign the guestbook.
			</p>
			<p>
				Finally, I discovered that even with MongoDb loading 50,000+ records in a reasonable second or so is a bit much.
				Consequently I edited this page so you can click on a row in the country or state table; the next table down
				on the page will load correspondinly (i.e. click on 'United States' in the country table, you see all U.S. states
				in the state table, etc.)
			</p>
		</div>
		<div class="datatable">
			<div id="containerEH">
				<div id="demo_jui">
					<table id="countryDataTable" class="datatable">
						<thead>
							<tr>
								<th>
									Country
								</th>
								<th>
									Has States
								</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="datatable">
			<div id="containerEH">
				<div id="demo_jui">
					<table id="stateDataTable" class="datatable">
						<thead>
							<tr>
								<th>
									Country
								</th>
								<th>
									State
								</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="datatable">
			<div id="containerEH">
				<div id="demo_jui">
					<table id="cityDataTable" class="datatable">
						<thead>
							<tr>
								<th>
									Country
								</th>
								<th>
									State
								</th>
								<th>
									City
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
	
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>