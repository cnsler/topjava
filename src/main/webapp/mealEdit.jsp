<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit meal</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Edit meal</h2>
<form method="post" action="meals" name="addMeal">
    <input type="hidden" name="mealId" value="${meal.id}">
    <br><br>
    <label for="dateTime">DateTime:</label>
    <input type="datetime-local" id="dateTime" name="dateTime"
           value="${meal.dateTime}"
           required>
    <br><br>
    <label for="description">Description: </label>
    <input type="text" id="description" name="description"
           value="${meal.description}"
           minlength="1" required>
    <br><br>
    <label for="calories">Calories:</label>
    <input type="number" id="calories" name="calories"
           value="${meal.calories}" min="0"
           required>
    <br><br>
    <input type="submit" value="Save"/>
    <input type="button" name="cancel" onclick="window.history.back()" value="Cancel">
</form>
</body>
</html>