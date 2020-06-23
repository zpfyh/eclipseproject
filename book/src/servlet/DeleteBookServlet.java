package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class DeleteBookServlet
 */
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		BookServiceimpl bookservice = new BookServiceimpl();
		boolean result = bookservice.DeleteBookID(id);
		
		PrintWriter writer = response.getWriter();
//		if(result) {
//			//writer.print("删除成功");
//		//response.sendRedirect("SelectAllServlet");
//		}else {
//			//writer.print("删除失败或没有找到此书");
//			
//		}
		//增加标识符
		if(!result) {
			request.setAttribute("erron", "erron");
		}else {
			request.setAttribute("erron", "noerron");
		}
		request.getRequestDispatcher("queryBookinfoByPage").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
