package org.zerock.service;

import java.util.List;

import org.zerock.domain.ExamApplicantAttachVO;

public interface ExamApplicantAttachService {
	
	List <ExamApplicantAttachVO> getFileList(ExamApplicantAttachVO attachVO) throws Exception;
	ExamApplicantAttachVO getOneFile(String apc_sn) ;
	void insertAttach(ExamApplicantAttachVO vo) throws Exception;
	int getSeq() throws Exception;
	void renewApplicant(ExamApplicantAttachVO attachVO)  throws Exception;
}
