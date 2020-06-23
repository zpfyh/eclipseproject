<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>增加图书</title>
</head>
<body>

<form action="UpdatebookServlet" method="post">

  书号：<input type="text" name="id"><br>
  书名：<input type="text" name="bookname"><br>
  作者：<input type="text" name="author"><br>
  出版社：<input type="text" name="press"><br>
  价格：<input type="text" name="price"><br>
  <input type="submit" value="修改图书">
</form>

</body>
</html>