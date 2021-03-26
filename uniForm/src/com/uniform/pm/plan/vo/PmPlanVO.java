package com.uniform.pm.plan.vo;

import org.apache.log4j.Logger;

public class PmPlanVO {

	// ��������
	private String pm_no;			// ������ȣ
	private String i_no;			// �ۼ���(ȸ����ȣ)
	private String i_nameKr;		// �ۼ��ڸ�(ȸ����)
	private String pm_title;		// ������
	private String pm_start;		// ������
	private String pm_end;			// ������
	private String pm_context;		// ����
	private String pm_allDay;		// ���Ͽ���	
	private String pm_backgroundColor;	// ����
	private String pm_textColor;		// ��Ʈ��
	private String pm_share;		// ����Ķ����(Ÿ��)
	// �߰�
	private String pm_dept;			// �μ�(�ڵ�)	
	private String pm_place;		// ���
	private String pm_alarm;		// Ǫ���˸�����
	private String pm_alarmTime;	// �˸��ð�	
	private String pm_message;		// ��������
	private String pm_recipient;	// ����������
	private String pm_insertdate;	// �����
	private String pm_updatedate;	// ������
	private String pm_deleteYN;		// ��������
	
	// �α�
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
	
	// ������ Ȯ�� ��� �Լ�
	public static void printVO(PmPlanVO ppvo){
		logger.info("PmPlanVO ������ Ȯ�� ���� >>>");
		
		logger.info("������ȣ pm_no : " + ppvo.getPm_no());
		logger.info("ȸ����ȣ i_no : " + ppvo.getI_no());
		logger.info("�ۼ��� i_nameKr : " + ppvo.getI_nameKr());
		logger.info("������ pm_title : " + ppvo.getPm_title());
		logger.info("������ pm_start : " + ppvo.getPm_start());
		logger.info("������ pm_end : " + ppvo.getPm_end());
		logger.info("���� pm_context : " + ppvo.getPm_context());
		logger.info("���Ͽ��� pm_allDay : " + ppvo.getPm_allDay());
		logger.info("����Ķ���� pm_share : " + ppvo.getPm_share());
		logger.info("�μ� pm_dept : " + ppvo.getPm_dept());
		logger.info("���� pm_backgroundColor : " + ppvo.getPm_backgroundColor());
		logger.info("��Ʈ�� pm_textColor : " + ppvo.getPm_textColor());
		
		logger.info("��� pm_place : " + ppvo.getPm_place());
		logger.info("�˸����� pm_alarm : " + ppvo.getPm_alarm());
		logger.info("�˸��ð� pm_alarmTime : " + ppvo.getPm_alarmTime());
		logger.info("�������� pm_message : " + ppvo.getPm_message());
		logger.info("������ pm_recipient : " + ppvo.getPm_recipient());

		logger.info("�ۼ����� pm_insertdate : " + ppvo.getPm_insertdate());
		logger.info("�������� pm_updatedate : " + ppvo.getPm_updatedate());
		logger.info("�������� pm_deleteYN : " + ppvo.getPm_deleteYN());
		
		logger.info("PmPlanVO ������ Ȯ�� �� <<<");
	}
	
}
