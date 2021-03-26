package com.uniform.mm.message.controller;

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
import com.uniform.common.utils.Paging;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.message.service.MmMessageService;
import com.uniform.mm.message.vo.MmMessageVO;

@Controller
@RequestMapping("/mm")
public class MmMessageController {
	
	private Logger logger = Logger.getLogger(MmMessageController.class);
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	@Autowired
	private MmMessageService mmMessageService;
	
	@RequestMapping("/goMessageMain")
	public ModelAndView goMessageMain(@ModelAttribute MmMessageVO mmvo,HttpServletRequest request){
		logger.info("goMessageMain ȣ�� ����");
		
		ModelAndView mav = null;
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		mav = new ModelAndView();
		
		boolean seBool = i_no!=null&&i_no!="";
		
		if(seBool){
			List<MmMessageVO> list = null;
			
			Paging.setPage(mmvo);
			
			mmvo.setI_no(i_no);
			int total = mmMessageService.countList(mmvo);
			
			System.out.println("mmvo �ȿ� ������ >> : " + mmvo.getI_no() + " : " + mmvo.getPage() + " : " + mmvo.getStart() + " : " + mmvo.getEnd());
			System.out.println("������ �� �? >> : " + total);
			
			list = mmMessageService.messageList(mmvo);
			
			EmCommonVO ecvo = new EmCommonVO();
			ecvo.setI_no(i_no);
			
			ecvo = commonInfoService.miniInfo(ecvo);
			
			mav.addObject("ecvo",ecvo);
			mav.addObject("messageList",list);
			mav.addObject("total",total + "");
			mav.addObject("page",mmvo.getPage());
		}
		mav.setViewName("mm/messageMain");
		
		return mav;
	}// end of goMessageMain() �Լ�
	
	@RequestMapping("/goInsertMessage")
	public String goInsertMessage(){
		logger.info("goInsertMessage ȣ�� ����");
		
		return "mm/insertMessage";
	}// end of goInsertMessage() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/insertMessage",produces="application/text; charset=UTF-8")
	public String insertMessage(@ModelAttribute MmMessageVO mmvo){
		logger.info("insertMessage ȣ�� ����");
		String result = "";
		
		System.out.println("�׽�Ʈ >>> : " + mmvo.getMm_recipient() + " : " + mmvo.getMm_message());
		
		MmMessageVO questionVO = mmMessageService.question(mmvo);
		if(questionVO.getMm_message().equals("Y")){
		
			MmMessageVO chaebunVO = mmMessageService.messageChaebun();
			
			String mm_no = ChaebunUtil.getChaebun(chaebunVO.getMm_no(), "mm");
			
			mmvo.setMm_no(mm_no);
			
			int cnt = mmMessageService.insertMessage(mmvo);
			
			if(cnt>0){
				result = "����";
			}else{
				result = "�� �� ���� ������ ���� �߽��ϴ�. ���� �ּ���";
			}
			
		}else{
			result = "���� ������ �ź��� ����� �Դϴ�";
		}
		
		return result;
	}// end of insertMessage() �Լ�
	
	@RequestMapping("/goDetailMessage")
	public ModelAndView goDetailMessage(@ModelAttribute MmMessageVO mmvo){
		logger.info("goDetailMessage ȣ�� ����");
		
		System.out.println("�Ѿ�� �� ��ȣ Ȯ�� >> : " + mmvo.getMm_no());
		
		mmvo = mmMessageService.detailMessage(mmvo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("detailVO",mmvo);
		mav.setViewName("mm/detailMessage");
		
		return mav;
	}// end of goDetailMessage() �Լ�
	
	@RequestMapping(value="/goReturnMessage",produces="application/text; charset=utf-8")
	public ModelAndView returnMessage(@ModelAttribute MmMessageVO mmvo){
		logger.info("returnMessage ȣ�� ����");
		
		System.out.println("Ȯ�� >> : " + mmvo.getI_nameKr() + " : " + mmvo.getMm_recipient());
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mmvo",mmvo);
		mav.setViewName("mm/returnMessage");
		
		return mav;
	}// end of returnMessage() �Լ�
	
	@ResponseBody
	@RequestMapping(value="/deleteMessage",produces="application/text; charset=utf-8")
	public String deleteMessage(@ModelAttribute MmMessageVO mmvo){
		logger.info("deleteMessage ȣ�� ����");
		
		String result = "";
		int resultCnt = 0;
		int cnt = 0;
		System.out.println("�Ѿ�� ������ >>> : " + mmvo.getMm_no());
		String noArray[] = mmvo.getMm_no().split(",");
		System.out.println(noArray.length);
		
		for(int i=0;i<noArray.length;i++){
			mmvo.setMm_no(noArray[i]);
			cnt = mmMessageService.deleteMessage(mmvo);
			if(cnt>0){
				resultCnt++;
			}else{
				break;
			}
		}// ������ ������ ������ŭ �����ϴ� for�� ����
		
		boolean cntBool = resultCnt==noArray.length;
		
		if(cntBool){
			result = "����";
		}else{
			result = "�� �� ���� ������ ������ ���� �߽��ϴ�";
		}
		
		return result;
	}// end of deleteMessage()�Լ�

}// end of MmMessageController
