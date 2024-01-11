<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<form action="admin" method="post">
  <input type="text" name="tenTaiKhoan">
  <input type="text" name="matKhau">
  <input type="submit" value="login">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>