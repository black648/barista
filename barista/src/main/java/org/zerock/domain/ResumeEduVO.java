package org.zerock.domain;

public class ResumeEduVO {
	private String resume_sn;
	private int seq;
	private String bgnde;
	private String endde;
	private String institution;
	private String edu_cn;
	private String edu_time;
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
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getEdu_cn() {
		return edu_cn;
	}
	public void setEdu_cn(String edu_cn) {
		this.edu_cn = edu_cn;
	}
	public String getEdu_time() {
		return edu_time;
	}
	public void setEdu_time(String edu_time) {
		this.edu_time = edu_time;
	}
	@Override
	public String toString() {
		return "ResumeEduVO [resume_sn=" + resume_sn + ", seq=" + seq + ", bgnde=" + bgnde + ", endde=" + endde
				+ ", institution=" + institution + ", edu_cn=" + edu_cn + ", edu_time=" + edu_time + "]";
	}
	
	
}
