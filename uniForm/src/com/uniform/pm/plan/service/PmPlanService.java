package com.uniform.pm.plan.service;

import java.util.List;

import com.uniform.pm.plan.vo.PmPlanVO;

public interface PmPlanService {

	// 전체일정조회
	public List<PmPlanVO> planList(PmPlanVO ppvo);
	// 일정상세조회
	public List<PmPlanVO> planDetail(PmPlanVO ppvo);
	// 일정등록
	public int planInsert(PmPlanVO ppvo);	
	// 채번
	public PmPlanVO planChaebun(PmPlanVO ppvo);
	// 일정수정
	public int planUpdate(PmPlanVO ppvo);	
	// 일정삭제
	public int planDelete(PmPlanVO ppvo);	
	// 회원검색
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo);
	
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo);
}
