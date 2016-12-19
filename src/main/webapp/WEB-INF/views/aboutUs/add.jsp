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
			<div class="panel-heading">Nav field</div>
			<c:if test="${!empty message}">
					${message}</c:if>
			<div class="panel-body">
				<div class="col-md-6">
					<form role="form" enctype="multipart/form-data" action="add?${_csrf.parameterName}=${_csrf.token}"
						method="post">
						<fieldset>
							<div class="form-group">
								<label>Title</label> <input class="form-control" name="title" required="required"
									placeholder="Enter title">
							</div>
							<div class="form-group">
									<label>Details</label>
									<textarea class="form-control" rows="3" name="details" required="required"></textarea>
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
