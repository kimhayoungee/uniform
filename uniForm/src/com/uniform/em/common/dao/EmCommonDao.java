package com.uniform.em.common.dao;

import java.util.List;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

public interface EmCommonDao {
	
	public List<EmCommonVO> searchName(EmCommonVO ecvo);

	public int addSign(EmCommonVO ecvo);
	public int updateDate(EmCommonVO ecvo);
	public int updatePw(EmCommonVO ecvo);
	public int updateMm(MmSettingVO msvo);
	public int updateInfo(EmCommonVO ecvo);
	public int insertInfo(EmCommonVO ecvo);
	public int insertEmp(EmCommonVO ecvo);
	public int insertSetting(EmCommonVO ecvo);
	public int updateEmp(EmCommonVO ecvo);
	public int updateEInfo(EmCommonVO ecvo);
	public int deleteEmp(EmCommonVO ecvo);
	
	public EmCommonVO passwordChk(EmCommonVO ecvo);
	public EmCommonVO empChaebun();
	
}// end of EmCommonDao Interface
