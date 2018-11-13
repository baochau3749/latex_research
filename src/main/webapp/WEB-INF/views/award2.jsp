<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello-Page</title>
</head>
<body>	
	<h2>Get Award Test</h2>
	<hr>
	
	<form:form method="POST" action="${pageContext.request.contextPath}/getAward">
		
		<%-- <c:if test="${account != null}">
			<input type="hidden" id="type" name="1" value="${id}"/>
			<input type="hidden" id="timeCreated" name="timeCreated" value="${account.timeCreated}"/>			
		</c:if>			    --%>
				
		<input type="hidden" name="type" value="2"/>	
		<p>Name: <input type="text" name="name" value=""/></p>
		<p>Date: <input type="text" name="date" value=""/></p>
		<p>Given By: <input type="text" name="awarder" value=""/></p>

		<input type="submit" value="Get Award"/>		
	</form:form>
	
</body>
</html>