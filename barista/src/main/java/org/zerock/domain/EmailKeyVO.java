package org.zerock.domain;

import java.util.Date;

public class EmailKeyVO {
	private Long sn;
	private String email;
	private String key;
	private Date key_de;
	private String confirm_yn;
	private String mber_id;
	private Date confirm_de;
	public Long getSn() {
		return sn;
	}
	public void setSn(Long sn) {
		this.sn = sn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getKey_de() {
		return key_de;
	}
	public void setKey_de(Date key_de) {
		this.key_de = key_de;
	}
	public String getConfirm_yn() {
		return confirm_yn;
	}
	public void setConfirm_yn(String confirm_yn) {
		this.confirm_yn = confirm_yn;
	}
	public String getMber_id() {
		return mber_id;
	}
	public void setMber_id(String mber_id) {
		this.mber_id = mber_id;
	}
	public Date getConfirm_de() {
		return confirm_de;
	}
	public void setConfirm_de(Date confirm_de) {
		this.confirm_de = confirm_de;
	}
	@Override
	public String toString() {
		return "EmailKeyVO [sn=" + sn + ", email=" + email + ", key=" + key + ", key_de=" + key_de + ", confirm_yn="
				+ confirm_yn + ", mber_id=" + mber_id + ", confirm_de=" + confirm_de + "]";
	}
	
	
	
}
