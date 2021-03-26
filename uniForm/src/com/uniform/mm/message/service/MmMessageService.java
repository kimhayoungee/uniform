package com.uniform.mm.message.service;

import java.util.List;

import com.uniform.mm.message.vo.MmMessageVO;

public interface MmMessageService {
	
	public List<MmMessageVO> messageList(MmMessageVO mmvo);
	
	public MmMessageVO messageChaebun();
	public MmMessageVO detailMessage(MmMessageVO mmvo);
	public MmMessageVO question(MmMessageVO mmvo);
	
	public int insertMessage(MmMessageVO mmvo);
	public int deleteMessage(MmMessageVO mmvo);
	public int countList(MmMessageVO mmvo);

}// MmMessageService Interface
