<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Hello Employee</h2>
	<p>${message}</p>

	<table>
		<thead>
			<th>Nume</th>
			<th>Prenume</th>
		</thead>
		<c:forEach var="employee" varStatus="status" items="${employeeList}">
			<tr>
				<td>${employee.lastName}</td>
				<td>${employee.firstName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
