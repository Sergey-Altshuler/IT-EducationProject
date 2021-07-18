<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Your role: Coach. <br> Fill the form below!</h1>
<a href="chooseRole.jsp"> Go back </a>
<br>
<div align="center">
    <form action="coachServlet" method="get">
        Login:
        <br>
        <input required name="login" type="text"/>
        <br>
        Password:
        <br>
        <input required name="password" type="password"/>
        <br>
        <input type="submit" value="Login" class="button"/>
    </form>
</div>
<h3>If you have not been registered yet, click on the link below.</h3>
<div align="center">
    <a href="coachRegister.jsp"> register</a>
</div>
</body>
</html>
