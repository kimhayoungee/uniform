package com.uniform.em.common.vo;

import com.uniform.common.info.vo.CommonInfoVO;

public class EmCommonVO extends CommonInfoVO{
	
	private String em_pw;       // 비밀번호
	private String em_hireDate; // 입사일자
	private String em_img;      // 교직원 사진
	private String em_dept;     // 부서
	private String em_position; // 직위
	private String em_team;     // 팀
	private String em_military; // 군필
	private String em_mNo;      // 군번
	private String em_mStart;   // 군복무 시작일
	private String em_mEnd;     // 전역일
	private String em_exemp;    // 면제사유
	private String em_academic; // 최종학력
	private String em_sign;     // 개인서명
	
	private String keyword;
	private String search;
	
	
	public String getEm_team() {
		return em_team;
	}
	public void setEm_team(String em_team) {
		this.em_team = em_team;
	}
	public String getEm_pw() {
		return em_pw;
	}
	public void setEm_pw(String em_pw) {
		this.em_pw = em_pw;
	}
	public String getEm_hireDate() {
		return em_hireDate;
	}
	public void setEm_hireDate(String em_hireDate) {
		this.em_hireDate = em_hireDate;
	}
	public String getEm_img() {
		return em_img;
	}
	public void setEm_img(String em_img) {
		this.em_img = em_img;
	}
	public String getEm_dept() {
		return em_dept;
	}
	public void setEm_dept(String em_dept) {
		this.em_dept = em_dept;
	}
	public String getEm_position() {
		return em_position;
	}
	public void setEm_position(String em_position) {
		this.em_position = em_position;
	}
	public String getEm_military() {
		return em_military;
	}
	public void setEm_military(String em_military) {
		this.em_military = em_military;
	}
	public String getEm_mNo() {
		return em_mNo;
	}
	public void setEm_mNo(String em_mNo) {
		this.em_mNo = em_mNo;
	}
	public String getEm_mStart() {
		return em_mStart;
	}
	public void setEm_mStart(String em_mStart) {
		this.em_mStart = em_mStart;
	}
	public String getEm_mEnd() {
		return em_mEnd;
	}
	public void setEm_mEnd(String em_mEnd) {
		this.em_mEnd = em_mEnd;
	}
	public String getEm_exemp() {
		return em_exemp;
	}
	public void setEm_exemp(String em_exemp) {
		this.em_exemp = em_exemp;
	}
	public String getEm_academic() {
		return em_academic;
	}
	public void setEm_academic(String em_academic) {
		this.em_academic = em_academic;
	}
	public String getEm_sign() {
		return em_sign;
	}
	public void setEm_sign(String em_sign) {
		this.em_sign = em_sign;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

}// end of EmCommonVO class
