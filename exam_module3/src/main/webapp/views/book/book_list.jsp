<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sách</title>
    <c:import url="../layout/labrary.jsp"/>
</head>
<body>
<div class="d-flex bg-info text-dark justify-content-center">
    <h1><a href="/books?action" style="text-decoration: none;">Danh sách sách</a></h1>
</div>
<h3 style="color: red">${param.mess != null ? param.mess : ""}</h3>
<table class="table table-striped table-bordered">
    <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Số lượng</th>
        <th>Mô tả</th>
        <th>Mượn</th>
    </tr>
    <c:forEach items="${books}" var="book" varStatus="status">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.stock}</td>
            <td>${book.description}</td>
            <td>
            <c:choose>
                <c:when test="${book.stock > 0}">
                    <a class="btn btn-sm btn-success" href="/books?action=borrow&bookId=${book.id}">Mượn</a>
                </c:when>
                <c:otherwise>
                    <span class="btn btn-sm btn-danger" disabled>Sách đã hết</span>
                </c:otherwise>
            </c:choose>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
