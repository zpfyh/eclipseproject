package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class SelectAllServlet
 */
public class SelectAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServiceimpl bookservice = new BookServiceimpl();
		List<BookInfo> bookinfo = bookservice.queryAllBook();
		//System.out.println(bookinfo);
		request.setAttribute("bookinfo", bookinfo);
		// session ת���ض��򶼿����õ�  ����ΧԽСԽ��
		request.getRequestDispatcher("Bookqueryall.jsp").forward(request, response);
//		Iterator<BookInfo> iterator = bookinfo.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//			System.out.println();
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
