package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;

public interface BoardService {
	List<BoardVO> selectList(SearchCriteria cri) throws Exception;
	
	int countList(SearchCriteria cri) throws Exception;
	
	BoardVO selectView(int id) throws Exception;
	
	void countUpdate(int id) throws Exception;
}
