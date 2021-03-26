package com.uniform.bm.board.vo;

import org.apache.log4j.Logger;

public class BmBoardVO {

/*
UNIFORM_BOARD �÷���

BM_ROWNUM		�Խñ� �ο�ѹ�
BM_NO           �Խñ۹�ȣ
I_NO            ȸ����ȣ
BM_CATEGORY     ī�װ�
BM_SUBJECT      ����
BM_CONTEXT      ����
BM_IMAGEPATH    �̹������
BM_FILEPATH     ÷�����ϰ��
BM_VIEW         ��ȸ��
BM_LIKEY        ��õ��
BM_SCRAP        ��ũ����
BM_INSERTDATE   �ۼ�����
BM_UPDATEDATE   ��������
BM_DELETEYN     ��������
*/
	
	// ����
	private String bm_rownum;		// �Խñ� �ο�ѹ�
	private String bm_no;			// �Խñ۹�ȣ(ä��)
	private String i_no;			// ȸ����ȣ
	private String i_nameKr;		// �ۼ��ڸ� (ȸ����ȣ�� ������)
	private String bm_category;		// ī�װ�
	private String bm_subject;		// ����
	private String bm_context;		// ����
	private String bm_image;		// �̹������
	private String bm_file;			// ÷�����ϰ��
	private String bm_view;			// ��ȸ��
	private String bm_likey;		// ��õ��
	private String bm_scrap;		// ��ũ����
	private String bm_insertdate;	// �ۼ�����
	private String bm_updatedate;	// ��������
	private String bm_deleteyn;		// ��������
	
	// likey ����
	private String bm_likeyyn;		// ���ƿ俩��
	// scrap ����
	private String sc_no;			// ��ũ��ä��
	private String bm_scrapyn;		// ��ũ������
	
	// paging ����
	private String page;
	private String start;
	private String end;	
	
	// search ����
	private String keyword;			// �˻���
	private String searchFilter;	// �˻�����
	private String startDate;		// �˻��Ⱓ ������
	private String endDate;			// �˻��Ⱓ ������

	// �α�
	static Logger logger = Logger.getLogger(BmBoardVO.class);
	
	// getter setter	
	public String getBm_rownum() {
		return bm_rownum;
	}
	public void setBm_rownum(String bm_rownum) {
		this.bm_rownum = bm_rownum;
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
	public String getBm_category() {
		return bm_category;
	}
	public void setBm_category(String bm_category) {
		this.bm_category = bm_category;
	}
	public String getBm_subject() {
		return bm_subject;
	}
	public void setBm_subject(String bm_subject) {
		this.bm_subject = bm_subject;
	}
	public String getBm_context() {
		return bm_context;
	}
	public void setBm_context(String bm_context) {
		this.bm_context = bm_context;
	}
	public String getBm_image() {
		return bm_image;
	}
	public void setBm_image(String bm_image) {
		this.bm_image = bm_image;
	}
	public String getBm_file() {
		return bm_file;
	}
	public void setBm_file(String bm_file) {
		this.bm_file = bm_file;
	}
	public String getBm_view() {
		return bm_view;
	}
	public void setBm_view(String bm_view) {
		this.bm_view = bm_view;
	}
	public String getBm_likey() {
		return bm_likey;
	}
	public void setBm_likey(String bm_likey) {
		this.bm_likey = bm_likey;
	}
	public String getBm_scrap() {
		return bm_scrap;
	}
	public void setBm_scrap(String bm_scrap) {
		this.bm_scrap = bm_scrap;
	}
	public String getBm_insertdate() {
		return bm_insertdate;
	}
	public void setBm_insertdate(String bm_insertdate) {
		this.bm_insertdate = bm_insertdate;
	}
	public String getBm_updatedate() {
		return bm_updatedate;
	}
	public void setBm_updatedate(String bm_updatedate) {
		this.bm_updatedate = bm_updatedate;
	}
	public String getBm_deleteyn() {
		return bm_deleteyn;
	}
	public void setBm_deleteyn(String bm_deleteyn) {
		this.bm_deleteyn = bm_deleteyn;
	}	
	public String getBm_likeyyn() {
		return bm_likeyyn;
	}
	public void setBm_likeyyn(String bm_likeyyn) {
		this.bm_likeyyn = bm_likeyyn;
	}
	public String getSc_no() {
		return sc_no;
	}
	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}
	public String getBm_scrapyn() {
		return bm_scrapyn;
	}
	public void setBm_scrapyn(String bm_scrapyn) {
		this.bm_scrapyn = bm_scrapyn;
	}
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearchFilter() {
		return searchFilter;
	}
	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	// �Ű����� Ȯ��
	public static void printVO(BmBoardVO bbvo){
		logger.info("BmBoardVO ������ Ȯ�� ���� >>>");
		
		logger.info("�Խñ۹�ȣ pm_no : " + bbvo.getBm_no());
		logger.info("ȸ����ȣ i_no : " + bbvo.getI_no());
		logger.info("�ۼ��� i_nameKr : " + bbvo.getI_nameKr());
		logger.info("ī�װ� bm_category : " + bbvo.getBm_category());
		logger.info("���� bm_subject : " + bbvo.getBm_subject());
		logger.info("���� bm_context : " + bbvo.getBm_context());
		logger.info("�̹������ bm_image : " + bbvo.getBm_image());
		logger.info("÷�����ϰ�� bm_file : " + bbvo.getBm_file());
		logger.info("��ȸ�� bm_view : " + bbvo.getBm_view());
		logger.info("��õ�� bm_likey : " + bbvo.getBm_likey());
		logger.info("��ũ���� bm_scrap : " + bbvo.getBm_scrap());
		logger.info("����¡ ������ Ȯ�� >>>");
		logger.info("start : " + bbvo.getStart());
		logger.info("end : " + bbvo.getEnd());
		logger.info("page : " + bbvo.getPage());
		logger.info("���ǰ˻� ������ Ȯ�� >>>");
		logger.info("bm_category : " + bbvo.getBm_category());
		logger.info("startDate : " + bbvo.getStartDate());
		logger.info("endDate : " + bbvo.getEndDate());
		logger.info("searchFilter : " + bbvo.getSearchFilter());
		logger.info("keyword : " + bbvo.getKeyword());

		
		logger.info("BmBoardVO ������ Ȯ�� �� <<<");
	}
	
	
}
