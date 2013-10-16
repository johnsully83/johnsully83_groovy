<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Euler Solutions (Python)</title>
<jsp:include page="../../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/code.css" />
<link rel="stylesheet" type="text/css" href="/css/custom/code/pythonEuler.css" />
</head>
<body>
	<jsp:include page="../../tags/navbar.jsp" />
	<jsp:include page="../../tags/header.jsp" />

	<div id="wrapper" class="blue">
		<jsp:include page="../../tags/codeHeader.jsp" />
		<div id="pythonWrapper">
			<div class="image">
				<a href="http://www.python.org/" target="_blank"><img id="pythonImage" alt="Java Logo" src="/img/logoPython.png" /></a>
			</div>
			<div class="info">
				<p>
					<a href="http://projecteuler.net" target="_blank">Project Euler</a> is a website that lists 
					and allows members to submit solutions to mathematics problems that are designed in a computer 
					programming context; the use of mathematical knowledge and methods as well as the ability to use a programming 
					language effectively and in a mathematical way is necessary to answer the questions.  
					I've answered a bunch of these a few years ago, 
					using <a href="http://projecteuler.net" target="_blank">Project Euler</a> for one of the best reasons to use it: learning
					a new language.  This was back before I had picked JAVA as my favorite.  
					I used Python back then, and have posted my functions here...
				</p>
				<p>
					At least I'm going to.  I'm not doing anything with Python now so this is relatively unexciting to me.  Also
					I now have to deal with the issue of formatting the code here (I actually had it formatted via CSS to look like
					code in my last iteration of the site, which is really really annoying), and I want to find some nice pretty way
					of doing that.  Don't worry though, the content is incredibly unexciting unless you're both a Math AND a CS nerd. :)
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../../tags/navigation.jsp" />
</body>
</html>