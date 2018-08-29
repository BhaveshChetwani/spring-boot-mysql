<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Location</title>
</head>
<body>
	<form action="saveLocation" method="post">
		<pre>
		Id: <input type="text" name="id"
				<c:if test="${location ne null && location.id ne null}">value="${location.id }" readonly="true"</c:if> />
		Code: <input type="text" name="code"
				<c:if test="${location ne null && location.code ne null}">value="${location.code }"</c:if> />
		Name: <input type="text" name="name"
				<c:if test="${location ne null && location.name ne null}">value="${location.name }"</c:if> />
		Type: Urban<input type="radio" name="type" value="URBAN"
				<c:if test="${location ne null && location.type ne null && location.type eq 'URBAN'}">selected="selected"</c:if> />
		Rural<input type="radio" name="type" value="RURAL"
				<c:if test="${location ne null && location.type ne null && location.type eq 'RURAL'}">value="RURAL"</c:if> />
		<input type="submit" value="save" />
		</pre>
	</form>
	${msg}
	<a href="displayAll">display all records</a>
</body>
</html>