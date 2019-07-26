package org.zerock.service;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamApplicantService {
	
	public void renewApplicant(ExamApplicantVO examApplicantVO) throws Exception;
	
	public ExamApplicantVO selectView(ExamApplicantVO examApplicantVO) throws Exception; 
	
	public String selectMaxSn(String exam_sn) throws Exception;
	
	
}
