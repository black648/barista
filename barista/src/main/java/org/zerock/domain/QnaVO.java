package org.zerock.domain;

import java.util.Arrays;
import java.util.Date;

public class QnaVO extends QnaAttachVO {
	private int sn;
	private int mber_no;
	private String mber_name;
	private String mber_id;
	private String mber_phone;
	private Date cre_de;
	private Date answer_de;
	private String title;
	private String content;
	private String email;
	private String middle_code;
	private String row_code;
	private String state;
	
	private String del_at;
	private String off_at;
	
	private String[] files;
	
	private String file_name;
	private String file_mask_name;

	private int file_seq;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public int getMber_no() {
		return mber_no;
	}
	public void setMber_no(int mber_no) {
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
	public String getMber_phone() {
		return mber_phone;
	}
	public void setMber_phone(String mber_phone) {
		this.mber_phone = mber_phone;
	}
	public Date getCre_de() {
		return cre_de;
	}
	public void setCre_de(Date cre_de) {
		this.cre_de = cre_de;
	}
	public Date getAnswer_de() {
		return answer_de;
	}
	public void setAnswer_de(Date answer_de) {
		this.answer_de = answer_de;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMiddle_code() {
		return middle_code;
	}
	public void setMiddle_code(String middle_code) {
		this.middle_code = middle_code;
	}
	public String getRow_code() {
		return row_code;
	}
	public void setRow_code(String row_code) {
		this.row_code = row_code;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDel_at() {
		return del_at;
	}
	public void setDel_at(String del_at) {
		this.del_at = del_at;
	}
	public String getOff_at() {
		return off_at;
	}
	public void setOff_at(String off_at) {
		this.off_at = off_at;
	}
	
	
	
	
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	
	
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_mask_name() {
		return file_mask_name;
	}
	public void setFile_mask_name(String file_mask_name) {
		this.file_mask_name = file_mask_name;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	@Override
	public String toString() {
		return "QnaVO [sn=" + sn + ", mber_no=" + mber_no + ", mber_name=" + mber_name + ", mber_id=" + mber_id
				+ ", mber_phone=" + mber_phone + ", cre_de=" + cre_de + ", answer_de=" + answer_de + ", title=" + title
				+ ", content=" + content + ", email=" + email + ", middle_code=" + middle_code + ", row_code="
				+ row_code + ", state=" + state + ", del_at=" + del_at + ", off_at=" + off_at + ", files="
				+ Arrays.toString(files) + ", file_name=" + file_name + ", file_mask_name=" + file_mask_name
				+ ", file_seq=" + file_seq + "]";
	}
	
	
	
	
	
	
	
}

