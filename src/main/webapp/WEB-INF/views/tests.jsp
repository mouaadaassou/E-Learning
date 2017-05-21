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