<%@page import="entity.BookInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table  border="1px">
  <tr>
   <th>书号</th>
   <th>书名</th> 
   <th>作者</th>
   <th>出版社</th>
   <th>书价</th>
  </tr>
  <%
  BookInfo bookinfo= ( BookInfo) request.getAttribute("bookinfo");
  
	%>  
	<tr>
	<td><%=bookinfo.getId() %></td>
	<td><%=bookinfo.getBookname() %></td>
	<td><%=bookinfo.getAuthor() %></td>
	<td><%=bookinfo.getPress() %></td>
	<td><%=bookinfo.getPrice() %></td>
	</tr>
	<%

  %>
  
  
</table>

</body>
</html>