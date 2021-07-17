<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CoachPutMarks</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1>This is rank table. Please, put marks. Insert numbers 0-10 or "N"(if the student is absent)</h1>
<br>
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
    Insert number of lesson: <input required name="numLesson" type="text">
    <br>
    <c:forEach var="student" items="${studentMap}">
        <br>
        Mark for ${student.value} :  <input required name=${student.key} type="text">
        <br>

    </c:forEach>
    <input type="submit"  value="put Marks" class="button"/>
</form>
</div>
<br>
<br>
<h3>If the latest lesson has been finished, click on the link below and generate total stats.</h3>
<div align="center">
<a href="calculateServlet"> generate statistics and finish the course </a>
</div>
</body>
</html>
