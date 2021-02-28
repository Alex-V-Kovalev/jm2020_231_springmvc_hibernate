<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 27.02.2021
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${user.id == null}">
        <title>Create new user</title>
    </c:if>
    <c:if test="${user.id != null}">
        <title>Edit information about user</title>
    </c:if>
</head>
<body>
<c:if test="${user.id == null}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${user.id != null}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <fieldset>
        <c:if test="${user.id == null}">
            <legend>Добавление пользователя</legend>
        </c:if>
        <c:if test="${user.id != null}">
            <legend>Редактирование пользователя</legend>
        </c:if>
        <input type="hidden" name="id" value="${user.id}">
        <label for="firstName">Имя</label>
        <input type="text" name="firstName" id="firstName">
        <br/>
        <br/>
        <label for="lastName">Фамилия</label>
        <input type="text" name="lastName" id="lastName">
        <br/>
        <br/>
        <label for="age">Возраст</label>
        <input type="text" name="age" id="age">
        <br/>
        <br/>
        <c:if test="${user.id == null}">
            <input type="submit" value="Добавить пользователя">
        </c:if>
        <c:if test="${user.id != null}">
            <input type="submit" value="Сохранить изменения">
        </c:if>
    </fieldset>
</form>
</body>
</html>
