<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body style="background-color: beige">
   <jsp:include page="header.jsp" />
 <a href="${pageContext.request.contextPath}/viewOrders.htm">
      Back to Orders   </a><br></br>
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
   Product Details:
   <table border=1>
   	<tr>
   		<th>Product Code</th>
   		<th>Product  Name</th>
   		<th>Price</th>
   		<th>Quantity</th>
   		
   	</tr>
   	<c:forEach items="${productList}" var="product">
   	<tr>
   		
   			<td>${product.prodID}</td>
   			<td>${product.prodName}</td>
   			<td>${product.prodPrice}</td>
   			<td>${product.prodQuantity}</td>
   	</tr>
   	</c:forEach>
   </table>
  
</body>
</html>