package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardVO> selectList(SearchCriteria cri) throws Exception {
		return boardDAO.selectList(cri);
	}
	
	@Override
	public int countList(SearchCriteria cri) throws Exception {
		return boardDAO.countList(cri);
	}
	
	
	@Override
	public BoardVO selectView (int id) throws Exception {
		return boardDAO.selectView(id);
	}
	
	@Override
	public void countUpdate(int id)throws Exception {
		boardDAO.countUpdate(id);
	}
}
