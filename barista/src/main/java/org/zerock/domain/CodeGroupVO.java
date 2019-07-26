package org.zerock.domain;

import java.util.Date;

public class CodeGroupVO {
	private String grp_cd;
	private String grp_cd_nm;
	private String grp_cd_dscr;
	private Long cd_max_lvl;
	private String usable;
	private Long orderno;
	private String user_def_1_dscr;
	private String user_def_2_dscr;
	private String user_def_3_dscr;
	private String ref_table;
	private Date creat_de;
	private String creat_userid;
	private Date update_de;
	private String update_userid;
	public String getGrp_cd() {
		return grp_cd;
	}
	public void setGrp_cd(String grp_cd) {
		this.grp_cd = grp_cd;
	}
	public String getGrp_cd_nm() {
		return grp_cd_nm;
	}
	public void setGrp_cd_nm(String grp_cd_nm) {
		this.grp_cd_nm = grp_cd_nm;
	}
	public String getGrp_cd_dscr() {
		return grp_cd_dscr;
	}
	public void setGrp_cd_dscr(String grp_cd_dscr) {
		this.grp_cd_dscr = grp_cd_dscr;
	}
	public Long getCd_max_lvl() {
		return cd_max_lvl;
	}
	public void setCd_max_lvl(Long cd_max_lvl) {
		this.cd_max_lvl = cd_max_lvl;
	}
	public String getUsable() {
		return usable;
	}
	public void setUsable(String usable) {
		this.usable = usable;
	}
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	public String getUser_def_1_dscr() {
		return user_def_1_dscr;
	}
	public void setUser_def_1_dscr(String user_def_1_dscr) {
		this.user_def_1_dscr = user_def_1_dscr;
	}
	public String getUser_def_2_dscr() {
		return user_def_2_dscr;
	}
	public void setUser_def_2_dscr(String user_def_2_dscr) {
		this.user_def_2_dscr = user_def_2_dscr;
	}
	public String getUser_def_3_dscr() {
		return user_def_3_dscr;
	}
	public void setUser_def_3_dscr(String user_def_3_dscr) {
		this.user_def_3_dscr = user_def_3_dscr;
	}
	public String getRef_table() {
		return ref_table;
	}
	public void setRef_table(String ref_table) {
		this.ref_table = ref_table;
	}
	public Date getCreat_de() {
		return creat_de;
	}
	public void setCreat_de(Date creat_de) {
		this.creat_de = creat_de;
	}
	public String getCreat_userid() {
		return creat_userid;
	}
	public void setCreat_userid(String creat_userid) {
		this.creat_userid = creat_userid;
	}
	public Date getUpdate_de() {
		return update_de;
	}
	public void setUpdate_de(Date update_de) {
		this.update_de = update_de;
	}
	public String getUpdate_userid() {
		return update_userid;
	}
	public void setUpdate_userid(String update_userid) {
		this.update_userid = update_userid;
	}
	
	
	@Override
	public String toString() {
		return "CodeGroupVO [grp_cd=" + grp_cd + ", grp_cd_nm=" + grp_cd_nm + ", grp_cd_dscr=" + grp_cd_dscr
				+ ", cd_max_lvl=" + cd_max_lvl + ", usable=" + usable + ", orderno=" + orderno + ", user_def_1_dscr="
				+ user_def_1_dscr + ", user_def_2_dscr=" + user_def_2_dscr + ", user_def_3_dscr=" + user_def_3_dscr
				+ ", ref_table=" + ref_table + ", creat_de=" + creat_de + ", creat_userid=" + creat_userid
				+ ", update_de=" + update_de + ", update_userid=" + update_userid + "]";
	}
	
	
	
	
	
}
