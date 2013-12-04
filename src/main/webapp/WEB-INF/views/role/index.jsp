<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Roles</h2>
	<p>${message}</p>

	<table>
		<thead>
			<th>Name</th>
			<th>Index</th>
		</thead>
		<c:forEach var="rol" varStatus="status" items="${roleList}">
			<tr>
				<td>${rol.getName()}</td>
				<td>${rol.getIndex()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
