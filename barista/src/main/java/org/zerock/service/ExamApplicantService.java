package org.zerock.service;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamApplicantService {
	
	void renewApplicant(ExamApplicantVO examApplicantVO) throws Exception;
	
	ExamApplicantVO selectView(ExamApplicantVO examApplicantVO) throws Exception; 
	
	String selectMaxSn(String exam_sn) throws Exception;
	
	
}
