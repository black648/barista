package org.zerock.service;

import java.util.List;

import org.zerock.domain.ExamApplicantAttachVO;

public interface ExamApplicantAttachService {
	
	public List <ExamApplicantAttachVO> getFileList(ExamApplicantAttachVO attachVO) throws Exception;
	public ExamApplicantAttachVO getOneFile(String apc_sn) ;
	public void insertAttach(ExamApplicantAttachVO vo) throws Exception;
	public int getSeq() throws Exception;
	public void renewApplicant(ExamApplicantAttachVO attachVO)  throws Exception;
}
