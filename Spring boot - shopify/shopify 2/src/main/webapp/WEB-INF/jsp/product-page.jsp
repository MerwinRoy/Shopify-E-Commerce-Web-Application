<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/shop-homepage.css">



</head>
<body style="background-color: beige">
 
   <jsp:include page="header.jsp" />
   <jsp:include page="common.jsp" />
  
   <fmt:setLocale value="en_US" scope="session"/>
 
 
  <div class="container">

      <div class="row">
      
       <div class="row">

        <div class="col-lg-3">

          <h1 class="my-4">Shopify</h1>
          <div class="list-group">
            <a href="${pageContext.request.contextPath}/displayProducts.htm" class="list-group-item">Browse</a>
            <a href="${pageContext.request.contextPath}/viewMyOrders.htm" class="list-group-item">My Orders</a>
            <a href="${pageContext.request.contextPath}/aboutUs.htm" class="list-group-item">About Us</a>
          </div>

        </div>
        
                <!-- /.col-lg-3 -->

        <div class="col-lg-9">
        
        <div class="row">
		
		 <c:forEach items="${requestScope.map.productlist}" var="prod">
            <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
               
                <div class="card-body">
                  <h4 class="card-title">
                    <a href="#"> ${prod.prodName}</a>
                  </h4>
                  <h5><fmt:formatNumber value="${prod.prodPrice}" type="currency"/></h5>
                  <p class="card-text">${prod.prodDetails} </p>
                   <li>Available Quantity: ${prod.prodQuantity}</li>
                </div>
                <div class="card-footer">
                  <h5 class="card-title" style="text-decoration: center">
                    <a href="${pageContext.request.contextPath}/buyProduct.htm?code=${prod.prodID}">BUY</a>
                  </h5>
                </div>
              </div>
            </div>
            
            </c:forEach>
            
        </div>
        </div>
 </div>
 </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</body>
</html>