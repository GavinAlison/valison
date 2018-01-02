package com.alison.json;

import java.util.Arrays;
import java.util.Collection;

public class ListObject {
	private int pagePreview;
	private int pageNext;
	private Collection pageNum;
//	private Collection pageBeanList;
	
	public int getPagePreview() {
		return pagePreview;
	}
	public void setPagePreview(int pagePreview) {
		this.pagePreview = pagePreview;
	}
	public int getPageNext() {
		return pageNext;
	}
	public void setPageNext(int pageNext) {
		this.pageNext = pageNext;
	}
	public Collection getPageNum() {
		return pageNum;
	}
	public void setPageNum(Collection pageNum) {
		this.pageNum = pageNum;
	}
	
//	public void setPageBeanList(PageBean[] page ){
//		this.pageNum.addAll(Arrays.asList(page));
//	}
	public void setPageBeanList(PageBean[] page ){
		this.pageNum.addAll(Arrays.asList(page));
//		this.pageNum = page;
	}
	
	
	public Collection getPageBeanList(){
		return this.pageNum;
	}
}	
