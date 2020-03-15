package org.zerock.service;

import java.util.List;

import org.zerock.domain.AttachVO;

public interface AttachService {
	
	List <AttachVO> getFileList(AttachVO attachVO) throws Exception;
	AttachVO getOneFile(int seqno) ;
	void insertAttach(AttachVO vo) throws Exception;
	int getSeq() throws Exception;
}
