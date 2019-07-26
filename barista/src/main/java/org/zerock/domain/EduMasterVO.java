package org.zerock.domain;

import java.util.Date;

public class EduMasterVO {
	private String edu_sn; 	 	//일련번호
	private String division; 	//구분
	private String title; 	 	//제목
	private String content;  	//내용
	private String content1; 	//추가내용
	private String note; 	 	//유의사항
	private String bgnde; 	 	//접수시작일
	private String endde; 	 	//접수종료일
	private String cre_id; 	 	//등록ID
	private Date cre_de; 	 	//등록일
	private String charge_nm; 	//담당자
	private String charge_dept; //부서
	private Date upd_de; 		//수정일
	private String upd_id; 		//수정자
	private String edu_bgnde; 	//교육 시작일
	private String edu_endde; 	//교육 종료일
	private long people_cnt;    //접수인원
	private EduApplicantVO eduApplicantVO;
	
	public String getEdu_sn() {
		return edu_sn;
	}
	public void setEdu_sn(String edu_sn) {
		this.edu_sn = edu_sn;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getBgnde() {
		return bgnde;
	}
	public void setBgnde(String bgnde) {
		this.bgnde = bgnde;
	}
	public String getEndde() {
		return endde;
	}
	public void setEndde(String endde) {
		this.endde = endde;
	}
	public String getCre_id() {
		return cre_id;
	}
	public void setCre_id(String cre_id) {
		this.cre_id = cre_id;
	}
	public Date getCre_de() {
		return cre_de;
	}
	public void setCre_de(Date cre_de) {
		this.cre_de = cre_de;
	}
	public String getCharge_nm() {
		return charge_nm;
	}
	public void setCharge_nm(String charge_nm) {
		this.charge_nm = charge_nm;
	}
	public String getCharge_dept() {
		return charge_dept;
	}
	public void setCharge_dept(String charge_dept) {
		this.charge_dept = charge_dept;
	}
	public Date getUpd_de() {
		return upd_de;
	}
	public void setUpd_de(Date upd_de) {
		this.upd_de = upd_de;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public String getEdu_bgnde() {
		return edu_bgnde;
	}
	public void setEdu_bgnde(String edu_bgnde) {
		this.edu_bgnde = edu_bgnde;
	}
	public String getEdu_endde() {
		return edu_endde;
	}
	public void setEdu_endde(String edu_endde) {
		this.edu_endde = edu_endde;
	}
	public long getPeople_cnt() {
		return people_cnt;
	}
	public void setPeople_cnt(long people_cnt) {
		this.people_cnt = people_cnt;
	}
	public EduApplicantVO getEduApplicantVO() {
		return eduApplicantVO;
	}
	public void setEduApplicantVO(EduApplicantVO eduApplicantVO) {
		this.eduApplicantVO = eduApplicantVO;
	}
	
	
	
}
