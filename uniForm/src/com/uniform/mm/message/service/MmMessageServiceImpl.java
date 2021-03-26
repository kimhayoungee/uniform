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
		logger.info("messageList ����");
		return mmMessageDao.messageList(mmvo);
	}// end of messageList() �Լ�

	@Override
	public MmMessageVO messageChaebun() {
		// TODO Auto-generated method stub
		logger.info("messageChaebun ����");
		return mmMessageDao.messageChaebun();
	}// end of messageChaebun() �Լ�

	@Override
	public int insertMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("insertMessage ����");
		return mmMessageDao.insertMessage(mmvo);
	}// end of insertMessage() �Լ�

	@Override
	public MmMessageVO detailMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("detailMessage ����");
		return mmMessageDao.detailMessage(mmvo);
	}// end of detailMessage() �Լ�

	@Override
	public int deleteMessage(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		logger.info("deleteMessage ����");
		return mmMessageDao.deleteMessage(mmvo);
	}// end of deleteMessage() �Լ�

	@Override
	public int countList(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return mmMessageDao.countList(mmvo);
	}// end of countList() �Լ�

	@Override
	public MmMessageVO question(MmMessageVO mmvo) {
		// TODO Auto-generated method stub
		return mmMessageDao.question(mmvo);
	}// end of question() �Լ�

}// end of MmMessageServiceImpl class
