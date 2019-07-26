package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.ExamApplicantDAO;
import org.zerock.domain.ExamApplicantVO;

@Service
public class ExamApplicantServiceImpl implements ExamApplicantService{
	@Inject
	private ExamApplicantDAO examApplicantDAO;
	
	public void renewApplicant(ExamApplicantVO examApplicantVO) throws Exception {
		examApplicantDAO.renewApplicant(examApplicantVO);
	}
	
	public ExamApplicantVO selectView(ExamApplicantVO examApplicantVO)  throws Exception {
		return examApplicantDAO.selectView(examApplicantVO);
	}
	
	public String selectMaxSn(String exam_sn) throws Exception {
		return examApplicantDAO.selectMaxSn(exam_sn);
	}
	
	
}
