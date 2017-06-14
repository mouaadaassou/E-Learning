<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>E-Linux</title>
</head>
<body>
	<!--  the navigation bar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/home"/>">E-Linux</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/home"/>">Home</a></li>
				<li><a href="<c:url value="/Linux/Test"/>">Test</a></li>
				<li><a href="<c:url value="/Linux/Evaluation"/>">Evaluations</a></li>
			</ul>
		</div>
	</nav>
	<!-- end of the navigation bar -->
	<section class="container">
		<div class="row">
			<c:forEach var="exercice" items="${exercices}">
				<div class="col-sm-6 col-md-6"
					style="padding-bottom: 15px; margin-top: 150px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${ exercice } </h3>
							<p>choose this if you wanna pass the ${exercice} exercice</p>
							<a href="<c:url value="/Linux/Evaluation/${exercice}"/>"><button
									type="button" name="button" class="btn btn-primary">Go
									to it</button></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>