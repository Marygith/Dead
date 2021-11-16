<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 17.01.2021
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Now you are ready to start</title>

    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Please register</h1>


<%--
<c:if test="${empty customer.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty customer.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty customer.name}">
    <input type="hidden" name="id" value="${customer.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="mail">Mail</label>
    <input type="text" name="mail" id="mail">


    <c:if test="${empty customer.name}">
    <input type="submit" value="Add new customer">
    </c:if>
    <c:if test="${!empty customer.name}">+
    <input type="submit" value="Edit customer">
    </c:if>--%>

<form action="registration" method="post">
    <label for="username"> Login:    </label>
    <input type="text" name="username" id="username"/><br>
    <label for="password"> Password:   </label>
    <input type="password" name="password" id="password"/><br>
    <label for="name"> Your name:   </label>
    <input type="text" name="name" id="name"/><br>
    <button class="login-button" type="submit" >Register </button>
</form>

<h2>${param.get("message")}</h2>

</body>
</html>
