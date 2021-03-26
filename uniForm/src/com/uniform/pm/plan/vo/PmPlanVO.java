package com.uniform.pm.plan.vo;

import org.apache.log4j.Logger;

public class PmPlanVO {

	// 변수선언
	private String pm_no;			// 일정번호
	private String i_no;			// 작성자(회원번호)
	private String i_nameKr;		// 작성자명(회원명)
	private String pm_title;		// 일정명
	private String pm_start;		// 시작일
	private String pm_end;			// 종료일
	private String pm_context;		// 내용
	private String pm_allDay;		// 종일여부	
	private String pm_backgroundColor;	// 배경색
	private String pm_textColor;		// 폰트색
	private String pm_share;		// 공유캘린더(타입)
	// 추가
	private String pm_dept;			// 부서(코드)	
	private String pm_place;		// 장소
	private String pm_alarm;		// 푸쉬알림여부
	private String pm_alarmTime;	// 알림시간	
	private String pm_message;		// 쪽지여부
	private String pm_recipient;	// 쪽지수신자
	private String pm_insertdate;	// 등록일
	private String pm_updatedate;	// 수정일
	private String pm_deleteYN;		// 삭제여부
	
	// 로그
	static Logger logger = Logger.getLogger(PmPlanVO.class);
	
	// getter setter
	public String getPm_no() {
		return pm_no;
	}

	public void setPm_no(String pm_no) {
		this.pm_no = pm_no;
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

	public String getPm_title() {
		return pm_title;
	}

	public void setPm_title(String pm_title) {
		this.pm_title = pm_title;
	}

	public String getPm_start() {
		return pm_start;
	}

	public void setPm_start(String pm_start) {
		this.pm_start = pm_start;
	}

	public String getPm_end() {
		return pm_end;
	}

	public void setPm_end(String pm_end) {
		this.pm_end = pm_end;
	}

	public String getPm_context() {
		return pm_context;
	}

	public void setPm_context(String pm_context) {
		this.pm_context = pm_context;
	}

	public String getPm_allDay() {
		return pm_allDay;
	}

	public void setPm_allDay(String pm_allDay) {
		this.pm_allDay = pm_allDay;
	}

	public String getPm_backgroundColor() {
		return pm_backgroundColor;
	}

	public void setPm_backgroundColor(String pm_backgroundColor) {
		this.pm_backgroundColor = pm_backgroundColor;
	}

	public String getPm_textColor() {
		return pm_textColor;
	}

	public void setPm_textColor(String pm_textColor) {
		this.pm_textColor = pm_textColor;
	}

	public String getPm_share() {
		return pm_share;
	}

	public void setPm_share(String pm_share) {
		this.pm_share = pm_share;
	}

	public String getPm_dept() {
		return pm_dept;
	}

	public void setPm_dept(String pm_dept) {
		this.pm_dept = pm_dept;
	}

	public String getPm_place() {
		return pm_place;
	}

	public void setPm_place(String pm_place) {
		this.pm_place = pm_place;
	}

	public String getPm_alarm() {
		return pm_alarm;
	}

	public void setPm_alarm(String pm_alarm) {
		this.pm_alarm = pm_alarm;
	}

	public String getPm_alarmTime() {
		return pm_alarmTime;
	}

	public void setPm_alarmTime(String pm_alarmTime) {
		this.pm_alarmTime = pm_alarmTime;
	}

	public String getPm_message() {
		return pm_message;
	}

	public void setPm_message(String pm_message) {
		this.pm_message = pm_message;
	}

	public String getPm_recipient() {
		return pm_recipient;
	}

	public void setPm_recipient(String pm_recipient) {
		this.pm_recipient = pm_recipient;
	}

	public String getPm_insertdate() {
		return pm_insertdate;
	}

	public void setPm_insertdate(String pm_insertdate) {
		this.pm_insertdate = pm_insertdate;
	}

	public String getPm_updatedate() {
		return pm_updatedate;
	}

	public void setPm_updatedate(String pm_updatedate) {
		this.pm_updatedate = pm_updatedate;
	}

	public String getPm_deleteYN() {
		return pm_deleteYN;
	}

	public void setPm_deleteYN(String pm_deleteYN) {
		this.pm_deleteYN = pm_deleteYN;
	}
	
	// 데이터 확인 출력 함수
	public static void printVO(PmPlanVO ppvo){
		logger.info("PmPlanVO 데이터 확인 시작 >>>");
		
		logger.info("일정번호 pm_no : " + ppvo.getPm_no());
		logger.info("회원번호 i_no : " + ppvo.getI_no());
		logger.info("작성자 i_nameKr : " + ppvo.getI_nameKr());
		logger.info("일정명 pm_title : " + ppvo.getPm_title());
		logger.info("시작일 pm_start : " + ppvo.getPm_start());
		logger.info("종료일 pm_end : " + ppvo.getPm_end());
		logger.info("내용 pm_context : " + ppvo.getPm_context());
		logger.info("종일여부 pm_allDay : " + ppvo.getPm_allDay());
		logger.info("공유캘린더 pm_share : " + ppvo.getPm_share());
		logger.info("부서 pm_dept : " + ppvo.getPm_dept());
		logger.info("배경색 pm_backgroundColor : " + ppvo.getPm_backgroundColor());
		logger.info("폰트색 pm_textColor : " + ppvo.getPm_textColor());
		
		logger.info("장소 pm_place : " + ppvo.getPm_place());
		logger.info("알림여부 pm_alarm : " + ppvo.getPm_alarm());
		logger.info("알림시간 pm_alarmTime : " + ppvo.getPm_alarmTime());
		logger.info("쪽지여부 pm_message : " + ppvo.getPm_message());
		logger.info("수신인 pm_recipient : " + ppvo.getPm_recipient());

		logger.info("작성일자 pm_insertdate : " + ppvo.getPm_insertdate());
		logger.info("수정일자 pm_updatedate : " + ppvo.getPm_updatedate());
		logger.info("삭제여부 pm_deleteYN : " + ppvo.getPm_deleteYN());
		
		logger.info("PmPlanVO 데이터 확인 끝 <<<");
	}
	
}
