<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="text"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <title>Welcome</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1 align="center" style="color: aliceblue;
    background-color: darkblue;
    text-align: center;
    font-family: Arial, serif;
    font-weight: bold;"><fmt:message key="label.welcomeToITCenter"/>
</h1>
<br>
<a href="chooseLanguage.jsp" style="font-size: 25px"> <fmt:message key="label.goBack"/></a>
<br>
<br>
<h3 align="center" style="color: black;
    font-family: Arial, sans-serif;
font-weight: bold;
text-align: center;"> <fmt:message key="label.wantToStart"/></h3>
<br>
<div align="center">
    <a href="chooseRole.jsp" style="font-size: 25px"><fmt:message key="label.getStarted"/></a>
</div>
</body>
</html>
