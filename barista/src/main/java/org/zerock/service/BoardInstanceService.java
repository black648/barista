package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardInstanceVO;

public interface BoardInstanceService {
	List<BoardInstanceVO> getInstanceList() throws Exception; 
	
	BoardInstanceVO getOneInstance (String instance_name) throws Exception;
}
