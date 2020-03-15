package org.zerock.domain;

import java.util.Date;

public class EduApplicantVO {
	private String edu_sn; 		//시험일련번호
	private String apc_sn; 		//접수일련번호
	private String mber_id; 	//접수자ID
	private String mber_name; 	//접수자명
	private String gunmul; 		//건물번호
	private String address1; 	//주소1
	private String address2; 	//주소2
	private String mber_phone; 	//휴대폰번호
	private String email; 		//이메일
	private Date cre_de; 		//접수일
	private Date upd_de; 		//수정일
	private Date final_de; 		//최종접수일
	private String final_yn; 	//최종접수여부
	private String edu_yn; 		//교육인가여부
	private String mber_engname ;
	private String agree1; 
	private String agree2;
	public String getEdu_sn() {
		return edu_sn;
	}
	public void setEdu_sn(String edu_sn) {
		this.edu_sn = edu_sn;
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
	public Date getFinal_de() {
		return final_de;
	}
	public void setFinal_de(Date final_de) {
		this.final_de = final_de;
	}
	public String getFinal_yn() {
		return final_yn;
	}
	public void setFinal_yn(String final_yn) {
		this.final_yn = final_yn;
	}
	public String getEdu_yn() {
		return edu_yn;
	}
	public void setEdu_yn(String edu_yn) {
		this.edu_yn = edu_yn;
	}
	public String getMber_engname() {
		return mber_engname;
	}
	public void setMber_engname(String mber_engname) {
		this.mber_engname = mber_engname;
	}
	public String getAgree1() {
		return agree1;
	}
	public void setAgree1(String agree1) {
		this.agree1 = agree1;
	}
	public String getAgree2() {
		return agree2;
	}
	public void setAgree2(String agree2) {
		this.agree2 = agree2;
	}
	@Override
	public String toString() {
		return "EduApplicantVO [edu_sn=" + edu_sn + ", apc_sn=" + apc_sn + ", mber_id=" + mber_id + ", mber_name="
				+ mber_name + ", gunmul=" + gunmul + ", address1=" + address1 + ", address2=" + address2
				+ ", mber_phone=" + mber_phone + ", email=" + email + ", cre_de=" + cre_de + ", upd_de=" + upd_de
				+ ", final_de=" + final_de + ", final_yn=" + final_yn + ", edu_yn=" + edu_yn + ", mber_engname="
				+ mber_engname + ", agree1=" + agree1 + ", agree2=" + agree2 + "]";
	}
	
	
	
	
	
}
