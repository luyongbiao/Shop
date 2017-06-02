package org.bqj.shopping.entity;

public class PageBean {
	private int pageCount;
	private int currentPage;
	private int pageSize;
	private int begin;
	private int totalCount;
	
	public PageBean(int currentPage, int pageSize, int totalCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		this.begin = pageSize * (currentPage - 1);
		if (totalCount % pageSize == 0) {
			this.pageCount = totalCount / pageSize;
		} else
			this.pageCount = totalCount / pageSize + 1;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
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
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
