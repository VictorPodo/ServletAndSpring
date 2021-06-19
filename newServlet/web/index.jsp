<%@ page import="ru.appline.logic.Model" %><%--
  Created by IntelliJ IDEA.
  User: zeroz
  Date: 17.06.2021
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>Домашняя страница по работе с пользователями</h1>
  Введите ID пользователся (0 - для вывода всего списка пользователей)
  <br/>
  Доступно: <%
      Model model = Model.getInstance();
  out.print(model.getFromList().size());
  %>
  <form method="get" action="get">
        <label>ID:
        <input type = "text" name = "id"/>
        </label>
  <button type = "submit">Поиск</button>
  </form>

  <a href="addUser.html">Создать нового пользователя</a>
  <a href="deleteUser.html">Удаление пользователя</a>
  <a href="putUser.html">Обновление пользователей</a>
  </body>
</html>
