<%--
  Created by IntelliJ IDEA.
  User: jakubjankowski
  Date: 03/10/2018
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabliczka Formularz</title>
</head>
<body>
<h2>Tabliczka form:</h2>
<form action="/tabliczka" method="post">
    <input type="number" name="x">
    <input type="number" name="y">
    <input type="submit" value="Oblicz">
</form>
</body>
</html>
