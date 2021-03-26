package com.uniform.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChaebunUtil {
	
	private static final String MESSAGE = "MM";
	private static final String EMP = "E";
	private static final String SI = "S";
	
	// ��������
	public final static String CHAEBUN_PM = "P";
	// �Խ���
	public final static String CHAEBUN_BM = "B";
	// ���
	public final static String CHAEBUN_BM_RE = "R";
	//��������
	public final static String CHAEBUN_NM = "N";
	// ��ũ��
	public final static String CHAEBUN_BM_SC = "S";
	
	
	public static String getChaebun(String no,String type){
		
		boolean b1 = no!=null&&type!=null;
		
		if(b1){
			
			for(int i=no.length(); i<4 ;i++){
				no = "0" + no;
			}// 0 ������ for�� ����
			
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
			}// ���� Ÿ�Կ� ���� �����ڸ� �ٸ��� �����ִ� if�� ����
		}// �Ű������� �� ���;� �����ϴ� if�� ����
		
		return no;
	}// end of getChaebun() �Լ�
	
	// �������� ä�� �Լ�(P0001)
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
		
		// �Խ��� ä�� �Լ�(B0001)
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
		// ��� ä�� �Լ�(R0001)
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
		
		// ��ũ�� ä�� �Լ�(S0001)
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
//		System.out.println("�׽�Ʈ >> : " + ChaebunUtil.getChaebun("3", "mm"));
//	}

}// end of ChaebunUril class
