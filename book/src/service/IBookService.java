package service;

import java.util.List;

import entity.BookInfo;


public interface IBookService {
	public boolean AddBook(BookInfo bookinfo);
	
	//查询总数据数
	 public  int getTotalCount();
	 //查询当前页数据集合
	 public List<BookInfo> queryStudentByPage(int currentPage, int pageSize);
}
