package org.zerock.dto;

public class LoginDTO {

	private String mber_id;
	private String password;
	private boolean	useCookie;
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
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	@Override
	public String toString() {
		return "LoginDTO [mber_id=" + mber_id + ", password=" + password + ", useCookie=" + useCookie + "]";
	}
	
	
	
}
