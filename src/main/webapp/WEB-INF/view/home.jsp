<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	welcome
	<sec:authentication property="principal.username"/>
	<sec:authentication property="principal.authorities"/>
	
	
	<sec:authorize access="hasRole('ma')">
	<a href="${pageContext.request.contextPath}/parents">parent Page</a>
	</sec:authorize>
	
	<sec:authorize access="hasRole('son')">
	<a href="${pageContext.request.contextPath}/childrens"> Son Page</a>
	</sec:authorize>
	
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>