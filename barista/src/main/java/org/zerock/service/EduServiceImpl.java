package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.EduApplicantAttachDAO;
import org.zerock.dao.EduApplicantDAO;
import org.zerock.dao.EduMasterDAO;
import org.zerock.domain.EduApplicantAttachVO;
import org.zerock.domain.EduApplicantVO;
import org.zerock.domain.EduMasterVO;

@Service
public class EduServiceImpl implements EduService {

	@Inject EduMasterDAO eduMasterDAO;
	@Inject EduApplicantDAO eduApplicantDAO;
	@Inject EduApplicantAttachDAO eduApplicantAttachDAO;
	
	@Override
	public List<EduMasterVO> getReceiptList() {
		return eduMasterDAO.getReceiptList();
	}
	
	@Override
	public EduMasterVO selectMasterView(String edu_sn) {
		return eduMasterDAO.selectMasterView(edu_sn);
	}
	@Override
	public int selectReceiptYN(EduMasterVO masterVO) {
		return eduMasterDAO.selectReceiptYN(masterVO); 
	}
	
	@Override
	public EduApplicantVO selectView(EduApplicantVO eduApplicantVO) {
		return eduApplicantDAO.selectView(eduApplicantVO);
	}
	@Override
	public String selectMaxSn(String edu_sn) {
		return eduApplicantDAO.selectMaxSn(edu_sn);
	}
	
	@Override
	public void renewApplicant(EduApplicantVO eduApplicantVO) {
		eduApplicantDAO.renewApplicant(eduApplicantVO);
	}
	
	@Override
	public EduApplicantAttachVO getOneFile(String apc_sn) {
		return eduApplicantAttachDAO.getOneFile(apc_sn);
	}
	
	@Override
	public void renewApplicantAttach(EduApplicantAttachVO attachVO) {
		eduApplicantAttachDAO.renewApplicantAttach(attachVO);
	}
	
	
}
