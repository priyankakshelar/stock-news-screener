<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stock News Search</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>

<body>
<div class="container">
<h1>Search Stock News</h1>
<hr>
<form:form method="POST" commandName="stock" action="search-news">
<div class="form-group">
<label for="stock">Stock</label>
<form:select id="stock" class="form-control" path="selectedStock">
<form:option value="-" label="--Select stock"/>
<form:options items="${stockOptions}" />
</form:select>
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
</body>
</html>
