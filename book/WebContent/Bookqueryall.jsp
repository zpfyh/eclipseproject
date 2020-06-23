<%@page import="entity.Page"%>
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

<%
        /*
         分页显示 jsp需要知道那些数据
         当前页
        页面大小
        当前页面的数据
        总数居
        新建Page类  用于封装以上5个字段
        
        */
%>
<%
 //如果有DELETEerron 增加成功  2.直接访问就为空
 String erron = (String)request.getAttribute("erron");
 if(erron != null){
  if(erron.equals("erron")){
	  out.print("删除失败");
  }else if(erron.equals("noerron")){
	  out.print("删除成功");
  }else{
	  //根本没有执行
  }
 }
%>
<table  border="1px">
  <tr>
   <th>书号</th>
   <th>书名</th> 
   <th>作者</th>
   <th>出版社</th>
   <th>书价</th>
   <th>操作</th>
  </tr>
  <%
  Page p =(Page) request.getAttribute("p");
  for(BookInfo bookinfo:p.getBookinfos()){
	%>  
	<tr>
	<td><a href="SelectBookid?id=<%=bookinfo.getId() %>"><%=bookinfo.getId() %></a></td>
	<td><%=bookinfo.getBookname() %></td>
	<td><%=bookinfo.getAuthor() %></td>
	<td><%=bookinfo.getPress() %></td>
	<td><%=bookinfo.getPrice() %></td>
	<td><a href="DeleteBookServlet?id=<%=bookinfo.getId()%>">删除</a></td>
	</tr>
	
	<%
  }
  %>
  
	 
 
</table>

      <a href="queryBookinfoByPage?currentPage=0">首页</a><br/>
	  <a href="queryBookinfoByPage?currentPage=<%=p.getCurrentPage()+1%>">下一页</a><br/>
	   <a href="queryBookinfoByPage?currentPage=<%=p.getCurrentPage()-1%>">上一页</a><br/>
       <a href="queryBookinfoByPage?currentPage=<%=p.getTotalCounts()%>">尾页</a><br/>
     
</body>
</html>