<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 07.07.2021
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> You are Admin. <br> Please, fill the form below! </h1>
<form action="adminServlet", method="post">
    Insert Admin login:
    <br>
    <input name="login" type="text"/>
    <br>
    Insert Admin password:
    <br>
    <input name="password" type="password"/>
    <br>
    <input type="submit" value="OK" />
</form>
</body>
</html>
