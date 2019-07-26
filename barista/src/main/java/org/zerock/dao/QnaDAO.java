package org.zerock.dao;

import java.util.List;

import org.zerock.domain.QnaAttachVO;
import org.zerock.domain.QnaVO;
import org.zerock.domain.SearchCriteria;

public interface QnaDAO {
	public int getSeqNo() throws Exception;
	
	public List<QnaVO> selectList(SearchCriteria cri) throws Exception; 
	
	public int countList(SearchCriteria cri) throws Exception;
	
	public QnaVO selectView (int sn) throws Exception;
	
	public void countUpdate(int sn) throws Exception;
	
	public void insertQna(QnaVO qnaVO) throws Exception;
	
	public void getAttach(QnaVO qnaVO) throws Exception;
	
	public List<QnaAttachVO> selectAttach(int sn) throws Exception;
	
}
