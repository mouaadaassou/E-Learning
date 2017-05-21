<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <title>E-Linux</title>
</head>
<body>
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
  <!-- <section>
    <div class="jumbotron">
      <div class="container">
        <h1>E-Linux</h1>
        <p>Welcome to the E-Linux Platform</p>
      </div>
    </div>
  </section> -->

  <section class="container">
    <div class="row">
      <div class="col-sm-6 col-md-6" style="padding-bottom: 15px ;margin-top: 150px">
        <div class="thumbnail">
          <div class="caption">
            <h3>Test</h3>
            <p>choose this if you wanna test your linux knowledge</p>
            <a href="<c:url value="/Linux/Test"/>"><button type="button" name="button" class="btn btn-primary">Go to it</button></a>
          </div>
        </div>
      </div>
      <div class="col-sm-6 col-md-6" style="padding-bottom: 15px;margin-top: 150px">
        <div class="thumbnail">
          <div class="caption">
            <h3>Evaluation</h3>
            <p>choose this if you wanna pass an Evaluation</p>
            <a href="<c:url value="/Linux/Evaluation"/>"><button type="button" name="button" class="btn btn-primary">Go to it</button></a>
          </div>
        </div>
      </div>
    </section>
</body>
</html>
    