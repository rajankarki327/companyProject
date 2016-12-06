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
					<form role="form" modelAttribute="message" action="update/${id}"
						method="post"enctype="multipart/form-data">
						<fieldset>
							<div class="form-group">
								<label>Nav Field</label> <input class="form-control" name="navField"value="${nav.navField }"
									placeholder="Edit Nav field name">
							</div>

							<input type="submit" value="Slider Update" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
