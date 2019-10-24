<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<form action="${pageContext.request.contextPath}add" method="post">
    <table>
        <tr>
            <td>Book title:</td>
            <td><input value="${title}" name="title"/></td>
        </tr>
        <tr>
            <td>Year:</td>
            <td><input value="${year}" name="year"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input value="${price}" name="price" type="number" step="0.01" min="0"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit" class="btn">Confirm</button>
            </td>
        </tr>
    </table>
</form>
<form action="${pageContext.request.contextPath}/book">
    <button type="submit" class="btn">All Books</button>
</form>
</body>
</html>
