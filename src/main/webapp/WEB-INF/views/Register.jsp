<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register-form</title>
	<style type="text/css">
		.app{
			text-align: center;
			border: 2px solid gray;
			border-radius: 10px;
			background-color: lightyellow;
			font-weight: bold;
			color: blue;
			width:220px;
			margin-left: 15px;
		}	
	</style>
</head>
<body>
	<h2 style="background-color: lime; text-align: center; color:orange;">Product Register!!</h2>
	
	<div class="app" align="center">
		<form:form action="save" method="POST" modelAttribute="product" enctype="multipart/form-data">
			<c:if test="${'EDIT' eq mode}">
			<label>Enter Product Id:</label><br>
			<form:input path="id" readonly="true"/><br>	
			</c:if>
		<label>Enter Product Code:</label><br>
		<form:input path="code" /><br>
		<label>Enter Product Name:</label><br>
		<form:input path="name" /><br>
		<label>Enter Product Cost:</label><br>
		<form:input path="cost" /><br>
		<label>Enter Email ID</label><br>
		<form:input path="pEmail"/><br>
		<label>Choose File</label><br>
		<input type="file" name="fileOb"/><br>
		<label>Select Gst:</label><br>
		<form:select path="gst" ><br>
			<form:option value="5">5%-SLAB</form:option>
			<form:option value="12">12%-SLAB</form:option>
			<form:option value="12">18%-SLAB</form:option>
			<form:option value="22">22%-SLAB</form:option>
			<form:option value="28">28%-SLAB</form:option>
		</form:select><br>
		<label>Enter Product Description:</label><br>
		<form:textarea path="note"/><br>
		<c:choose>
		<c:when test="${'EDIT' eq mode} ">
		<input type="submit" value="Update-Product" />
		</c:when>
		<c:otherwise>
		<input type="submit" value="Register-Product" />
		</c:otherwise>
		</c:choose>
		<input type="reset" value="Reset"/>
		</form:form>
		</div>
	<font color="green" size=6> ${msg} </font><br>
	<a style="text-align: center;text-decoration: none;" href="show">Get All Product Table </a>
		
</body>
</html>