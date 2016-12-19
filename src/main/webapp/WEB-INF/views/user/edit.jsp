<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="/WEB-INF/views/base/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Edit user's information</h1>
	</div>
</div>
<!--/.row-->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">User input fields</div>
			<div class="panel-body">
				<div class="col-md-6">
					<form role="form" modelAttribute="message" action="update/${id}" method="post">
						<fieldset>
							<div class="form-group">
								<input class="form-control" value="${user.name }" name="name" required
									type="text" autofocus="">
							</div>
							<div class="form-group">
								<div class="form-group">
									<input class="form-control" value="${user.username }" required
										name="username" type="text" autofocus="">
								</div>
								<input class="form-control" value="${user.email }" name="email" required
									type="email" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" value="${user.address }" name="address" required
									type="text" autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" value="${user.password }" required
									name="password" type="password" value="">
							</div>
								<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<input type="submit" value="Update" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
