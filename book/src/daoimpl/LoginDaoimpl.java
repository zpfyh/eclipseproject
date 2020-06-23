package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ILoginDao;
import entity.Student;

//处理登录 用于查询数据
public class LoginDaoimpl implements ILoginDao {
	
	public int login(Student student) {
		
		ResultSet executeQuery = null;
		PreparedStatement prepareStatement = null;
		Connection connection =  null;
		int flag = -1; //系统异常   0 用户名密码错误  1 登陆成功
		
		int count  = -1;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root");
		   String sql="select * from student where name=? and password=? ";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1,student.getName());
			prepareStatement.setString(2,student.getPassword());
	         executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()) {
				 count = executeQuery.getInt(1);
			}
			if(count > 0) {
				return 1;
			}else {
				return 0;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 
				try {
				if(executeQuery != null)	executeQuery.close();
				if(prepareStatement != null)	prepareStatement.close();
				if(connection != null) connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(Exception e) {
					e.printStackTrace();
				}
			
		}
		return count;
		
	
	}

}
