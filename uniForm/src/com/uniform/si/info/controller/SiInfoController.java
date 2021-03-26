package com.uniform.si.info.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uniform.common.info.service.CommonInfoService;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.common.utils.FileUtil;
import com.uniform.common.utils.InfoUtil;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.si.info.service.SiInfoService;
import com.uniform.si.info.vo.SiInfoVO;

@Controller
@RequestMapping("/si")
public class SiInfoController {
	
	private Logger logger = Logger.getLogger(SiInfoController.class);
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	@Autowired
	private SiInfoService siInfoService;
	
	@RequestMapping("/goSiMain")
	public ModelAndView siMain(@ModelAttribute SiInfoVO sivo,HttpServletRequest request){
		logger.info("siMain 호출 성공");
		
		EmCommonVO ecvo = new EmCommonVO();
		
		List<SiInfoVO> list = null;
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		ecvo.setI_no(i_no);
		EmCommonVO miniVO = commonInfoService.miniInfo(ecvo);
		
		list = siInfoService.studentList(sivo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("miniVO",miniVO);
		mav.addObject("siList",list);
		mav.setViewName("si/siMain");
		
		return mav;
	}// end of siMain() 함수
	
	@RequestMapping("/goInsertSi")
	public ModelAndView goInsertSi(){
		logger.info("goInsertSi 호출 성공");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("si/insertSi");
		
		return mav;
	}// end of goInsertSi() 함수
	
	@ResponseBody
	@RequestMapping(value="/imgUpload",produces="application/text; charset=utf-8")
	public String imgUpload(HttpServletRequest request){
		logger.info("imgUpload 호출 성공");
		String upload = "/si/img";
		String si_img = "";
		
		try{
			si_img = FileUtil.fileUpload(request, upload);
			System.out.println("등록한 사진 이름 >>> : " + si_img);
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		
		return si_img;
	}// end of imgUpload() 함수
	
	@ResponseBody
	@RequestMapping(value="/insertSi",produces="application/text; charset=utf-8")
	public String insertSi(@ModelAttribute SiInfoVO sivo){
		logger.info("insertSi 호출 성공");
		
		String result = "";
		
		SiInfoVO chaebunVO = siInfoService.siChaebun();
		
		String no = chaebunVO.getI_no();
		
		String i_no = ChaebunUtil.getChaebun(no, "si");
		sivo.setI_no(i_no);
		
		int cnt = siInfoService.insertSi(sivo);
		
		if(cnt==2){
			result = "성공";
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
		}
		return result;
	}// end of insertSi() 함수
	
	@RequestMapping("/goDetailSi")
	public ModelAndView goDetailSi(@ModelAttribute SiInfoVO sivo){
		logger.info("goDetailSi 호출 성공");
		
		SiInfoVO detailVO = siInfoService.detailSi(sivo);
		detailVO = InfoUtil.siSetting(detailVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO",detailVO);
		mav.setViewName("si/detailSi");
		
		return mav;
	}// end of goDetailSi() 함수
	
	@RequestMapping("/goUpdateSi")
	public ModelAndView goUpdateSi(@ModelAttribute SiInfoVO sivo){
		logger.info("goUpdateSi 호출 성공");
		
		SiInfoVO cDetailVO = siInfoService.cDetailSi(sivo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("cDetailVO",cDetailVO);
		mav.setViewName("si/updateSi");
		
		return mav;
	}// end of goUpdateSi() 함수
	
	@ResponseBody
	@RequestMapping(value="/uploadFile",produces="application/text; charset=utf-8")
	public String uploadFile(HttpServletRequest request){
		logger.info("uploadFile 호출 성공");
		
		String si_img = "";
		String upload = "/si/img";
		
		try{
			si_img = FileUtil.fileUpload(request, upload);
			System.out.println("업로드한 파일 이름 >>> : " + si_img);
		}catch(Exception e){
			System.out.println("에러났다 >>> : " + e.getMessage());
		}
		return si_img;
	}// end of uploadFile() 함수
	
	@ResponseBody
	@RequestMapping(value="/updateSi",produces="application/text; charset=utf-8")
	public String updateSi(@ModelAttribute SiInfoVO sivo){
		logger.info("updateSi 호출 성공");
		
		String result = "";
		
		int cnt = siInfoService.updateStudent(sivo);
		
		if(cnt==2){
			result = "성공";
		}else{
			result = "알 수 없는 이유로 실패 했습니다. 문의 주세요";
		}
		return result;
	}// end of updateSi() 함수
	
	@ResponseBody
	@RequestMapping(value="/deleteSi",produces="application/text; charset=utf-8")
	public String deleteSi(@ModelAttribute SiInfoVO sivo){
		logger.info("deleteSi 호출 성공");
		
//		String path = "C:/L_work/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String path = "D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
//		String path = "C:/Users/이상훈/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String delete = "/si/img/";
		String result = "";
		
		System.out.println("들어온거 >>>> : " + sivo.getI_no() + " : " + sivo.getSi_img());
		int cnt = siInfoService.deleteSi(sivo);
		
		if(cnt==1){
			File f = new File(path + delete + sivo.getSi_img());
			System.out.println("파일 맞습니까? >>> : " + f.isFile() + " : " + f);
			
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
	}// end of deleteSi() 함수

}// end of SiInfoController class
