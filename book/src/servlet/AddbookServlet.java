package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import service.IBookService;
import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class AddbookServlet
 */
public class AddbookServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//接受
		int id = Integer.parseInt(request.getParameter("id"));
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		BookInfo bookinfo = new BookInfo(id,bookname,author,press,price);
		
		IBookService bookservice = new BookServiceimpl();
		boolean result = bookservice.AddBook(bookinfo);
		
		//设置响应编码
		 PrintWriter writer = response.getWriter();
		 response.setContentType("text/html; charset=utf-8");
		 response.setCharacterEncoding("utf-8");
		if(result) {
			
			writer.print("增加成功");
		}else {
			writer.print("增加失败");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
