package org.zerock.domain;

import java.util.Date;

public class ResumeMasterVO {
	private String resume_sn;
	private int seq;
	private String title;
	private String mber_id;
	private String mber_name;
	private String mber_engname;
	private String mber_phone;
	private String sex;
	private String birth;
	private String email;
	private String status;
	private String resume_apply;
	private String resume_nature;
	private String resume_ambition;
	private Date cre_de;
	private Date upd_de;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getMber_engname() {
		return mber_engname;
	}
	public void setMber_engname(String mber_engname) {
		this.mber_engname = mber_engname;
	}
	public String getMber_phone() {
		return mber_phone;
	}
	public void setMber_phone(String mber_phone) {
		this.mber_phone = mber_phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResume_apply() {
		return resume_apply;
	}
	public void setResume_apply(String resume_apply) {
		this.resume_apply = resume_apply;
	}
	public String getResume_nature() {
		return resume_nature;
	}
	public void setResume_nature(String resume_nature) {
		this.resume_nature = resume_nature;
	}
	public String getResume_ambition() {
		return resume_ambition;
	}
	public void setResume_ambition(String resume_ambition) {
		this.resume_ambition = resume_ambition;
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
	@Override
	public String toString() {
		return "ResumeMasterVO [resume_sn=" + resume_sn + ", seq=" + seq + ", title=" + title + ", mber_id=" + mber_id
				+ ", mber_name=" + mber_name + ", mber_engname=" + mber_engname + ", mber_phone=" + mber_phone
				+ ", sex=" + sex + ", birth=" + birth + ", email=" + email + ", status=" + status + ", resume_apply="
				+ resume_apply + ", resume_nature=" + resume_nature + ", resume_ambition=" + resume_ambition
				+ ", cre_de=" + cre_de + ", upd_de=" + upd_de + "]";
	}
	
	
	
	
}
