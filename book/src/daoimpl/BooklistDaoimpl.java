package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.IBookList;

import entity.Booklist;
import util.DBUtil;

public class BooklistDaoimpl implements IBookList {
	Connection connection =null;
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;

	
	
	@Override
	public List<Booklist> queryAllBooklist() {
		 List<Booklist>  booklist = new ArrayList<Booklist>();
		 Booklist bl = null;
			try {
				
				 try {
					 String sql ="select * from booklist ";
					 ResultSet rs = DBUtil.excuteQuery(sql, null);
				      while(rs.next()) {
				    	 
				    	  String bookname= rs.getString("bookname");
				    	  String bookaddress = rs.getString("address");
				    	  
				    	 bl = new Booklist(bookname,bookaddress);
				    	 booklist.add(bl);
				      }
				      
				  	return booklist;
				      
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

}
