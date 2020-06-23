package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Liuyan;
import service.ILiuyanService;
import serviceimpl.Liuyanimpl;

/**
 * Servlet implementation class AddLiuyanServlet
 */
public class AddLiuyanServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String liuyanname = request.getParameter("liuyanname");
		String liuyantime = request.getParameter("liuyantime");
		String liuyanneirong = request.getParameter("liuyanneirong");
		
		Liuyan liuyan = new Liuyan(liuyanname, liuyantime, liuyanneirong);
		
		ILiuyanService liuyanservice = new Liuyanimpl();
		boolean result = liuyanservice.AddLiuyan(liuyan);
		request.setAttribute("liuyan", liuyan);
		//…Ë÷√œÏ”¶±‡¬Î
		 PrintWriter writer = response.getWriter();
		 response.setContentType("text/html; charset=utf-8");
		 response.setCharacterEncoding("utf-8");
		if(result) {
			
			request.getRequestDispatcher("liuyanban.jsp").forward(request, response);
		}else {
			writer.print("¡Ù—‘ ß∞‹");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
