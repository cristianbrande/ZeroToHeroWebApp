<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="includes/admin-head.jsp" />
<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value="/admin/"/>">Zero To Hero</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/admin/list/"/>">Lista utilizatori</a></li>
					<li><a href="<c:url value="/admin/listRole/"/>">Lista roluri</a></li>
					<li><a href="<c:url value="/j_spring_security_logout"/>">Iesire</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
				<legend>Adaugare rol</legend>
				<form class="form-horizontal" method="post" action="<c:url value="/admin/saveRole/" />" name="roleForm" id="roleForm">
					<div class="control-group">
						<label class="control-label">Nume</label>
						<div class="controls">
							<input type="text" name="name" id="name" title="name" value="${role.name}">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Tip rol</label>
						<div class="controls">
							<input type="text" name="authority" id="authority" title="authority" value="${role.authority}">
						</div>
					</div>
					<input type="hidden" name="roleId" id="roleId" title="roleId" value="${role.roleId}">
					<div class="form-actions">
						<button type="submit" class="btn btn-success">Salveaza</button>
					</div>
				</form>
				</fieldset>
			</div>
		</div>
	</div>		
</body>
</html>