package com.uniform.common.utils;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;
import com.uniform.si.info.vo.SiInfoVO;

public class InfoUtil {
	
	public static EmCommonVO infoSetting(EmCommonVO ecvo){
		System.out.println("(log) 데이터 베이스에서 가져온 데이터를 유저에게 보여주기 위해 셋팅하는 class");
		
		String i_rrn = "";
		String i_birth = "";
		String i_hp = "";
		String i_tel = "";
		String em_mNo = "";
		String em_sign = "";
		String em_exemp = "";
		String em_military = "";
		
		// 주민등록 번호 설정
		i_rrn = ecvo.getI_rrn();
		
		if(i_rrn!=null&&i_rrn!=""){
			i_rrn = i_rrn.substring(0,6) + "-" + i_rrn.substring(6);	
		}
		ecvo.setI_rrn(i_rrn);
		
		// 생년 월일 설정
		i_birth = ecvo.getI_birth();
		
		if(i_birth!=null&&i_birth!=""){
			i_birth = i_birth.substring(0,2) + "-" + i_birth.substring(2,4) + "-" + i_birth.substring(4);
			boolean birthBool = Integer.parseInt(i_birth.substring(0,2)) > 50;
			if(birthBool){
				i_birth = "19" + i_birth;
			}else{
				i_birth = "20" + i_birth;
			}
		}
		ecvo.setI_birth(i_birth);
		
		// 핸드폰 번호 설정
		i_hp = ecvo.getI_hp();
		boolean hpBool = i_hp==null||i_hp=="";
		if(hpBool){
			i_hp = "없음";
		}else if(i_hp.length()>=11){
			i_hp = i_hp.substring(0,3) + "-" + i_hp.substring(3,7) + "-" + i_hp.substring(7);
		}else{
			
		}
		
		ecvo.setI_hp(i_hp);
		
		// 비상 연락망 설정
		i_tel = ecvo.getI_tel();
		boolean telBool = i_tel==null||i_tel=="";
		if(telBool){
			i_tel = "없음";
		}else{
			if(i_tel.length()==9){
				
				i_tel = i_tel.substring(0,2) + "-" + i_tel.substring(2,5) + "-" + i_tel.substring(5);
				
			}else if(i_tel.length()==10&&i_tel.substring(0,2).equals("02")){
				
				i_tel = i_tel.substring(0,2) + "-" + i_tel.substring(2,6) + "-" + i_tel.substring(6);
						
			}else if(i_tel.length()==10){
				
				i_tel = i_tel.substring(0,3) + "-" + i_tel.substring(3,6) + "-" + i_tel.substring(6);
				
			}else if(i_tel.length()==11||i_tel.length()==12){
				
				i_tel = i_tel.substring(0,3) + "-" + i_tel.substring(3,7) + "-" + i_tel.substring(7);
				
			}
		}
		
		ecvo.setI_tel(i_tel);
		
		// 군번 설정
		em_mNo = ecvo.getEm_mNo();
		
		if(em_mNo!=null&&em_mNo!=""){
			em_mNo = em_mNo.substring(0,2) + "-" + em_mNo.substring(2);
		}else{
			em_mNo = "";
		}
		
		ecvo.setEm_mNo(em_mNo);
		
		// 개인서명 설정
		em_sign = ecvo.getEm_sign();
		boolean signBool = em_sign==null||em_sign=="";
		if(signBool){
			em_sign = "없음";
		}
		ecvo.setEm_sign(em_sign);
		
		// 면제 사유 설정
		em_exemp = ecvo.getEm_exemp();
		boolean exempBool = em_exemp==null||em_exemp=="";
		if(exempBool){
			em_exemp = "없음";
		}
		ecvo.setEm_exemp(em_exemp);
		
		
		// 군필 설정
		em_military = ecvo.getEm_military();
		boolean milBool = em_military==null||em_military=="";
		if(milBool){
			em_military = "";
		}
		ecvo.setEm_military(em_military);
		
		return ecvo;
	}// end of infoSetting() 함수
	
	public static MmSettingVO mmSetting(MmSettingVO msvo){
		
		System.out.println("(log) 쪽지와 알림 받을 여부를 보여주기 위해 세팅하는 함수");
		
		String mm_alarm = "";
		String mm_message = "";
		
		// 쪽지
		mm_message = msvo.getMm_message();
		boolean meBool = mm_message.equals("Y");
		if(meBool){
			mm_message = "동의";
		}else{
			mm_message = "거부";
		}
		msvo.setMm_message(mm_message);
		
		// 알림
		mm_alarm = msvo.getMm_alarm();
		boolean alBool = mm_alarm.equals("Y");
		if(alBool){
			mm_alarm = "동의";
		}else{
			mm_alarm = "거부";
		}
		msvo.setMm_alarm(mm_alarm);
		
		return msvo;
	}// end of mmSetting() 함수
	
