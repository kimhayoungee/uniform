package com.uniform.bm.reply.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.bm.reply.dao.BmReplyDao;
import com.uniform.bm.reply.vo.BmReplyVO;

@Service
@Transactional
public class BmReplyServiceImpl implements BmReplyService {
	
	// 로그
	private Logger logger = Logger.getLogger(BmReplyServiceImpl.class);
	
	@Autowired
	private BmReplyDao bmReplyDao;
	
	// 댓글전체조회 구현 ===================================
	@Override
	public List<BmReplyVO> replyList(BmReplyVO brvo) {
		logger.info("서비스 댓글전체조회 구현 함수 호출 성공!");
		
		List<BmReplyVO> replyList = bmReplyDao.replyList(brvo);
		
		return replyList;
	}
	// 댓글채번 =========================================
	@Override
	public BmReplyVO replyNum() {
		logger.info("서비스 댓글채번 구현 함수 호출 성공!");
		
		BmReplyVO replyNum = bmReplyDao.replyNum();
		return replyNum;
	}
	// 댓글쓰기 구현 ======================================
	@Override
	public int replyInsert(BmReplyVO brvo) {
		logger.info("서비스 댓글쓰기 구현 함수 호출 성공!");
		
		int nCntReplyInsert = bmReplyDao.replyInsert(brvo);
		return nCntReplyInsert;
	}
	// 댓글수정 구현 ======================================
	@Override
	public int replyUpdate(BmReplyVO brvo) {
		logger.info("서비스 댓글수정 구현 함수 호출 성공!");
		
		int nCntReplyUpdate = bmReplyDao.replyUpdate(brvo);
		return nCntReplyUpdate;
	}
	// 댓글삭제 구현 ======================================
	@Override
	public int replyDelete(BmReplyVO brvo) {
		logger.info("서비스 댓글삭제 구현 함수 호출 성공!");
		
		int nCntReplyDelete = bmReplyDao.replyDelete(brvo);
		return nCntReplyDelete;
	}
	// 댓글total ======================================
	@Override
	public int replyPaging(BmReplyVO brvo) {
		logger.info("서비스 댓글total 구현 함수 호출 성공!");
		
		int replyTotal = bmReplyDao.replyPaging(brvo);
		return replyTotal;
	}

}
