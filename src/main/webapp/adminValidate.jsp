<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> You are Admin. <br> Please, fill the form below! </h1>
<div align="center">
<form action="adminServlet" method="post">
    Insert Admin login:
    <br>
    <input name="login" type="text"/>
    <br>
    Insert Admin password:
    <br>
    <input name="password" type="password"/>
    <br>
    <input type="submit" value="OK" class="button"/>
</form>
</div>
</body>
</html>
