package entity;

public class Liuyan {
	
	
	private  String liuyanname;
	private  String  liuyantime;
	private  String liuyanneirong;
	
	
	public String getLiuyanname() {
		return liuyanname;
	}
	public void setLiuyanname(String liuyanname) {
		this.liuyanname = liuyanname;
	}
	public String getLiuyantime() {
		return liuyantime;
	}
	public void setLiuyantime(String liuyantime) {
		this.liuyantime = liuyantime;
	}
	public String getLiuyanneirong() {
		return liuyanneirong;
	}
	public void setLiuyanneirong(String liuyanneirong) {
		this.liuyanneirong = liuyanneirong;
	}
	
	public Liuyan(String liuyanname, String liuyantime, String liuyanneirong) {
	
		this.liuyanname = liuyanname;
		this.liuyantime = liuyantime;
		this.liuyanneirong = liuyanneirong;
	}
	public Liuyan() {
		
	}
	@Override
	public String toString() {
		return "Liuyan [liuyanname=" + liuyanname + ", liuyantime=" + liuyantime + ", liuyanneirong=" + liuyanneirong
				+ "]";
	}
	
	
	
	
	
	

}
