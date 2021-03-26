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
	
	// ���� ��ü��ȸ
	@ResponseBody
	@RequestMapping(value="/planList")
	public JSONArray planList(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]������ü��ȸ planList �Լ� ���� >>> ");
		logger.info("������ Ȯ�� >>> pm_start : " + ppvo.getPm_start() + ", pm_end : " + ppvo.getPm_end());
		logger.info("������ Ȯ�� >>> ���ǿ��� ������ ���� �α������� ȸ����ȣ i_no : " + ppvo.getI_no());
	
		// ��ü������ȸ ��ü����
		List<PmPlanVO> planList = null;
		planList = pmPlanService.planList(ppvo);
		logger.info("��ü�������� : " + planList.size());

		// ��ü������ü json�����ͷ� ��ȯ
		JSONArray jsonArr = null;	
		
		try {
			jsonArr = JsonTest.getJson(planList);
			PmPlanVO.printVO(ppvo);
		} catch (Exception e) {
			e.getMessage();
		}
		
		logger.info("[log]������ü��ȸ planList �Լ� �� <<< ");
		return jsonArr;
	}
	// ���� �󼼺���
	@ResponseBody
	@RequestMapping(value="/planDetail")
	public JSONArray planDetail(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]��������ȸ planDetail�Լ� ���� >>> ");
		logger.info("������ Ȯ�� >>> pm_no : " + ppvo.getPm_no());		
		
		JSONArray jsonArr = null;
		List<PmPlanVO> planDetailList = null;
		planDetailList = pmPlanService.planDetail(ppvo);
		
		try {			
			jsonArr = JsonTest.getJson(planDetailList);
		} catch (Exception e) {
			e.getMessage();
		}
		
		logger.info("[log]��������ȸ planDetail�Լ� �� <<< ");
		return jsonArr;
	}
	
	// ���� ���
	@ResponseBody
	@RequestMapping("/planInsert")
	public JSONArray planInsert(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]������� planInsert �Լ� ���� >>> ");

		// ä��
		// ���� ä�� ����
		PmPlanVO planChaebunVO = pmPlanService.planChaebun(ppvo);
		String chaebunPM = planChaebunVO.getPm_no();
		logger.info("chaebunPM >>> : " + chaebunPM);
		String pm_no = ChaebunUtil.pmChaebun(chaebunPM);
		logger.info("pm_no >>> : " + pm_no);
		ppvo.setPm_no(pm_no);
		
		// �Ű����� ������ Ȯ��
		PmPlanVO.printVO(ppvo);
		
		int nCntInsert = 0;

		nCntInsert = pmPlanService.planInsert(ppvo);
		logger.info("��ϼ��� �̺�Ʈ ���� nCntInsert : " + nCntInsert);
						
		logger.info("[log]��Ʈ�ѷ� ������� planInsert �Լ� �� >>> ");
		return null;
	}
	// ���� ����(�׽�Ʈ��)
	@ResponseBody
	@RequestMapping(value="/planUpdate")
	public JSONArray planUpdate(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]�������� �Լ� ���� >>>");
		
		// �Ű����� ������ Ȯ��
		PmPlanVO.printVO(ppvo);
		
		int nCntUpdate = pmPlanService.planUpdate(ppvo);
		logger.info("���� ������Ʈ ���� >>> nCntUpdate : " + nCntUpdate);

		JSONArray jsonArr = null;
		List<PmPlanVO> planList = null;
		
		if(nCntUpdate == 1){
			planList = pmPlanService.planList(ppvo);
			int listSize = planList.size();
			logger.info("�̺�Ʈ ���� listSize : " + listSize);
			
			try {			
				jsonArr = JsonTest.getJson(planList);
				PmPlanVO.printVO(ppvo);
			} catch (Exception e) {
				e.getMessage();
			}
		}else{
			logger.info("�������� ����");
		}
		
		logger.info("[log]�������� �Լ� �� <<<");
		return jsonArr;
	}
	@ResponseBody
	@RequestMapping(value="/planDelete")
	public JSONArray planDelete(@ModelAttribute PmPlanVO ppvo){
		logger.info("[log]�������� �Լ� ���� >>> ");
		
		// �Ű����� ������ Ȯ��
		PmPlanVO.printVO(ppvo);
		
		int nCntDelete = pmPlanService.planDelete(ppvo);
		logger.info("���� ���� ���� >>> nCntDelete : " + nCntDelete);		
		
		logger.info("[log]�������� �Լ� �� <<< ");
		return null;
	}
	
	// ȸ���˻� ==================================
	@ResponseBody
	@RequestMapping(value="/planSearchMember",produces="application/json;charset=utf-8")
	public Map<String,String> planSearchMember(@RequestParam("q") String _i_nameKr){
		logger.info("[log] ȸ���˻� �Լ� ȣ��!");
				
		Map<String,String> planSearchMemberMap = null;
		
		PmPlanVO ppvo = new PmPlanVO();
		ppvo.setI_nameKr(_i_nameKr);
		
		// ���� ����
		List<PmPlanVO> planSearchMemberList = pmPlanService.planSearchMember(ppvo);
		
		
		if(planSearchMemberList!=null && planSearchMemberList.size()>0){
			for(int i=0;i<planSearchMemberList.size();i++){
				PmPlanVO searchMemVO = null;
				searchMemVO = planSearchMemberList.get(i);
				String i_no = searchMemVO.getI_no();
				String i_nameKr = searchMemVO.getI_nameKr();
				String pm_dept = searchMemVO.getPm_dept();
				logger.info("��ȸ��� ������ >>> i_nameKr : " + i_nameKr + ", pm_dept : " + pm_dept);
				
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
