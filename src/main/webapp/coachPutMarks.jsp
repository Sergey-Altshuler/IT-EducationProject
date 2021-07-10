<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10.07.2021
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachPutMarks</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>This is rank table. Please, put marks.</h1>
<br>
<br>
<table>
    <tr>

<c:forEach var="mapElement" items="${titles}">
        <th>${mapElement.key}</th>
</c:forEach>

    </tr>
   <%-- <c:forEach var="table" items="${table}">
    <tr>
        <td>${table.id}</td>
        <td>${table.student_name}</td>
        <td>${table.student_surname}</td>
        <td>${table.mark}</td>
        <td>${table.review}</td>
        <td>${table.course_name}</td>
        <td>${table.coachYouHaveWorked}</td>
    </tr>
    </c:forEach>--%>

</table>
</body>
</html>
