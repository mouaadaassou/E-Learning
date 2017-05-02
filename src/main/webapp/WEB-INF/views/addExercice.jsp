<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script src="<c:url value='/static/js/exercice.js' />"></script>
    <title>Exercice GUI</title>
  </head>
  <body ng-app="mainApp">
    <div class="jumbotron text-center">
      <h1>Exercice GUI</h1>
      <p>Add an Exercice</p>
    </div>
    <form:form action="addExercice" method="POST" commandName="exercice">
		<div class="container" ng-controller="ExerciceController as ctr">
      <button type="button" ng-click="ctr.addQuestion();" class="btn btn-primary">Add Question</button>
      <br><br>
      <div class="form-group">
        <label for="exerciceName">Exercice Name :</label>
      	<form:input type="text" path="exerciceName" class="form-control" id="exerciceName"/>
      </div>
      <div class="container" ng-repeat="index in ctr.exe">
      <% int i = 0; %>
      <% System.out.println(i); %>
        <div class="container">
          <div class="form-group">
            <label for="question{{index}}">Qustion {{index}}:</label>
            <form:input path="questions" type="text"  class="form-control" id="question{{index}}"/>
          </div>
          <div class="form-group">
            <label for="answer{{index}}">Answer {{index}}:</label>
            <form:input type="text" path="answers" class="form-control" id="answer{{index}}"/>
          </div>
        </div>
        <button type="button" ng-click="ctr.removeQuestion();" class="btn btn-danger">Remove Question</button>
        <br><br>
      <!-- </div>
      <input type="text" value="{{ctr.itemNumber}}"/>-->
      </div>
      <button type="submit" class="btn btn-primary">OK</button>		
	</form:form>
  </body>
</html>
