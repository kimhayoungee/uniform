package com.uniform.mm.message.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.mm.message.dao.MmMessageDao;
import com.uniform.mm.message.vo.MmMessageVO;

@Service
@Transactional
public class MmMessageServiceImpl implements MmMessageService {
	
	private Logger logger = Logger.getLogger(MmMessageServiceImpl.class);
	
	@Autowired
	private MmMessageDao mmMessageDao;

	@Override
	public List<MmMessageVO> messageList(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("messageList 서비스");
		return mmMessageDao.messageList(mmvo);
	}// end of messageList() 함수

	@Override
	public MmMessageVO messageChaebun() {
		// TODO Auto-generated method stub
		logger.info("messageChaebun 서비스");
		return mmMessageDao.messageChaebun();
	}// end of messageChaebun() 함수

	@Override
	public int insertMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("insertMessage 서비스");
		return mmMessageDao.insertMessage(mmvo);
	}// end of insertMessage() 함수

	@Override
	public MmMessageVO detailMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("detailMessage 서비스");
		return mmMessageDao.detailMessage(mmvo);
	}// end of detailMessage() 함수

	@Override
	public int deleteMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("deleteMessage 서비스");
		return mmMessageDao.deleteMessage(mmvo);
	}// end of deleteMessage() 함수

	@Override
	public int countList(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return mmMessageDao.countList(mmvo);
	}// end of countList() 함수

	@Override
	public MmMessageVO question(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return mmMessageDao.question(mmvo);
	}// end of question() 함수

}// end of MmMessageServiceImpl class
