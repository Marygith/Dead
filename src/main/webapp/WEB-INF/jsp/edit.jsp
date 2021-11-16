<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 19.01.2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deadline Creation</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/edit" method="post">
    <label for="name"> Name:    </label>
    <input type="text" name="name" id="name" value="${deadline.name}"/><br>
    <label for="importance"> Importance:   </label>
    <input type="text" name="importance" id="importance" value="${deadline.importance}"/><br>
    <label for="date"> Date:   </label>
    <input type="date" name="date" id="date" value="${deadline.date.toString()}"/><br>
    <label for="description"> Description:   </label>
    <input type="text" name="description" id="description" value="${deadline.description}"/><br>
     <input type="hidden" name="id" value="${deadline.id}">
     <input type="hidden" name="spaceId" value="${deadline.spaceId}">
    <button class="login-button" type="submit"> Save deadline </button>

</form><%--
<h2>You can pick color <a href="https://get-color.ru">here</a> if you like</h2>--%>

</body>
</html>