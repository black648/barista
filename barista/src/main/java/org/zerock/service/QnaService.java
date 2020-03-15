package org.zerock.service;

import java.util.List;

import org.zerock.domain.QnaAttachVO;
import org.zerock.domain.QnaVO;
import org.zerock.domain.SearchCriteria;

public interface QnaService {
	
	int getSeqNo() throws Exception;
	
	List<QnaVO> selectList(SearchCriteria cri) throws Exception;
	
	int countList(SearchCriteria cri) throws Exception;
	
	QnaVO selectView(int sn) throws Exception;
	
	void countUpdate(int sn) throws Exception;
	
	void insertQna(QnaVO qnaVO) throws Exception;
	
	List<QnaAttachVO> selectAttach(int sn) throws Exception;
	
}
