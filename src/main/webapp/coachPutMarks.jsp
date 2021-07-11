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
    <c:forEach var="courseMap" items="${courseMap}">
        <c:set var="miniMap" value="${courseMap.value}"/>
    <tr>
        <c:forEach var="miniMap" items="${miniMap}">
        <td>${miniMap.value}</td>
        </c:forEach>
    </tr>
    </c:forEach>

    <br>
    <br>
    <c:set var="num"  value="${numToFill}"/>
     <c:if test="${num}==0">
         <h3>Course has been finished. Click on the link below to generate stats.</h3>
         <a href="calculateServlet"> click here </a>
     </c:if>
    <c:if test="${num}!=0">
        <br>
        <br>
        <form action="coachFillMarksServlet" method="POST">
            Insert number of lesson: <input required name="numLesson" type="text">
            <c:forEach var="student" items="${studentMap}">
                <br>
                Mark for ${student.value} :  <input required name=${student.key} type="text">
                <br>

            </c:forEach>
                <input type="submit"  value="put Marks"/>
        </form>
    </c:if>
</table>
</body>
</html>
