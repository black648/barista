package org.zerock.dao;

import org.zerock.domain.EduApplicantVO;
import org.zerock.domain.EduMasterVO;

public interface EduApplicantDAO {

	EduApplicantVO selectView(EduApplicantVO eduApplicantVO);
	String selectMaxSn(String edu_sn);
	void renewApplicant(EduApplicantVO eduApplicantVO);
	
	
}
