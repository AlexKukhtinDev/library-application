<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Book Info</title>
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

<h1>Complete info about selected book</h1>

<table border="1">
    <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.price}</td>
    </tr>
</table>
</body>
</html>