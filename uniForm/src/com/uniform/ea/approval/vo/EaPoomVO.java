package com.uniform.ea.approval.vo;

public class EaPoomVO extends EaDocumentVO{

	private String po_docno;	//문서번호
	private String po_writerno;	//작성자회원번호   
	private String po_team;		//작성자부서	
	private String po_writer;	//작성자명
	private String po_title;	//제목
	private String po_data;		//내용
	private String po_attach;	//첨부문서
	private String po_deleteyn; //삭제여부
	private String po_insertdate;	//작성날짜
	private String po_updatedate;	//수정날짜 
	
	public String getPo_docno() {
		return po_docno;
	}
	public void setPo_docno(String po_docno) {
		this.po_docno = po_docno;
	}
	public String getPo_writerno() {
		return po_writerno;
	}
	public void setPo_writerno(String po_writerno) {
		this.po_writerno = po_writerno;
	}
	public String getPo_team() {
		return po_team;
	}
	public void setPo_team(String po_team) {
		this.po_team = po_team;
	}
	public String getPo_writer() {
		return po_writer;
	}
	public void setPo_writer(String po_writer) {
		this.po_writer = po_writer;
	}
	public String getPo_title() {
		return po_title;
	}
	public void setPo_title(String po_title) {
		this.po_title = po_title;
	}
	public String getPo_data() {
		return po_data;
	}
	public void setPo_data(String po_data) {
		this.po_data = po_data;
	}
	public String getPo_attach() {
		return po_attach;
	}
	public void setPo_attach(String po_attach) {
		this.po_attach = po_attach;
	}
	public String getPo_deleteyn() {
		return po_deleteyn;
	}
	public void setPo_deleteyn(String po_deleteyn) {
		this.po_deleteyn = po_deleteyn;
	}
	public String getPo_insertdate() {
		return po_insertdate;
	}
	public void setPo_insertdate(String po_insertdate) {
		this.po_insertdate = po_insertdate;
	}
	public String getPo_updatedate() {
		return po_updatedate;
	}
	public void setPo_updatedate(String po_updatedate) {
		this.po_updatedate = po_updatedate;
	}
	
}
