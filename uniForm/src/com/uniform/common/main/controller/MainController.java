package com.uniform.common.main.controller;

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

import com.uniform.bm.board.service.BmBoardService;
import com.uniform.bm.board.vo.BmBoardVO;
import com.uniform.common.info.service.CommonInfoService;
import com.uniform.common.utils.InfoUtil;
import com.uniform.common.utils.Paging;
import com.uniform.common.utils.PagingUtil;
import com.uniform.ea.approval.service.EaApprovalService;
import com.uniform.ea.approval.vo.EaApprovalVO;
import com.uniform.ea.approval.vo.PageVO;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.message.service.MmMessageService;
import com.uniform.mm.message.vo.MmMessageVO;
import com.uniform.mm.setting.vo.MmSettingVO;
import com.uniform.nm.notice.service.NmNoticeService;
import com.uniform.nm.notice.vo.NmNoticeVO;
import com.uniform.pm.plan.service.PmPlanService;
import com.uniform.pm.plan.vo.PmPlanVO;

@Controller
@RequestMapping("/main")
public class MainController {
	
	Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private CommonInfoService commonInfoService;
	
	@Autowired
	private MmMessageService mmMessageService;
	
	@Autowired
	private NmNoticeService nmNoticeService;
	
	@Autowired
	private BmBoardService bmBoardService;
	
	@Autowired
	private EaApprovalService eaApprovalService;
	
	@Autowired
	private PmPlanService pmPlanService;
	
	@RequestMapping("/goMyInfo")
	public ModelAndView goMyInfo(HttpServletRequest request){
		logger.info("goMyInfo ȣ?? ????");
		
		ModelAndView mav = null;
		mav = new ModelAndView();
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		boolean sessionBool = false;
		
		try{
			sessionBool = i_no!=null&&i_no.length()>0;
		}catch(Exception e){
			System.out.println("(log) ???ڿ??? null?Դϴ?");
		}
		
		if(sessionBool){
			EmCommonVO ecvo = new EmCommonVO();
			ecvo.setI_no(i_no);
			
			EmCommonVO myInfoVO = commonInfoService.myInfo(ecvo);
			myInfoVO = InfoUtil.infoSetting(myInfoVO);
			MmSettingVO msvo = commonInfoService.mmSetting(ecvo);
			msvo = InfoUtil.mmSetting(msvo);
			
			mav.addObject("myInfoVO",myInfoVO);
			mav.addObject("msvo",msvo);
		}
		mav.setViewName("/pi/myInfo");
		return mav;
	}// end of goMyInfo() ?Լ?
	
	@RequestMapping("/goMain")
	public ModelAndView goMain(HttpServletRequest request){
		logger.info("goMain ȣ?? ????");
		
		ModelAndView mav = null;
		mav = new ModelAndView();
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		boolean sessionBool = false;
		sessionBool = i_no!=null;
		
		if(sessionBool){
			// ???? ȭ?鿡 ?????? ?????? ???? ????
			EmCommonVO ecvo = new EmCommonVO();
			ecvo.setI_no(i_no);
			EmCommonVO mainVO = commonInfoService.mainInfo(ecvo);
			
			MmMessageVO mmvo = new MmMessageVO();
			mmvo.setI_no(i_no);
			Paging.setPage(mmvo);
			
			// ???? ????
			int mSize = mmMessageService.countList(mmvo);
			// ?????? ?????? ????
			List<MmMessageVO> mList = mmMessageService.messageList(mmvo);
			
			// ?????? ?????? ????
			NmNoticeVO nnvo = new NmNoticeVO();
			PagingUtil.setPageN(nnvo);
			List<NmNoticeVO> nList = nmNoticeService.noticeList(nnvo);
			// ?????? ?????? ?Խñ?
			BmBoardVO bbvo = new BmBoardVO();
			PagingUtil.setPage(bbvo);
			List<BmBoardVO> bList = bmBoardService.boardList(bbvo);
			// ?????? ?????? ???ڰ???
			PageVO pvo = new PageVO();
			pvo.setDo_aprno(i_no);
			pvo.setPageSize(10);
			List<PageVO> toList = eaApprovalService.toApSelect(pvo);
			
			mav.addObject("toList",toList);
			mav.addObject("boardList",bList);
			mav.addObject("noticeList",nList);
			mav.addObject("messageList",mList);
			mav.addObject("mainVO",mainVO);
			mav.addObject("mSize",mSize);
		}
		mav.setViewName("main/main");
	
		return mav;
	}// end of goMain() ?Լ?
	
	@RequestMapping("/goAddSign")
	public ModelAndView goAddSign(){
		
		logger.info("goAddSign ȣ?? ????");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("pi/addSign");
		
		return mav;
	}// end of goAddSign() ?Լ?
	
	@ResponseBody
	@RequestMapping("/getMessageCnt")
	public int getMessageCnt(@ModelAttribute MmMessageVO mmvo){
		
		int testCnt = mmMessageService.countList(mmvo);
		
		return testCnt;
	}// end of test() ?Լ?
	
	// ???????? ?????????? ?̵?
	@RequestMapping(value="/pmGoPlanMain")
	public ModelAndView goPlanMain(@ModelAttribute PmPlanVO ppvo,HttpServletRequest request){
		logger.info("goPlanMain ȣ?? ????");
		
		HttpSession hs = request.getSession();
		String i_no = (String)hs.getAttribute("i_no");
		
		EmCommonVO ecvo = new EmCommonVO();
		ecvo.setI_no(i_no);
		ecvo = commonInfoService.miniInfo(ecvo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ecvo",ecvo);
		mav.setViewName("plan/planMain");
		
		return mav;
	}// end of goPlanMain() ?Լ?
	
	@ResponseBody
	@RequestMapping(value="/getPlanList",produces="application/json; charset=utf-8")
	public List<PmPlanVO> getPlanList(@ModelAttribute PmPlanVO ppvo){
		
		List<PmPlanVO> pList = pmPlanService.getAlarm(ppvo);
		
		return pList;
	}// end of getPlanList() ?Լ?

}// end of MainController class
