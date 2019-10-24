<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Index</title>
</head>
<p>
<h1>Welcome in our Library!</h1>
<p>
<form action="${pageContext.request.contextPath}/injectData">
  <button style="width:150px;height:35px">Inject test Data</button>
</form>
<form action="${pageContext.request.contextPath}/book">
  <button style="width:150px;height:35px">List all Books</button>
</form>
<form action="${pageContext.request.contextPath}/admin">
  <button style="width:150px;height:35px">Admin Library</button>
</form>
</p>
</body>
</html>
