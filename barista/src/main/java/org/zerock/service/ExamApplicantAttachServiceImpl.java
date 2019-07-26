package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.ExamApplicantAttachDAO;
import org.zerock.domain.ExamApplicantAttachVO;

@Service
public class ExamApplicantAttachServiceImpl implements ExamApplicantAttachService {

	@Inject
	private ExamApplicantAttachDAO attachDAO;
	
	@Override
	public List<ExamApplicantAttachVO> getFileList(ExamApplicantAttachVO attachVO) throws Exception {
		return attachDAO.getFileList(attachVO);
	}
	@Override
	public ExamApplicantAttachVO getOneFile(String apc_sn) {
		return attachDAO.getOneFile(apc_sn);
	}
	
	
	@Override
	public void insertAttach(ExamApplicantAttachVO vo)throws Exception {
		attachDAO.insertAttach(vo);
	}
	
	@Override
	public int getSeq()throws Exception {
		return attachDAO.getSeq();
	}
	@Override
	public void renewApplicant(ExamApplicantAttachVO attachVO) throws Exception {
		attachDAO.renewApplicant(attachVO);
	}

}
