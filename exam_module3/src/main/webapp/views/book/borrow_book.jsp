<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mượn Sách</title>
    <c:import url="../layout/labrary.jsp"/>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 15px;
            display: flex;
        }
        .form-group label {
            width: 150px;
            font-weight: bold;
        }
        .form-group input, .form-group select {
            flex-grow: 1;
            padding: 5px;
            border: 1px solid #ccc;
        }
        .btn-group {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 30px;
        }
        .btn {
            padding: 8px 20px;
            background-color: white;
            border: 1px solid black;
            cursor: pointer;
            min-width: 100px;
        }
    </style>
</head>
<body>
<div class="d-flex bg-info text-dark justify-content-center">
    <h1>Mượn Sách</h1>
</div>
<form action="/books?action=borrow" method="post">
    <div class="form-group">
        <label for="borrowId">Mã mượn sách:</label>
        <input type="text" id="borrowId" name="borrowId" value="borrowId" required>
    </div>
    <div class="form-group">
        <label for="bookName">Tên sách:</label>
        <input type="text" id="bookName" name="bookName" value="${book.name}" readonly>
        <input type="hidden" name="bookId" value="${book.id}">
    </div>
    <div class="form-group">
        <label for="studentName">Tên học sinh:</label>
        <select id="studentName" name="studentId" required>
            <c:forEach items="${students}" var="student">
                <option value="${student.id}">${student.name}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="borrowDate">Ngày mượn sách:</label>
        <input type="date" id="borrowDate" name="borrowDate" value="${borrowDate}" required>
    </div>

    <div class="form-group">
        <label for="returnDate">Ngày trả sách:</label>
        <input type="date" id="returnDate" name="returnDate" value="${returnDate}" required>
    </div>

    <div class="btn-group">
        <button type="submit" class="btn btn-success">Mượn sách</button>
        <a href="/books" class="btn btn-secondary">Hủy</a>
    </div>
</form>
</body>
</html>