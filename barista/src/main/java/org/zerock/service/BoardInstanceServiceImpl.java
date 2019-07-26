package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.BoardInstanceDAO;
import org.zerock.domain.BoardInstanceVO;
import org.zerock.domain.BoardVO;

@Service
public class BoardInstanceServiceImpl implements BoardInstanceService {

	@Inject
	private BoardInstanceDAO boardInsDAO;
	
	@Override
	public List<BoardInstanceVO> getInstanceList()  throws Exception {
		return boardInsDAO.getInstanceList();
	}
	
	
	@Override
	public BoardInstanceVO getOneInstance  (String instance_name) throws Exception {
		return boardInsDAO.getOneInstance(instance_name);
	}
	
}
