<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Stock News Search</title>
</head>
<body>

<form:form method="POST" commandName="stock" action="search-news">
<table>
    <tr>
    <td>
        <ul>
            <form:select path="selectedStock">
                <form:option value="-" label="--Select stock"/>
                <form:options items="${stockOptions}" />
            </form:select>
        </ul>
    </td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>
</form:form>

</body>
</html>
