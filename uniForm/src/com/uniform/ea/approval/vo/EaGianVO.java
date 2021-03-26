package com.uniform.ea.approval.vo;


public class EaGianVO extends EaDocumentVO{

	private String gi_docno;	//문서번호
	private String gi_team;		//작성자팀
	private String gi_writerno;	//작성자회원번호
	private String gi_writer;	//작성자명
	private String gi_title;	//제목
	private String gi_data;		//내용
	private String gi_attach;	//첨부문서
	private String gi_deleteyn; //삭제여부
	private String gi_insertdate;	//작성일자
	private String gi_updatedate;	//수정일자
	
	public String getGi_docno() {
		return gi_docno;
	}
	public void setGi_docno(String gi_docno) {
		this.gi_docno = gi_docno;
	}
	public String getGi_team() {
		return gi_team;
	}
	public void setGi_team(String gi_team) {
		this.gi_team = gi_team;
	}
	public String getGi_writerno() {
		return gi_writerno;
	}
	public void setGi_writerno(String gi_writerno) {
		this.gi_writerno = gi_writerno;
	}
	public String getGi_writer() {
		return gi_writer;
	}
	public void setGi_writer(String gi_writer) {
		this.gi_writer = gi_writer;
	}
	public String getGi_title() {
		return gi_title;
	}
	public void setGi_title(String gi_title) {
		this.gi_title = gi_title;
	}
	public String getGi_data() {
		return gi_data;
	}
	public void setGi_data(String gi_data) {
		this.gi_data = gi_data;
	}
	public String getGi_attach() {
		return gi_attach;
	}
	public void setGi_attach(String gi_attach) {
		this.gi_attach = gi_attach;
	}
	public String getGi_deleteyn() {
		return gi_deleteyn;
	}
	public void setGi_deleteyn(String gi_deleteyn) {
		this.gi_deleteyn = gi_deleteyn;
	}
	public String getGi_insertdate() {
		return gi_insertdate;
	}
	public void setGi_insertdate(String gi_insertdate) {
		this.gi_insertdate = gi_insertdate;
	}
	public String getGi_updatedate() {
		return gi_updatedate;
	}
	public void setGi_updatedate(String gi_updatedate) {
		this.gi_updatedate = gi_updatedate;
	}
	

}
