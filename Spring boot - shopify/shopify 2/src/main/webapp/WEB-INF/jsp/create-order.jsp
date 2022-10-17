<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shop-homepage.css">

</head>
<body style="background-color: beige">
<jsp:include page="header.jsp" />
   <jsp:include page="common.jsp" />
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form action="${contextPath}/displayOrderForm.htm" method="POST">
        <table>
        <tr>
            <td>Customer Email:</td>
            <td><input type="text" name="customerName" size="30" required="required" /></td>
        </tr>
       
        <tr>
            <td>Customer Address:</td>
            <td><input type="text" name="customerAddress" size="30" required="required" /></td>
        </tr>
        <tr>
           <h3>Cart Summary:</h3>
      <ul>
      <li>Products: </li>
     <c:forEach items="${myCart.cartItems}" var="cartItems">
       <div class="product-preview-container">
           <ul>
               <li>Product: ${cartItems.productInfo.code}</li>
               <li>Name: ${cartItems.productInfo.name}</li>
               <li>Price: ${cartItems.productInfo.price}</li>
               <br></br>
           </ul>
           </div>
           </c:forEach>
          <li>Quantity: ${myCart.quantityTotal}</li>
             <td><input type="hidden" name="quantity" value="${myCart.quantityTotal}"/></td>
          <li>Total: ${myCart.amountTotal}</li>
          <td><input type="hidden" name="price" value="${myCart.amountTotal}"/></td>
      </ul>
           
        </tr>
      
        <tr>
            <td colspan="2"><input type="submit" value="Add Order" /></td>
        </tr>
                
        </table>
    </form>
   <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>