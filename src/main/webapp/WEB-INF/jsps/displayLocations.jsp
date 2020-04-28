<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2>All locations</h2>
	<table>

		<tr>
			<th>Id</th>
			<th>Code</th>
			<th>Name</th>
			<th>Type</th>
		</tr>


		<c:forEach items="${locations}" var="locations">
			<tr>
				<td>${locations.id}</td>
				<td>${locations.code}</td>
				<td>${locations.name}</td>
				<td>${locations.type}</td>
				  <td><a href="editLocation?id=${locations.id}">Edit</td>
                <td><a href="deleteLocation?id=${locations.id}">Delete</td>

			</tr>


		</c:forEach>



	</table>

<a href="showCreate">Add Location</a>

</body>
</html>