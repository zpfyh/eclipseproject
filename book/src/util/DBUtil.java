package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//数据库帮助类
public class DBUtil {
	
	 // 不在一个包里加public 
	public static Connection connection =null;
	public static PreparedStatement prepareStatement = null;
	public static ResultSet rs = null;
	private static final String URL="jdbc:mysql://localhost:3306/book";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	//通用的增删改
	public static boolean executeUpadte(String sql,Object[] obj) { //sql语句 和？
			try {
				Class.forName("com.mysql.jdbc.Driver");
				 try {
					 connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
				//	String sql ="select * from bookinfo where id=?";
				      prepareStatement = connection.prepareStatement(sql);
				    // setXxx方法的个数依赖与问号的个数  问好的个数和object数组个数保持一致
				    for (int i = 0; i < obj.length; i++) {
						//set 任何类型  数组 0 问号1开始
				    	prepareStatement.setObject(i+1, obj[i]);
					}
				    int count = prepareStatement.executeUpdate();
				    if(count>0) {
				    	return true;
				    }else
				    	return false;
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					return false;
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			} finally {
				
					try {
						if(prepareStatement != null)	prepareStatement.close();
						if(connection != null)	connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}
	
	
	
	//查询  返回集合  通用适合任何类型
	public static ResultSet excuteQuery(String sql,Object[] object ) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 try {
				 connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
			
			      prepareStatement = connection.prepareStatement(sql);
			      if(object != null) {  //排空处理
			    	  for (int i = 0; i < object.length; i++) {
							//set 任何类型  数组 0 问号1开始
					    	prepareStatement.setObject(i+1, object[i]);
						}
			      }
			      rs = prepareStatement.executeQuery();
			     
			      return rs;
			    
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				return null;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} //rs不能关
		
		
	}

	//分页  查询总数
	 public static int getTotalCount(String sql) {
		 int count = -1;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
			 prepareStatement = connection.prepareStatement(sql);
			 ResultSet rs = prepareStatement.executeQuery();
			 if(rs.next()) {
				count = rs.getInt(1);
			 }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!= null) rs.close(); 
				if(prepareStatement != null)	prepareStatement.close();
				if(connection != null)	connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	 }


	
}
