<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News Result</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" int
</head>
<body>
<div class="container">
<h1>News [${newsSearch.getSelectedStock()}]</h1>
<hr>
    <ul class="list-group">
        <c:forEach items="${newsList}" var="news">
            <li class="list-group-item"> ${news.title} </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
