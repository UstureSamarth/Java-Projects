<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>result page</title>
</head>
<body bgcolor="lightyellow">
	<br />
	<br />
	<br />
	<center>
		<c:set var="result" value="${applicationScope.delete}" />
		<c:choose>
			<c:when test="${result eq 'success'}">
				<h1 style="color: green; text-align: center;">Deletion
					operation successful</h1>
			</c:when>
			<c:when test="${result eq 'not found'}">
				<h1 style="color: red; text-align: center;">Record not found</h1>
			</c:when>
			<c:when test="${result eq 'failure'}">
				<h1 style="color: red; text-align: center;">Deletion operation
					failed</h1>
			</c:when>
		</c:choose>
	</center>
</body>
</html>