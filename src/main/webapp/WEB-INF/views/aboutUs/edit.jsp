<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

					<c:url var="addAction" value="/nav"></c:url>
					<form role="form" modelAttribute="message" action="update/${id}?${_csrf.parameterName}=${_csrf.token}"
						method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="form-group">
								<label>Title Field</label> <input class="form-control"
									name="title" value="${aboutUs.title }"
									placeholder="title field">
							</div>
							<div class="form-group">
									<label>Details</label>
									<textarea class="form-control" rows="3" name="details" value="${aboutUs.title }"></textarea>
								</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />	
							<input type="submit" value="Add" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
