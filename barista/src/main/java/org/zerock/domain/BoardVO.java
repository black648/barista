package org.zerock.domain;

import java.util.Date;

public class BoardVO {

	private Long id;
	private Long instance_id;
	private String title;
	private String content;
	private String cre_nm;
	private String cre_id;
	private String upd_nm;
	private String upd_id;
	private String is_public;
	private String is_notice;
	private String del_yn;
	private String dept;
	private String status;
	private Date cre_de;
	private Date upd_de;
	private Long read_cnt;
	private String etc1;
	private String etc2;
	private String etc3;
	private int file_seq;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(Long instance_id) {
		this.instance_id = instance_id;
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
	public String getCre_nm() {
		return cre_nm;
	}
	public void setCre_nm(String cre_nm) {
		this.cre_nm = cre_nm;
	}
	public String getCre_id() {
		return cre_id;
	}
	public void setCre_id(String cre_id) {
		this.cre_id = cre_id;
	}
	public String getUpd_nm() {
		return upd_nm;
	}
	public void setUpd_nm(String upd_nm) {
		this.upd_nm = upd_nm;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public String getIs_public() {
		return is_public;
	}
	public void setIs_public(String is_public) {
		this.is_public = is_public;
	}
	public String getIs_notice() {
		return is_notice;
	}
	public void setIs_notice(String is_notice) {
		this.is_notice = is_notice;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public Long getRead_cnt() {
		return read_cnt;
	}
	public void setRead_cnt(Long read_cnt) {
		this.read_cnt = read_cnt;
	}
	public String getEtc1() {
		return etc1;
	}
	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}
	public String getEtc2() {
		return etc2;
	}
	public void setEtc2(String etc2) {
		this.etc2 = etc2;
	}
	public String getEtc3() {
		return etc3;
	}
	public void setEtc3(String etc3) {
		this.etc3 = etc3;
	}
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", instance_id=" + instance_id + ", title=" + title + ", content=" + content
				+ ", cre_nm=" + cre_nm + ", cre_id=" + cre_id + ", upd_nm=" + upd_nm + ", upd_id=" + upd_id
				+ ", is_public=" + is_public + ", is_notice=" + is_notice + ", del_yn=" + del_yn + ", dept=" + dept
				+ ", status=" + status + ", cre_de=" + cre_de + ", upd_de=" + upd_de + ", read_cnt=" + read_cnt
				+ ", etc1=" + etc1 + ", etc2=" + etc2 + ", etc3=" + etc3 + ", file_seq=" + file_seq + "]";
	}
	
	
	
	
	
	
}
