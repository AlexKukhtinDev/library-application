<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
Menu:
<a href="${pageContext.request.contextPath}/injectData">Inject data</a>
<a href="${pageContext.request.contextPath}/book/">All books</a>
<a href="${pageContext.request.contextPath}/book/add">Add new book</a>
<a href="${pageContext.request.contextPath}/book/find?title=against">Find Us against you</a>
</body>
</html>
