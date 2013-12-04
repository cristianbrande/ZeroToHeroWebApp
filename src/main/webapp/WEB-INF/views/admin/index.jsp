<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Hello Admin</h2>
	<p>${message}</p>

	<table>
		<thead>
			<th>Nume</th>
			<th>Prenume</th>
		</thead>
		<c:forEach var="admin" varStatus="status" items="${adminList}">
			<tr>
				<td>${admin.lastName}</td>
				<td>${admin.firstName}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
