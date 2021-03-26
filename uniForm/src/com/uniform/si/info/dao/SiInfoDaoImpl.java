package com.uniform.si.info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.si.info.vo.SiInfoVO;

@Repository
public class SiInfoDaoImpl implements SiInfoDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<SiInfoVO> studentList(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("studentList");
	}// end of studentList() �Լ�

	@Override
	public int insertInfo(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertInfo");
	}// end of insertInfo() �Լ�

	@Override
	public int insertSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertSi");
	}// end of insertSi() �Լ�

	@Override
	public SiInfoVO siChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("siChaebun");
	}// end of siChaebun() �Լ�

	@Override
	public SiInfoVO detailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailSi");
	}// end of detailSi() �Լ�

	@Override
	public SiInfoVO cDetailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("cDetailSi");
	}// end of cDetailSi() �Լ�

	@Override
	public int updateInfo(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateInfo");
	}// end of updateInfo() �Լ�

	@Override
	public int updateStudent(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateStudent");
	}// end of updateStudent() �Լ�

	@Override
	public int deleteSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteSi");
	}// end of deleteSi() �Լ�

}// end of SiInfoDaoImpl class
