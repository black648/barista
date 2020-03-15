package org.zerock.service;

import java.util.List;

import org.zerock.domain.ComnCodeVO;

public interface ComnCodeService {
	
	List<ComnCodeVO> selectList(ComnCodeVO codeVO) throws Exception;
	ComnCodeVO selectView(String cd) throws Exception; 
}
