package org.zerock.domain;

import java.util.Date;

public class ExamMasterVO {
	private String exam_sn;
	private String division;
	private String title;
	private String content;
	private String note;
	private String bgnde;
	private String endde;
	private String cre_id;
	private Date cre_de;
	private String charge_nm;
	private String charge_dept;
	private String upd_id;
	private Date upd_de;
	private String examde;
	private ExamApplicantVO examApplicantVO;
	private ExamScoreVO examScoreVO;
	
	
	private String mber_id;
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	
	
	
	
	public String getExam_sn() {
		return exam_sn;
	}
	public void setExam_sn(String exam_sn) {
		this.exam_sn = exam_sn;
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
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public Date getUpd_de() {
		return upd_de;
	}
	public void setUpd_de(Date upd_de) {
		this.upd_de = upd_de;
	}
	
	public String getExamde() {
		return examde;
	}
	public void setExamde(String examde) {
		this.examde = examde;
	}
	
	
	
	public ExamApplicantVO getExamApplicantVO() {
		return examApplicantVO;
	}
	public void setExamApplicantVO(ExamApplicantVO examApplicantVO) {
		this.examApplicantVO = examApplicantVO;
	}
	
	
	public ExamScoreVO getExamScoreVO() {
		return examScoreVO;
	}
	public void setExamScoreVO(ExamScoreVO examScoreVO) {
		this.examScoreVO = examScoreVO;
	}
	@Override
	public String toString() {
		return "ExamMasterVO [exam_sn=" + exam_sn + ", division=" + division + ", title=" + title + ", content="
				+ content + ", note=" + note + ", bgnde=" + bgnde + ", endde=" + endde + ", cre_id=" + cre_id
				+ ", cre_de=" + cre_de + ", charge_nm=" + charge_nm + ", charge_dept=" + charge_dept + ", upd_id="
				+ upd_id + ", upd_de=" + upd_de + "]";
	}
	
	
	
}
