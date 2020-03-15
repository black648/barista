package org.zerock.dao;

import org.zerock.domain.EduApplicantAttachVO;

public interface EduApplicantAttachDAO {

	EduApplicantAttachVO getOneFile(String apc_sn);
	void renewApplicantAttach(EduApplicantAttachVO attachVO);
}
