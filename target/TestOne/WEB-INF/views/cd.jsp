<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>
<html>
<head>
	<title>cd command line test</title>
	<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"  />
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Linux Evaluation</h1>
			<p>This is a System Administration Evaluation : </p>
		</div>
		<p>Change the current directory to the ~/PFA_Desktop</p>
	</div>
	<div class="container">
		<form:form action="cd" method="POST" commandName="page">
			<div class="form-group">
				<label for="command">your Answer : </label>
				<form:textarea path="command" class="form-control" rows="5"
					id="command"></form:textarea>
					<br><br>
				<button type="submit" class="btn btn-primary">OK</button>
			</div>
			<p>${message}</p>
		</form:form>
	</div>
</body>
</html>