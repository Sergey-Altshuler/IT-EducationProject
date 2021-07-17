<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 17.07.2021
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminChangeProperties</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Please, change your login and password </h1>
<div align="center">
    <form action="adminChangePropertiesServlet" method="post">
        Insert your new login:
        <br>
        <input name="login" type="text"/>
        <br>
        Insert your new password:
        <br>
        <input name="password" type="password"/>
        <br>
        <input type="submit" value="OK" class="button"/>
    </form>
</div>
</body>
