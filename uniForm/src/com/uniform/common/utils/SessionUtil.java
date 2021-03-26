package com.uniform.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class SessionUtil {
	
	private static final String SESSION_KEY = "i_no";
	
	public static boolean newSession(final HttpServletRequest request,final String i_no){
		System.out.println("SessionUtil class의 newSession()함수");

		HttpSession hs = request.getSession();
		String seVal = (String)hs.getAttribute(SESSION_KEY);
		int cnt = 0;
			
		if(seVal!=null){
			
			boolean b1 = seVal.equals(i_no);

			if(b1){
				cnt++;
			}else{
				System.out.println("아직 부여된 세션 없음");
			}
		}else{
			System.out.println("아직 부여된 세션 없음");
		}
		
		if(cnt==0){
			hs.invalidate();
			hs = request.getSession();
			hs.setAttribute(SESSION_KEY, i_no);
			hs.setMaxInactiveInterval(60*60);
			
			return false;
		}
		
		return true;
	}// end of newSession()함수
	
	public static void killSession(final HttpServletRequest request){
		
		HttpSession hs = request.getSession(false);
		System.out.println("세션 죽음..");
		
		if(hs!=null){
			hs.removeAttribute(SESSION_KEY);
			hs.invalidate();
		}
	}// end of killSession

}// end of SessionUtil class
