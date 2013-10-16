<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<title>Homepage</title>
<jsp:include page="../tags/coreDependencies.jsp" />
<link rel="stylesheet" type="text/css" href="/css/custom/homepage.css" />
</head>
<body>
	<jsp:include page="../tags/navbar.jsp" />
	<jsp:include page="../tags/header.jsp" />
	<div id="wrapper" class="blue">
		<h1>
			Hi there,
		</h1>
	
		<p class="info">
			My name is Sully and I'm a JAVA engineer, specializing in making dynamic web applications for creating,
			editing, persisting, integrating, and/or converting data of various types.  Of course, 
			<span>
				<a href="http://www.springsource.org/" target="_blank">
					Spring Framework
				</a>
			</span> 
			is my favorite tool, along with Hibernate/JPA, JSR-303, JAX-B, XSTREAM, AWS (etc...)
			and I have now officially completely redone my site with a Spring back-end, as well as with
			<span>
				<a href="http://jqueryui.com/" target="_blank">
					jQuery UI
				</a>
			</span> 
			and
			<span>
				<a href="http://twitter.github.com/bootstrap/" target="_blank">
					Twitter Bootstrap
				</a>
			</span>
			's oh-so pretty base CSS.  I use my favorite hosting tool,
			<span>
				<a href="http://www.cloudbees.com/" target="_blank">
					Cloudbees
				</a>
			</span>
			to dynamically deploy this site using Jenkins whenever I commit to my Cloudbees-hosted repository.
		</p>
		
		<p class="info">
			If you don't understand all that nonsense, don't worry; there is some random fun stuff on this site besides all my
			nerdy development stuff.  Basically I just tried to use some of the coolest and newest technologies available
			to JAVA developers to make this site!
		</p>
		
		<p class="info">
			Enjoy what little there is, please, and feel free to sign my guestbook!
		</p>
		
		<p class="info">
			Sully
		</p>
	</div>
	<jsp:include page="../tags/navigation.jsp" />
</body>
</html>