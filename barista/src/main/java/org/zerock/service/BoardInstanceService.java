package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardInstanceVO;

public interface BoardInstanceService {
	public List<BoardInstanceVO> getInstanceList() throws Exception; 
	
	public BoardInstanceVO getOneInstance (String instance_name) throws Exception;
}
