package com.uniform.si.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniform.si.info.dao.SiInfoDao;
import com.uniform.si.info.vo.SiInfoVO;

@Service
@Transactional
public class SiInfoServiceImpl implements SiInfoService {
	
	@Autowired
	private SiInfoDao siInfoDao;

	@Override
	public List<SiInfoVO> studentList(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return siInfoDao.studentList(sivo);
	}// end of studentList() �Լ�

	@Override
	public int insertSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		
		int infoCnt = 0;
		int siCnt = 0;
		
		infoCnt = siInfoDao.insertInfo(sivo);
		siCnt = siInfoDao.insertSi(sivo);
		
		return infoCnt + siCnt;
	}// end of insertSi() �Լ�

	@Override
	public SiInfoVO siChaebun() {
		// TODO Auto-generated method stub
		return siInfoDao.siChaebun();
	}// end of siChaebun() �Լ�

	@Override
	public SiInfoVO detailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return siInfoDao.detailSi(sivo);
	}// end of detailSi() �Լ�

	@Override
	public SiInfoVO cDetailSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return siInfoDao.cDetailSi(sivo);
	}// end of cDetailSi() �Լ�

	@Override
	public int updateStudent(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		
		int infoCnt = 0;
		int studentCnt = 0;
		
		infoCnt = siInfoDao.updateInfo(sivo);
		studentCnt = siInfoDao.updateStudent(sivo);
		
		return infoCnt + studentCnt;
	}// end of updateStudent() �Լ�

	@Override
	public int deleteSi(SiInfoVO sivo) {
		// TODO Auto-generated method stub
		return siInfoDao.deleteSi(sivo);
	}// end of deleteSi() �Լ�

}// end of SiInfoServiceImpl class
