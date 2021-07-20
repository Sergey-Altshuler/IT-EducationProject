<%@ page import="com.Altshuler.info.ProjectInfo" %>
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
    <title>CoachPutMarks</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.hello"/> <%=ProjectInfo.getCoach().getName()%> <%=ProjectInfo.getCoach().getSurname()%>!<br>
    <fmt:message key="label.putMarksAttendance"/></h1>
<br>
<br>
<a href="coachValidate.jsp"> <fmt:message key="label.logOut"/>  </a>
<a href="coachRedirect.jsp"> <fmt:message key="label.goBack"/> </a>
<br>
<table>
    <tr>

<c:forEach var="mapElement" items="${titles}">
        <th>${mapElement.key}</th>
</c:forEach>

    </tr>
    <c:forEach var="courseMap" items="${courseMap}">
        <c:set var="miniMap" value="${courseMap.value}"/>
    <tr>
        <c:forEach var="miniMap" items="${miniMap}">
        <td>${miniMap.value}</td>
        </c:forEach>
    </tr>
    </c:forEach>

</table>


<br>
<br>
<div align="center">
<form action="coachFillMarksServlet" method="POST">
    <fmt:message key="label.NumOfLesson"/> <input required name="numLesson" type="text">
    <br>
    <c:forEach var="student" items="${studentMap}">
        <br>
        <fmt:message key="label.mark"/> ${student.value} :  <input required name=${student.key} type="text">
        <br>

    </c:forEach>
    <input type="submit"  value="OK" class="button"/>
</form>
</div>
<br>
<br>
<h3><fmt:message key="label.generateTotalStats"/></h3>
<div align="center">
<a href="calculateServlet"> <fmt:message key="label.generate"/> </a>
</div>
</body>
</html>
