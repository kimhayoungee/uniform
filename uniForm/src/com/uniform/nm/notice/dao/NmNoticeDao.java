package com.uniform.nm.notice.dao;

import java.util.List;

import com.uniform.nm.notice.vo.NmNoticeVO;

public interface NmNoticeDao {
	
	public List<NmNoticeVO> noticeList(NmNoticeVO nnvo);
	public List<NmNoticeVO> miniNotice();
	
	public NmNoticeVO nmChaebun();
	public NmNoticeVO detailNotice(NmNoticeVO nnvo);
	
	public int insertNotice(NmNoticeVO nnvo);
	public int deleteNotice(NmNoticeVO nnvo);
	public int updateNotice(NmNoticeVO nnvo);
	public int listCnt(NmNoticeVO nnvo);
	public int updateView(NmNoticeVO nnvo);

}// end of NmNoticeDao Interface
