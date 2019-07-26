package org.zerock.dao;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;

public interface BoardDAO {
	public List<BoardVO> selectList(SearchCriteria cri) throws Exception; 
	
	public int countList(SearchCriteria cri) throws Exception;
	
	public BoardVO selectView (int id) throws Exception;
	
	public void countUpdate(int id) throws Exception;
	
}
