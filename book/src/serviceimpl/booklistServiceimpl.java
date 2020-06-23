package serviceimpl;

import java.util.List;

import daoimpl.BooklistDaoimpl;
import entity.Booklist;
import service.IBooklistSrevice;

public class booklistServiceimpl  implements IBooklistSrevice{

	BooklistDaoimpl booklistDao = new BooklistDaoimpl();
	
	public List<Booklist> queryAllBooklist() {
		return booklistDao.queryAllBooklist();
			
	}

}
