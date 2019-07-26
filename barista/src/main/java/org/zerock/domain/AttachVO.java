package org.zerock.domain;

import java.util.Date;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class AttachVO {
	private int seqno;
	private int grpno;
	private String savedfilename;
	private String orgfilename;
	private String dirpath;
	private String state;
	private String upd_id;
	private Date upd_date;
	private String division;
	
	private String file_type;
	
	public String makeFile() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("seqno", seqno)
				.queryParam("orgfilename", orgfilename)
				.queryParam("savedfilename", savedfilename)
				.queryParam("dirpath", dirpath)
				.build()
				.encode();
		return uriComponents.toUriString();
	}
	
	
	public int getSeqno() {
		return seqno;
	}
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	
	
	public int getGrpno() {
		return grpno;
	}
	public void setGrpno(int grpno) {
		this.grpno = grpno;
	}
	public String getSavedfilename() {
		return savedfilename;
	}
	public void setSavedfilename(String savedfilename) {
		this.savedfilename = savedfilename;
	}
	public String getOrgfilename() {
		return orgfilename;
	}
	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}
	public String getDirpath() {
		return dirpath;
	}
	public void setDirpath(String dirpath) {
		this.dirpath = dirpath;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUpd_id() {
		return upd_id;
	}
	public void setUpd_id(String upd_id) {
		this.upd_id = upd_id;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}
	
	



	public String getFile_type() {
		return file_type;
	}


	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}


	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "AttachVO [seqno=" + seqno + ", savedfilename=" + savedfilename + ", orgfilename=" + orgfilename
				+ ", dirpath=" + dirpath + ", state=" + state + ", upd_id=" + upd_id + ", upd_date=" + upd_date
				+ ", division=" + division + "]";
	}
	
	
	
	
	
	
}
