package entity;

public class BookInfo {
	
	private int id;
	private String bookname;
	private String author;
	private String press;
	private String price;
	
	public BookInfo() {
	
	}
	
	public BookInfo( String bookname, String author, String press, String price) {
		
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.price = price;
	}
	
	public BookInfo(int id, String bookname, String author, String press, String price) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", bookname=" + bookname + ", author=" + author + ", press=" + press + ", price="
				+ price + "]";
	}
	
	

}
