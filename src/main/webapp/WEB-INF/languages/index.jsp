<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- To use form binding -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<title>Languages</title>
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-dark bg-success">
				<span class="navbar-brand mb-0 h1">Languages</span>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavDropdown">
					<ul class="navbar-nav">
						<li class="nav-item active">
							<a class="nav-link" href="/languages">Home <span class="sr-only">(current)</span></a>
						</li>      
					</ul>
				</div>
			</nav>
			<div class="row">
				<div class="col p-4">
					<c:if test="${not empty languages}" >
						<div class="row p-2 justify-content-center">
							<div class="col-8">
								<div class="row justify-content-center mb-2">
									<h1 class="text-center">List of Languages</h1>
								</div>
								<div class="row">
							        <table class="table">
							        	<thead>
							        		<tr>
								        		<th scope="col">Name</th>
								        		<th scope="col">Creator</th>
								        		<th scope="col">Version</th>
								        		<th scope="col">Actions</th>
								        	</tr>					        		
							        	</thead>
							        	<c:forEach items="${languages}" var="language">								    
									        <tr>
									            <td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
									            <td><c:out value="${language.creator}"/></td>
									            <td><c:out value="${language.version}"/></td>
									            <td>
									            	<div class="row">
									            		<div class="col-sm-6 border-right">
									            			<form action="/languages/<c:out value="${language.id}"/>" method="post">
									            				<input type="hidden" name="_method" value="delete">
						    									<input type="submit" class="btn btn-link" value="delete">
									            			</form>
									            		</div>
									            		<div class="col-sm-6 border-left">
									            			<form action="/languages/edit/<c:out value="${language.id}"/>" method="get">
						    									<input type="submit" class="btn btn-link" value="edit">
									            			</form>
									            		</div>
									            	</div>
									            </td>
									        </tr>
							        	</c:forEach>
							        </table>
								</div>
							</div>
				        </div>
					</c:if>
					<div class="row p-2 justify-content-center">
						<div class="col">
							<div class="row justify-content-center mb-4">
								<h2 class="text-center">New Language</h2>
							</div>
							<div class="row justify-content-center">
								<div class="col-4 p-2">
									<form:form action="/languages" method="post" modelAttribute="language">
										<div class="row justify-content-start">
											<div class="col-6">
										        <form:label path="name">Name</form:label>
										        <p class="text-danger"><form:errors path="name"/></p>
									        </div>
									        <div class="col-6">
									        	<form:input path="name"/>
									        </div>
										</div>
										<div class="row justify-content-start">
											<div class="col-6">
										        <form:label path="creator">Creator</form:label>
										        <p class="text-danger"><form:errors path="creator"/></p>
										    </div>
									        <div class="col-6">  
									        	<form:input path="creator"/>
											</div>
										</div>
										<div class="row justify-content-start">
											<div class="col-6">
									        	<form:label path="version">Version</form:label>
									        	<p class="text-danger"><form:errors path="version"/></p>
									        </div>
									        <div class="col-6">  
									        	<form:input path="version"/>
									        </div>
										</div>
										<div class="row justify-content-end">
											<div class="col-2-offset-5">
									    		<input type="submit" value="Submit" class="btn btn-success"/>
									    	</div>
									    </div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>