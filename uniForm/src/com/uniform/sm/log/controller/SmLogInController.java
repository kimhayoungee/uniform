package com.uniform.sm.log.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.manager.util.SessionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uniform.common.utils.SessionUtil;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.sm.log.service.SmLoginService;

@Controller
@RequestMapping("/sm")
public class SmLogInController {
	
	private Logger logger = Logger.getLogger(SmLogInController.class);
	
	@Autowired
	private SmLoginService smLoginService;
	
	@ResponseBody
	@RequestMapping(value="/login",produces = "application/text; charset=utf8")
	public String login(@ModelAttribute EmCommonVO ecvo,HttpServletRequest request){
		
		logger.info("ȣ�� ����");
		
		String result = "";
		
		System.out.println("id >>> : " + ecvo.getI_no());
		System.out.println("pw >>> : " + ecvo.getEm_pw());
		
		EmCommonVO logVO = smLoginService.login(ecvo);
		
		boolean b1 = logVO!=null;
		
		if(b1){
			SessionUtil.newSession(request, logVO.getI_no());
			
			result = "����";
		}else{
			result = "�α��� ������ ��ġ���� �ʽ��ϴ�";
		}
		return result;
	}// end of login() �Լ�
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request){
		logger.info("logout ȣ�� ����");
		ModelAndView mav = null;
		
		SessionUtil.killSession(request);
		mav = new ModelAndView();
		mav.addObject("result","�α׾ƿ�");
		mav.setViewName("../../index");
		
		return mav;
	}// end of logout() �Լ�
	
}// end of SmLogInController class
