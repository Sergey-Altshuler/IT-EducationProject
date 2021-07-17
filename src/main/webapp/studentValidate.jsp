<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Please, fill the form below!</h1>
<div align="center">
<form action="studentServlet" method="post">
    Insert Student login:
    <br>
    <input name="login" type="text"/>
    <br>
    Insert Student password:
    <br>
    <input name="password" type="password"/>
    <br>
    <input type="submit" value="OK" class="button"/>
</form>
</div>
<h3>If you have not been registered yet, click on the link below.</h3>
<div align="center">
<a href="studentRegister.jsp"> register</a>
</div>
<h3>Click here if you want to move to start page</h3>
<div align="center">
<a href="index.jsp"> move to start page</a>
</div>
</body>
</html>
