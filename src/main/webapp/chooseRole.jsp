<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 07.07.2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChooseRole</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Select your role </h1>
<form action="chooseRole-servlet" method="post">
    <p><input name="role" type="radio" value="admin"> Administrator</p>
    <p><input name="role" type="radio" value="student"> Student</p>
    <p><input name="role" type="radio" value="coach" checked> Coach</p>
    <p><input type="submit" value="Choose your role"></p>
</form>

</body>
</html>
