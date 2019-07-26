package org.zerock.service;

import java.util.List;

import org.zerock.domain.ComnCodeVO;

public interface ComnCodeService {
	
	public List<ComnCodeVO> selectList(ComnCodeVO codeVO) throws Exception;
	public ComnCodeVO selectView(String cd) throws Exception; 
}
