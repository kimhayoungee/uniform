package com.uniform.mm.message.dao;

import java.util.List;

import com.uniform.mm.message.vo.MmMessageVO;

public interface MmMessageDao {
	
	public List<MmMessageVO> messageList(MmMessageVO mmvo);
	
	public MmMessageVO messageChaebun();
	public MmMessageVO detailMessage(MmMessageVO mmvo);
	public MmMessageVO question(MmMessageVO mmvo);
	
	public int insertMessage(MmMessageVO mmvo);
	public int deleteMessage(MmMessageVO mmvo);
	public int countList(MmMessageVO mmvo);

}// end of MmMessageDao Interface
