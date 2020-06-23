package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IBookDao;
import entity.BookInfo;
import util.DBUtil;

//数据访问层
public class BookDaoimpl  implements IBookDao{
	
	Connection connection =null;
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	private final String URL="jdbc:mysql://localhost:3306/book";
	private final String USERNAME="root";
	private final String PASSWORD="root";
	
	
	
	// 查询全部书籍
	public List<BookInfo> queryAllBook() {
		 List<BookInfo>  bokinfos = new ArrayList<BookInfo>();
		BookInfo bookinfo = null;
		try {
			
			 try {
				 String sql ="select * from bookinfo ";
				 ResultSet rs = DBUtil.excuteQuery(sql, null);
			      while(rs.next()) {
			    	  int ids = rs.getInt("id");
			    	  String booknames = rs.getString("bookname");
			    	  String authors = rs.getString("author");
			    	  String presss = rs.getString("press");
			    	  String prices = rs.getString("price");
			    	 bookinfo = new BookInfo(ids,booknames,authors,presss,prices);
			    	 bokinfos.add(bookinfo);
			      }
			      
			  	return bokinfos;
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return null;
			}
		} finally {
			
				try {
					if(rs != null)	rs.close();
					if(DBUtil.prepareStatement != null)	DBUtil.prepareStatement .close();
					if(DBUtil.connection != null)	DBUtil.connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
		
	}
	
	
	//根据书号查询书籍
	public BookInfo queryBookId(int id) {
		BookInfo bookinfo = null;
		try {
			
			 try {
				 String sql ="select * from bookinfo where id=?";
				 Object[] obj = new Object[] {id};
				 ResultSet rs = DBUtil.excuteQuery(sql, obj);
				
				
			      if(rs.next()) {
			    	  int ids = rs.getInt("id");
			    	  String booknames = rs.getString("bookname");
			    	  String authors = rs.getString("author");
			    	  String presss = rs.getString("press");
			    	  String prices = rs.getString("price");
			    	 bookinfo = new BookInfo(ids,booknames,authors,presss,prices);
			      }
			   
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		} finally {
			
				try {
					if(rs != null)	rs.close();
					if(DBUtil.prepareStatement != null)	DBUtil.prepareStatement .close();
					if(DBUtil.connection != null)	DBUtil.connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return bookinfo;
		
		
	}
	
	//查询此人是否存在
	public boolean ISbook(int id) {
		return queryBookId(id)==null? false:true;
	}
	
	//增加书籍
	public boolean AddBook(BookInfo bookinfo) {
		String sql="insert into bookinfo (id,bookname,author,press,price) values(?,?,?,?,?)";
		Object[] obj = new Object[] {bookinfo.getId(),bookinfo.getBookname(),bookinfo.getAuthor(),bookinfo.getPress(),bookinfo.getPrice()};
		return DBUtil.executeUpadte(sql, obj);
	
		
	}
	
	//根据书号删除书籍
	public boolean DeleteBookID(int id) {
		String sql ="delete from  bookinfo where id=?";
		Object[] obj = new Object[] {id};
		return DBUtil.executeUpadte(sql, obj);
		
	}

	 //根据id修改书  知道id修改的人 然后修改为bookinfo
  public boolean UpdateBookId(int id,BookInfo bookinfo) {
	  
		String sql ="update bookinfo set bookname=?,author=?,press=?,price=? where id=?";
		Object[] obj = new Object[] {bookinfo.getBookname(),bookinfo.getAuthor(),bookinfo.getPress(),bookinfo.getPrice(),id};
		return DBUtil.executeUpadte(sql, obj);
	
  }
	
  public  int getTotalCount() {
	  String sql ="select count(*) from bookinfo";
	return DBUtil.getTotalCount(sql);
	  
  }
	
  public List<BookInfo> queryStudentByPage(int currentPage, int pageSize){
	    List<BookInfo>  bokinfos = new ArrayList<BookInfo>();
	  String sql ="select * from bookinfo order by id asc Limit ?,?";
		 Object[] obj = new Object[] {currentPage*pageSize,pageSize};
		 ResultSet rs = DBUtil.excuteQuery(sql, obj);
		 try {
			while(rs.next()) {
				   rs.getInt("id");
				   rs.getString("bookname");
				   rs.getString("bookname");
			       rs.getString("press");
				   rs.getString("price");
				  BookInfo  bookinfo = new BookInfo( rs.getInt("id") ,rs.getString("bookname"), rs.getString("bookname"), rs.getString("press"), rs.getString("price"));
				  bokinfos.add(bookinfo);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	return bokinfos ;
	  
  }
	

}
