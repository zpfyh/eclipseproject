package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ILoginDao;
import daoimpl.LoginDaoimpl;
import entity.Student;


//���Ʋ� ����view����  �ַ���Moden����

public class LoginServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�����½
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String admin = request.getParameter("admin");
		String stu = request.getParameter("student");
		
		
		//�û�����ж�
		if(admin != null) {
		Student student = new Student(name,password);  //�û�������  ģ�ͳɲ�
		
		//��ģ�Ͳ�
		ILoginDao logindao = new LoginDaoimpl();
		int result = logindao.login(student);
		
		if(result >0) {  //û�д�����  �ض���
			response.sendRedirect("shouye.jsp"); //�ɹ�
		}else {
			response.sendRedirect("login.jsp"); //ʧ��
		}
		
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
