<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Code</title>
<link rel="icon" href="/img/icon.ico">
<link rel="shortcut icon" href="/img/icon.ico">
<link rel="stylesheet" type="text/css" href="/css/library/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jqueryui/jquery-ui.custom.min.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/core.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/math.css" />
<script type="text/javascript" src="/javascript/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/javascript/library/jqueryui/jquery-ui.custom.min.js"></script>
<script type="text/javascript" src="/javascript/custom/core.js"></script>
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
	<jsp:include page="../tags/navbar.jsp" />
	<jsp:include page="../tags/header.jsp" />
	
	<div id="wrapper" class="blue">
		<jsp:include page="../tags/mathHeader.jsp"></jsp:include>
		<div class="info">
			<div id="mathIntro">
				<p>
					So as you can see there isn't a ton up here right now; I haven't been doing much outside of code
					as of recent, so I haven't exactly had a ton of time to do much with math.  However I decided to try
					to combine the two, and the result is this section of my site.  As of now it's just one page about
					the prime numbers this application generates, but I plan on adding at least some of my old college proofs
					up here soon.
				</p>
				<p>
					Anyways I have this section because as you may have seen somewhere else on this site I was a Math major at 
					Boston College.  I did a lot of abstract pseudo-graduate math when I was there (Algebra, Analysis),
					as well as a handful of classes dealing with more applied mathematics.  
				</p>
				<p>
					This may not be particularly exciting for the majority of you, but if you like numbers like I do,
					please look around.
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>