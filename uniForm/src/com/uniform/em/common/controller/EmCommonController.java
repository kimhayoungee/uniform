package com.uniform.em.common.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uniform.common.info.service.CommonInfoService;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.common.utils.FileUtil;
import com.uniform.common.utils.InfoUtil;
import com.uniform.em.common.service.EmCommonService;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

@Controller
@RequestMapping("/em")
public class EmCommonController {
	
	private Logger logger = Logger.getLogger(EmCommonController.class);
	
	@Autowired
	private EmCommonService emCommonService;
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	@ResponseBody
	@RequestMapping("/addSign")
	public String addSign(HttpServletRequest request){
		logger.info("addSign ȣ�� ����");
		String result = "";

		try{
			HttpSession hs = request.getSession(true);
			String i_no = (String)hs.getAttribute("i_no");
			String upload = "/em/img";

			String em_sign = FileUtil.fileUpload(request, upload);
			em_sign = "/em/img/" + em_sign;
			EmCommonVO ecvo = new EmCommonVO();
			ecvo.setEm_sign(em_sign);
			ecvo.setI_no(i_no);
			
			int cnt = emCommonService.addSign(ecvo);
			
			if(cnt>0){
				int updateResult = emCommonService.updateDate(ecvo);
				if(updateResult>0){
					result = "����";
				}// ������¥ ������Ʈ ������ true
			}// ���� ��� ���� ������ true
			
		}catch(Exception e){
			System.out.println("�������� >>> : " + e.getMessage());
		}
		
		return result;
	}// end of addSign() �Լ�
	
