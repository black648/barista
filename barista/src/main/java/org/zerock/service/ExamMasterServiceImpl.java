package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.ExamMasterDAO;
import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

@Service
public class ExamMasterServiceImpl implements ExamMasterService{
	@Inject
	private ExamMasterDAO examMasterDAO;
	
	public List<ExamMasterVO> selectList() throws Exception {
		return examMasterDAO.selectList();
	}
	
	public ExamMasterVO selectView(String exam_sn) throws Exception {
		return  examMasterDAO.selectView(exam_sn);
	}
	
	public int selectReceiptYN(ExamMasterVO vo) throws Exception {
		return examMasterDAO.selectReceiptYN(vo);
	}
	public List<ExamMasterVO> receiptMasterInfo(String mber_id) throws Exception {
		return examMasterDAO.receiptMasterInfo(mber_id);
	}
	
	public List<ExamMasterVO> getPassList() throws Exception {
		return examMasterDAO.getPassList();
	}
	
	public ExamMasterVO getPassView(ExamApplicantVO appVO) throws Exception {
		return  examMasterDAO.getPassView(appVO);
	}
}
