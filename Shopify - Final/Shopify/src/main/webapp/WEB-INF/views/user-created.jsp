<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User - Successess</title>
</head>
<body style="background-color: beige">
    Account created successfully , please click on the link to activate your account !
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <br><br>
    <a href="${contextPath}/user/login.htm">Click here to login</a>
</body>
</html>