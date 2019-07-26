package org.zerock.domain;

import java.util.Date;

public class MemberVO {
	private Long mber_no;
	private String mber_name;
	private String mber_id;
	private String password;
	private String mber_phone;
	private String address1;
	private String address2;
	private String mber_se;
	private Date cre_de;
	private Date upd_de;
	
	private String tel1;
	private String tel2;
	private String tel3;
	
	
	private String email;
	
	
	public Long getMber_no() {
		return mber_no;
	}
	public void setMber_no(Long mber_no) {
		this.mber_no = mber_no;
	}
	public String getMber_name() {
		return mber_name;
	}
	public void setMber_name(String mber_name) {
		this.mber_name = mber_name;
	}
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMber_phone() {
		return mber_phone;
	}
	public void setMber_phone(String mber_phone) {
		this.mber_phone = mber_phone;
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
	public String getMber_se() {
		return mber_se;
	}
	public void setMber_se(String mber_se) {
		this.mber_se = mber_se;
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public String getTel1() {
		return tel1;
	}
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}
	@Override
	public String toString() {
		return "MemberVO [mber_no=" + mber_no + ", mber_name=" + mber_name + ", mber_id=" + mber_id + ", password="
				+ password + ", mber_phone=" + mber_phone + ", address1=" + address1 + ", address2=" + address2
				+ ", mber_se=" + mber_se + ", cre_de=" + cre_de + ", upd_de=" + upd_de + ", email=" + email + "]";
	}

	
	
	
	
	
}
