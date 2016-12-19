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
					<form role="form" action="update/${id}?${_csrf.parameterName}=${_csrf.token}"
						method="post"enctype="multipart/form-data">
						<fieldset>
						
							<div class="form-group">
								<label>Name</label> <input class="form-control" name="name"value="${team.name }" required
									placeholder="Enter name">
							</div>
							
							<div class="form-group">
								<label>Post</label> <input class="form-control" name="post"value="${team.post }" required
									placeholder="Enter post">
							</div>
							
							<div class="form-group">
								<label>Image</label> <input type="file" name="image">value="${team.image }" required
								<td style="color: red; font-style: italic;">
								<img src="<c:url value="/resources/uploads/${team.image }"/>" style="height: 100px;width: 100px;">
							</div>
							
							<div class="form-group">
								<label>details</label> <input class="form-control" name="details"value="${team.details }" required
									placeholder="Enter details">
							</div>
							
							<div class="form-group">
								<label>fb_id</label> <input class="form-control" name="fb_id"value="${team.fb_id }"
									placeholder="Enter facebook id">
							</div>
							
							<div class="form-group">
								<label>twiter_id</label> <input class="form-control" name="twiter_id"value="${team.twiter_id }"
									placeholder="Enter twiter id">
							</div>
													
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<input type="submit" value="submit" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
