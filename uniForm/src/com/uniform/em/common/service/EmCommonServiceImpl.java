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
	}// end of addSign() 함수

	@Override
	public int updateDate(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateDate(ecvo);
	}// end of updateDate() 함수

	@Override
	public EmCommonVO passwordChk(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.passwordChk(ecvo);
	}// end of passwordChk() 함수

	@Override
	public int updatePw(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updatePw(ecvo);
	}// end of updatePw() 함수

	@Override
	public int updateMm(MmSettingVO msvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateMm(msvo);
	}// end of updateMm() 함수

	@Override
	public List<EmCommonVO> searchName(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.searchName(ecvo);
	}// end of searchName() 함수

	@Override
	public int updateInfo(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.updateInfo(ecvo);
	}// end of updateInfo() 함수

	@Override
	public EmCommonVO empChaebun() {
		// TODO Auto-generated method stub
		return emCommonDao.empChaebun();
	}// end of empChaebun() 함수

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
	}// end of insertInfo() 함수

	@Override
	public int updateEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		
		int infoCnt = 0;
		int empCnt = 0;
		
		empCnt = emCommonDao.updateEmp(ecvo);
		infoCnt = emCommonDao.updateEInfo(ecvo);
		
		return infoCnt + empCnt;
	}// end of updateEmp() 함수

	@Override
	public int deleteEmp(EmCommonVO ecvo) {
		// TODO Auto-generated method stub
		return emCommonDao.deleteEmp(ecvo);
	}// end of deleteEmp() 함수

}// end of EmCommonServiceImpl class
