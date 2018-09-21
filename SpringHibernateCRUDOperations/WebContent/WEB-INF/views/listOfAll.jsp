<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${not empty user_list}">

	<table border="1">
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Age</th>
	</tr>
	

			<c:forEach var="listValue" items="${user_list}">
			<tr>
			<td>${listValue.id}</td>
			<td>${listValue.name}</td>
			<td>${listValue.age}</td>
			<td><a href="/SpringHibernateCRUDOperations/deleteUserByID?id=${listValue.id}">Delete</a></td>
			<td><a href="/SpringHibernateCRUDOperations/updateUserByID?id=${listValue.id}">Update</a></td>
			<tr>
				
			</c:forEach>
		
	</table>
	</c:if>
	
	<c:if test="${empty user_list }">
	
	<h2>No Users Found</h2>
	</c:if>
	<br>
	<a href="/SpringHibernateCRUDOperations/home">Add User</a>
</body>
</html>