package com.uniform.ea.approval.vo;

public class EaDocumentVO extends EaApprovalVO{

	private String do_docno;	//문서번호
	private String do_type;		//문서종류
	private String do_writerno;	//작성자회원번호	--이 컬럼 빼야할지 고민
	private String do_writer;	//작성자명
	private	String do_title;	//제목
	private String do_insertdate;	//작성일자
	private	String do_updatedate;	//수정일자
	private String do_deleteyn;	//삭제여부
	private String do_lineno;	//결재선번호
	private String do_aprno;	//결재자회원번호 
	
	public String getDo_docno() {
		return do_docno;
	}
	public void setDo_docno(String do_docno) {
		this.do_docno = do_docno;
	}
	public String getDo_type() {
		return do_type;
	}
	public void setDo_type(String do_type) {
		this.do_type = do_type;
	}
	public String getDo_writerno() {
		return do_writerno;
	}
	public void setDo_writerno(String do_writerno) {
		this.do_writerno = do_writerno;
	}
	public String getDo_writer() {
		return do_writer;
	}
	public void setDo_writer(String do_writer) {
		this.do_writer = do_writer;
	}
	public String getDo_title() {
		return do_title;
	}
	public void setDo_title(String do_title) {
		this.do_title = do_title;
	}
	public String getDo_insertdate() {
		return do_insertdate;
	}
	public void setDo_insertdate(String do_insertdate) {
		this.do_insertdate = do_insertdate;
	}
	public String getDo_updatedate() {
		return do_updatedate;
	}
	public void setDo_updatedate(String do_updatedate) {
		this.do_updatedate = do_updatedate;
	}
	public String getDo_deleteyn() {
		return do_deleteyn;
	}
	public void setDo_deleteyn(String do_deleteyn) {
		this.do_deleteyn = do_deleteyn;
	}
	public String getDo_lineno() {
		return do_lineno;
	}
	public void setDo_lineno(String do_lineno) {
		this.do_lineno = do_lineno;
	}
	public String getDo_aprno() {
		return do_aprno;
	}
	public void setDo_aprno(String do_aprno) {
		this.do_aprno = do_aprno;
	}

}
