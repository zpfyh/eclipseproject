package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ILoginDao;
import daoimpl.LoginDaoimpl;
import entity.Student;


//控制层 接受view亲求  分发给Moden处理

public class LoginServlet extends HttpServlet {

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//处理登陆
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upwd");
		String admin = request.getParameter("admin");
		String stu = request.getParameter("student");
		
		
		//用户类别判断
		if(admin != null) {
		Student student = new Student(name,password);  //用户名密码  模型成层
		
		//调模型层
		ILoginDao logindao = new LoginDaoimpl();
		int result = logindao.login(student);
		
		if(result >0) {  //没有带数据  重定向
			response.sendRedirect("shouye.jsp"); //成功
		}else {
			response.sendRedirect("login.jsp"); //失败
		}
		
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
