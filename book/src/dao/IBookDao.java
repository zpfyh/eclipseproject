package dao;

import java.util.List;

import entity.BookInfo;
import entity.Student;

public interface IBookDao {
	public List<BookInfo> queryAllBook();
	
	public boolean AddBook(BookInfo bookinfo);
	
	public BookInfo queryBookId(int id);
	
	public boolean ISbook(int id);
	
	public boolean DeleteBookID(int id);
	
    public boolean UpdateBookId(int id,BookInfo bookinfo);
	
    //查询总数据数
    public  int getTotalCount();
    
    //
    public List<BookInfo> queryStudentByPage(int currentPage, int pageSize); //页数 页面大小
    

}
