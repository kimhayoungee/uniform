package com.uniform.common.info.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

@Repository
public class CommonInfoDaoImpl implements CommonInfoDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public EmCommonVO miniInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("miniInfo");
	}// end of miniInfo() 함수

	@Override
	public EmCommonVO myInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("myInfo");
	}// end of myInfo() 함수

	@Override
	public MmSettingVO mmSetting(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mmSetting");
	}// end of mmSetting() 함수

	@Override
	public List<EmCommonVO> infoCard(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("infoCard");
	}// end of infoCard() 함수

	@Override
	public EmCommonVO detailInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailInfo");
	}// end of datailInfo() 함수

	@Override
	public EmCommonVO mainInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mainInfo");
	}// end of mainInfo() 함수

}// end of CommonInfoDaoImpl class
