package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.AttachDAO;
import org.zerock.domain.AttachVO;

@Service
public class AttachServiceImpl implements AttachService {

	@Inject
	private AttachDAO attachDAO;
	
	@Override
	public List<AttachVO> getFileList(AttachVO attachVO) throws Exception {
		return attachDAO.getFileList(attachVO);
	}
	@Override
	public AttachVO getOneFile(int seqno) {
		return attachDAO.getOneFile(seqno);
	}
	
	
	@Override
	public void insertAttach(AttachVO vo)throws Exception {
		attachDAO.insertAttach(vo);
	}
	
	@Override
	public int getSeq()throws Exception {
		return attachDAO.getSeq();
	}

}
