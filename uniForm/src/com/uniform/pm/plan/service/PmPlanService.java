package com.uniform.pm.plan.service;

import java.util.List;

import com.uniform.pm.plan.vo.PmPlanVO;

public interface PmPlanService {

	// ��ü������ȸ
	public List<PmPlanVO> planList(PmPlanVO ppvo);
	// ��������ȸ
	public List<PmPlanVO> planDetail(PmPlanVO ppvo);
	// �������
	public int planInsert(PmPlanVO ppvo);	
	// ä��
	public PmPlanVO planChaebun(PmPlanVO ppvo);
	// ��������
	public int planUpdate(PmPlanVO ppvo);	
	// ��������
	public int planDelete(PmPlanVO ppvo);	
	// ȸ���˻�
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo);
	
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo);
}