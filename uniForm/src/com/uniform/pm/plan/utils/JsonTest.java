package com.uniform.pm.plan.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.uniform.pm.plan.vo.PmPlanVO;

public class JsonTest {
	
	static Logger logger = Logger.getLogger(JsonTest.class);
	
	public static JSONArray getJson(List<PmPlanVO> planList) throws Exception{
		logger.info("[log]JsonTest >>> getJson() 함수 시작");
		
		JSONArray jsonArr = null;
		jsonArr = new JSONArray();
		PmPlanVO ppvo = null;
		int eventsCount = 0;	// 등록 이벤트 갯수
		
		// HashMap형태로 Json데이터 담을 객체 선언
		JSONObject jsonObj = null;
	
		try{		
			String allDay = "";
			
			eventsCount = planList.size();
			logger.info("eventsCount : " + eventsCount);
			PmPlanVO.printVO(planList.get(0));
			
			for(int i=0; i<planList.size(); i++){
				jsonObj = new JSONObject();
				ppvo = planList.get(i);				
				jsonObj.put("_id", ppvo.getPm_no());
				jsonObj.put("title", ppvo.getPm_title());
				jsonObj.put("start", ppvo.getPm_start());
				jsonObj.put("end", ppvo.getPm_end());
				jsonObj.put("description", ppvo.getPm_context());
				jsonObj.put("type", ppvo.getPm_share());
				jsonObj.put("username", ppvo.getI_nameKr());
				jsonObj.put("backgroundColor", ppvo.getPm_backgroundColor());
				jsonObj.put("textColor", ppvo.getPm_textColor());
				// 추가
				jsonObj.put("i_no", ppvo.getI_no());
				jsonObj.put("dept", ppvo.getPm_dept());				
				jsonObj.put("place", ppvo.getPm_place());
				jsonObj.put("alarm", ppvo.getPm_alarm());
				jsonObj.put("alarmTime", ppvo.getPm_alarmTime());
				jsonObj.put("message", ppvo.getPm_message());
				jsonObj.put("recipient", ppvo.getPm_recipient());
				
				allDay = ppvo.getPm_allDay();
				if(allDay!=null && allDay.length()>0){
					boolean boolVal = false;
					
					if("true".equals(allDay.toLowerCase())){
						boolVal = true;
						jsonObj.put("allDay", boolVal);
					}
					jsonObj.put("allDay", boolVal);
				}
				
				jsonArr.add(jsonObj);
			} // end of for
			
		}catch(Exception e){
			e.getMessage();
		}finally{}
			
		logger.info("[log]JsonTest >>> getJson() 함수 끝");
		return jsonArr;
	} // end of getJson()

} // end of JsonTest class
