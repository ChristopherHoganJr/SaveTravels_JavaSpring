<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="container text-center">
	<h1 class="text-start">Save Travels</h1>
	<hr />

	<table class="table text-center">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Expense</th>
				<th scope="col">Vendor</th>
				<th scope="col">Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${allExpenses}">
				<tr>
					<th><c:out value="${expense.expense}" /></th>
					<td><c:out value="${expense.vendor}" /></td>
					<td>$<c:out value="${expense.amount}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p></p>
	
	<hr />
	<h2>Add an expense:</h2>
	<!-- Create Expense -->
	<form:form action="/expenses" method="post" modelAttribute="expenses">
		<p>
			<form:label path="expense">Expense Name:</form:label>
			<form:errors path="expense" />
			<form:input path="expense" />
		</p>
		<p>
			<form:label path="vendor">Vendor:</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">Amount:</form:label>
			<form:errors path="amount" />
			<form:input type="number" path="amount" />
		</p>
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>
