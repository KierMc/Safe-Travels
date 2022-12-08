<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
	<form:form action="/expenses/edit/${oneExpense.id}" method="post" modelAttribute="oneExpense">
		<input type="hidden" name="_method" value="put">
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
			<form:input type="number" path="amount" class="form-control"/>
			<form:errors class="text-danger" path="amount"/>
		</div>
		<div class="form-group">	
			<form:label path="description">Description: </form:label>
			<form:input type="text" path="description" class="form-control"/>
			<form:errors class="text-danger" path="description"/>
		</div>
		<button type="submit" class="btn btn-primary">Edit Expense</button>
	</form:form>
</body>
</html>