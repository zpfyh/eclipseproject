package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.ILiuyanDao;
import entity.Liuyan;
import util.DBUtil;

public class LiuyanDaoimpl implements ILiuyanDao {

	Connection connection =null;
	PreparedStatement prepareStatement = null;
	ResultSet rs = null;
	
	
	@Override
	public boolean AddLiuyan(Liuyan liuyan) {
		// TODO Auto-generated method stub
		String sql="insert into liuyan (liuyanname,liuyantime,liuyanneirong) values(?,?,?)";
		Object[] obj = new Object[] {liuyan.getLiuyanname(),liuyan.getLiuyantime(),liuyan.getLiuyanneirong()};
		return DBUtil.executeUpadte(sql, obj);
	}

}
