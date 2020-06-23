<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="entity.Liuyan"%>
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
   <th>留言人姓名</th>
   <th>留言时间</th> 
   <th>留言内容</th>
  
  </tr>
  <%
  Liuyan liuyan= ( Liuyan) request.getAttribute("liuyan");
  
	%>  

	
	<tr>
	<td><%=liuyan.getLiuyanname() %></td>
	<td><%=liuyan.getLiuyantime()%></td>
	<td><%=liuyan.getLiuyanneirong()%></td>
</tr>
	<%

  %>
  </table>
</body>
</html>