package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkcodeservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public checkcodeservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultTip ="img/wong.jpg";
		//获取用户输入的
		String checkcodeClient  = request.getParameter("checkCodeid");
		
	//真实的
		String checkcodeServer = (String) request.getSession().getAttribute("checkCode");
		
		if(checkcodeServer.equals(checkcodeClient)) {
			resultTip ="img/tim.jpg";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(resultTip);
		writer.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
