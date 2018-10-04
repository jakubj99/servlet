<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jakubjankowski
  Date: 03/10/2018
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabliczka View</title>
</head>
<body>
<h2>Tabliczka Mnożenia</h2>
<table width="100%" border="1" align="center">
<c:forEach var="x" begin="1" end="${rozmiar_x}">
    <tr>
    <c:forEach var="y" begin="1" end="${rozmiar_y}">
        <td>
            <c:out value="${x*y}"/>
        </td>
        </c:forEach>
    </tr>
</c:forEach>
</table>
</body>
</html>
