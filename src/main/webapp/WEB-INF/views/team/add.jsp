<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="/WEB-INF/views/base/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Upload slider</h1>
	</div>
</div>
<!--/.row-->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Slider upload</div>
			<c:if test="${!empty message}">
					${message}</c:if>
			<div class="panel-body">
				<div class="col-md-6">
					<form role="form" enctype="multipart/form-data"
					 action="addData?${_csrf.parameterName}=${_csrf.token}""
						method="post">
						<fieldset>
						
							<div class="form-group">
								<label>Name</label> <input class="form-control" name="name" required
									placeholder="Enter name">
							</div>
							
							<div class="form-group">
								<label>Post</label> <input class="form-control" name="post" required
									placeholder="Enter post">
							</div>
							
							<div class="form-group">
								<label>Image</label> <input type="file" name="image" required>
								<td style="color: red; font-style: italic;"><form:errors
										path="file" /></td>
							</div>
							
							<div class="form-group">
								<label>details</label> <input class="form-control" name="details" required
									placeholder="Enter details">
							</div>
							
							<div class="form-group">
								<label>fb_id</label> <input class="form-control" name="fb_id" 
									placeholder="Enter facebook id">
							</div>
							
							<div class="form-group">
								<label>twiter_id</label> <input class="form-control" name="twiter_id" 
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
