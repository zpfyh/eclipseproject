package serviceimpl;

import java.util.List;

import dao.IBookDao;
import daoimpl.BookDaoimpl;
import entity.BookInfo;
import service.IBookService;

// 逻辑性增删改  对dao进行组装
public class BookServiceimpl  implements IBookService{
	
	IBookDao bookdao = new BookDaoimpl();
	public boolean AddBook(BookInfo bookinfo) {
		
		//判断是否存在
				if(!bookdao.ISbook(bookinfo.getId())) {
					bookdao.AddBook(bookinfo);
					return true;
				}else {
					System.out.println("此人已存在");
					return false;
				}
	}
	
   //按照书号删除书籍
	public boolean DeleteBookID(int id) {
		
		if(bookdao.ISbook(id)) {
			return bookdao.DeleteBookID(id);
		}
		
		return false;
	

}
	
	//修改书籍
	public boolean UpdateBookId(int id,BookInfo bookinfo) {
	
			return bookdao.UpdateBookId(id, bookinfo);	
	}
	
	//根据书号查询书籍
	
	public BookInfo queryBookId(int id) {
		return bookdao.queryBookId(id);
	}
	
	// 查询全部书籍
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