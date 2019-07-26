package org.zerock.service;

import java.util.List;

import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

public interface ExamMasterService {
	
	public List<ExamMasterVO> selectList() throws Exception;
	public ExamMasterVO selectView(String exam_sn) throws Exception; 
	public int selectReceiptYN(ExamMasterVO vo) throws Exception;
	public List<ExamMasterVO> receiptMasterInfo(String mber_id) throws Exception;
	
	public List<ExamMasterVO> getPassList() throws Exception;
	public ExamMasterVO getPassView(ExamApplicantVO appVO) throws Exception; 
}
