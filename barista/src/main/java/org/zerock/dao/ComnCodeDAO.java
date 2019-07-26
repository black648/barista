package org.zerock.dao;

import java.util.List;

import org.zerock.domain.ComnCodeVO;

public interface ComnCodeDAO {
	public List<ComnCodeVO> selectList(ComnCodeVO codeVO) throws Exception;
	public ComnCodeVO selectView(String cd) throws Exception; 
}
