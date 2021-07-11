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
Please, fill the form below!
<form action="coachServlet" method="post">
    Insert Coach login:
    <br>
    <input name="login" type="text"/>
    <br>
    Insert Coach password:
    <br>
    <input name="password" type="password"/>
    <br>
    <input type="submit" value="OK" />
</form>
<h3>If you have not been registered yet, click on the link below.</h3>
<a href="coachRegister.jsp"> register</a>
<h3>Click here if you want to move to start page</h3>
<a href="index.jsp"> move to start page</a>
</body>
</html>
