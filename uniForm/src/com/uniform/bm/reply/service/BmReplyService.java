package com.uniform.bm.reply.service;

import java.util.List;

import com.uniform.bm.reply.vo.BmReplyVO;

public interface BmReplyService {
	// ´ñ±ÛÀüÃ¼Á¶È¸ ±¸Çö ======================================
	public List<BmReplyVO> replyList(BmReplyVO brvo);
	// ´ñ±ÛÃ¤¹ø =========================================
	public BmReplyVO replyNum();
	// ´ñ±Û¾²±â ±¸Çö ======================================
	public int replyInsert(BmReplyVO brvo);
	// ´ñ±Û¼öÁ¤ ±¸Çö ======================================
	public int replyUpdate(BmReplyVO brvo);
	// ´ñ±Û»èÁ¦ ±¸Çö ======================================
	public int replyDelete(BmReplyVO brvo);
	// ´ñ±Ûtotal ======================================
	public int replyPaging(BmReplyVO brvo);
}
