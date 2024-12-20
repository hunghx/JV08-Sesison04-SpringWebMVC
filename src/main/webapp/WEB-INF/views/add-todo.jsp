<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 12/20/2024
  Time: 8:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Thêm mới công việc</h1>
<form action="/todo/add" method="post">
    <input type="text" placeholder="tiêu đề" name="title">
    <textarea name="details" placeholder="mô tả"></textarea>
    <button type="submit">Gửi</button>
</form>

</body>
</html>
