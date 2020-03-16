package org.zerock.domain;

public class ResumeSchoolVO {
	private String resume_sn;
	private int seq;
	private String bgnde;
	private String endde;
	private String school;
	private String major;
	private String division;
	public String getResume_sn() {
		return resume_sn;
	}
	public void setResume_sn(String resume_sn) {
		this.resume_sn = resume_sn;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "ResumeSchoolVO [resume_sn=" + resume_sn + ", seq=" + seq + ", bgnde=" + bgnde + ", endde=" + endde
				+ ", school=" + school + ", major=" + major + ", division=" + division + "]";
	}
	
	
}
