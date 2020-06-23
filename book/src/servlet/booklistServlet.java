package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Booklist;
import serviceimpl.booklistServiceimpl;

/**
 * Servlet implementation class booklistServlet
 */
public class booklistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		booklistServiceimpl book = new booklistServiceimpl();
		List<Booklist> queryAllBooklist = book.queryAllBooklist();
		request.setAttribute("queryAllBooklist", queryAllBooklist);
		// session ת���ض��򶼿����õ�  ����ΧԽСԽ��
		request.getRequestDispatcher("Booklist.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
