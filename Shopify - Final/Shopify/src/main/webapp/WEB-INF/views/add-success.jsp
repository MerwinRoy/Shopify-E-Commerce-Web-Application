<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products Added</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">

</head>
<body style="background-color: beige">

<jsp:include page="header.jsp" />
 <a href="${pageContext.request.contextPath}/clearCart.htm">Go Back To Home!</a>
 <br>
 </br>
 
  <a href="${pageContext.request.contextPath}/addProducts.htm">Back to Add Products</a>
 
<div class="page-title">Order Success</div>
  
   <div class="container">
       <h3>Product has been added successfully!</h3>
   </div>
 

</body>

</html>