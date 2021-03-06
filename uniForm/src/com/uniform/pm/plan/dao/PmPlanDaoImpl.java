package com.uniform.pm.plan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.pm.plan.vo.PmPlanVO;

@Repository
public class PmPlanDaoImpl implements PmPlanDao {

	private Logger logger = Logger.getLogger(PmPlanDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	// 전체일정조회(개인)
	@Override
	public List<PmPlanVO> myPlanList(PmPlanVO ppvo) {
		logger.info("[log]전체일정조회(개인) 함수 시작 >>> ");
		
		return sqlSession.selectList("myPlanList", ppvo);
	}
	// 전체일정조회(!개인)
	@Override
	public List<PmPlanVO> notMyPlanList(PmPlanVO ppvo) {
		logger.info("[log]전체일정조회(!개인) 함수 시작 >>> ");
		
		return sqlSession.selectList("notMyPlanList", ppvo);
	}
	// 일정상세조회
	@Override
	public List<PmPlanVO> planDetail(PmPlanVO ppvo) {
		logger.info("[log]일정상세조회 함수 시작 >>> ");

		return sqlSession.selectList("planDetail", ppvo);
	}
	// 채번
	@Override
	public PmPlanVO planChaebun(PmPlanVO ppvo) {
		logger.info("[log]다오 채번 함수 시작 >>> ");
		return sqlSession.selectOne("planChaebun", ppvo);
	}
	// 일정등록
	@Override
	public int planInsert(PmPlanVO ppvo) {
		logger.info("[log]다오 일정등록 함수 시작 >>> ");
		return (Integer)sqlSession.insert("planInsert", ppvo);
	}
	// 일정수정
	@Override
	public int planUpdate(PmPlanVO ppvo) {
		logger.info("[log]다오 일정수정 함수 시작 >>> ");
		return (Integer)sqlSession.update("planUpdate", ppvo);
	}
	// 일정삭제
	@Override
	public int planDelete(PmPlanVO ppvo) {
		logger.info("[log]다오 일정삭제 함수 시작 >>> ");
		return (Integer)sqlSession.update("planDelete", ppvo);
	}
	// 회원검색
	@Override
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo){
		logger.info("[log]다오 회원검색 함수 호출! ");
		return sqlSession.selectList("planSearchMember", ppvo);
	}
	@Override
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getAlarm");
	}

}
