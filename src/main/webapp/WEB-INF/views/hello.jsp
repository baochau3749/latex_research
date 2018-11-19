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
	
	
	<c:url var="updateLink4" value="${pageContect.request.contextPath}/my_text.txt" />
	<a href="${updateLink4}">my_text.txt</a>
	
	<%-- <p><h4>Latex Folder: ${latexFolder}</h4></p>
	<p><h4>Pdf Document: ${pdfDoc}</h4></p>
	
	<p><h4>Pdf link: <a href="${pdfDoc}">Pdf Document Link</a></h4></p>
	<hr>

	
	<c:url var="updateLink" value="${pageContect.request.contextPath}/hello.pdf" />
	<a href="${updateLink}">hello</a>

	<br>
	<c:url var="updateLink2" value="${pageContect.request.contextPath}/hello_in_latex_files.pdf" />
	<a href="${updateLink2}">hello_in_latex_files</a>
	
	<br>
	<c:url var="updateLink3" value="${pageContect.request.contextPath}/document_2.pdf" />
	<a href="${updateLink3}">document_2</a>
	
	<br>
	<p><h4>Content: ${content}</h4></p>
	<c:url var="updateLink4" value="${pageContect.request.contextPath}/my_text.txt" />
	<a href="${updateLink4}">my_text.txt</a>
	
	<br>
	<c:url var="updateLink5" value="${pageContect.request.contextPath}/latex_files/sample.pdf" />
	<a href="${updateLink5}">sample</a> --%>
	
	<h2>Get Award Test</h2>
	<hr>
	
	<%-- <form:form method="POST" action="${pageContext.request.contextPath}/getAward">
		
		<c:if test="${account != null}">
			<input type="hidden" id="id" name="id" value="${id}"/>
			<input type="hidden" id="timeCreated" name="timeCreated" value="${account.timeCreated}"/>			
		</c:if>			   
				
		<p>Name: <input type="text" name="name" value=""/></p>
		<p>Date: <input type="text" name="date" value=""/></p>
		<p>Given By: <input type="text" name="awarder" value=""/></p>

		<input type="submit" value="Get Award"/>		
	</form:form> --%>
	
</body>
</html>