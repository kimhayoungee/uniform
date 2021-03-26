package com.uniform.common.info.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.common.info.dao.CommonInfoDao;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

@Service
@Transactional
public class CommonInfoServiceImpl implements CommonInfoService {
	
	private Logger logger = Logger.getLogger(CommonInfoServiceImpl.class);
	
	@Autowired
	private CommonInfoDao commonInfoDao;

	@Override
	public EmCommonVO miniInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.miniInfo(ecvo);
	}// end of miniInfo() �Լ�

	@Override
	public EmCommonVO myInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.myInfo(ecvo);
	}// end of myInfo() �Լ�

	@Override
	public MmSettingVO mmSetting(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.mmSetting(ecvo);
	}// end of mmSetting() �Լ�

	@Override
	public List<EmCommonVO> infoCard(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.infoCard(ecvo);
	}// end of infoCard() �Լ�

	@Override
	public EmCommonVO detailInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.detailInfo(ecvo);
	}// end of detailInfo() �Լ�

	@Override
	public EmCommonVO mainInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return commonInfoDao.mainInfo(ecvo);
	}// end of mainInfo() �Լ�

}// end of CommonInfoServiceImpl class
