<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "balance" value = "${bank.getLoggedInCustomer().getCheckingAccount().getBalance()}" />
	<c:set var = "sbalance" value = "${bank.getLoggedInCustomer().getSavingAccount().getBalance()}" />
	<jsp:include page="Navbar.jsp"/>
	<div style= "margin-top: 5%">
		<h6>Checking balance: <fmt:formatNumber value = "${balance}" type = "currency"/></h6>
		<form class="form-inline" action="TransferServlet" >
			<input type="text" class="form-control mr-sm-2" name="amount" placeholder="Amount">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="checking" value= "true">Transfer to Savings</button>
		</form>
		<h6>Saving balance: <fmt:formatNumber value = "${sbalance}" type = "currency"/></h6>
		<form class="form-inline" action="TransferServlet" >
			<input type="text" class="form-control mr-sm-2" name="amount" placeholder="Amount">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="checking" value= "false">Transfer to Checkings</button>
		</form>
	</div>
	<jsp:include page="bottomNavBar.jsp"/>
</body>
</html>