package org.zerock.service;

import java.util.List;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamMasterService {
	
	List<ExamMasterVO> selectList() throws Exception;
	ExamMasterVO selectView(String exam_sn) throws Exception; 
	int selectReceiptYN(ExamMasterVO vo) throws Exception;
	List<ExamMasterVO> receiptMasterInfo(String mber_id) throws Exception;
	
	List<ExamMasterVO> getPassList() throws Exception;
	ExamMasterVO getPassView(ExamApplicantVO appVO) throws Exception; 
}
