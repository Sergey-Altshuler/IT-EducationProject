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
    <link rel="stylesheet" href="styles.css" type="text/css">
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
        <th><fmt:message key="label.student"/> </th>
<c:forEach var="mapElement" items="${titles}">
        <th>${mapElement.key}</th>
</c:forEach>
        <th> <fmt:message key="label.avgMark"/></th>
        <th> <fmt:message key="label.attendance"/></th>
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
<form action="coachFillMarksServlet" method="POST" class="decor">
    <div class="form-inner">
    <fmt:message key="label.NumOfLesson"/>  <input required name="numLesson" type="text">
    <c:forEach var="student" items="${studentMap}">
        <fmt:message key="label.mark"/> ${student.value} <input required name=${student.key} type="text">

    </c:forEach>
    <input type="submit"  value="OK"/>
    </div>
</form>
</div>
<br>
<br>
<div align="center">
<h2><fmt:message key="label.generateTotalStats"/></h2>
<br>
<a href="calculateServlet"> <fmt:message key="label.generate"/> </a>
</div>
</body>
</html>
