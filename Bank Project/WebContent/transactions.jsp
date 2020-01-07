<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	     
	    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	    
	  	
	  	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Navbar.jsp"/>
<div>
	<h4 style= "margin-top: 5%">Transactions</h4> <button>Print</button>
	<c:forEach items="${bank.getTransactionList()}" var="trans">	
			<div class="card" style="width:60vw">
			  <div class="card-body">
				  <ul class="list-group list-group-horizontal-sm">
					  <li class="list-group-item"><c:out value = "${trans.getaN()}"/></li>
					  <li class="list-group-item"><c:out value = "${trans.getNameCompany()}"/></li>
					  <li class="list-group-item"><c:out value = "${trans.getAmountTrans()}"/></li>
					  <li class="list-group-item"><c:out value = "${trans.getTransType()}"/></li>
					  <li class="list-group-item"><c:out value = "${trans.getDate()}"/></li>
					</ul>
			  </div>
			</div>
	</c:forEach>
</div>
<jsp:include page="bottomNavBar.jsp"/>
</body>
</html>