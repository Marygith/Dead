<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 17.01.2021
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h2>Customers</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>username</th>
        <th>password</th>
        <th>action</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.username}</td>
            <td>${customer.password}</td>

            <td>
                <a href="edit/${customer.id}">edit</a>
                <a href="delete/${customer.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
<h1>Hello, ${user.name}!</h1>

<form action="logout" method="post">
    <input type="submit" value="Sign Out"/>
</form>

<%--<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new customer</a>--%>
</body>
</html>
