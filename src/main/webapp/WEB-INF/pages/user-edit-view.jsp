<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 27.02.2021
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
        <label for="userName">Имя</label>
        <input type="text" name="userName" id="userName" value="${user.userName}">
        <br/>
        <br/>
        <label for="phoneNumber">Телефон</label>
        <input type="text" name="phoneNumber" id="phoneNumber" value="${user.phoneNumber}">
        <br/>
        <br/>
        <label for="flatNum">Квартира</label>
        <input type="text" name="flatNum" id="flatNum" value="${user.flatNum}">
        <br/>
        <br/>
        <label for="numCount">Количество счетчиков</label>
        <input type="text" name="numCount" id="numCount"  value="${user.numCount}">
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
