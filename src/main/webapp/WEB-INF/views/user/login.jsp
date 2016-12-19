<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Forms</title>

<link href="<c:url value="/resources/user/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/user/css/datepicker3.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/user/css/styles.css"/>" rel="stylesheet">

</head>

<body>
	
	<div class="row">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Log in</div>
				<p id="true"><c:if test="${!empty message}">
					${message}</p></c:if>
					<p id="false"><c:if test="${!empty msg}">
					${msg}</p></c:if>
				<div class="panel-body">				
					<form role="form" method="post" action="<c:url value='/j_spring_security_check' />">
						<fieldset>
							<div class="form-group">
								<input class="form-control" placeholder="Username" name="username" type="text"  autofocus="">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="password" type="password" value="">
							</div>
							<div class="checkbox">
								<label>
									<input name="remember" type="checkbox" value="Remember Me">Remember Me
								</label>
							</div>
							<input type="submit" value="Login"/><br/><br/>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<p>Not yet member, <a href="signup">Register here</a></p>
						</fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->
		
	
<%@include file="script.jsp"%>