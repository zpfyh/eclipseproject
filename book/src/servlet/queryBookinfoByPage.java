package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BookInfo;
import entity.Page;
import serviceimpl.BookServiceimpl;

/**
 * Servlet implementation class queryBookinfoByPage
 */
public class queryBookinfoByPage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServiceimpl bookservice = new BookServiceimpl();
		Page page = new Page();
		//数据总数 注意顺序
		int count =	bookservice.getTotalCount();
		page.setTotalCount(count);
		
		//将分页5个字段 组装到page对象里
	
		String cpage = request.getParameter("currentPage");
		if(cpage == null) {
			cpage="0";
		}
		
		//当前集合
		int currentPage  =Integer.parseInt(cpage) ;
		page.setCurrentPage(currentPage);
		//int currentPage = 2;
		int pageSize =3;
		page.setPageSize(pageSize);
		List<BookInfo> bookinfos = bookservice.queryStudentByPage(currentPage, pageSize);
		page.setBookinfos(bookinfos);
//		System.out.println(bookinfos);
//		System.out.println(count);
		
		request.setAttribute("p",page);
		request.getRequestDispatcher("Bookqueryall.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
