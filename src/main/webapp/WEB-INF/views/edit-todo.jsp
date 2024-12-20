<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 12/20/2024
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa công việc</title>
</head>
<body>
<h1>Chỉnh sửa công việc</h1>
<form action="/todo/update" method="post">
    <input type="hidden" name="id" value="${todo.id}" >
    <input type="text" placeholder="tiêu đề" name="title" value="${todo.title}">
    <textarea name="details" placeholder="mô tả" >${todo.details} </textarea>
    <select name="status">
        <option value="true" ${todo.status?'selected':''}>Đã hoàn thành </option>
        <option value="false" ${!todo.status?'selected':''}>Chưa hoàn thành</option>
    </select>
    <button type="submit">Gửi</button>
</form>
</body>
</html>
