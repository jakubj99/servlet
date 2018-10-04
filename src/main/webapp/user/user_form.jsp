<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakubjankowski
  Date: 03/10/2018
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<h2>User Form:</h2>

<span style="color: #dc143c; ">
<c:out value="${error_message}"/>
</span>

<c:choose>
    <c:when test="${not empty user_to_modify}">
<form action="/user/modify" method="post">
    <input type="hidden" name="id" value="<c:out value="${user_to_modify.id}"/>">
    <div>
        <label for="username">Username:</label>
        <input id="username" name="username" type="text" value="<c:out value="${user_to_modify.login}"/>">
    </div>
    <div>
        <label for="password">Password:</label>
        <input id="password" name="password" type="password" value="<c:out value="${user_to_modify.password}"/>">
    </div>
    <div>
        <label for="password-confirm">Password Confirmation:</label>
        <input id="password-confirm" name="password-confirm" type="password" value="<c:out value="${user_to_modify.password}"/>">
    </div>
    <div>
        <input type="submit" value="Modify">
    </div>
</form>
    </c:when>
    <c:otherwise>
        <form action="/user/add" method="post">
            <div>
                <label for="username">Username:</label>
                <input id="username" name="username" type="text">
            </div>
            <div>
                <label for="password">Password:</label>
                <input id="password" name="password" type="password">
            </div>
            <div>
                <label for="password-confirm">Password Confirmation:</label>
                <input id="password-confirm" name="password-confirm" type="password">
            </div>
            <div>
                <input type="submit" value="Register">
            </div>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
