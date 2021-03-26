package com.uniform.bm.board.vo;

import org.apache.log4j.Logger;

public class BmBoardVO {

/*
UNIFORM_BOARD 컬럼명

BM_ROWNUM		게시글 로우넘버
BM_NO           게시글번호
I_NO            회원번호
BM_CATEGORY     카테고리
BM_SUBJECT      제목
BM_CONTEXT      내용
BM_IMAGEPATH    이미지경로
BM_FILEPATH     첨부파일경로
BM_VIEW         조회수
BM_LIKEY        추천수
BM_SCRAP        스크랩수
BM_INSERTDATE   작성일자
BM_UPDATEDATE   수정일자
BM_DELETEYN     삭제여부
*/
	
	// 변수
	private String bm_rownum;		// 게시글 로우넘버
	private String bm_no;			// 게시글번호(채번)
	private String i_no;			// 회원번호
	private String i_nameKr;		// 작성자명 (회원번호로 꺼내옴)
	private String bm_category;		// 카테고리
	private String bm_subject;		// 제목
	private String bm_context;		// 내용
	private String bm_image;		// 이미지경로
	private String bm_file;			// 첨부파일경로
	private String bm_view;			// 조회수
	private String bm_likey;		// 추천수
	private String bm_scrap;		// 스크랩수
	private String bm_insertdate;	// 작성일자
	private String bm_updatedate;	// 수정일자
	private String bm_deleteyn;		// 삭제여부
	
	// likey 변수
	private String bm_likeyyn;		// 좋아요여부
	// scrap 변수
	private String sc_no;			// 스크랩채번
	private String bm_scrapyn;		// 스크랩여부
	
	// paging 변수
	private String page;
	private String start;
	private String end;	
	
	// search 변수
	private String keyword;			// 검색어
	private String searchFilter;	// 검색조건
	private String startDate;		// 검색기간 시작일
	private String endDate;			// 검색기간 종료일

	// 로그
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
	// 매개변수 확인
	public static void printVO(BmBoardVO bbvo){
		logger.info("BmBoardVO 데이터 확인 시작 >>>");
		
		logger.info("게시글번호 pm_no : " + bbvo.getBm_no());
		logger.info("회원번호 i_no : " + bbvo.getI_no());
		logger.info("작성자 i_nameKr : " + bbvo.getI_nameKr());
		logger.info("카테고리 bm_category : " + bbvo.getBm_category());
		logger.info("제목 bm_subject : " + bbvo.getBm_subject());
		logger.info("내용 bm_context : " + bbvo.getBm_context());
		logger.info("이미지경로 bm_image : " + bbvo.getBm_image());
		logger.info("첨부파일경로 bm_file : " + bbvo.getBm_file());
		logger.info("조회수 bm_view : " + bbvo.getBm_view());
		logger.info("추천수 bm_likey : " + bbvo.getBm_likey());
		logger.info("스크랩수 bm_scrap : " + bbvo.getBm_scrap());
		logger.info("페이징 데이터 확인 >>>");
		logger.info("start : " + bbvo.getStart());
		logger.info("end : " + bbvo.getEnd());
		logger.info("page : " + bbvo.getPage());
		logger.info("조건검색 데이터 확인 >>>");
		logger.info("bm_category : " + bbvo.getBm_category());
		logger.info("startDate : " + bbvo.getStartDate());
		logger.info("endDate : " + bbvo.getEndDate());
		logger.info("searchFilter : " + bbvo.getSearchFilter());
		logger.info("keyword : " + bbvo.getKeyword());

		
		logger.info("BmBoardVO 데이터 확인 끝 <<<");
	}
	
	
}
