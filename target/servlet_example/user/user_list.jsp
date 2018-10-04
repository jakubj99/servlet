<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakubjankowski
  Date: 03/10/2018
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>User List</h2>

<table width="100%" border="1">
    <thead>
    <th>Id</th>
    <th>Login</th>
    <th>Password</th>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>
                <c:out value="${user.id}"/>
            </td>
            <td>
                <c:out value="${user.login}"/>
            </td>
            <td>
                <c:out value="${user.password}"/>
            </td>
            <td>
                <a href="/user/remove?id=<c:out value="${user.id}"/>">Remove</a>

            </td>
            <td>
                <a href="/user/modify?id=<c:out value="${user.id}"/>">Modify</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
