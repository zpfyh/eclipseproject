package serviceimpl;

import java.util.List;

import dao.IBookDao;
import daoimpl.BookDaoimpl;
import entity.BookInfo;
import service.IBookService;

// �߼�����ɾ��  ��dao������װ
public class BookServiceimpl  implements IBookService{
	
	IBookDao bookdao = new BookDaoimpl();
	public boolean AddBook(BookInfo bookinfo) {
		
		//�ж��Ƿ����
				if(!bookdao.ISbook(bookinfo.getId())) {
					bookdao.AddBook(bookinfo);
					return true;
				}else {
					System.out.println("�����Ѵ���");
					return false;
				}
	}
	
   //�������ɾ���鼮
	public boolean DeleteBookID(int id) {
		
		if(bookdao.ISbook(id)) {
			return bookdao.DeleteBookID(id);
		}
		
		return false;
	

}
	
	//�޸��鼮
	public boolean UpdateBookId(int id,BookInfo bookinfo) {
	
			return bookdao.UpdateBookId(id, bookinfo);	
	}
	
	//������Ų�ѯ�鼮
	
	public BookInfo queryBookId(int id) {
		return bookdao.queryBookId(id);
	}
	
	// ��ѯȫ���鼮
	public List<BookInfo> queryAllBook() {
		return bookdao.queryAllBook();
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return bookdao.getTotalCount();
	}

	@Override
	public List<BookInfo> queryStudentByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return bookdao.queryStudentByPage(currentPage, pageSize);
	}
	
	
	
	
	
	
	
	
}