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

<form action="logout" method="post">
<%--    <label for="username"> Login:    </label>
    <input type="text" name="username" id="username"/>
    <label for="password"> Password:   </label>
    <input type="password" name="password" id="password"/>--%>
   <input type="hidden" value="Log out"/>
</form>
<h1>Such a shame that you are leaving....</h1>
<a href="registration">Click here</a>


</body>
</html>
