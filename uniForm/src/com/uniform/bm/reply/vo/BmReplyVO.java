package com.uniform.bm.reply.vo;

import org.apache.log4j.Logger;

public class BmReplyVO {

/*
댓글번호	    BM_RENO
게시글번호		BM_NO
회원번호	   	I_NO
댓글내용	    BM_RECONTEXT
댓글작성일자	BM_REINSERTDATE
댓글수정일자	BM_REUPDATEDATE
댓글삭제여부	BM_REDELETEYN 
*/	
	
	// 변수
	private String bm_reno;			// 댓글채번
	private String bm_no;			// 게시글번호
	private String i_no;			// 회원번호
	private String i_nameKr;		// 작성자명 (회원번호로 꺼내옴)
	private String bm_recontext;	// 댓글내용
	private String bm_reinsertdate;	// 댓글작성일
	private String bm_reupdatedate;	// 댓글수정일
	private String bm_redeleteyn;	// 댓글삭제여부
	// replyPaging 변수
	private String replyPage;
	private String replyStart;
	private String replyEnd;	
	
	// 로그
	static Logger logger = Logger.getLogger(BmReplyVO.class);
	
	// getter setter
	public String getBm_reno() {
		return bm_reno;
	}

	public void setBm_reno(String bm_reno) {
		this.bm_reno = bm_reno;
	}

	public String getBm_no() {
		return bm_no;
	}

	public void setBm_no(String bm_no) {
		this.bm_no = bm_no;
	}

	public String getI_no() {
		return i_no;
	}

	public void setI_no(String i_no) {
		this.i_no = i_no;
	}

	public String getI_nameKr() {
		return i_nameKr;
	}

	public void setI_nameKr(String i_nameKr) {
		this.i_nameKr = i_nameKr;
	}

	public String getBm_recontext() {
		return bm_recontext;
	}

	public void setBm_recontext(String bm_recontext) {
		this.bm_recontext = bm_recontext;
	}

	public String getBm_reinsertdate() {
		return bm_reinsertdate;
	}

	public void setBm_reinsertdate(String bm_reinsertdate) {
		this.bm_reinsertdate = bm_reinsertdate;
	}

	public String getBm_reupdatedate() {
		return bm_reupdatedate;
	}

	public void setBm_reupdatedate(String bm_reupdatedate) {
		this.bm_reupdatedate = bm_reupdatedate;
	}

	public String getBm_redeleteyn() {
		return bm_redeleteyn;
	}

	public void setBm_redeleteyn(String bm_redeleteyn) {
		this.bm_redeleteyn = bm_redeleteyn;
	}

	public String getReplyPage() {
		return replyPage;
	}

	public void setReplyPage(String replyPage) {
		this.replyPage = replyPage;
	}

	public String getReplyStart() {
		return replyStart;
	}

	public void setReplyStart(String replyStart) {
		this.replyStart = replyStart;
	}

	public String getReplyEnd() {
		return replyEnd;
	}

	public void setReplyEnd(String replyEnd) {
		this.replyEnd = replyEnd;
	}


	

} // end of BmReplyVO
