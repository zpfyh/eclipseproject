package serviceimpl;


import daoimpl.LiuyanDaoimpl;
import entity.Liuyan;
import service.ILiuyanService;


public class Liuyanimpl implements ILiuyanService {

	
	LiuyanDaoimpl liuyandao = new LiuyanDaoimpl();
	@Override
	public boolean AddLiuyan(Liuyan liuyan) {
		// TODO Auto-generated method stub
		return liuyandao.AddLiuyan(liuyan)  ;
	}

}
