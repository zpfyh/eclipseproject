package entity;

import java.util.List;

public class Page {
	// 当前页
	private int currentPage;
	//页面大小
	  private int pageSize;
	  //总数据
	  private int totalCount;
	  
	  //总页数
	  private int totalPage;
	  
	  // 当前页的数据集合
	  private List<BookInfo> bookinfos;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		//自动计算总页数
		this.totalPage = this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
	}

	public int getTotalCounts() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}
// 总页数
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}



	public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<BookInfo> bookinfos) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.bookinfos = bookinfos;
	}
	  
	public List<BookInfo> getBookinfos() {
		return bookinfos;
	}

	public void setBookinfos(List<BookInfo> bookinfos) {
		this.bookinfos = bookinfos;
	}

	public Page() {
		
	}  
	  

}
