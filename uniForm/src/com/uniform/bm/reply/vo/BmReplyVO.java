package com.uniform.bm.reply.vo;

import org.apache.log4j.Logger;

public class BmReplyVO {

/*
��۹�ȣ	    BM_RENO
�Խñ۹�ȣ		BM_NO
ȸ����ȣ	   	I_NO
��۳���	    BM_RECONTEXT
����ۼ�����	BM_REINSERTDATE
��ۼ�������	BM_REUPDATEDATE
��ۻ�������	BM_REDELETEYN 
*/	
	
	// ����
	private String bm_reno;			// ���ä��
	private String bm_no;			// �Խñ۹�ȣ
	private String i_no;			// ȸ����ȣ
	private String i_nameKr;		// �ۼ��ڸ� (ȸ����ȣ�� ������)
	private String bm_recontext;	// ��۳���
	private String bm_reinsertdate;	// ����ۼ���
	private String bm_reupdatedate;	// ��ۼ�����
	private String bm_redeleteyn;	// ��ۻ�������
	// replyPaging ����
	private String replyPage;
	private String replyStart;
	private String replyEnd;	
	
	// �α�
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
