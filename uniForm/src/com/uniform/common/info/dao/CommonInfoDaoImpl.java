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
	}// end of miniInfo() �Լ�

	@Override
	public EmCommonVO myInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("myInfo");
	}// end of myInfo() �Լ�

	@Override
	public MmSettingVO mmSetting(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mmSetting");
	}// end of mmSetting() �Լ�

	@Override
	public List<EmCommonVO> infoCard(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("infoCard");
	}// end of infoCard() �Լ�

	@Override
	public EmCommonVO detailInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailInfo");
	}// end of datailInfo() �Լ�

	@Override
	public EmCommonVO mainInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mainInfo");
	}// end of mainInfo() �Լ�

}// end of CommonInfoDaoImpl class
