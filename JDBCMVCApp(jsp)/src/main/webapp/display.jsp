<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result page</title>
</head>
<body bgcolor="lightblue">
	<br />
	<br />
	<br />
	<center>
		<c:set var="student" value="${requestScope.student}" />
		<c:choose>
			<c:when test="${student ne null }">
				<table border="1">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>City</th>
						<th>Country</th>
					</tr>
					<tr>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.email}</td>
						<td>${student.city}</td>
						<td>${student.country}</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${student eq null }">
				<h1 style="color: red; text-align: center;">Record not found</h1>
			</c:when>
		</c:choose>
	</center>
</body>
</html>