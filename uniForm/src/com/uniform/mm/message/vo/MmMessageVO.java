package com.uniform.mm.message.vo;

import com.uniform.mm.setting.vo.MmSettingVO;

public class MmMessageVO extends MmSettingVO{
	
	private String mm_no; // �޼��� ��ȣ
	private String i_nameKr; // �̸�
	private String mm_recipient; // ������
	private String mm_message; // ����
	private String mm_insertDate; // �ۼ� ��¥
	private String mm_updateDate; // ���� ��¥
	private String mm_deleteyn; // ��������
	
	private String page;
	private String start;
	private String end;

	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getMm_no() {
		return mm_no;
	}
	public void setMm_no(String mm_no) {
		this.mm_no = mm_no;
	}
	public String getI_nameKr() {
		return i_nameKr;
	}
	public void setI_nameKr(String i_nameKr) {
		this.i_nameKr = i_nameKr;
	}
	public String getMm_recipient() {
		return mm_recipient;
	}
	public void setMm_recipient(String mm_recipient) {
		this.mm_recipient = mm_recipient;
	}
	public String getMm_message() {
		return mm_message;
	}
	public void setMm_message(String mm_message) {
		this.mm_message = mm_message;
	}
	public String getMm_insertDate() {
		return mm_insertDate;
	}
	public void setMm_insertDate(String mm_insertDate) {
		this.mm_insertDate = mm_insertDate;
	}
	public String getMm_updateDate() {
		return mm_updateDate;
	}
	public void setMm_updateDate(String mm_updateDate) {
		this.mm_updateDate = mm_updateDate;
	}
	public String getMm_deleteyn() {
		return mm_deleteyn;
	}
	public void setMm_deleteyn(String mm_deleteyn) {
		this.mm_deleteyn = mm_deleteyn;
	}
	
}// end of MmMessageVO
