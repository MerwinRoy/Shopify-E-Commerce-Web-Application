<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Orders</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shop-homepage.css">
</head>
<body style="background-color: beige">

   <jsp:include page="header-admin.jsp"/>
    <a href="${pageContext.request.contextPath}/user/login.htm">Admin Home</a><br></br>
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   Orders:
   <table border=1>
   	<tr>
   	    <th>Order ID</th>
   		<th>Customer Name</th>
   		<th>Customer Address</th>
   		<th>Price</th>
   		<th>Quantity</th>
   		
   	</tr>
   	<c:forEach items="${orderList}" var="list">
   	<tr>
   		    <td>${list.id}</td>
   			<td>${list.cname}</td>
   			<td>${list.caddress}</td>
   			<td>${list.tPrice}</td>
   			<td>${list.quantity}</td>
   			
   		
   	</tr>
   	</c:forEach>
   </table>
   
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>