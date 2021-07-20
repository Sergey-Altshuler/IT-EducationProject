<%@ page pageEncoding="UTF-8" %>
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
    <title>ChooseLanguage</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1 align="center" style="color: aliceblue;
    background-color: darkblue;
    text-align: center;
    font-family: Arial, serif;
    font-weight: bold;"><fmt:message key="label.welcomeToITWorld"/>
</h1>
<br>
<h3 align="center" style="color: black;
    font-family: Arial, sans-serif;
font-weight: bold;
text-align: center;"><fmt:message key="label.chooseLanguage"/></h3>
<br>
<br>
<br>
<div align="center" style="font-size: large">
    <form>
        <select id="language" name="language" style="width: 25%;
    font-family: cursive;
    font-size: 25px;
    padding: 5px 10px;
    border-radius: 2px;
    background-color: antiquewhite;" onchange="submit()">
            <option value="ru" ${language == 'ru' ? 'selected' : ''} style="font-size: 20px">Russian</option>
            <option value="en" ${language == 'en' ? 'selected' : ''} style="font-size: 20px">English</option>
        </select>
    </form>
</div>
<br>
<br>
<br>
<br>
<div align="center">
    <a href="welcome.jsp" style="font-size: 25px"><fmt:message key="label.continue"/></a>
</div>
</body>
</html>
