package org.zerock.domain;

public class ResumeQualVO {
	private String resume_sn;
	private int seq;
	private String qual_nm;
	private String issue_no;
	private String institution;
	private String issue_de;
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
	public String getQual_nm() {
		return qual_nm;
	}
	public void setQual_nm(String qual_nm) {
		this.qual_nm = qual_nm;
	}
	public String getIssue_no() {
		return issue_no;
	}
	public void setIssue_no(String issue_no) {
		this.issue_no = issue_no;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getIssue_de() {
		return issue_de;
	}
	public void setIssue_de(String issue_de) {
		this.issue_de = issue_de;
	}
	@Override
	public String toString() {
		return "ResumeQualVO [resume_sn=" + resume_sn + ", seq=" + seq + ", qual_nm=" + qual_nm + ", issue_no="
				+ issue_no + ", institution=" + institution + ", issue_de=" + issue_de + "]";
	}
	
	
}
