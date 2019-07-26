package org.zerock.domain;

public class BoardInstanceVO {

	private Long instance_id;
	private String instance_name;
	
	public Long getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(Long instance_id) {
		this.instance_id = instance_id;
	}
	public String getInstance_name() {
		return instance_name;
	}
	public void setInstance_name(String instance_name) {
		this.instance_name = instance_name;
	}
	@Override
	public String toString() {
		return "BoardInstanceVO [instance_id=" + instance_id + ", instance_name=" + instance_name + "]";
	}
	
	
}
