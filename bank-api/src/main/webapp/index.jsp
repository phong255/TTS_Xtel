<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<form action="api-test" method="post">
  <input type="text" name="input">
  <input type="submit" value="save">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>