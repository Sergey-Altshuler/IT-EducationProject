<%@ page import="com.Altshuler.info.ProjectInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<html>
<head>
    <title>StudentChooseCourse</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>Hello, <%=ProjectInfo.getStudent().getName()%> <%=ProjectInfo.getStudent().getSurname()%>!<br>
Select a course</h1>
<br>
<br>
<a href="studentValidate.jsp"> Log out </a>
<br>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>subgroup</th>
        <th>EducationType</th>
        <th>price</th>
        <th>address</th>
        <th>startDate</th>
        <th>finishDate</th>
        <th>Students Remaining</th>
        <th>Press here and enroll</th>
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
            <td><a href="studentChooseCourseServlet?number=${courses.id}"> enroll </a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
