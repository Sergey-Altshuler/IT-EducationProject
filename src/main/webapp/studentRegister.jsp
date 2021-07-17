<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentRegister</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Fill in the form below</h1>
<div align="center">
<form action="studentRegisterServlet" method="POST">
    <br>
    Login:
    <br>
    <input name="login" required type="text">
    <br>
    Password:
    <br>
    <input name="password" required type="password">
    <br>
    Name:
    <br>
    <input name="name" required type="text">
    <br>
    Surname:
    <br>
    <input name="surname" required type="text">
    <br>
    Age:
    <br>
    <input name="age" required type="text">
    <br>
    Interests
    <br>
    <input name="interests" required type="text">
    <br>
    <br>
    <input type="submit" value="confirm registration" class="button"/>

</form>
</div>
</body>
</html>
