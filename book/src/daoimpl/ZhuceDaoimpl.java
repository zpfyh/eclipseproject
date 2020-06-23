package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IZhuceDao;
import entity.Student;

public class ZhuceDaoimpl  implements IZhuceDao{
   
	private final String URL="jdbc:mysql://localhost:3306/book";
	private final String USERNAME="root";
	private final String PASSWORD="root";
	
	public int AddStudent(Student student) {
		
		Connection connection =null;
		PreparedStatement prepareStatement = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 try {
				 connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
				String sql ="insert into student (id,name,password) values(?,?,?)";
				  prepareStatement = connection.prepareStatement(sql);
			      prepareStatement.setString(1, student.getId());
			      prepareStatement.setString(2,student.getName()); 
			      prepareStatement.setString(3,student.getPassword());
			   
			       int count =prepareStatement.executeUpdate();
			  
			     if(count>0) {
			    	 return 1;
			     }else {
			    	 return 0;
			     }
			      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				 return 0;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return 0;
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
}
