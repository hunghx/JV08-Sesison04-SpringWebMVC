<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 12/20/2024
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach công việc</title>
</head>
<body>
    <h1> Danh sách công viẹc</h1>
    <a href="/todo/add">Thêm moi công việc</a>
<table border="1" cellpadding="10" cellspacing="10">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Details</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${todos}" var="todo">
        <tr>
            <td>${todo.id}</td>
            <td>${todo.title}</td>
            <td>${todo.details}</td>
            <td>${todo.status?"Đã hoàn thành":"Chưa hoàn thành"}</td>
            <td>
                <a href="">Sửa</a>
                <a href="">Xóa</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
