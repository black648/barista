package org.zerock.service;

import java.util.List;

import org.zerock.domain.EduApplicantAttachVO;
import org.zerock.domain.EduApplicantVO;
import org.zerock.domain.EduMasterVO;

public interface EduService {
	
	List<EduMasterVO> getReceiptList(); 
	EduMasterVO selectMasterView(String edu_sn);
	int selectReceiptYN(EduMasterVO masterVO);
	
	EduApplicantVO selectView(EduApplicantVO eduApplicantVO);
	String selectMaxSn(String edu_sn);

	void renewApplicant(EduApplicantVO eduApplicantVO);
	
	EduApplicantAttachVO getOneFile(String apc_sn); 
	void renewApplicantAttach(EduApplicantAttachVO attachVO);
}
