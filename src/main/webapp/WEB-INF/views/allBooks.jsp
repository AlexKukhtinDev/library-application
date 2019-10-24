<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>All Books</title>
    <style>
        table {
            font-family: "Times New Roman", sans-serif;
            border-collapse: collapse;
            width: 75%;
        }
        th {
            border: 1px solid black;
            text-align: center;
            padding: 8px;
        }
        td {
            border: 1px solid black;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h1>Select the book you need</h1>
<td>
    <a href="${pageContext.request.contextPath}/rent/rentedBooks">Return Book</a>
</td>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Book Info</th>
        <th>Rent</th>
        <th>Return</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.title}</td>
            <td>${book.year}</td>
            <td>${book.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/book/${book.bookId}">Book Info</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/rentBook?book_id=${book.bookId}">Rent Book</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/rent/returnBook?book_id=${book.bookId}">Return Book</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
