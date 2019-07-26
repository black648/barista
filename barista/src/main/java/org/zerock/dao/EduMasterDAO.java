package org.zerock.dao;

import java.util.List;

import org.zerock.domain.EduMasterVO;

public interface EduMasterDAO {
	
	public List<EduMasterVO> getReceiptList();
	
	public EduMasterVO selectMasterView(String edu_sn);
	public int selectReceiptYN(EduMasterVO masterVO);
}
