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
	
	// ��ü������ȸ(����)
	@Override
	public List<PmPlanVO> myPlanList(PmPlanVO ppvo) {
		logger.info("[log]��ü������ȸ(����) �Լ� ���� >>> ");
		
		return sqlSession.selectList("myPlanList", ppvo);
	}
	// ��ü������ȸ(!����)
	@Override
	public List<PmPlanVO> notMyPlanList(PmPlanVO ppvo) {
		logger.info("[log]��ü������ȸ(!����) �Լ� ���� >>> ");
		
		return sqlSession.selectList("notMyPlanList", ppvo);
	}
	// ��������ȸ
	@Override
	public List<PmPlanVO> planDetail(PmPlanVO ppvo) {
		logger.info("[log]��������ȸ �Լ� ���� >>> ");

		return sqlSession.selectList("planDetail", ppvo);
	}
	// ä��
	@Override
	public PmPlanVO planChaebun(PmPlanVO ppvo) {
		logger.info("[log]�ٿ� ä�� �Լ� ���� >>> ");
		return sqlSession.selectOne("planChaebun", ppvo);
	}
	// �������
	@Override
	public int planInsert(PmPlanVO ppvo) {
		logger.info("[log]�ٿ� ������� �Լ� ���� >>> ");
		return (Integer)sqlSession.insert("planInsert", ppvo);
	}
	// ��������
	@Override
	public int planUpdate(PmPlanVO ppvo) {
		logger.info("[log]�ٿ� �������� �Լ� ���� >>> ");
		return (Integer)sqlSession.update("planUpdate", ppvo);
	}
	// ��������
	@Override
	public int planDelete(PmPlanVO ppvo) {
		logger.info("[log]�ٿ� �������� �Լ� ���� >>> ");
		return (Integer)sqlSession.update("planDelete", ppvo);
	}
	// ȸ���˻�
	@Override
	public List<PmPlanVO> planSearchMember(PmPlanVO ppvo){
		logger.info("[log]�ٿ� ȸ���˻� �Լ� ȣ��! ");
		return sqlSession.selectList("planSearchMember", ppvo);
	}
	@Override
	public List<PmPlanVO> getAlarm(PmPlanVO ppvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("getAlarm");
	}

}