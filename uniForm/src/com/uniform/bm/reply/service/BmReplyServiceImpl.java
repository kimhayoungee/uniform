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
	
	// �α�
	private Logger logger = Logger.getLogger(BmReplyServiceImpl.class);
	
	@Autowired
	private BmReplyDao bmReplyDao;
	
	// �����ü��ȸ ���� ===================================
	@Override
	public List<BmReplyVO> replyList(BmReplyVO brvo) {
		logger.info("���� �����ü��ȸ ���� �Լ� ȣ�� ����!");
		
		List<BmReplyVO> replyList = bmReplyDao.replyList(brvo);
		
		return replyList;
	}
	// ���ä�� =========================================
	@Override
	public BmReplyVO replyNum() {
		logger.info("���� ���ä�� ���� �Լ� ȣ�� ����!");
		
		BmReplyVO replyNum = bmReplyDao.replyNum();
		return replyNum;
	}
	// ��۾��� ���� ======================================
	@Override
	public int replyInsert(BmReplyVO brvo) {
		logger.info("���� ��۾��� ���� �Լ� ȣ�� ����!");
		
		int nCntReplyInsert = bmReplyDao.replyInsert(brvo);
		return nCntReplyInsert;
	}
	// ��ۼ��� ���� ======================================
	@Override
	public int replyUpdate(BmReplyVO brvo) {
		logger.info("���� ��ۼ��� ���� �Լ� ȣ�� ����!");
		
		int nCntReplyUpdate = bmReplyDao.replyUpdate(brvo);
		return nCntReplyUpdate;
	}
	// ��ۻ��� ���� ======================================
	@Override
	public int replyDelete(BmReplyVO brvo) {
		logger.info("���� ��ۻ��� ���� �Լ� ȣ�� ����!");
		
		int nCntReplyDelete = bmReplyDao.replyDelete(brvo);
		return nCntReplyDelete;
	}
	// ���total ======================================
	@Override
	public int replyPaging(BmReplyVO brvo) {
		logger.info("���� ���total ���� �Լ� ȣ�� ����!");
		
		int replyTotal = bmReplyDao.replyPaging(brvo);
		return replyTotal;
	}

}
