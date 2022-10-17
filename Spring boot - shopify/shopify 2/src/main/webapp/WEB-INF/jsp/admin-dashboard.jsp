<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shop-homepage.css">
<title>Admin dashboard</title>
</head>
<body style="background-color: beige">
  <jsp:include page="header-admin.jsp"/>
   <jsp:include page="common.jsp" />
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form action="${contextPath}/addProduct.htm" method="POST">
        <table>
        <tr>
            <td>Product Name:</td>
            <td><input type="text" name="prodName" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>Product Details:</td>
            <td><input type="text" name="prodDetails" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>Product Price:</td>
            <td><input type="text" name="prodPrice" size="30" required="required" /></td>
        </tr> 
        <tr>
            <td>Product Quantity:</td>
            <td><input type="text" name="prodQuantity" size="30" required="required" /></td>
        </tr>
      
        <tr>
            <td colspan="2"><input type="submit" value="Add Product" /></td>
        </tr>
                
        </table>
    </form>
 
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>