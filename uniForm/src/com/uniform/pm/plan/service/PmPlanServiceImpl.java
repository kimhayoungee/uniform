package com.uniform.pm.plan.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.pm.plan.dao.PmPlanDao;
import com.uniform.pm.plan.vo.PmPlanVO;

@Service
@Transactional
public class PmPlanServiceImpl implements PmPlanService {
	
	private Logger logger = Logger.getLogger(PmPlanServiceImpl.class);
	
	@Autowired
	private PmPlanDao pmPlanDao;
	
	// ��ü������ȸ(�����߰�)
	@Override
	public List<PmPlanVO> planList(PmPlanVO ppvo) {
		logger.info("[log]������ü��ȸ(!����) �Լ� ���� >>> ");
		
		// ������ü��ȸ ��ü����
		List<PmPlanVO> planList = null;
		
		// �������� ���� ��ü������ ��������
		planList = pmPlanDao.notMyPlanList(ppvo);
		logger.info("��ü����(��������)���� : " + planList.size());
		
		// �������� ��ü��ȸ
		List<PmPlanVO> myPlanList = null;
		myPlanList = pmPlanDao.myPlanList(ppvo);
		logger.info("�������� ���� : " + myPlanList.size());

		if(myPlanList.size()>0){
			PmPlanVO MyPlanVO = null;		
			// �������� ��ü�� ������ ��ü����(��������)��ü�� �߰�
			for(int i=0; i<myPlanList.size(); i++){
				MyPlanVO = new PmPlanVO();
				MyPlanVO = myPlanList.get(i);
				planList.add(MyPlanVO);
			}
			logger.info("��ü�������� : " + planList.size());
		}
		
		return planList;
	}
	// ��������ȸ
	@Override
	public List<PmPlanVO> planDetail(PmPlanVO ppvo) {
		logger.info("[log]��������ȸ planDetail �Լ� ���� >>> ");
		
		List<PmPlanVO> planDetailList = pmPlanDao.planDetail(ppvo);
		
		return planDetailList;
	}

	// ä��
	@Override
	public PmPlanVO planChaebun(PmPlanVO ppvo) {
		
		PmPlanVO planChaebunVO = pmPlanDao.planChaebun(ppvo);
		
		return planChaebunVO;
	}	

	// �������
	@Override
	public int planInsert(PmPlanVO ppvo) {
		logger.info("[log]���� ������� planInsert �Լ� ���� >>> ");
		
		int nCntInsert = pmPlanDao.planInsert(ppvo);
		
		return nCntInsert;
	}
	// ��������
	@Override
	public int planUpdate(PmPlanVO ppvo) {
		logger.info("[log]���� �������� �Լ� ���� >>> ");
		
		int nCntUpdate = pmPlanDao.planUpdate(ppvo);
		
		return nCntUpdate;
	}
	// ��������
	@Override
	public int planDelete(PmPlanVO ppvo) {
		logger.info("[log]���� �������� �Լ� ���� >>> ");
		
		int nCntDelete = pmPlanDao.planDelete(ppvo);
		
		return nCntDelete;
	}
	// ȸ���˻�
	@Override
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo){
		logger.info("[log]���� ȸ���˻� �Լ� ���� >>> i_nameKr : " + ppvo.getI_nameKr());
		
		List<PmPlanVO> planSearchMemberList = pmPlanDao.planSearchMember(ppvo);
		
		return planSearchMemberList;
	}
	@Override
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo) {
		// TODO Auto-generated method stub
		return pmPlanDao.getAlarm(ppvo);
	}

}
