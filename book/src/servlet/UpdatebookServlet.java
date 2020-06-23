package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class UpdatebookServlet
 */
public class UpdatebookServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		//获取修改的学号
		int id = Integer.parseInt(request.getParameter("id"));
		//获取修改后的内容
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		
		BookInfo bookinfo = new BookInfo(bookname,author,press,price);
		BookServiceimpl bookservice = new BookServiceimpl();
		boolean result = bookservice.UpdateBookId(id, bookinfo);
		PrintWriter writer = response.getWriter();
         if(result) {
			writer.print("修改成功");
		}else {
			writer.print("修改失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
