package org.zerock.dao;

import java.util.List;

import org.zerock.domain.BoardInstanceVO;

public interface BoardInstanceDAO {
	public List<BoardInstanceVO> getInstanceList() throws Exception; 
	
	public BoardInstanceVO getOneInstance (String instance_name) throws Exception;
	

	
}
