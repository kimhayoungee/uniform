package com.uniform.em.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

@Repository
public class EmCommonDaoImpl implements EmCommonDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int addSign(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("addSign");
	}// end of addSign() 함수

	@Override
	public int updateDate(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateDate");
	}// end of updateDate() 함수

	@Override
	public EmCommonVO passwordChk(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("passwordChk");
	}// end of passwordChk() 함수

	@Override
	public int updatePw(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updatePw");
	}// end of updatePw() 함수

	@Override
	public int updateMm(MmSettingVO msvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateMm");
	}// end of updateMm() 함수

	@Override
	public List<EmCommonVO> searchName(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("searchName");
	}// end of searchName() 함수

	@Override
	public int updateInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateInfo");
	}// end of updateInfo() 함수

	@Override
	public EmCommonVO empChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("empChaebun");
	}// end of empChaebun() 함수

	@Override
	public int insertInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertInfo");
	}// end of insertInfo() 함수

	@Override
	public int insertEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertEmp");
	}// end of insertEmp() 함수

	@Override
	public int insertSetting(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertSetting");
	}// end of insertSetting() 함수

	@Override
	public int updateEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateEmp");
	}// end of updateEmp() 함수

	@Override
	public int updateEInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateEInfo");
	}// end of updateEInfo() 함수

	@Override
	public int deleteEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteEmp");
	}// end of deleteEmp() 함수

}// end of EmCommonDaoImpl class
