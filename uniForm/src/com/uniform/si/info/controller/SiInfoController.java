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
		logger.info("siMain ȣ�� ����");
		
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
	}// end of siMain() �Լ�
	
	@RequestMapping("/goInsertSi")
	public ModelAndView goInsertSi(){
		logger.info("goInsertSi ȣ�� ����");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("si/insertSi");
		
		return mav;
	}// end of goInsertSi() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/imgUpload",produces="application/text; charset=utf-8")
	public String imgUpload(HttpServletRequest request){
		logger.info("imgUpload ȣ�� ����");
		String upload = "/si/img";
		String si_img = "";
		
		try{
			si_img = FileUtil.fileUpload(request, upload);
			System.out.println("����� ���� �̸� >>> : " + si_img);
		}catch(Exception e){
			System.out.println("�������� >>> : " + e.getMessage());
		}
		
		return si_img;
	}// end of imgUpload() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/insertSi",produces="application/text; charset=utf-8")
	public String insertSi(@ModelAttribute SiInfoVO sivo){
		logger.info("insertSi ȣ�� ����");
		
		String result = "";
		
		SiInfoVO chaebunVO = siInfoService.siChaebun();
		
		String no = chaebunVO.getI_no();
		
		String i_no = ChaebunUtil.getChaebun(no, "si");
		sivo.setI_no(i_no);
		
		int cnt = siInfoService.insertSi(sivo);
		
		if(cnt==2){
			result = "����";
		}else{
			result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
		}
		return result;
	}// end of insertSi() �Լ�
	
	@RequestMapping("/goDetailSi")
	public ModelAndView goDetailSi(@ModelAttribute SiInfoVO sivo){
		logger.info("goDetailSi ȣ�� ����");
		
		SiInfoVO detailVO = siInfoService.detailSi(sivo);
		detailVO = InfoUtil.siSetting(detailVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO",detailVO);
		mav.setViewName("si/detailSi");
		
		return mav;
	}// end of goDetailSi() �Լ�
	
	@RequestMapping("/goUpdateSi")
	public ModelAndView goUpdateSi(@ModelAttribute SiInfoVO sivo){
		logger.info("goUpdateSi ȣ�� ����");
		
		SiInfoVO cDetailVO = siInfoService.cDetailSi(sivo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("cDetailVO",cDetailVO);
		mav.setViewName("si/updateSi");
		
		return mav;
	}// end of goUpdateSi() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/uploadFile",produces="application/text; charset=utf-8")
	public String uploadFile(HttpServletRequest request){
		logger.info("uploadFile ȣ�� ����");
		
		String si_img = "";
		String upload = "/si/img";
		
		try{
			si_img = FileUtil.fileUpload(request, upload);
			System.out.println("���ε��� ���� �̸� >>> : " + si_img);
		}catch(Exception e){
			System.out.println("�������� >>> : " + e.getMessage());
		}
		return si_img;
	}// end of uploadFile() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/updateSi",produces="application/text; charset=utf-8")
	public String updateSi(@ModelAttribute SiInfoVO sivo){
		logger.info("updateSi ȣ�� ����");
		
		String result = "";
		
		int cnt = siInfoService.updateStudent(sivo);
		
		if(cnt==2){
			result = "����";
		}else{
			result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
		}
		return result;
	}// end of updateSi() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/deleteSi",produces="application/text; charset=utf-8")
	public String deleteSi(@ModelAttribute SiInfoVO sivo){
		logger.info("deleteSi ȣ�� ����");
		
//		String path = "C:/L_work/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String path = "D:/00.BITCAMP/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
//		String path = "C:/Users/�̻���/Desktop/java142Uniform/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/uniForm";
		String delete = "/si/img/";
		String result = "";
		
		System.out.println("���°� >>>> : " + sivo.getI_no() + " : " + sivo.getSi_img());
		int cnt = siInfoService.deleteSi(sivo);
		
		if(cnt==1){
			File f = new File(path + delete + sivo.getSi_img());
			System.out.println("���� �½��ϱ�? >>> : " + f.isFile() + " : " + f);
			
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
	}// end of deleteSi() �Լ�

}// end of SiInfoController class
