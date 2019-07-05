<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register-form</title>
	<style type="text/css">
	table{
		border: 2px solid blue;
	}
	tr{
		color: red;
		padding: 5px;
		margin: 5px;
		background-color:#33FF8D;
		text-align: center;
		text-decoration: none;
	}
	th{
		background-color: dodgerBlue;
	}
	
	</style>
</head>
<body>
	<h2 class="text-center">Product Table</h2>
	<c:if test='${!empty list}'>	
	<table>
		<tr>
		<th>PId</th>	
		<th>PCode</th>
		<th>PName</th>
		<th>PCost</th>
		<th>pGst</th>
		<th>Description</th>
		<th colspan="2">Operations</th>	
		</tr>
	<c:forEach items='${list}' var="list">
		<tr>
			<td><c:out value="${list.id}" /> </td>	
			<td><c:out value="${list.code}" /> </td>
			<td><c:out value="${list.name}" /> </td>
			<td><c:out value="${list.cost}" /> </td>
			<td><c:out value="${list.gst}" /> </td>
			<td><c:out value="${list.note}" /> </td>
			<td><a href='delete?id=${list.id}'>DELETE&ensp; |</a> </td>
			<td> <a href='edit?id=${list.id}'>EDIT</a></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>
</body>
</html>