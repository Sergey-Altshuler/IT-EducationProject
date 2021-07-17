<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChooseRole</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Select your role </h1>
<div align="center">
<form action="chooseRole-servlet" method="post">
    <p><input name="role" type="radio" value="admin"> Administrator</p>
    <p><input name="role" type="radio" value="student"> Student</p>
    <p><input name="role" type="radio" value="coach" checked> Coach</p>
    <p><input type="submit" value="Confirm" class="button"></p>
</form>
</div>
</body>
</html>
