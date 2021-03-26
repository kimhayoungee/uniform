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
	}// end of addSign() �Լ�

	@Override
	public int updateDate(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateDate");
	}// end of updateDate() �Լ�

	@Override
	public EmCommonVO passwordChk(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("passwordChk");
	}// end of passwordChk() �Լ�

	@Override
	public int updatePw(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updatePw");
	}// end of updatePw() �Լ�

	@Override
	public int updateMm(MmSettingVO msvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateMm");
	}// end of updateMm() �Լ�

	@Override
	public List<EmCommonVO> searchName(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("searchName");
	}// end of searchName() �Լ�

	@Override
	public int updateInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateInfo");
	}// end of updateInfo() �Լ�

	@Override
	public EmCommonVO empChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("empChaebun");
	}// end of empChaebun() �Լ�

	@Override
	public int insertInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertInfo");
	}// end of insertInfo() �Լ�

	@Override
	public int insertEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertEmp");
	}// end of insertEmp() �Լ�

	@Override
	public int insertSetting(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertSetting");
	}// end of insertSetting() �Լ�

	@Override
	public int updateEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateEmp");
	}// end of updateEmp() �Լ�

	@Override
	public int updateEInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("updateEInfo");
	}// end of updateEInfo() �Լ�

	@Override
	public int deleteEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteEmp");
	}// end of deleteEmp() �Լ�

}// end of EmCommonDaoImpl class
