<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>all locations</title>
</head>
<body>
	<table style="border:1px">
		<c:forEach items="${locations}" var="location">
		<br/>
			<td>${location.id }</td>
			<td>${location.code }</td>
			<td>${location.name}</td>
			<td>${location.type }</td>
			<td><a href="showCreate?id=${location.id }">edit</a></td>
			<td><a href="deleteLocation?id=${location.id }">delete</a></td>
		</c:forEach>
	</table>
	<a href="showCreate">add record</a>
</body>
</html>