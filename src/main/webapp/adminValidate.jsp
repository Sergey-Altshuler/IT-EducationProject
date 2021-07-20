<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<html lang="${language}">
<head>
    <title>AdminValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> <fmt:message key="label.yourRoleAdmin"/><br> <fmt:message key="label.fillTheForm"/></h1>
<a href="chooseRole.jsp"><fmt:message key="label.goBack"/></a>
<div align="center">
<form action="adminServlet" method="post">
    <fmt:message key="label.login"/>
    <br>
    <input name="login" type="text"/>
    <br>
    <fmt:message key="label.password"/>
    <br>
    <input name="password" type="password"/>
    <br>
    <br>
    <input type="submit" value="OK" class="button"/>
</form>
</div>
</body>
</html>
