<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
	    <meta name="description" content="">
	    <meta name="author" content="">
	     <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/carousel/">
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    
	  	<link rel="stylesheet" href="C:\Users\CGada\eclipse-workspace\Bank Project\WebContent\Styles\stylesheet.css">
	  
	  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="collapse navbar-collapse">
	  <ul class="navbar-nav mr-auto">
	  	<li class="nav-item">
		  <a class="navbar-brand" href="home.jsp">Home</a>
		</li>
		<li class="nav-item">
			<a class="navbar-brand" href="index.jsp">LogInPage</a>
		</li>
		<li class="nav-item"> 
		  <form class="form-inline" action="SigninServlet" method="POST" >
			<input type="email" class="form-control mr-sm-2" name="email" placeholder="Email">
			<input type="password" class="form-control mr-sm-2" name="password" placeholder="Password">
		    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign In</button>
		  </form>
		</li>
	  </ul>
  </div>
</nav>
</body>
</html>