<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@page import="com.captcha.botdetect.web.servlet.Captcha"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body style="background-color: beige">
<font color="red">${errorMessage}</font>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <form action="${contextPath}/sendQuery.htm" method="POST">
        <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" size="30" required="required" /></td>
        </tr>
       
        <tr>
            <td>Email Address:</td>
            <td><input type="text" name="emailAddress" size="30" required="required" /></td>
        </tr>
        <tr>
            <td>Query:</td>
            <td><textarea name="query" required="required">Enter text here...</textarea></td>
        </tr>
      
        <tr>
            <td colspan="2"><input type="submit" value="Send Query" /></td>
        </tr>
                
        </table>
    </form>
</body>
</html>