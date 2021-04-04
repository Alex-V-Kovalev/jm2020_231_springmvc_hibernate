<%--
  Created by IntelliJ IDEA.
  User: don
  Date: 27.02.2021
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of users</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h2>Users list</h2>
<table>
    <tr>
        <th width="10%">id</th>
        <th width="30%">Имя</th>
        <th width="20%">Телефон</th>
        <th width="10%">Квартира</th>
        <th width="10%">Количество счетчиков</th>
        <th width="10%">Изменить/Удалить</th>
    </tr>
    <c:forEach var="user" items="${usersList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.flatNum}</td>
            <td>${user.numCount}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<h2>Добавить</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>

</body>
</html>
