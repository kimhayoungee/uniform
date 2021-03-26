package com.uniform.sm.log.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.sm.log.dao.SmLoginDao;

@Service
@Transactional
public class SmLoginServiceImpl implements SmLoginService {
	
	Logger logger = Logger.getLogger(SmLoginServiceImpl.class);
	
	@Autowired
	private SmLoginDao smLoginDao;

	@Override
	public EmCommonVO login(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return smLoginDao.login(ecvo);
	}// end of login() ÇÔ¼ö

}// end of SmLoginServiceImpl class
