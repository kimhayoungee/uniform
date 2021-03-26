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
		logger.info("addSign 호출 성공");
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
					result = "성공";
				}// 수정날짜 업데이트 성공시 true
			}// 사인 경로 저장 성공시 true
			
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		
		return result;
	}// end of addSign() 함수
	
	@RequestMapping("/goUpdateInfo")
	public ModelAndView goUpdateInfo(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("goUpdateInfo 호출 성공");
		
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		EmCommonVO updateInfo = commonInfoService.myInfo(ecvo);
		updateInfo = InfoUtil.infoSetting(updateInfo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateInfo",updateInfo);
		
		mav.setViewName("pi/updateInfo");
		
		return mav;
	}// end of goInfoUpdate() 함수
	
	@ResponseBody
	@RequestMapping(value="/passwordChk",produces = "application/text; charset=utf8")
	public String passwordChk(@ModelAttribute EmCommonVO ecvo){
		logger.info("passwordChk 호출 성공");
		
		logger.info(ecvo.getEm_pw());
		String result = "";
		
		EmCommonVO pwResult = emCommonService.passwordChk(ecvo);
		
		boolean pwBool = pwResult!=null;
		if(pwBool){
			result = "성공";
		}else{
			result = "비밀번호가 일치하지 않습니다";
		}
		return result;
	}// end of passwordChk() 함수
	
	@ResponseBody
	@RequestMapping(value="/updatePw",produces = "application/text; charset=utf8")
	public String updatePw(@ModelAttribute EmCommonVO ecvo){
		logger.info("updatePw 호출 성공");
		
		String result = "";
		
		logger.info("테스트 >> : " + ecvo.getEm_pw() + " : " + ecvo.getI_no());
		
		int cnt = emCommonService.updatePw(ecvo);
		
		boolean pwBool = cnt>0;
		
		if(pwBool){
			int cnt2 = emCommonService.updateDate(ecvo);
			
			boolean pwBool2 = cnt2>0;
			
			if(pwBool2){
				result = "성공";
			}else{
				result = "시스템 에러!! 관리자에게 문의 하세요";
			}
		}else{
			result = "시스템 에러!! 관리자에게 문의 하세요";
		}
		return result;
	}// end of updatePw() 함수
	
	@ResponseBody
	@RequestMapping(value="/updateMm",produces = "application/text; charset=utf8")
	public String updateMm(@ModelAttribute MmSettingVO msvo,HttpServletRequest request){
		logger.info("updateMm 호출 성공");
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
				result = "성공";
			}else{
				result = "알수 없는 이유로 업데이트 실패";
			}// 날짜 업데이트 확인 if문
		}else{
			result = "알수 없는 이유로 업데이트 실패";
		}// 정보 업데이트 확인 if문
		
		return result;
	}// end of updateMm() 함수
	
	@RequestMapping("/goUpdateAddr")
	public String goUpdateAddr(){
		logger.info("goUpdateAddr 호출 성공");
		
		return "pi/updateAddr";
	}// end of goUpdateAddr() 함수
	
	@ResponseBody
	@RequestMapping(value="/updateInfo",produces = "application/text; charset=utf8")
	public String updateInfo(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("updateInfo 호출 성공");
		
		String result = "";
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		int cnt = emCommonService.updateInfo(ecvo);
		if(cnt>0){
			int cnt2 = emCommonService.updateDate(ecvo);
			
			if(cnt2>0){
				result = "성공";
			}else{
				result = "알수없는 이유로 업데이트에 실패했습니다";
			}
		}else{
			result = "알수없는 이유로 업데이트에 실패했습니다";
		}
		
		return result;
	}// end of updateInfo() 함수
	
	@RequestMapping("/splitType/{type}.uni")
	public ModelAndView splitType(@PathVariable String type){
		logger.info("splitType 호출 성공");
		
		System.out.println(type);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("type",type);
		mav.setViewName("pi/allInfo");
		
		return mav;
	}// end of splitType() 함수
	
	@RequestMapping("goUpdatePassword")
	public String goUpdatePassword(){
		logger.info("goUpdatePassword 호출 성공");
		
		return "pi/updatePassword";
	}// end of goUpdatePassword() 함수
	
	@RequestMapping("/goUpdateMm")
	public ModelAndView goUpdateMm(HttpServletRequest request){
		logger.info("goUpdateMm 호출 성공");
		
		EmCommonVO ecvo = new EmCommonVO();
		HttpSession hs = request.getSession(true);
		String i_no = (String)hs.getAttribute("i_no");
		ecvo.setI_no(i_no);
		
		MmSettingVO msvo = commonInfoService.mmSetting(ecvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msvo",msvo);
		mav.setViewName("pi/mmSetting");
		
		return mav;
	}// end of goUpdateMm() 함수
	
	@RequestMapping("/goUpdateSign")
	public ModelAndView goUpdateSign(@ModelAttribute EmCommonVO ecvo){
		logger.info("goUpdateSign 호출 성공");
		
		System.out.println("올드서명 확인 >>> : " + ecvo.getEm_sign());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ecvo",ecvo);
		mav.setViewName("pi/updateSign");
		
		return mav;
	}// end of goUpdateSign()함수
	
	@ResponseBody
	@RequestMapping(value="/searchName",produces="application/json; charset=utf8")
	public List<EmCommonVO> searchName(@ModelAttribute EmCommonVO ecvo){
		logger.info("searchName 호출 성공");
		
		List<EmCommonVO> list = emCommonService.searchName(ecvo);
		
		return list;
	}// end of searchName() 함수
	
	@RequestMapping("/goEmMain")
	public ModelAndView goEmMain(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		logger.info("goEmMain 호출 성공");
		
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
	}// end of goEmMain() 함수
	
	@RequestMapping("/goInsertEmp")
	public ModelAndView goInsertEmp(){
		logger.info("goInsertEmp 호출 성공");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("em/insertEmp");
		
		return mav;
	}// end of goInsertEmp() 함수
	
	@ResponseBody
	@RequestMapping(value="/insertImage",produces="application/text; charset=utf-8")
	public String insertImage(HttpServletRequest request){
		logger.info("insertImage 호출 성공");
		
		String upload = "/common/img";
		String em_img = "";
		try{
			em_img = FileUtil.fileUpload(request, upload);
			System.out.println("나온 파일 이름 >> : " + em_img);
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		
		return em_img;
	}// end of insertImage() 함수
	
	@ResponseBody
	@RequestMapping(value="/insertInfo",produces="application/text; charset=utf-8")
	public String insertInfo(@ModelAttribute EmCommonVO ecvo){
		logger.info("insertInfo 호출 성공");
		
		String i_no = "";
		String result = "";
		
		EmCommonVO chaebunVO = emCommonService.empChaebun();
		
		i_no = ChaebunUtil.getChaebun(chaebunVO.getI_no(), "emp");
		
		ecvo.setI_no(i_no);
		System.out.println("왜 아카데미가 없어 >> : " + ecvo.getEm_academic());
		int cnt = emCommonService.insertEmp(ecvo);
		
		if(cnt==3){
			result = "성공";
		}else{
			result = "알 수 없는 이유로 실패했습니다.";
		}
		
		return result;
	}// end of insertInfo() 함수
	
	@RequestMapping("/goDetailEmp")
	public ModelAndView goDetailEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("goDetailForm 호출 성공");
		
		EmCommonVO detailVO = commonInfoService.myInfo(ecvo);
		detailVO = InfoUtil.infoSetting(detailVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO", detailVO);
		mav.setViewName("em/detailEmp");
		
		return mav;
	}// end of goDetailForm() 함수
	
	@RequestMapping("/goUpdateEmp")
	public ModelAndView goUpdateEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("goUpdateEmp 호출 성공");
		
		EmCommonVO updateVO = commonInfoService.detailInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updateVO", updateVO);
		mav.setViewName("em/updateEmp");
		
		return mav;
	}// end of goUpdateEmp() 함수
	
	@ResponseBody
	@RequestMapping(value="/updateEmp",produces="application/text; charset=utf-8")
	public String updateEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("updateEmp 호출 성공");
		
		String result = "";
		System.out.println("왜 아카데미가 없어 >> : " + ecvo.getEm_academic());
		int cnt = emCommonService.updateEmp(ecvo);
		
		if(cnt==2){
			int dateCnt = emCommonService.updateDate(ecvo);
			
			if(dateCnt==1){
				result = "성공";
			}else{
				result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
			}
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
		}
		
		return result;
	}// end of updateEmp() 함수
	
	@ResponseBody
	@RequestMapping(value="/deleteEmp",produces="application/text; charset=utf-8")
	public String deleteEmp(@ModelAttribute EmCommonVO ecvo){
		logger.info("deleteEmp 호출 성공");
		
		String path = "D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
//		String path = "C:/Users/이상훈/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String delete = "/common/img/";
		String result = "";
		
		System.out.println("테스트 >>> : " + ecvo.getI_no() + " : " + ecvo.getEm_img());
		int cnt = emCommonService.deleteEmp(ecvo);
		
		if(cnt==1){
			File f = new File(path + delete + ecvo.getEm_img());
			System.out.println("파일 맞아? >> : " + f.isFile());
			
			boolean fileBool = f.delete();
			
			if(fileBool){
				result = "성공";
			}else{
				result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
			}
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
		}
		return result;
	}// end of deleteEmp() 함수

}// end of EmCommonController class
