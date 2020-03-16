package org.zerock.domain;

public class ResumeCareerVO {
	private String resume_sn;
	private int seq;
	private String bgnde;
	private String endde;
	private String company_nm;
	private String position;
	private String assign_task;
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
	public String getCompany_nm() {
		return company_nm;
	}
	public void setCompany_nm(String company_nm) {
		this.company_nm = company_nm;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAssign_task() {
		return assign_task;
	}
	public void setAssign_task(String assign_task) {
		this.assign_task = assign_task;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "ResumeMasterVO [resume_sn=" + resume_sn + ", seq=" + seq + ", bgnde=" + bgnde + ", endde=" + endde
				+ ", company_nm=" + company_nm + ", position=" + position + ", assign_task=" + assign_task
				+ ", division=" + division + "]";
	}
	
	
	
	
}
