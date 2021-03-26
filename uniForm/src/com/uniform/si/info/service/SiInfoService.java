package com.uniform.si.info.service;

import java.util.List;

import com.uniform.si.info.vo.SiInfoVO;

public interface SiInfoService {
	
	public List<SiInfoVO> studentList(SiInfoVO sivo);
	
	public SiInfoVO siChaebun();
	public SiInfoVO detailSi(SiInfoVO sivo);
	public SiInfoVO cDetailSi(SiInfoVO sivo);
	
	public int insertSi(SiInfoVO sivo);
	public int updateStudent(SiInfoVO sivo);
	public int deleteSi(SiInfoVO sivo);

}// end of SiInfoService Interface
