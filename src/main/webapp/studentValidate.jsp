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
    <title>StudentValidation</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css" type="text/css">
<body>
<h1><fmt:message key="label.yourRoleStudent"/> <br> <fmt:message key="label.fillTheForm"/></h1>
<a href="chooseRole.jsp"> <fmt:message key="label.goBack"/> </a>
<br>
<div align="center">
<form action="studentServlet" method="get">
    <fmt:message key="label.login"/>
    <br>
    <input required name="login" type="text"/>
    <br>
    <fmt:message key="label.password"/>
    <br>
    <input required name="password" type="password"/>
    <br>
    <input type="submit" value="OK" class="button"/>
</form>
</div>
<h3><fmt:message key="label.ifNotRegistered"/></h3>
<div align="center">
<a href="studentRegister.jsp"> <fmt:message key="label.register"/></a>
</div>
</body>
</html>
