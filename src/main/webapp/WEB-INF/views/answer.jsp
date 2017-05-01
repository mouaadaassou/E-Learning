<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<html>
<head>
	<title>cat command line test</title>
	<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"  />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Linux Evaluation</h1>
			<p>This is a System Administration Evaluation : </p>
			<h2>your answers are : ${ param['message'] }</h2>
		</div>
	</div>
	<div class="container">
		<form:form action="answer" method="POST" commandName="answer">
			<c:forEach items="${length}" var="i">
				<div class="form-group">
					<label for="command"> ${ question.get(i)} : </label>
					<form:textarea path="answers[${i}]" class="form-control" rows="2"
						id="command"></form:textarea>
						<br><br>
				</div>
			</c:forEach>
			<button type="submit" class="btn btn-primary">OK</button>
		</form:form>
	</div>
</body>
</html>