package org.zerock.domain;

import java.util.Date;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ExamApplicantAttachVO {
	private int seqno;
	private String apc_sn;
	private String savedfilename;
	private String orgfilename;
	private String dirpath;
	private Date cre_date;
	private Date upd_date;
	
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

	public String getApc_sn() {
		return apc_sn;
	}

	public void setApc_sn(String apc_sn) {
		this.apc_sn = apc_sn;
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

	@Override
	public String toString() {
		return "ExamApplicantAttachVO [seqno=" + seqno + ", apc_sn=" + apc_sn + ", savedfilename=" + savedfilename
				+ ", orgfilename=" + orgfilename + ", dirpath=" + dirpath + ", cre_date=" + cre_date + ", upd_date="
				+ upd_date + "]";
	}
	
	
	
	
	
	
	
	
}