	@RequestMapping("/goUpdateInfo")
	public ModelAndView goUpdateInfo(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("goUpdateInfo ȣ�� ����");
		
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		EmCommonVO updateInfo = commonInfoService.myInfo(ecvo);
		updateInfo = InfoUtil.infoSetting(updateInfo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateInfo",updateInfo);
		
		mav.setViewName("pi/updateInfo");
		
		return mav;
	}// end of goInfoUpdate() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/passwordChk",produces = "application/text; charset=utf8")
	public String passwordChk(@ModelAttribute EmCommonVO ecvo){
		logger.info("passwordChk ȣ�� ����");
		
		logger.info(ecvo.getEm_pw());
		String result = "";
		
		EmCommonVO pwResult = emCommonService.passwordChk(ecvo);
		
		boolean pwBool = pwResult!=null;
		if(pwBool){
			result = "����";
		}else{
			result = "��й�ȣ�� ��ġ���� �ʽ��ϴ�";
		}
		return result;
	}// end of passwordChk() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/updatePw",produces = "application/text; charset=utf8")
	public String updatePw(@ModelAttribute EmCommonVO ecvo){
		logger.info("updatePw ȣ�� ����");
		
		String result = "";
		
		logger.info("�׽�Ʈ >> : " + ecvo.getEm_pw() + " : " + ecvo.getI_no());
		
		int cnt = emCommonService.updatePw(ecvo);
		
		boolean pwBool = cnt>0;
		
		if(pwBool){
			int cnt2 = emCommonService.updateDate(ecvo);
			
			boolean pwBool2 = cnt2>0;
			
			if(pwBool2){
				result = "����";
			}else{
				result = "�ý��� ����!! �����ڿ��� ���� �ϼ���";
			}
		}else{
			result = "�ý��� ����!! �����ڿ��� ���� �ϼ���";
		}
		return result;
	}// end of updatePw() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/updateMm",produces = "application/text; charset=utf8")
	public String updateMm(@ModelAttribute MmSettingVO msvo,HttpServletRequest request){
		logger.info("updateMm ȣ�� ����");
		logger.info(msvo.getMm_alarm() + " : " + msvo.getMm_message());
		
		String result = "";
		
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		msvo.setI_no(i_no);
		
		int cnt = emCommonService.updateMm(msvo);
		
		if(cnt>0){
			EmCommonVO ecvo = new EmCommonVO();
			ecvo.setI_no(i_no);
			
			int cnt2 = emCommonService.updateDate(ecvo);
			
			if(cnt2>0){
				result = "����";
			}else{
				result = "�˼� ���� ������ ������Ʈ ����";
			}// ��¥ ������Ʈ Ȯ�� if��
		}else{
			result = "�˼� ���� ������ ������Ʈ ����";
		}// ���� ������Ʈ Ȯ�� if��
		
		return result;
	}// end of updateMm() �Լ�
	
	@RequestMapping("/goUpdateAddr")
	public String goUpdateAddr(){
		logger.info("goUpdateAddr ȣ�� ����");
		
		return "pi/updateAddr";
	}// end of goUpdateAddr() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/updateInfo",produces = "application/text; charset=utf8")
	public String updateInfo(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("updateInfo ȣ�� ����");
		
		String result = "";
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		int cnt = emCommonService.updateInfo(ecvo);
		if(cnt>0){
			int cnt2 = emCommonService.updateDate(ecvo);
			
			if(cnt2>0){
				result = "����";
			}else{
				result = "�˼����� ������ ������Ʈ�� �����߽��ϴ�";
			}
		}else{
			result = "�˼����� ������ ������Ʈ�� �����߽��ϴ�";
		}
		
		return result;
	}// end of updateInfo() �Լ�
	
	@RequestMapping("/splitType/{type}.uni")
	public ModelAndView splitType(@PathVariable String type){
		logger.info("splitType ȣ�� ����");
		
		System.out.println(type);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("type",type);
		mav.setViewName("pi/allInfo");
		
		return mav;
	}// end of splitType() �Լ�
	
	@RequestMapping("goUpdatePassword")
	public String goUpdatePassword(){
		logger.info("goUpdatePassword ȣ�� ����");
		
		return "pi/updatePassword";
	}// end of goUpdatePassword() �Լ�
	
	@RequestMapping("/goUpdateMm")
	public ModelAndView goUpdateMm(HttpServletRequest request){
		logger.info("goUpdateMm ȣ�� ����");
		
		EmCommonVO ecvo = new EmCommonVO();
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		MmSettingVO msvo = commonInfoService.mmSetting(ecvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msvo",msvo);
		mav.setViewName("pi/mmSetting");
		
		return mav;
	}// end of goUpdateMm() �Լ�
	
	@RequestMapping("/goUpdateSign")
	public ModelAndView goUpdateSign(@ModelAttribute EmCommonVO ecvo){
		logger.info("goUpdateSign ȣ�� ����");
		
		System.out.println("�õ弭�� Ȯ�� >>> : " + ecvo.getEm_sign());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ecvo",ecvo);
		mav.setViewName("pi/updateSign");
		
		return mav;
	}// end of goUpdateSign()�Լ�
	
	@ResponseBody
	@RequestMapping(value="/searchName",produces="application/json; charset=utf8")
	public List<EmCommonVO> searchName(@ModelAttribute EmCommonVO ecvo){
		logger.info("searchName ȣ�� ����");
		
		List<EmCommonVO> list = emCommonService.searchName(ecvo);
		
		return list;
	}// end of searchName() �Լ�
	
	@RequestMapping("/goEmMain")
	public ModelAndView goEmMain(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("goEmMain ȣ�� ����");
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");

		EmCommonVO ecvo1 = new EmCommonVO();
		ecvo1.setI_no(i_no);
		
		ecvo1 = commonInfoService.miniInfo(ecvo1);
		
		List<EmCommonVO> list = commonInfoService.infoCard(ecvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ecvo",ecvo1);
		mav.addObject("infoList",list);
		mav.addObject("keyword",ecvo.getKeyword());
		mav.addObject("search",ecvo.getSearch());
		mav.setViewName("em/emMain");
		
		return mav;
	}// end of goEmMain() �Լ�
	
	@RequestMapping("/goInsertEmp")
	public ModelAndView goInsertEmp(){
		logger.info("goInsertEmp ȣ�� ����");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("em/insertEmp");
		
		return mav;
	}// end of goInsertEmp() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/insertImage",produces="application/text; charset=utf-8")
	public String insertImage(HttpServletRequest request){
		logger.info("insertImage ȣ�� ����");
		
		String upload = "/common/img";
		String em_img = "";
		try{
			em_img = FileUtil.fileUpload(request, upload);
			System.out.println("���� ���� �̸� >> : " + em_img);
		}catch(Exception e){
			System.out.println("�������� >>> : " + e.getMessage());
		}
		
		return em_img;
	}// end of insertImage() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/insertInfo",produces="application/text; charset=utf-8")
	public String insertInfo(@ModelAttribute EmCommonVO ecvo){
		logger.info("insertInfo ȣ�� ����");
		
		String i_no = "";
		String result = "";
		
		EmCommonVO chaebunVO = emCommonService.empChaebun();
		
		i_no = ChaebunUtil.getChaebun(chaebunVO.getI_no(), "emp");
		
		ecvo.setI_no(i_no);
		System.out.println("�� ��ī���̰� ���� >> : " + ecvo.getEm_academic());
		int cnt = emCommonService.insertEmp(ecvo);
		
		if(cnt==3){
			result = "����";
		}else{
			result = "�� �� ���� ������ �����߽��ϴ�.";
		}
		
		return result;
	}// end of insertInfo() �Լ�
	
	@RequestMapping("/goDetailEmp")
	public ModelAndView goDetailEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("goDetailForm ȣ�� ����");
		
		EmCommonVO detailVO = commonInfoService.myInfo(ecvo);
		detailVO = InfoUtil.infoSetting(detailVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO", detailVO);
		mav.setViewName("em/detailEmp");
		
		return mav;
	}// end of goDetailForm() �Լ�
	
	@RequestMapping("/goUpdateEmp")
	public ModelAndView goUpdateEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("goUpdateEmp ȣ�� ����");
		
		EmCommonVO updateVO = commonInfoService.detailInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateVO", updateVO);
		mav.setViewName("em/updateEmp");
		
		return mav;
	}// end of goUpdateEmp() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/updateEmp",produces="application/text; charset=utf-8")
	public String updateEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("updateEmp ȣ�� ����");
		
		String result = "";
		System.out.println("�� ��ī���̰� ���� >> : " + ecvo.getEm_academic());
		int cnt = emCommonService.updateEmp(ecvo);
		
		if(cnt==2){
			int dateCnt = emCommonService.updateDate(ecvo);
			
			if(dateCnt==1){
				result = "����";
			}else{
				result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
			}
		}else{
			result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
		}
		
		return result;
	}// end of updateEmp() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/deleteEmp",produces="application/text; charset=utf-8")
	public String deleteEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("deleteEmp ȣ�� ����");
		
		String path = "D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
//		String path = "C:/Users/�̻���/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String delete = "/common/img/";
		String result = "";
		
		System.out.println("�׽�Ʈ >>> : " + ecvo.getI_no() + " : " + ecvo.getEm_img());
		int cnt = emCommonService.deleteEmp(ecvo);
		
		if(cnt==1){
			File f = new File(path + delete + ecvo.getEm_img());
			System.out.println("���� �¾�? >> : " + f.isFile());
			
			boolean fileBool = f.delete();
			
			if(fileBool){
				result = "����";
			}else{
				result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
			}
		}else{
			result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
		}
		return result;
	}// end of deleteEmp() �Լ�

}// end of EmCommonController class
