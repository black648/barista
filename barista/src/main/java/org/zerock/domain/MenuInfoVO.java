package org.zerock.domain;

import java.util.Date;

public class MenuInfoVO {
	private String menu_code;
	private String menu_name;
	private String p_menu_code;
	private long lvl;
	private String menu_form;
	private String del_yn;
	private String cre_id;
	private Date cre_de;
	private String upd_id;
	private Date upd_de;
	private String url;
	private long ord;
	
	
	
	public String getMenu_code() {
		return menu_code;
	}
	public void setMenu_code(String menu_code) {
		this.menu_code = menu_code;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getP_menu_code() {
		return p_menu_code;
	}
	public void setP_menu_code(String p_menu_code) {
		this.p_menu_code = p_menu_code;
	}
	public long getLvl() {
		return lvl;
	}
	public void setLvl(long lvl) {
		this.lvl = lvl;
	}
	public String getMenu_form() {
		return menu_form;
	}
	public void setMenu_form(String menu_form) {
		this.menu_form = menu_form;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getCre_id() {
		return cre_id;
	}
	public void setCre_id(String cre_id) {
		this.cre_id = cre_id;
	}
	public Date getCre_de() {
		return cre_de;
	}
	public void setCre_de(Date cre_de) {
		this.cre_de = cre_de;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public Date getUpd_de() {
		return upd_de;
	}
	public void setUpd_de(Date upd_de) {
		this.upd_de = upd_de;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getOrd() {
		return ord;
	}
	public void setOrd(long ord) {
		this.ord = ord;
	}
	@Override
	public String toString() {
		return "MenuInfoVO [menu_code=" + menu_code + ", menu_name=" + menu_name + ", p_menu_code=" + p_menu_code
				+ ", lvl=" + lvl + ", menu_form=" + menu_form + ", del_yn=" + del_yn + ", cre_id=" + cre_id
				+ ", cre_de=" + cre_de + ", upd_id=" + upd_id + ", upd_de=" + upd_de + ", url=" + url + ", ord=" + ord
				+ "]";
	}
	
	
	
	
}
