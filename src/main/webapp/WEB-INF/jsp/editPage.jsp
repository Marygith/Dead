<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 17.01.2021
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Fuck off</H1>
<c:if test="${empty customer.username}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty customer.username}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty customer.username}">
        <input type="hidden" name="id" value="${customer.id}">
    </c:if>
    <label for="username">Login</label>
    <input type="text" name="username" id="username">
    <label for="password">Password</label>
    <input type="text" name="password" id="password">


    <c:if test="${empty customer.username}">
        <input type="submit" value="Add new customer">
    </c:if>
    <c:if test="${!empty customer.username}">
        <input type="submit" value="Edit customer">
    </c:if>
</form>
</body>
</html>
