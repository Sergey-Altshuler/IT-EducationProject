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
    <title>StudentChooseCourse</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>
<h1><fmt:message key="label.hello"/> <%=ProjectInfo.getStudent().getName()%> <%=ProjectInfo.getStudent().getSurname()%>!<br>
    <fmt:message key="label.selectCourse"/></h1>
<br>
<br>
<a href="studentValidate.jsp"> <fmt:message key="label.logOut"/> </a>
<br>
<table>
    <tr>
        <th><fmt:message key="label.id"/></th>
        <th><fmt:message key="label.title"/></th>
        <th><fmt:message key="label.subgroup"/></th>
        <th><fmt:message key="label.edType"/></th>
        <th><fmt:message key="label.price"/></th>
        <th><fmt:message key="label.address"/></th>
        <th><fmt:message key="label.startDate"/></th>
        <th><fmt:message key="label.finishDate"/></th>
        <th><fmt:message key="label.placesRemaining"/></th>
        <th><fmt:message key="label.pressAndRegister"/></th>
    </tr>
    <c:forEach var="courses" items="${courses}">
        <tr>
            <td>${courses.id}</td>
            <td>${courses.title}</td>
            <td>${courses.subgroupNum}</td>
            <td>${courses.educationType}</td>
            <td>${courses.price}</td>
            <td>${courses.address}</td>
            <td>${courses.startDate}</td>
            <td>${courses.finishDate}</td>
            <td>${courses.remaining}</td>
            <td><a href="studentChooseCourseServlet?number=${courses.id}"> <fmt:message
                    key="label.pressAndRegister"/> </a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
