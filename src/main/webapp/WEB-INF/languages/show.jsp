<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<title>Information for <c:out value="${language.name}" /></title>
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
					<div class="row p-2 justify-content-center">
						<div class="col-8">
							<div class="row justify-content-center border-bottom mb-4">
								<h2 class="text-start"><c:out value="${language.name}" /></h2>
							</div>
							<div class="row justify-content-start">
								<h5 class="text-start">Creator: <c:out value="${language.creator}" /></h5>
							</div>
							<div class="row justify-content-start mb-4">
								<h5 class="text-start">Current Version: <c:out value="${language.version}" /></h5>
							</div>
							<div class="row justify-content-center border-top pt-3">
								<div class="col-sm-6-offset-3 border-right px-5">
			            			<form action="/languages/<c:out value="${language.id}"/>" method="post">
			            				<input type="hidden" name="_method" value="delete">
    									<input type="submit" class="btn btn-link" value="delete">
			            			</form>
			            		</div>
			            		<div class="col-sm-6-offset-3 border-left px-5">
			            			<form action="/languages/edit/<c:out value="${language.id}"/>" method="get">
    									<input type="submit" class="btn btn-link" value="edit">
			            			</form>
			            		</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>