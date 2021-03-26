package com.uniform.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChaebunUtil {
	
	private static final String MESSAGE = "MM";
	private static final String EMP = "E";
	private static final String SI = "S";
	
	// 일정관리
	public final static String CHAEBUN_PM = "P";
	// 게시판
	public final static String CHAEBUN_BM = "B";
	// 댓글
	public final static String CHAEBUN_BM_RE = "R";
	//공지사항
	public final static String CHAEBUN_NM = "N";
	// 스크랩
	public final static String CHAEBUN_BM_SC = "S";
	
	
	public static String getChaebun(String no,String type){
		
		boolean b1 = no!=null&&type!=null;
		
		if(b1){
			
			for(int i=no.length(); i<4 ;i++){
				no = "0" + no;
			}// 0 붙히는 for문 종료
			
			Date d = new Date();
			
			SimpleDateFormat sf = new SimpleDateFormat("YYYYMMdd");
			
			String date = sf.format(d);
			
			no = date + no;
			
			if("mm".equals(type.toLowerCase())){
				no = MESSAGE + no;
			}else if("emp".equals(type.toLowerCase())){
				no = EMP + no;
			}else if("si".equals(type.toLowerCase())){
				no = SI + no;
			}// 들어온 타입에 따라 구분자를 다르게 붙혀주는 if문 종료
		}// 매개변수가 다 들어와야 진입하는 if문 종료
		
		return no;
	}// end of getChaebun() 함수
	
	// 일정관리 채번 함수(P0001)
		public static String pmChaebun(String _strNum){
			
			String strNum = _strNum;
			int strLength = strNum.length();
			
			// 0001 0011 0111 1111
			for(int i=strLength; i<4; i++){
				strNum = "0" + strNum;
			}
			
			String pmChaebum = CHAEBUN_PM + strNum;
			
			return pmChaebum;
		}
		
		// 게시판 채번 함수(B0001)
		public static String bmChaebun(String _strNum){
			
			String strNum = _strNum;
			int strLength = strNum.length();
			
			// 0001 0011 0111 1111
			for(int i=strLength; i<4; i++){
				strNum = "0" + strNum;
			}
			
			String bmChaebun = CHAEBUN_BM + strNum;
			
			return bmChaebun;
		}
		// 댓글 채번 함수(R0001)
		public static String bmReplyChaebun(String _strNum){
			
			String strNum = _strNum;
			int strLength = strNum.length();
			
			// 0001 0011 0111 1111
			for(int i=strLength; i<4; i++){
				strNum = "0" + strNum;
			}
			
			String bmReplyChaebun = CHAEBUN_BM_RE + strNum;
			
			return bmReplyChaebun;
		}	
		
		public static String nmNoticeChaebun(String _strNum){
			
			String nm_no = _strNum;
			
			// 0001 0011 0111 1111
			for(int i=nm_no.length(); i<4; i++){
				nm_no = "0" + nm_no;
			}
			
			nm_no = CHAEBUN_NM + nm_no;
			
			return nm_no;
		}
		
		// 스크랩 채번 함수(S0001)
		public static String bmScrapChaebun(String _strNum){
			
			String strNum = _strNum;
			int strLength = strNum.length();
			
			// 0001 0011 0111 1111
			for(int i=strLength; i<4; i++){
				strNum = "0" + strNum;
			}
			
			String bmScrapChaebun = CHAEBUN_BM_SC + strNum;
			
			return bmScrapChaebun;
		}	
	
//	public static void main(String[] args){
//		System.out.println("테스트 >> : " + ChaebunUtil.getChaebun("3", "mm"));
//	}

}// end of ChaebunUril class
