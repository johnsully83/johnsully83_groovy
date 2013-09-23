<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About Me</title>
<link rel="icon" href="/img/icon.ico">
<link rel="shortcut icon" href="/img/icon.ico">
<link rel="stylesheet" type="text/css" href="/css/library/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/library/jqueryui/jquery-ui.custom.min.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/core.css" />
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
		<div class="info">
			<div>
				<p>
					Hey there, my name is John Sullivan and you are on my new site.  This is the third version of it, the first one 
					being very, very, very rudimentary (made circa 2009), and the second version being somewhat better, but honestly
					lacking a bit of style.  This new site is supposed to be much more modern in appearance; I am also trying to ensure
					its usability on mobile devices.
				</p>
				<p>
					Seeing as how I have become a software engineer recently, I decided to redo my site reflecting that side of me
					a little more.  If you know what any of this means, this site is made with a JAVA Spring back end, MySQL databases,
					jQuery and CSS for the front end, and a whole bunch of APIs and publicly available JAVA technologies.  If you're
					more interested in this, hit up the 
					<a href='javascript:openPage("/guestbook/getGuestbookForm");'>guestbook</a>
					.  
					Also, I have a 
					<a href='javascript:openPage("/navigate/base?page=code");'>code</a> 
					page that I will be adding to,
					hopefully pretty steadily, and it already has a handful of things on it (including some pretty 
					<a href='javascript:openPage("/navigate/code?page=spacePictures");'>space pictures</a>).
				</p>
				<p>
					Anyways a little more about me; I graduated from 
					<a target="_blank" href="http://www.bc.edu/">Boston College</a>
					 this year (currently 2012) and have since started working
					for 
					<a target="_blank" href='http://www.bullhorn.com/'>BULLHORN</a>
					, who I interned for during college for a little over a year
					as a reporting engineer.  When I started full-time I became a software engineer, and thus this site.  
					<a target="_blank" href='http://www.bullhorn.com/'>BULLHORN</a> 
					is a very fun place to work, and I recommend it to anyone looking to work for a well-established 
					up-and-coming tech company (check out the news stories on the site about our recent acquisitions).
				</p>
				<p>
					Back at 
					<a target="_blank" href="http://www.bc.edu/">Boston College</a>
					 I was a Math major and a Computer Science minor; I studied a lot of abstract mathematics
					such as Algebra, Analysis, and Geometry/Topology (my favorite).  I also did a decent amount of computational analytic stuff, 
					using software tools like 
					<a target="_blank" href="http://www.mathworks.com/products/matlab/">MATLAB</a>
					or 
					<a target="_blank" href="http://www.wolfram.com/mathematica/">Mathematica</a>
					to solve complex and/or large math problems; it was during this time that I had my first lessons in Cryptography,
					which I plan on writing some JAVA for before too long.  I'll be adding some more stuff here about some of that stuff before too long.
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>