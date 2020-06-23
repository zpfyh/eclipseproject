
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="entity.Booklist"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  
<table border="1px">
<tr>
<th>书名</th>
<th>书籍图录</th>
</tr>
<% 
  List<Booklist> bk = (List<Booklist>) request.getAttribute("queryAllBooklist");
   
   for(Booklist booklist:bk){ %>
   <tr>
 <td><%=booklist.getBookname() %></td>
   <td><img src="img/u0.jpg">    </td>
  <td><img src="img/timg (1).jpg">    </td>
  <td><img src="img/timg (2).jpg">    </td>
  <td><img src="img/t.jpg">    </td>
 </tr>
	<%
 }
%>
       
   </table>   

</body>
</html>