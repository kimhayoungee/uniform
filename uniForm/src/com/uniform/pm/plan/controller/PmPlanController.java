package com.uniform.pm.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uniform.pm.plan.utils.JsonTest;
import com.uniform.common.utils.ChaebunUtil;
import com.uniform.pm.plan.service.PmPlanService;
import com.uniform.pm.plan.vo.PmPlanVO;

@Controller
@RequestMapping("/plan")
public class PmPlanController {
	
	private Logger logger = Logger.getLogger(PmPlanController.class);
	
	@Autowired
	private PmPlanService pmPlanService;
	
	// 일정 전체조회
	@ResponseBody
	@RequestMapping(value="/planList")
	public JSONArray planList(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]일정전체조회 planList 함수 시작 >>> ");
		logger.info("데이터 확인 >>> pm_start : " + ppvo.getPm_start() + ", pm_end : " + ppvo.getPm_end());
		logger.info("데이터 확인 >>> 세션에서 꺼내온 현재 로그인중인 회원번호 i_no : " + ppvo.getI_no());
	
		// 전체일정조회 객체생성
		List<PmPlanVO> planList = null;
		planList = pmPlanService.planList(ppvo);
		logger.info("전체일정갯수 : " + planList.size());

		// 전체일정객체 json데이터로 변환
		JSONArray jsonArr = null;	
		
		try {
			jsonArr = JsonTest.getJson(planList);
			PmPlanVO.printVO(ppvo);
		} catch (Exception e) {
			e.getMessage();
		}
		
		logger.info("[log]일정전체조회 planList 함수 끝 <<< ");
		return jsonArr;
	}
	// 일정 상세보기
	@ResponseBody
	@RequestMapping(value="/planDetail")
	public JSONArray planDetail(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]일정상세조회 planDetail함수 시작 >>> ");
		logger.info("데이터 확인 >>> pm_no : " + ppvo.getPm_no());		
		
		JSONArray jsonArr = null;
		List<PmPlanVO> planDetailList = null;
		planDetailList = pmPlanService.planDetail(ppvo);
		
		try {			
			jsonArr = JsonTest.getJson(planDetailList);
		} catch (Exception e) {
			e.getMessage();
		}
		
		logger.info("[log]일정상세조회 planDetail함수 끝 <<< ");
		return jsonArr;
	}
	
	// 일정 등록
	@ResponseBody
	@RequestMapping("/planInsert")
	public JSONArray planInsert(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]일정등록 planInsert 함수 시작 >>> ");

		// 채번
		// 서비스 채번 연결
		PmPlanVO planChaebunVO = pmPlanService.planChaebun(ppvo);
		String chaebunPM = planChaebunVO.getPm_no();
		logger.info("chaebunPM >>> : " + chaebunPM);
		String pm_no = ChaebunUtil.pmChaebun(chaebunPM);
		logger.info("pm_no >>> : " + pm_no);
		ppvo.setPm_no(pm_no);
		
		// 매개변수 데이터 확인
		PmPlanVO.printVO(ppvo);
		
		int nCntInsert = 0;

		nCntInsert = pmPlanService.planInsert(ppvo);
		logger.info("등록성공 이벤트 개수 nCntInsert : " + nCntInsert);
						
		logger.info("[log]컨트롤러 일정등록 planInsert 함수 끝 >>> ");
		return null;
	}
	// 일정 수정(테스트용)
	@ResponseBody
	@RequestMapping(value="/planUpdate")
	public JSONArray planUpdate(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]일정수정 함수 시작 >>>");
		
		// 매개변수 데이터 확인
		PmPlanVO.printVO(ppvo);
		
		int nCntUpdate = pmPlanService.planUpdate(ppvo);
		logger.info("일정 업데이트 갯수 >>> nCntUpdate : " + nCntUpdate);

		JSONArray jsonArr = null;
		List<PmPlanVO> planList = null;
		
		if(nCntUpdate == 1){
			planList = pmPlanService.planList(ppvo);
			int listSize = planList.size();
			logger.info("이벤트 갯수 listSize : " + listSize);
			
			try {			
				jsonArr = JsonTest.getJson(planList);
				PmPlanVO.printVO(ppvo);
			} catch (Exception e) {
				e.getMessage();
			}
		}else{
			logger.info("일정수정 실패");
		}
		
		logger.info("[log]일정수정 함수 끝 <<<");
		return jsonArr;
	}
	@ResponseBody
	@RequestMapping(value="/planDelete")
	public JSONArray planDelete(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]일정삭제 함수 시작 >>> ");
		
		// 매개변수 데이터 확인
		PmPlanVO.printVO(ppvo);
		
		int nCntDelete = pmPlanService.planDelete(ppvo);
		logger.info("일정 삭제 갯수 >>> nCntDelete : " + nCntDelete);		
		
		logger.info("[log]일정삭제 함수 끝 <<< ");
		return null;
	}
	
	// 회원검색 ==================================
	@ResponseBody
	@RequestMapping(value="/planSearchMember",produces="application/json;charset=utf-8")
	public Map<String,String> planSearchMember(@RequestParam("q") String _i_nameKr){
		logger.info("[log] 회원검색 함수 호출!");
				
		Map<String,String> planSearchMemberMap = null;
		
		PmPlanVO ppvo = new PmPlanVO();
		ppvo.setI_nameKr(_i_nameKr);
		
		// 서비스 연결
		List<PmPlanVO> planSearchMemberList = pmPlanService.planSearchMember(ppvo);
		
		
		if(planSearchMemberList!=null && planSearchMemberList.size()>0){
			for(int i=0;i<planSearchMemberList.size();i++){
				PmPlanVO searchMemVO = null;
				searchMemVO = planSearchMemberList.get(i);
				String i_no = searchMemVO.getI_no();
				String i_nameKr = searchMemVO.getI_nameKr();
				String pm_dept = searchMemVO.getPm_dept();
				logger.info("조회결과 데이터 >>> i_nameKr : " + i_nameKr + ", pm_dept : " + pm_dept);
				
				planSearchMemberMap = new HashMap<String,String>();
				planSearchMemberMap.put("i_no", i_no);
				planSearchMemberMap.put("i_nameKr", i_nameKr);
				planSearchMemberMap.put("pm_dept", pm_dept);
				planSearchMemberMap.put("total_count",planSearchMemberList.size()+"");
			}
		}
		
		return planSearchMemberMap;
	}
}
