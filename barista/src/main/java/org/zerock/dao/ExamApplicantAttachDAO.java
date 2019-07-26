package org.zerock.dao;

import java.util.List;

import org.zerock.domain.AttachVO;
import org.zerock.domain.ExamApplicantAttachVO;
import org.zerock.domain.ExamApplicantVO;

public interface ExamApplicantAttachDAO {

	public List <ExamApplicantAttachVO> getFileList(ExamApplicantAttachVO attachVO) throws Exception;
	public ExamApplicantAttachVO getOneFile(String apc_sn) ;
	public void insertAttach(ExamApplicantAttachVO vo) throws Exception;
	public int getSeq() throws Exception;
	
	public void renewApplicant(ExamApplicantAttachVO attachVO)  throws Exception;
}
