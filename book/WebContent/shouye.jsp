<%@page import="entity.BookInfo"%>
<%@page import="entity.Page"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理系统</title>
<link rel="shortcut icon" href="img/favicon.ico" />
<link rel="stylesheet" href="css/haotaigli.html.css" />
</head>
<body>
	<%
		Date date = new Date();
	%>
	<div class="biaoti">
		<div class="b1">
			<h2>欢迎进入图书信息后台管理系统</h2>
		</div>
		<div class="b2">
			<span>欢迎管理员：admin&nbsp;现在是北京时间：<%=date%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="new.html">退出系统</a></span>
		</div>
	</div>

	<div class="nav">
		<div class="nav1">

			<ul>
				<li>
					<div class="nav222">
						<a>添加图书</a>
					</div>
					<div class="g1">
						<form action="AddbookServlet" method="post">

							书号：<input type="text" name="id"><br> 书名：<input
								type="text" name="bookname"><br> 作者：<input
								type="text" name="author"><br> 出版社：<input
								type="text" name="press"><br> 价格：<input type="text"
								name="price"><br> <input type="submit" value="增加图书">
						</form>

					</div>
				</li>
				<li>
					<div class="nav444">
						<a href="queryBookinfoByPage">查询所有图书</a>
					</div>
					<div class="g2">
                     
        

					</div>
				</li>
				<li>
					<div class="nav333">
						<a>删除图书</a>
					</div>
					<div class="g3">
						<form action="DeleteBookServlet" method="post">

							书号：<input type="text" name="id"><br> <input
								type="submit" value="删除图书">
						</form>

					</div>
				</li>
				<li>
					<div class="nav555">
						<a>修改图书</a>
					</div>
					<div class="g4">
						<form action="UpdatebookServlet" method="post">

							书号：<input type="text" name="id"><br> 书名：<input
								type="text" name="bookname"><br> 作者：<input
								type="text" name="author"><br> 出版社：<input
								type="text" name="press"><br> 价格：<input type="text"
								name="price"><br> <input type="submit" value="修改图书">
						</form>

					</div>
				</li>
				<li>
					<div class="nav666">
						<a>按编号查图书</a>
					</div>
					<div class="g5">
						<form action="SelectBookid" method="post">

							书号：<input type="text" name="id"><br> <input
								type="submit" value="查询图书">
						</form>

					</div>
				</li>
				<li>
					<div class="nav666">
						<a>留言板</a>
					</div>
					<div class="g5">
						<form action="AddLiuyanServlet" method="post">
                                                                                                           留言人:<input type="text" name="liuyanname" /><br />
	                                                                                            留言时间:<input type="text"name="liuyantime" /><br /> 
	                                                                                            留言内容:<input type="text"name="liuyanneirong" /><br /> 
	                              <input type="submit" value="留言">
                        </form>

					</div>
				</li>
				<li>
					<div class="nav444">
						<a href="booklistServlet">书目</a>
					</div>
					<div class="g2">
                  
					</div>
				</li>
			</ul>

		</div>

	</div>
</body>
</html>