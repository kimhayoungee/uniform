package com.uniform.em.common.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.em.common.dao.EmCommonDao;
import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

@Service
@Transactional
public class EmCommonServiceImpl implements EmCommonService {
	
	private Logger logger = Logger.getLogger(EmCommonServiceImpl.class);
	
	@Autowired
	private EmCommonDao emCommonDao;

	@Override
	public int addSign(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.addSign(ecvo);
	}// end of addSign() �Լ�

	@Override
	public int updateDate(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateDate(ecvo);
	}// end of updateDate() �Լ�

	@Override
	public EmCommonVO passwordChk(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.passwordChk(ecvo);
	}// end of passwordChk() �Լ�

	@Override
	public int updatePw(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updatePw(ecvo);
	}// end of updatePw() �Լ�

	@Override
	public int updateMm(MmSettingVO msvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateMm(msvo);
	}// end of updateMm() �Լ�

	@Override
	public List<EmCommonVO> searchName(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.searchName(ecvo);
	}// end of searchName() �Լ�

	@Override
	public int updateInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateInfo(ecvo);
	}// end of updateInfo() �Լ�

	@Override
	public EmCommonVO empChaebun() {
		// TODO Auto-generated method stub
		return emCommonDao.empChaebun();
	}// end of empChaebun() �Լ�

	@Override
	public int insertEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		
		int infoCnt = 0;
		int empCnt = 0;
		int settingCnt = 0;
		infoCnt = emCommonDao.insertInfo(ecvo);
		empCnt = emCommonDao.insertEmp(ecvo);
		settingCnt = emCommonDao.insertSetting(ecvo);
		
		return infoCnt + empCnt + settingCnt;
	}// end of insertInfo() �Լ�

	@Override
	public int updateEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		
		int infoCnt = 0;
		int empCnt = 0;
		
		empCnt = emCommonDao.updateEmp(ecvo);
		infoCnt = emCommonDao.updateEInfo(ecvo);
		
		return infoCnt + empCnt;
	}// end of updateEmp() �Լ�

	@Override
	public int deleteEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.deleteEmp(ecvo);
	}// end of deleteEmp() �Լ�

}// end of EmCommonServiceImpl class
