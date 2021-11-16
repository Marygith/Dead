<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 19.01.2021
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>

    <link href="<c:url value="/res/homePage.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="header-fixed">
    <div style="margin-right: 70px">Deadlines</div>
    <div>${user.name}</div>
    <div>My code: ${user.id}</div>
    <div><a href="homePage">Return to the Home Page</a></div>
    <div style="margin-right: 0"><a href="logout">Sign out</a></div>
</div>


<div class="block">
<h1>Hello, ${user.name}!</h1>
<%--
<form action="logout" method="post">
    <button class="login-button"><a href="logout">Sign out</a> </button>
</form>--%>


<form action="space" method="get">
    <button class="login-button"><a href="space">Click here to go to my space</a></button>
</form>
<form style="margin-top: 30px;" action="redirection" method="post">
    <label for="code" style="margin-top: 20px">Enter access code: </label>
    <input type="text" name="code" id="code">
    <input  style="margin-left: 0" class="login-button" type="submit" value="Check">
    <h2>${param.get("message")}</h2>
    <c:if test = "${param.get('message').equals('Code confirmed')}">
        <button class="login-button"><a href="space/${param.get("destination")}">Click here to go to the other realm</a></button>
    </c:if>

</form>
    <div style="display: inline" >

        <form style="display: inline" action="setPermission" method="post">
            <label for="permissionCode" style="margin-top: 20px">Set permission: </label>
            <input type="text" name="permissionCode" id="permissionCode">
            <input  style="margin-left: 0" class="login-button" type="submit" value="Validate permission">
            <h2>${param.get("message1")}</h2>
        </form>

    </div>
</div>
</body>
</html>
