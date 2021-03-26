package com.uniform.mm.message.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.uniform.mm.message.vo.MmMessageVO;

public class MmMessageDaoImpl implements MmMessageDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MmMessageVO> messageList(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("messageList");
	}// end of messageList()�Լ�

	@Override
	public MmMessageVO messageChaebun() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("messageChaebun");
	}// end of messageChaebun() �Լ�

	@Override
	public int insertMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertMessage");
	}// end of insertMessage() �Լ�

	@Override
	public MmMessageVO detailMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("detailMessage");
	}// end of detailMessage() �Լ�

	@Override
	public int deleteMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("deleteMessage");
	}// end of deleteMessage() �Լ�

	@Override
	public int countList(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return (Integer)sqlSession.selectOne("countList");
	}// end of countList() �Լ�

	@Override
	public MmMessageVO question(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("question");
	}// end of question() �Լ�

}// end of MmMessageDaoImpl class
