<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 07.07.2021
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Please, fill the form below!</h1>
<div align="center">
<form action="coachServlet" method="post">
    Insert Coach login:
    <br>
    <input name="login" type="text"/>
    <br>
    Insert Coach password:
    <br>
    <input name="password" type="password"/>
    <br>
    <input type="submit" value="OK" class="button"/>
</form>
</div>
<h3>If you have not been registered yet, click on the link below.</h3>
<div align="center">
<a href="coachRegister.jsp"> register</a>
</div>
<h3>Click here if you want to move to start page</h3>
<div align="center">
<a href="index.jsp"> move to start page</a>
</div>
</body>
</html>
