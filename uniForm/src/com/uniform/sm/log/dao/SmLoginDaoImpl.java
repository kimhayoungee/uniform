package com.uniform.sm.log.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.em.common.vo.EmCommonVO;

@Repository
public class SmLoginDaoImpl implements SmLoginDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public EmCommonVO login(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("login");
	}// end of login() ÇÔ¼ö

}// end of SmLoginDaoImpl class
