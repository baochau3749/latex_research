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
	<h2>Hello World</h2>
	<hr>
	
	<p><h4>Latex Folder: ${latexFolder}</h4></p>
	<p><h4>Pdf Document: ${pdfDoc}</h4></p>
	
	<p><h4>Pdf link: <a href="${pdfDoc}">Pdf Document Link</a></h4></p>
	<hr>
	
	<c:url var="updateLink" value="${pageContect.request.contextPath}/hello.pdf" />
	<a href="${updateLink}">Pdf Document Link</a>

	
</body>
</html>