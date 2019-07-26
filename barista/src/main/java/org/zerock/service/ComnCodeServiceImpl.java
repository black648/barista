package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.ComnCodeDAO;
import org.zerock.domain.ComnCodeVO;

@Service
public class ComnCodeServiceImpl implements ComnCodeService{
	@Inject
	private ComnCodeDAO comnCodeDAO;
	
	public List<ComnCodeVO> selectList(ComnCodeVO codeVO) throws Exception {
		return comnCodeDAO.selectList(codeVO);
	}
	
	public ComnCodeVO selectView(String cd) throws Exception {
		return  comnCodeDAO.selectView(cd);
	}
}
