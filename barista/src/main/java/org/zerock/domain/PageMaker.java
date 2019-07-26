package org.zerock.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount; //총게시글
	private int startPage; //화면에 표출되는 시작페이지 ex) 1,11 ,21,31 
	private int endPage;  // 화면에 표출되는 마지막페이지 ex) 10,20,30,40
	
	private boolean prev;
	private boolean next;
	
	private int displayPageNum=10;
	private Criteria cri;
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	
	}
	private void calcData() {
		endPage=(int) (Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage - displayPageNum)+1;
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)(cri.getPerPageNum()/cri.getPage())));
		
		if(endPage>tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage ==1? false : true;
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
	}
	
	
	
	
	
	
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	
	

	
	
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	// URI를 통해 GET방식에 데이터를 보낼때 사용 EX) URL?page=&perPageNum=
	
	// 검색이 없을떄
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", 10)
				.build();
		return uriComponents.toUriString();
	}
	
	
	// 검색 내용이 있을때
	public String makeSearch(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", 10)
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
				.build()
				.encode();
		return uriComponents.toUriString();
	}
	
}
