package com.uniform.bm.reply.dao;

import java.util.List;

import com.uniform.bm.reply.vo.BmReplyVO;

public interface BmReplyDao {
	// ??????ü??ȸ ???? ===================================
	public List<BmReplyVO> replyList(BmReplyVO brvo);
	// ????ä?? =========================================
	public BmReplyVO replyNum();
	// ???۾??? ???? ======================================
	public int replyInsert(BmReplyVO brvo);
	// ???ۼ??? ???? ======================================
	public int replyUpdate(BmReplyVO brvo);
	// ???ۻ??? ???? ======================================
	public int replyDelete(BmReplyVO brvo);
	// ????total ======================================
	public int replyPaging(BmReplyVO brvo);

}
