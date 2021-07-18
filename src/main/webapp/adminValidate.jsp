<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Your role: Admin. <br> Fill the form below! </h1>
<a href="chooseRole.jsp"> Go back </a>
<div align="center">
<form action="adminServlet" method="post">
    Login:
    <br>
    <input name="login" type="text"/>
    <br>
    Password:
    <br>
    <input name="password" type="password"/>
    <br>
    <br>
    <input type="submit" value="Login" class="button"/>
</form>
</div>
</body>
</html>
