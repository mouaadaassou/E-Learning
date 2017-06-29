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
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script src="<c:url value='/static/js/exercice.js' />"></script>
<title>Exercice GUI</title>
</head>
<body ng-app="mainApp">
	<!-- the navigation bar -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value="/home"/>">E-Linux</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/home"/>">Home</a></li>
				<li><a href="<c:url value="/Linux/Test"/>">Tests</a></li>
				<li><a href="<c:url value="/Linux/Evaluation"/>">Evaluations</a></li>
				<li><a href="<c:url value="/Linux/addTest"/>">add a Test</a></li>
				<li><a href="<c:url value="/addExo"/>">add an Evaluation</a></li>
			</ul>
		</div>
	</nav>
	<!-- end of navigation bar -->
	<div class="jumbotron text-center">
		<h1>Exercice GUI</h1>
		<p>Add an Exercice</p>
	</div>
	<form:form action="addTest" method="POST" commandName="test">
		<div class="container" ng-controller="ExerciceController as ctr">
			<!-- <button type="button" ng-click="ctr.addQuestion();"
				class="btn btn-primary">Add Question</button>-->
			<br> <br>
			<div class="form-group">
				<label for="exerciceName">Test Name :</label>
				<form:input type="text" path="name" class="form-control"
					id="exerciceName" />
			</div>
			<div class="container" ng-repeat="index in ctr.exe">
				<div class="container">
					<div class="form-group">
						<label for="question{{index}}">Qustion {{index}}:</label>
						<form:input path="question" type="text" class="form-control"
							id="question{{index}}" />
					</div>
					<div class="form-group">
						<label for="answer{{index}}">Answer {{index}}:</label>
						<form:input type="text" path="answer" class="form-control"
							id="answer{{index}}" />
					</div>
				</div>
				<!-- <button type="button" ng-click="ctr.removeQuestion();"
					class="btn btn-danger">Remove Question</button> -->
				<br> <br>
				<!-- </div>
      <input type="text" value="{{ctr.itemNumber}}"/>-->
			</div>
			<button type="submit" class="btn btn-primary">OK</button>
	</form:form>
</body>
</html>
