package org.zerock.dao;

import java.util.List;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamApplicantDAO {
	public void renewApplicant(ExamApplicantVO examApplicantVO)  throws Exception;
	public ExamApplicantVO selectView(ExamApplicantVO examApplicantVO) throws Exception; 
	public String selectMaxSn(String exam_sn) throws Exception;
	
}
