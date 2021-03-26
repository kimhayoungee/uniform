package com.uniform.common.utils;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;
import com.uniform.si.info.vo.SiInfoVO;

public class InfoUtil {
	
	public static EmCommonVO infoSetting(EmCommonVO ecvo){
		System.out.println("(log) ������ ���̽����� ������ �����͸� �������� �����ֱ� ���� �����ϴ� class");
		
		String i_rrn = "";
		String i_birth = "";
		String i_hp = "";
		String i_tel = "";
		String em_mNo = "";
		String em_sign = "";
		String em_exemp = "";
		String em_military = "";
		
		// �ֹε�� ��ȣ ����
		i_rrn = ecvo.getI_rrn();
		
		if(i_rrn!=null&&i_rrn!=""){
			i_rrn = i_rrn.substring(0,6) + "-" + i_rrn.substring(6);	
		}
		ecvo.setI_rrn(i_rrn);
		
		// ���� ���� ����
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
		
		// �ڵ��� ��ȣ ����
		i_hp = ecvo.getI_hp();
		boolean hpBool = i_hp==null||i_hp=="";
		if(hpBool){
			i_hp = "����";
		}else if(i_hp.length()>=11){
			i_hp = i_hp.substring(0,3) + "-" + i_hp.substring(3,7) + "-" + i_hp.substring(7);
		}else{
			
		}
		
		ecvo.setI_hp(i_hp);
		
		// ��� ������ ����
		i_tel = ecvo.getI_tel();
		boolean telBool = i_tel==null||i_tel=="";
		if(telBool){
			i_tel = "����";
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
		
		// ���� ����
		em_mNo = ecvo.getEm_mNo();
		
		if(em_mNo!=null&&em_mNo!=""){
			em_mNo = em_mNo.substring(0,2) + "-" + em_mNo.substring(2);
		}else{
			em_mNo = "";
		}
		
		ecvo.setEm_mNo(em_mNo);
		
		// ���μ��� ����
		em_sign = ecvo.getEm_sign();
		boolean signBool = em_sign==null||em_sign=="";
		if(signBool){
			em_sign = "����";
		}
		ecvo.setEm_sign(em_sign);
		
		// ���� ���� ����
		em_exemp = ecvo.getEm_exemp();
		boolean exempBool = em_exemp==null||em_exemp=="";
		if(exempBool){
			em_exemp = "����";
		}
		ecvo.setEm_exemp(em_exemp);
		
		
		// ���� ����
		em_military = ecvo.getEm_military();
		boolean milBool = em_military==null||em_military=="";
		if(milBool){
			em_military = "";
		}
		ecvo.setEm_military(em_military);
		
		return ecvo;
	}// end of infoSetting() �Լ�
	
	public static MmSettingVO mmSetting(MmSettingVO msvo){
		
		System.out.println("(log) ������ �˸� ���� ���θ� �����ֱ� ���� �����ϴ� �Լ�");
		
		String mm_alarm = "";
		String mm_message = "";
		
		// ����
		mm_message = msvo.getMm_message();
		boolean meBool = mm_message.equals("Y");
		if(meBool){
			mm_message = "����";
		}else{
			mm_message = "�ź�";
		}
		msvo.setMm_message(mm_message);
		
		// �˸�
		mm_alarm = msvo.getMm_alarm();
		boolean alBool = mm_alarm.equals("Y");
		if(alBool){
			mm_alarm = "����";
		}else{
			mm_alarm = "�ź�";
		}
		msvo.setMm_alarm(mm_alarm);
		
		return msvo;
	}// end of mmSetting() �Լ�
	
	// sivo
	public static SiInfoVO siSetting(SiInfoVO sivo){
		System.out.println("(log) ������ ���̽����� ������ �����͸� �������� �����ֱ� ���� �����ϴ� class");
		
		String i_rrn = "";
		String i_birth = "";
		String i_hp = "";
		String i_tel = "";
		String si_admissionDate = "";
		String si_graduationDate = "";
		String si_credits = "";
		String si_avg = "";
		
		// �ֹε�� ��ȣ ����
		i_rrn = sivo.getI_rrn();
		
		if(i_rrn!=null&&i_rrn!=""){
			i_rrn = i_rrn.substring(0,6) + "-" + i_rrn.substring(6);	
		}
		sivo.setI_rrn(i_rrn);
		
		// ���� ���� ����
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
		
		// �ڵ��� ��ȣ ����
		i_hp = sivo.getI_hp();
		boolean hpBool = i_hp==null||i_hp=="";
		if(hpBool){
			i_hp = "����";
		}else if(i_hp.length()>=11){
			i_hp = i_hp.substring(0,3) + "-" + i_hp.substring(3,7) + "-" + i_hp.substring(7);
		}else{
			
		}
		
		sivo.setI_hp(i_hp);
		
		// ��� ������ ����
		i_tel = sivo.getI_tel();
		boolean telBool = i_tel==null||i_tel=="";
		if(telBool){
			i_tel = "����";
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
		
		//�̼�����
		si_credits = sivo.getSi_credits();
		boolean crBool = si_credits==null||si_credits=="";
		if(crBool){
			si_credits = "";
		}
		sivo.setSi_credits(si_credits);
		
		//�������
		si_avg = sivo.getSi_avg();
		boolean avgBool = si_avg==null||si_avg=="";
		if(avgBool){
			si_avg = "";
		}
		sivo.setSi_avg(si_avg);
		
		//���г�¥
		si_admissionDate = sivo.getSi_admissionDate();
		boolean adBool = si_admissionDate==null||si_admissionDate=="";
		
		if(adBool){
			si_admissionDate = "";
		}
		sivo.setSi_admissionDate(si_admissionDate);
		
		//������¥
		si_graduationDate = sivo.getSi_graduationDate();
		boolean grBool = si_graduationDate==null||si_graduationDate=="";
		
		if(grBool){
			si_graduationDate = "";
		}
		sivo.setSi_graduationDate(si_graduationDate);
		
		return sivo;
	}// end of siSetting() �Լ�
	
//	public static void main(String[] args){
//		
//		EmCommonVO ecvo = new EmCommonVO();
//		
//		ecvo.setI_rrn("9507121032120");
//		ecvo.setI_birth("950712");
//		ecvo.setI_hp("01040208223");
//		
//		System.out.println("test >>> : " + infoSetting(ecvo).getI_hp());
//	}// end of main() �Լ�

}// end of InfoUtil class