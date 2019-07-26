package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.EduApplicantDAO;
import org.zerock.dao.EduMasterDAO;
import org.zerock.domain.EduMasterVO;

@Service
public class EduServiceImpl implements EduService {

	@Inject EduMasterDAO eduMasterDAO;
	@Inject EduApplicantDAO eduApplicantDAO;
	@Inject EduApplicantDAO eduApplicantAttachDAO;
	
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
	
}
