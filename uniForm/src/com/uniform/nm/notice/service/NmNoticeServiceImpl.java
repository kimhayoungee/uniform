package com.uniform.nm.notice.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.nm.notice.dao.NmNoticeDao;
import com.uniform.nm.notice.vo.NmNoticeVO;

@Service
public class NmNoticeServiceImpl implements NmNoticeService {
	
	private Logger logger = Logger.getLogger(NmNoticeServiceImpl.class);
	
	@Autowired
	private NmNoticeDao nmNoticeDao;

	@Override
	public List<NmNoticeVO> noticeList(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.noticeList(nnvo);
	}// end of noticeList() 함수

	@Override
	public NmNoticeVO nmChaebun() {
		// TODO Auto-generated method stub
		return nmNoticeDao.nmChaebun();
	}// end of nmChaebun() 함수

	@Override
	public int insertNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.insertNotice(nnvo);
	}// end of insertNotice() 함수

	@Override
	public NmNoticeVO detailNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.detailNotice(nnvo);
	}// end of detailNotice() 함수

	@Override
	public int deleteNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub	
		logger.info("deleteNotice 서비스");
		return nmNoticeDao.deleteNotice(nnvo);
	}// end of deleteNotice() 함수

	@Override
	public int updateNotice(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.updateNotice(nnvo);
	}// end of updateNotice() 함수

	@Override
	public int listCnt(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.listCnt(nnvo);
	}// end of listCnt()함수

	@Override
	public int updateView(NmNoticeVO nnvo) {
		// TODO Auto-generated method stub
		return nmNoticeDao.updateView(nnvo);
	}// end of updateView() 함수

	@Override
	public List<NmNoticeVO> miniNotice() {
		// TODO Auto-generated method stub
		return nmNoticeDao.miniNotice();
	}// end of miniNotice() 함수

}// end of NmNoticeServiceImpl class
