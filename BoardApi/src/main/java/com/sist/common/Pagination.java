package com.sist.common;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class Pagination {

	public int start(int rowSize,int page) {
		return  (rowSize*page)-rowSize;
		
		
	}
	
	public int totalPage(int count) {
		return (int)Math.ceil(count/10.0);
	
	}
	
	public int startPage(int page , int block) {
		
		return (page-1)/(block*block)+1;  // page 3 - > 2/ 100 +1 
	}
	
public int endPage(int page , int block, int totalPage) {
		
	int endPage=(page-1)/(block*block)+block;
	
	if(endPage>totalPage) {
		endPage=totalPage;
	}
	
		return endPage;
	}
	
	
	
}
