package com.uniform.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class SessionUtil {
	
	private static final String SESSION_KEY = "i_no";
	
	public static boolean newSession(final HttpServletRequest request,final String i_no){
		System.out.println("SessionUtil class�� newSession()�Լ�");

		HttpSession hs = request.getSession();
		String seVal = (String)hs.getAttribute(SESSION_KEY);
		int cnt = 0;
			
		if(seVal!=null){
			
			boolean b1 = seVal.equals(i_no);

			if(b1){
				cnt++;
			}else{
				System.out.println("���� �ο��� ���� ����");
			}
		}else{
			System.out.println("���� �ο��� ���� ����");
		}
		
		if(cnt==0){
			hs.invalidate();
			hs = request.getSession();
			hs.setAttribute(SESSION_KEY, i_no);
			hs.setMaxInactiveInterval(60*60);
			
			return false;
		}
		
		return true;
	}// end of newSession()�Լ�
	
	public static void killSession(final HttpServletRequest request){
		
		HttpSession hs = request.getSession(false);
		System.out.println("���� ����..");
		
		if(hs!=null){
			hs.removeAttribute(SESSION_KEY);
			hs.invalidate();
		}
	}// end of killSession

}// end of SessionUtil class
