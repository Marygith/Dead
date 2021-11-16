<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 18.01.2021
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<%--<form action="add" method="post">

    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="mail">Mail</label>
    <input type="text" name="mail" id="mail">
    <input type="submit" value="Register">

</form>--%>
<span class="login">
<form action="login" method="post">
    <label for="username"> Login:    </label>
    <input type="text" name="username" id="username"/><br>
    <label for="password"> Password:   </label>
    <input type="password" name="password" id="password"/><br>
    <button class="login-button" type="submit"> Log in </button>
    <button class="login-button"><a href="registration">Register</a></button>
</form>
    </span>

<%--
<h1>Please register if you are here for the first time!</h1>--%>
<%--<a href="registration">Click here</a>--%>
<c:if test="${param.size() != 0}">
    <h2>Invalid username and password.</h2>
</c:if>

</body>
</html>
