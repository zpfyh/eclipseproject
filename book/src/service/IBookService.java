package service;

import java.util.List;

import entity.BookInfo;


public interface IBookService {
	public boolean AddBook(BookInfo bookinfo);
	
	//��ѯ��������
	 public  int getTotalCount();
	 //��ѯ��ǰҳ���ݼ���
	 public List<BookInfo> queryStudentByPage(int currentPage, int pageSize);
}
