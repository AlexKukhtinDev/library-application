<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
    </tr>
<c:forEach var="book" items="${books}">
    <tr>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.price}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
