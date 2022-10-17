<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shop-homepage.css">
</head>
<body style="background-color: beige">
   <jsp:include page="header.jsp" />
  
   <jsp:include page="common.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">${user.name}'s Cart!</div>
 
   <c:if test="${empty cartInfo or empty cartInfo.cartItems}">
       <h2>There is no items in Cart</h2>
   </c:if>
 
   <c:if test="${not empty cartInfo and not empty cartInfo.cartItems}">
       <form:form method="POST" modelAttribute="cartForm" action="${contextPath}/displayOrderForm.htm">
 
           <c:forEach items="${cartInfo.cartItems}" var="cartItems"
               varStatus="varStatus">
               <div class="product-preview-container">
                   <ul>
                       
                       <li>Code: ${cartItems.productInfo.code}
                       </li>
                       <li>Name: ${cartItems.productInfo.name}</li>
                       <li>Price: <span class="price">
                      
                         <fmt:formatNumber value="${cartItems.productInfo.price}" type="currency"/>
                        
                       </span></li>
                       <li>Quantity: ${cartItems.quantity}</li>
                       <li>Subtotal:
                         <span class="subtotal">
                        
                            <fmt:formatNumber value="${cartItems.amount}" type="currency"/>
                      
                         </span>
                       </li>
                       <li><a
                           href="${pageContext.request.contextPath}/shoppingCartRemoveProduct.htm?code=${cartItems.productInfo.code}">
                               Delete </a></li>
                   </ul>
                   </ul>
               </div>
           </c:forEach>
           <div style="clear: both"></div>
         
           <a class="navi-item"
               href="${pageContext.request.contextPath}/displayOrderForm.htm">Proceed to Checkout!</a>
        
               
       </form:form>
 
 
   </c:if>
 
 
 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>