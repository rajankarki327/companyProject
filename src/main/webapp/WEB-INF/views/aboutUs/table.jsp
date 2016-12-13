<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="/WEB-INF/views/base/header.jsp"%>



	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">AboutUs field</h1>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<!-- Advanced Tables -->
			<div class="panel panel-default">
				<div class="panel-heading"><a href="add">Add AboutUs Field</a></div>
				<p id="true"><c:if test="${!empty message}">
					${message}</p></c:if>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover"
							id="dataTables-example">
							<thead>
								<tr>
									<th>ID</th>
									<th>Title</th>
									<th>Details</th>
									<th>Edit</th>
									<th>Delete</th>
								</tr>
							</thead>
								<c:forEach items="${aboutUs}" var="aboutUs">
							<tr class="odd gradeX">
								<td class="center">${aboutUs.id }</td>
								<td class="center">${aboutUs.title }</td>
								<td class="center">${aboutUs.details }</td>
								<td class="breadcrumb"><a href="<c:url value='/about-us/edit/${aboutUs.id}'/>"></svg> <svg
											class="glyph stroked pencil">
											<use xlink:href="#stroked-pencil" /></svg></a></td>
								<td class="breadcrumb"><a href="<c:url value='/about-us/delete/${aboutUs.id}'/>"
									id="a18"
									onclick="return confirm('Are you sure you want to delete this item?');"><svg class="glyph stroked trash"><use xlink:href="#stroked-trash"/></svg></a></td>
							</tr>
							</c:forEach>
						</table>
					</div>

				</div>
			</div>
			<!--End Advanced Tables -->