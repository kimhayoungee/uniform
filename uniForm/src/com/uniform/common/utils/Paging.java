package com.uniform.common.utils;

import com.uniform.mm.message.vo.MmMessageVO;

public class Paging {
	
	public static void setPage(MmMessageVO mmvo){
		System.out.println("�������� ������ ���� ���۰� ���� �̴� class");
		
		int page = 0;
		int pageSize = 10;
		System.out.println(mmvo.getPage());
		if(mmvo.getPage()==null||mmvo.getPage()==""||mmvo.getPage().indexOf("un")>-1){
			page = 1;
			mmvo.setPage("1");
		}else{
			System.out.println("����� �� ����");
			page = Integer.parseInt(mmvo.getPage());
		}
		
		int start = (page-1)*pageSize + 1;
		int end = (page-1)*pageSize+pageSize;
		
		mmvo.setStart(start + "");
		mmvo.setEnd(end + "");
		
		System.out.println("Paging class ��");
	}// end of setPage

}// end of Paging class
