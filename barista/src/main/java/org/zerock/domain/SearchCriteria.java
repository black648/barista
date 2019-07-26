package org.zerock.domain;

public class SearchCriteria extends Criteria{

	private String searchType;
	private String keyword;
	
	private Long instance_id;
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	public Long getInstance_id() {
		return instance_id;
	}
	public void setInstance_id(Long instance_id) {
		this.instance_id = instance_id;
	}
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	
}
