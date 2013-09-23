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
<link rel="stylesheet" type="text/css" href="/css/custom/code.css" />
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
		<jsp:include page="../tags/codeHeader.jsp"></jsp:include>
		<div class="info">
			<div id="codeIntro">
				<p>
					So this is the area of my site where I do some stuff with various forms of code.  Not all of it is intensive
					in the slightest, and the majority of it is likely readable by non-programmer type people.  Anyways this is also
					the portion of the site that will get updated the most, seeing as how I'm a computer nerd and all.
				</p>
				<p>
					Basically it might be worth it to stop back here every once in a while to check for updates, especially if
					you have some interest in computers.  As for now I just have some random pictures from and of outer space,
					which if you've been around long enough will recognize from that past two versions of this site.  I also
					have some <a target="_blank" href="http://projecteuler.net/">Project Euler</a> solutions in both Python (it's been a while)
					and JAVA (which is what I wrote when I made this web page).  More to come!
				</p>
				<p>
					Enjoy!
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>