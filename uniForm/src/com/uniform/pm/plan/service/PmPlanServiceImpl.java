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
	
	// 전체일정조회(개인추가)
	@Override
	public List<PmPlanVO> planList(PmPlanVO ppvo) {
		logger.info("[log]일정전체조회(!개인) 함수 시작 >>> ");
		
		// 일정전체조회 객체생성
		List<PmPlanVO> planList = null;
		
		// 개인일정 제외 전체데이터 꺼내오기
		planList = pmPlanDao.notMyPlanList(ppvo);
		logger.info("전체일정(개인제외)갯수 : " + planList.size());
		
		// 개인일정 전체조회
		List<PmPlanVO> myPlanList = null;
		myPlanList = pmPlanDao.myPlanList(ppvo);
		logger.info("개인일정 갯수 : " + myPlanList.size());

		if(myPlanList.size()>0){
			PmPlanVO MyPlanVO = null;		
			// 개인일정 객체를 꺼내서 전체일정(개인제외)객체에 추가
			for(int i=0; i<myPlanList.size(); i++){
				MyPlanVO = new PmPlanVO();
				MyPlanVO = myPlanList.get(i);
				planList.add(MyPlanVO);
			}
			logger.info("전체일정갯수 : " + planList.size());
		}
		
		return planList;
	}
	// 일정상세조회
	@Override
	public List<PmPlanVO> planDetail(PmPlanVO ppvo) {
		logger.info("[log]일정상세조회 planDetail 함수 시작 >>> ");
		
		List<PmPlanVO> planDetailList = pmPlanDao.planDetail(ppvo);
		
		return planDetailList;
	}

	// 채번
	@Override
	public PmPlanVO planChaebun(PmPlanVO ppvo) {
		
		PmPlanVO planChaebunVO = pmPlanDao.planChaebun(ppvo);
		
		return planChaebunVO;
	}	

	// 일정등록
	@Override
	public int planInsert(PmPlanVO ppvo) {
		logger.info("[log]서비스 일정등록 planInsert 함수 시작 >>> ");
		
		int nCntInsert = pmPlanDao.planInsert(ppvo);
		
		return nCntInsert;
	}
	// 일정수정
	@Override
	public int planUpdate(PmPlanVO ppvo) {
		logger.info("[log]서비스 일정수정 함수 시작 >>> ");
		
		int nCntUpdate = pmPlanDao.planUpdate(ppvo);
		
		return nCntUpdate;
	}
	// 일정삭제
	@Override
	public int planDelete(PmPlanVO ppvo) {
		logger.info("[log]서비스 일정삭제 함수 시작 >>> ");
		
		int nCntDelete = pmPlanDao.planDelete(ppvo);
		
		return nCntDelete;
	}
	// 회원검색
	@Override
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo){
		logger.info("[log]서비스 회원검색 함수 시작 >>> i_nameKr : " + ppvo.getI_nameKr());
		
		List<PmPlanVO> planSearchMemberList = pmPlanDao.planSearchMember(ppvo);
		
		return planSearchMemberList;
	}
	@Override
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo) {
		// TODO Auto-generated method stub
		return pmPlanDao.getAlarm(ppvo);
	}

}
