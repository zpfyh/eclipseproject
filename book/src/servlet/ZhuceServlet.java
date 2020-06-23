package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IZhuceDao;
import daoimpl.ZhuceDaoimpl;
import entity.Student;

/**
 * Servlet implementation class ZhuceServlet
 */
public class ZhuceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 request.setCharacterEncoding("utf-8");
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
		 String password = request.getParameter("password");
		 Student student = new Student(id,name,password);
		 
		 IZhuceDao zhucedao = new ZhuceDaoimpl();
		 int result = zhucedao.AddStudent(student);
			
			//������Ӧ����
			 PrintWriter writer = response.getWriter();
			 response.setContentType("text/html; charset=utf-8");
			 response.setCharacterEncoding("utf-8");
			 
				
				if(result >0) {  //û�д�����  �ض���
					request.getRequestDispatcher("login.html").forward(request, response);
				}else {
					response.sendRedirect("regster.html"); //ʧ��
				}
//		 if(result>0) {
//			 writer.print("ע��ɹ�");
//		 }else {
//			 writer.print("ע��ʧ��");
//		 }
		 
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
