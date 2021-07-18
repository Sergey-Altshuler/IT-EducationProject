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
<h1>Your role: Admin <br> Launch a course</h1>
<br>
<br>
<a href="adminValidate.jsp"> Log out </a>
<a href="adminActions.jsp"> Go back </a>
<br>
<div align="center">
    <form action="adminChangePropertiesServlet" method="post">
        Insert new admin login:
        <br>
        <input name="login" type="text"/>
        <br>
        Insert new admin password:
        <br>
        <input name="password" type="password"/>
        <br>
        <input type="submit" value="OK" class="button"/>
    </form>
</div>
</body>
