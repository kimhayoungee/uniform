package com.uniform.bm.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.bm.reply.vo.BmReplyVO;

@Repository
public class BmReplyDaoImpl implements BmReplyDao {

	// �α�
	private Logger logger = Logger.getLogger(BmReplyDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	// �����ü��ȸ ���� ===================================
	@Override
	public List<BmReplyVO> replyList(BmReplyVO brvo) {
		logger.info("���� �����ü��ȸ ���� �Լ� ȣ�� ����!");
		return sqlSession.selectList("replyList",brvo);
	}
	// ���ä�� =========================================
	@Override
	public BmReplyVO replyNum() {
		logger.info("���� ���ä�� ���� �Լ� ȣ�� ����!");
		return sqlSession.selectOne("replyNum");
	}
	// ��۾��� ���� ======================================
	@Override
	public int replyInsert(BmReplyVO brvo) {
		logger.info("���� ��۾��� ���� �Լ� ȣ�� ����!");
		return sqlSession.insert("replyInsert",brvo);
	}
	// ��ۼ��� ���� ======================================
	@Override
	public int replyUpdate(BmReplyVO brvo) {
		logger.info("���� ��ۼ��� ���� �Լ� ȣ�� ����!");
		return sqlSession.update("replyUpdate",brvo);
	}
	// ��ۻ��� ���� ======================================
	@Override
	public int replyDelete(BmReplyVO brvo) {
		logger.info("���� ��ۻ��� ���� �Լ� ȣ�� ����!");
		return sqlSession.update("replyDelete",brvo);
	}
	// ���total ======================================
	@Override
	public int replyPaging(BmReplyVO brvo) {
		logger.info("���� ���total ���� �Լ� ȣ�� ����!");
		
		return (Integer)sqlSession.selectOne("replyPaging",brvo);
	}


}
