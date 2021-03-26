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
	}// end of studentList() 함수

	@Override
	public int insertInfo(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertInfo");
	}// end of insertInfo() 함수

	@Override
	public int insertSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertSi");
	}// end of insertSi() 함수

	@Override
	public SiInfoVO siChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("siChaebun");
	}// end of siChaebun() 함수

	@Override
	public SiInfoVO detailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailSi");
	}// end of detailSi() 함수

	@Override
	public SiInfoVO cDetailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("cDetailSi");
	}// end of cDetailSi() 함수

	@Override
	public int updateInfo(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateInfo");
	}// end of updateInfo() 함수

	@Override
	public int updateStudent(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateStudent");
	}// end of updateStudent() 함수

	@Override
	public int deleteSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteSi");
	}// end of deleteSi() 함수

}// end of SiInfoDaoImpl class
