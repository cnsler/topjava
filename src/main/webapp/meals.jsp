<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<a href="meals?action=create">Add Meal</a>
<br><br>
<form action="meals" method="post">
    <table border>
        <tr style="text-align: center">
            <%--<th>ID</th>--%>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th colspan="2">Actions</th>
        </tr>
        <jsp:useBean id="mealsTo" scope="request" type="java.util.List"/>
        <c:forEach var="mealTo" items="${mealsTo}">
            <jsp:useBean id="mealTo" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr style="color:${mealTo.excess ? 'red' : 'green'}">
                    <%--<td>${mealTo.ID}</td>--%>
                <td><fmt:parseDate value="${mealTo.dateTime}" pattern="yyyy-MM-dd'T'HH:mm"
                                   var="parsedDateTime" type="both"/>
                    <fmt:formatDate pattern="dd.MM.yyyy HH:mm"
                                    value="${parsedDateTime}"/></td>
                <td>${mealTo.description}</td>
                <td>${mealTo.calories}</td>
                <td><a href="meals?action=update&mealId=${mealTo.ID}">Update</a></td>
                <td><a href="meals?action=delete&mealId=${mealTo.ID}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
