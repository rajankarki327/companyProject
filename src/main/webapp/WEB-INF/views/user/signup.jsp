<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forms</title>

<link href="<c:url value="/resources/user/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/user/css/datepicker3.css"/>"
	rel="stylesheet">
<link href="<c:url value="/resources/user/css/styles.css"/>"
	rel="stylesheet">

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>

	<div class="row">
		<div
			class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Signup</div>
				<div class="panel-body">

					<form role="form" action="signup" method="post" id="signup">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Full Name" name="name" required
									type="text" autofocus="">
							</div>
							<div class="form-group">
								<div class="form-group">
									<input class="form-control" placeholder="Username" required
										name="username" type="text" autofocus=""><c:if test="${!empty message1}">
					<p style="color: red">${message1}</p></c:if>
								</div>
								 <input class="form-control" placeholder="E-mail" name="email" required
									type="email" autofocus=""><c:if test="${!empty message}">
					<p style="color: red">${message}</p></c:if> 
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Address" name="address" required
									type="text" autofocus="">
							</div>
							 <div class="form-group">
								<input class="form-control" placeholder="Password" required
									name="password" type="password" value="">
							</div> 
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="submit" value="Signup" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->
	

	<%@include file="script.jsp"%>