package com.uniform.bm.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uniform.bm.reply.vo.BmReplyVO;

@Repository
public class BmReplyDaoImpl implements BmReplyDao {

	// 로그
	private Logger logger = Logger.getLogger(BmReplyDaoImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	// 댓글전체조회 구현 ===================================
	@Override
	public List<BmReplyVO> replyList(BmReplyVO brvo) {
		logger.info("서비스 댓글전체조회 구현 함수 호출 성공!");
		return sqlSession.selectList("replyList",brvo);
	}
	// 댓글채번 =========================================
	@Override
	public BmReplyVO replyNum() {
		logger.info("서비스 댓글채번 구현 함수 호출 성공!");
		return sqlSession.selectOne("replyNum");
	}
	// 댓글쓰기 구현 ======================================
	@Override
	public int replyInsert(BmReplyVO brvo) {
		logger.info("서비스 댓글쓰기 구현 함수 호출 성공!");
		return sqlSession.insert("replyInsert",brvo);
	}
	// 댓글수정 구현 ======================================
	@Override
	public int replyUpdate(BmReplyVO brvo) {
		logger.info("서비스 댓글수정 구현 함수 호출 성공!");
		return sqlSession.update("replyUpdate",brvo);
	}
	// 댓글삭제 구현 ======================================
	@Override
	public int replyDelete(BmReplyVO brvo) {
		logger.info("서비스 댓글삭제 구현 함수 호출 성공!");
		return sqlSession.update("replyDelete",brvo);
	}
	// 댓글total ======================================
	@Override
	public int replyPaging(BmReplyVO brvo) {
		logger.info("서비스 댓글total 구현 함수 호출 성공!");
		
		return (Integer)sqlSession.selectOne("replyPaging",brvo);
	}


}
