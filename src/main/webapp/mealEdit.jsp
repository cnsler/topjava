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
<%--<jsp:useBean id="meal" scope="application" type="ru.javawebinar.topjava.model.Meal"/>--%>
<%--<form action="meals">
    <label for="dateTime">DateTime:</label>
    <input type="datetime-local" id="dateTime" name="dateTime" value="${meal.dateTime != null ? meal.dateTime : "2022-10-07T12:30"}"
           required>
    <br><br>
    <label for="description">Description: </label>
    <input type="text" id="description" name="description" value="${meal.description != null ? meal.description : "description"}"
           minlength="1" required>
    <br><br>
    <label for="calories">Calories:</label>
    <input type="number" id="calories" name="calories" value="${meal.calories != null ? meal.calories : 0}" min="0"
           required>
    <br><br>
    &lt;%&ndash;<input type="button" name="save" value="Save">&ndash;%&gt;
    <button type="submit" formmethod="post">Save</button>
    <button type="reset" value="reset">Reset</button>
    <button type="submit" value="cancel">Cancel</button>
    &lt;%&ndash;<input type="button" value="Cancel">&ndash;%&gt;
</form>--%>
<form method="post" action="meals" name="addMeal">
    <%--<jsp:useBean id="meal" scope="application" type="ru.javawebinar.topjava.model.Meal"/>--%>
    <input type="hidden" name="mealId" value="${meal.id}">
    <br><br>
    <label for="dateTime">DateTime:</label>
    <input type="datetime-local" id="dateTime" name="dateTime"
           value="${meal.dateTime != null ? meal.dateTime : "2022-10-07T12:30"}"
           required>
    <br><br>
    <label for="description">Description: </label>
    <input type="text" id="description" name="description"
           value="${meal.description != null ? meal.description : "description"}"
           minlength="1" required>
    <br><br>
    <label for="calories">Calories:</label>
    <input type="number" id="calories" name="calories"
           value="${meal.calories != null ? meal.calories : 0}" min="0"
           required>
    <br><br>
    <input type="submit" value="Save"/>
    <button type="submit" formmethod="get">Cancel</button>
</form>
</body>
</html>
