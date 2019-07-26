package org.zerock.domain;

import java.util.Date;

public class EduApplicantAttachVO {
	private long seqno; 			//순번
	private String savedfilename; 	//저장파일명
	private String orgfilename; 	//원본파일명
	private String dirpath; 		//저장경로
	private Date cre_date; 			//수정일
	private Date upd_date; 			//수정일
	private String apc_sn; 			//접수일련번호
	
	
	public long getSeqno() {
		return seqno;
	}
	public void setSeqno(long seqno) {
		this.seqno = seqno;
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
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public Date getUpd_date() {
		return upd_date;
	}
	public void setUpd_date(Date upd_date) {
		this.upd_date = upd_date;
	}
	public String getApc_sn() {
		return apc_sn;
	}
	public void setApc_sn(String apc_sn) {
		this.apc_sn = apc_sn;
	}
	
	
}
