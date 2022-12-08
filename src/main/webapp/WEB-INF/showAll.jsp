<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Expenses</title>
</head>
<body>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col"> Expense </th>
				<th scope="col"> Vendor </th>
				<th scope="col"> Amount </th>
				<th scope="col"> Action </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<td><a href="/expenses/one/${expense.id}"><c:out value="${expense.expense}"/></a></td>
					<td><c:out value="${expense.vendor}"/></td>
					<td>${expense.amount}</td>
					<td>
						<form action="/expenses/edit/${expense.id}">
						    <input type="hidden" name="_method" value="edit">
						    <input type="submit" value="Edit" class="btn btn-warning">
						</form>
						<br/>
						<form action="/expenses/delete/${expense.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form:form action="/expenses/process" method="post" modelAttribute="oneExpense">
		<div class="form-group">	
			<form:label path="expense">Expense: </form:label>
			<form:input type="text" path="expense" class="form-control"/>
			<form:errors class="text-danger" path="expense"/>
		</div>
		<div class="form-group">	
			<form:label path="vendor">Vendor: </form:label>
			<form:input type="text" path="vendor" class="form-control"/>
			<form:errors class="text-danger" path="vendor"/>
		</div>
		<div class="form-group">	
			<form:label path="amount">Amount</form:label>
			<form:input type="number" path="amount" class="form-control" step="0.01"/>
			<form:errors class="text-danger" path="amount"/>
		</div>
		<div class="form-group">	
			<form:label path="description">Description: </form:label>
			<form:input type="text" path="description" class="form-control"/>
			<form:errors class="text-danger" path="description"/>
		</div>
		<button type="submit" class="btn btn-primary">Add Expense</button>
	</form:form>
</body>
</html>