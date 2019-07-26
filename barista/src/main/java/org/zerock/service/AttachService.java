package org.zerock.service;

import java.util.List;

import org.zerock.domain.AttachVO;

public interface AttachService {
	
	public List <AttachVO> getFileList(AttachVO attachVO) throws Exception;
	public AttachVO getOneFile(int seqno) ;
	public void insertAttach(AttachVO vo) throws Exception;
	public int getSeq() throws Exception;
}
