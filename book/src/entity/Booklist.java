package entity;

public class Booklist {
	
	private String bookname;
	private String bookaddress;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookaddress() {
		return bookaddress;
	}
	public void setBookaddress(String bookaddress) {
		this.bookaddress = bookaddress;
	}
	public Booklist(String bookname, String bookaddress) {
		super();
		this.bookname = bookname;
		this.bookaddress = bookaddress;
	}
	public Booklist() {
		super();
	}
	@Override
	public String toString() {
		return "Booklist [bookname=" + bookname + ", bookaddress=" + bookaddress + "]";
	}
	
	

}
