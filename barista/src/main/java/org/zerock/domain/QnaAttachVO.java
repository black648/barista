package org.zerock.domain;

public class QnaAttachVO {
	private int file_sn;
	private int sn;
	private String file_name;
	private String file_mask_name;
	private String path;
	
	private String file_type;
	
	public int getFile_sn() {
		return file_sn;
	}
	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
	public String getFile_type() {
		return file_type;
	}
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}
	@Override
	public String toString() {
		return "QnaAttachVO [file_sn=" + file_sn + ", sn=" + sn + ", file_name=" + file_name + ", file_mask_name="
				+ file_mask_name + ", path=" + path + "]";
	}

	
	
	
	
	
}
