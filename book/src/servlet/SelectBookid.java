package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class SelectBookid
 */
public class SelectBookid extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookServiceimpl bookservice = new BookServiceimpl();
		BookInfo  bookinfo = bookservice.queryBookId(id);
		//System.out.println(bookinfo.toString());
		request.setAttribute("bookinfo", bookinfo);
	//	有数据请求转发
		request.getRequestDispatcher("bookone.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