	// sivo
	public static SiInfoVO siSetting(SiInfoVO sivo){
		System.out.println("(log) 데이터 베이스에서 가져온 데이터를 유저에게 보여주기 위해 셋팅하는 class");
		
		String i_rrn = "";
		String i_birth = "";
		String i_hp = "";
		String i_tel = "";
		String si_admissionDate = "";
		String si_graduationDate = "";
		String si_credits = "";
		String si_avg = "";
		
		// 주민등록 번호 설정
		i_rrn = sivo.getI_rrn();
		
		if(i_rrn!=null&&i_rrn!=""){
			i_rrn = i_rrn.substring(0,6) + "-" + i_rrn.substring(6);	
		}
		sivo.setI_rrn(i_rrn);
		
		// 생년 월일 설정
		i_birth = sivo.getI_birth();
		
		if(i_birth!=null&&i_birth!=""){
			i_birth = i_birth.substring(0,2) + "-" + i_birth.substring(2,4) + "-" + i_birth.substring(4);
			boolean birthBool = Integer.parseInt(i_birth.substring(0,2)) > 50;
			if(birthBool){
				i_birth = "19" + i_birth;
			}else{
				i_birth = "20" + i_birth;
			}
		}
		sivo.setI_birth(i_birth);
		
		// 핸드폰 번호 설정
		i_hp = sivo.getI_hp();
		boolean hpBool = i_hp==null||i_hp=="";
		if(hpBool){
			i_hp = "없음";
		}else if(i_hp.length()>=11){
			i_hp = i_hp.substring(0,3) + "-" + i_hp.substring(3,7) + "-" + i_hp.substring(7);
		}else{
			
		}
		
		sivo.setI_hp(i_hp);
		
		// 비상 연락망 설정
		i_tel = sivo.getI_tel();
		boolean telBool = i_tel==null||i_tel=="";
		if(telBool){
			i_tel = "없음";
		}else{
			if(i_tel.length()==9){
				
				i_tel = i_tel.substring(0,2) + "-" + i_tel.substring(2,5) + "-" + i_tel.substring(5);
				
			}else if(i_tel.length()==10&&i_tel.substring(0,2).equals("02")){
				
				i_tel = i_tel.substring(0,2) + "-" + i_tel.substring(2,6) + "-" + i_tel.substring(6);
						
			}else if(i_tel.length()==10){
				
				i_tel = i_tel.substring(0,3) + "-" + i_tel.substring(3,6) + "-" + i_tel.substring(6);
				
			}else if(i_tel.length()==11||i_tel.length()==12){
				
				i_tel = i_tel.substring(0,3) + "-" + i_tel.substring(3,7) + "-" + i_tel.substring(7);
				
			}
		}
		
		sivo.setI_tel(i_tel);
		
		//이수학점
		si_credits = sivo.getSi_credits();
		boolean crBool = si_credits==null||si_credits=="";
		if(crBool){
			si_credits = "";
		}
		sivo.setSi_credits(si_credits);
		
		//평균학점
		si_avg = sivo.getSi_avg();
		boolean avgBool = si_avg==null||si_avg=="";
		if(avgBool){
			si_avg = "";
		}
		sivo.setSi_avg(si_avg);
		
		//입학날짜
		si_admissionDate = sivo.getSi_admissionDate();
		boolean adBool = si_admissionDate==null||si_admissionDate=="";
		
		if(adBool){
			si_admissionDate = "";
		}
		sivo.setSi_admissionDate(si_admissionDate);
		
		//졸업날짜
		si_graduationDate = sivo.getSi_graduationDate();
		boolean grBool = si_graduationDate==null||si_graduationDate=="";
		
		if(grBool){
			si_graduationDate = "";
		}
		sivo.setSi_graduationDate(si_graduationDate);
		
		return sivo;
	}// end of siSetting() 함수
	
//	public static void main(String[] args){
//		
//		EmCommonVO ecvo = new EmCommonVO();
//		
//		ecvo.setI_rrn("9507121032120");
//		ecvo.setI_birth("950712");
//		ecvo.setI_hp("01040208223");
//		
//		System.out.println("test >>> : " + infoSetting(ecvo).getI_hp());
//	}// end of main() 함수

}// end of InfoUtil class