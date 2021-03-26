package com.uniform.si.info.dao;

import java.util.List;

import com.uniform.si.info.vo.SiInfoVO;

public interface SiInfoDao {
	
	public List<SiInfoVO> studentList(SiInfoVO sivo);
	
	public SiInfoVO siChaebun();
	public SiInfoVO detailSi(SiInfoVO sivo);
	public SiInfoVO cDetailSi(SiInfoVO sivo);
	
	public int insertInfo(SiInfoVO sivo);
	public int insertSi(SiInfoVO sivo);
	public int updateInfo(SiInfoVO sivo);
	public int updateStudent(SiInfoVO sivo);
	public int deleteSi(SiInfoVO sivo);

}// end of SiInfoDao Interface
