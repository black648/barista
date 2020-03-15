package org.zerock.dao;

import java.util.List;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamApplicantDAO {
	void renewApplicant(ExamApplicantVO examApplicantVO)  throws Exception;
	ExamApplicantVO selectView(ExamApplicantVO examApplicantVO) throws Exception; 
	String selectMaxSn(String exam_sn) throws Exception;
	
}
