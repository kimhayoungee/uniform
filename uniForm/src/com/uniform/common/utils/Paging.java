package com.uniform.common.utils;

import com.uniform.mm.message.vo.MmMessageVO;

public class Paging {
	
	public static void setPage(MmMessageVO mmvo){
		System.out.println("페이지에 보여질 행의 시작과 끝을 뽑는 class");
		
		int page = 0;
		int pageSize = 10;
		System.out.println(mmvo.getPage());
		if(mmvo.getPage()==null||mmvo.getPage()==""||mmvo.getPage().indexOf("un")>-1){
			page = 1;
			mmvo.setPage("1");
		}else{
			System.out.println("여기로 왜 들어와");
			page = Integer.parseInt(mmvo.getPage());
		}
		
		int start = (page-1)*pageSize + 1;
		int end = (page-1)*pageSize+pageSize;
		
		mmvo.setStart(start + "");
		mmvo.setEnd(end + "");
		
		System.out.println("Paging class 끝");
	}// end of setPage

}// end of Paging class
