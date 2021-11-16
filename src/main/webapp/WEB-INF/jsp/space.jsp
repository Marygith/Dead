<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mariya
  Date: 19.01.2021
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Space</title>
    <link href="<c:url value="/res/space.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body bgcolor="#${space.colorLight}">
    <div class="header-fixed">
        <div>Deadlines</div>
        <div>${user.name}</div>
        <div>My code: ${user.id}</div>
        <div><a href="${pageContext.request.contextPath}/homePage">Return to the Home Page</a></div>
    </div>

<div class="block">
<c:forEach var="deadline" items="${deadlines}">
    <div>
<table>
    <caption>${deadline.name}</caption>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <c:if test="${authority.equals('OWNER')}">
            <th>Action</th>
        </c:if>


    </tr>

        <tr>
            <td style="background: ${deadline.color}" class="date">${deadline.date.toString()}</td>
            <td style="max-width: 1000px">${deadline.description}</td>
            <c:if test="${authority.equals('OWNER')}">
            <td>
                <a href="edit/${deadline.id}" style="color: #022e41; font-size: 16px; font-weight: bold">edit</a>
                <a href="delete/${deadline.id}" style="color: #022e41; font-size: 16px; font-weight: bold">delete</a>
            </td>
            </c:if>
        </tr>
</table>
    </div>

    </c:forEach>

    <c:if test="${authority.equals('OWNER')}">
</div>
    <form action="createDeadline" method="get">
    <button class="login-button"><a href="createDeadline">+ Add new deadline</a></button>
</form>
</c:if>
<%--</div>--%>

<%--
<style>


    .login-button {
        margin-left: 112px;
        margin-top: 20px;
        min-width: 75px;
        min-height: 35px;
        position: relative;
        display: inline-block;
        font-size: 110%;
        font-weight: 700;
        color: rgb(209,209,217);
        text-decoration: none;
        text-shadow: 0 -1px 2px rgba(0,0,0,.2);
        padding: .5em 1em;
        outline: none;
        border-radius: 3px;
        background: "#${space.colorDark}";
        box-shadow:
                0 1px rgba(255,255,255,.2) inset,
                0 3px 5px rgba(0,1,6,.5),
                0 0 1px 1px rgba(0,1,6,.2);
        transition: .2s ease-in-out;
    }
    .login-button:hover:not(:active) {
        background: linear-gradient(rgb(126,126,134), rgb(70,71,76)) rgb(126,126,134);
    }
    .login-button:active {
        top: 1px;
        background: linear-gradient(rgb(76,77,82), rgb(56,57,62)) rgb(76,77,82);
        box-shadow:
                0 0 1px rgba(0,0,0,.5) inset,
                0 2px 3px rgba(0,0,0,.5) inset,
                0 1px 1px rgba(255,255,255,.1);
    }



</style>--%>

</body>
</html>
