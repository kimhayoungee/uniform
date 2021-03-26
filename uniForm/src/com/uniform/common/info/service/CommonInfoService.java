package com.uniform.common.info.service;

import java.util.List;

import com.uniform.em.common.vo.EmCommonVO;
import com.uniform.mm.setting.vo.MmSettingVO;

public interface CommonInfoService {
	
	public List<EmCommonVO> infoCard(EmCommonVO ecvo);
	
	public EmCommonVO mainInfo(EmCommonVO ecvo);
	public EmCommonVO miniInfo(EmCommonVO ecvo);
	public EmCommonVO myInfo(EmCommonVO ecvo);
	public EmCommonVO detailInfo(EmCommonVO ecvo);
	
	public MmSettingVO mmSetting(EmCommonVO ecvo);

}// end of CommonInfoService
