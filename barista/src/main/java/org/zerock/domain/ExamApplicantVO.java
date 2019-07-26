package org.zerock.domain;

import java.util.Date;

public class ExamApplicantVO {
	private String exam_sn;
	private String apc_sn;
	private String mber_id;
	private String mber_name;
	private String gunmul;
	private String address1;
	private String address2;
	private String mber_phone;
	private String email;
	private Date cre_de;
	private Date upd_de;
	private String grade;
	private String mber_engname;
	private String birth;
	private String exam_place_code;
	private ExamApplicantAttachVO examapplicantattachVO;
	private String year;
	private String month;
	private String date;
	
	
	public String getExam_sn() {
		return exam_sn;
	}
	public void setExam_sn(String exam_sn) {
		this.exam_sn = exam_sn;
	}
	public String getApc_sn() {
		return apc_sn;
	}
	public void setApc_sn(String apc_sn) {
		this.apc_sn = apc_sn;
	}
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	public String getMber_name() {
		return mber_name;
	}
	public void setMber_name(String mber_name) {
		this.mber_name = mber_name;
	}
	public String getGunmul() {
		return gunmul;
	}
	public void setGunmul(String gunmul) {
		this.gunmul = gunmul;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getMber_phone() {
		return mber_phone;
	}
	public void setMber_phone(String mber_phone) {
		this.mber_phone = mber_phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCre_de() {
		return cre_de;
	}
	public void setCre_de(Date cre_de) {
		this.cre_de = cre_de;
	}
	public Date getUpd_de() {
		return upd_de;
	}
	public void setUpd_de(Date upd_de) {
		this.upd_de = upd_de;
	}
	
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMber_engname() {
		return mber_engname;
	}
	public void setMber_engname(String mber_engname) {
		this.mber_engname = mber_engname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
	public String getExam_place_code() {
		return exam_place_code;
	}
	public void setExam_place_code(String exam_place_code) {
		this.exam_place_code = exam_place_code;
	}
	
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ExamApplicantAttachVO getExamapplicantattachVO() {
		return examapplicantattachVO;
	}
	public void setExamapplicantattachVO(ExamApplicantAttachVO examapplicantattachVO) {
		this.examapplicantattachVO = examapplicantattachVO;
	}
	@Override
	public String toString() {
		return "ExamApplicantVO [exam_sn=" + exam_sn + ", apc_sn=" + apc_sn + ", mber_id=" + mber_id + ", mber_name="
				+ mber_name + ", gunmul=" + gunmul + ", address1=" + address1 + ", address2=" + address2
				+ ", mber_phone=" + mber_phone + ", email=" + email + ", cre_de=" + cre_de + ", upd_de=" + upd_de
				+ ", grade=" + grade + ", mber_engname=" + mber_engname + ", birth=" + birth + ", exam_place_code="
				+ exam_place_code + ", examapplicantattachVO=" + examapplicantattachVO + "]";
	}
	
	
	
	
	
	
	
}
