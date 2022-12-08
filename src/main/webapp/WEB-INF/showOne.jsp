<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense</title>
</head>
<body>
	<h1> Expense: <c:out value="${oneExpense.expense}"/> </h1>
	<h4> Vendor: <c:out value="${oneExpense.vendor}"/> </h4>
	<h4> Amount: <c:out value="${oneExpense.amount}"/> </h4>
	<h4> Description: <c:out value="${oneExpense.description}"/></h4>
</body>
</html>