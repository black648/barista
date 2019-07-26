package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.dao.QnaDAO;
import org.zerock.domain.QnaAttachVO;
import org.zerock.domain.QnaVO;
import org.zerock.domain.SearchCriteria;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	@Override
	public int getSeqNo() throws Exception {
		return qnaDAO.getSeqNo();
	}
	
	@Override
	public List<QnaVO> selectList(SearchCriteria cri) throws Exception {
		return qnaDAO.selectList(cri);
	}
	
	@Override
	public int countList(SearchCriteria cri) throws Exception {
		return qnaDAO.countList(cri);
	}
	
	
	@Override
	public QnaVO selectView (int sn) throws Exception {
		return qnaDAO.selectView(sn);
	}
	
	@Override
	public void countUpdate(int sn)throws Exception {
		qnaDAO.countUpdate(sn);
	}
	@Transactional
	@Override
	public void insertQna(QnaVO qnaVO) throws Exception {
		qnaDAO.insertQna(qnaVO);
		String[] files = qnaVO.getFiles();
		String file = qnaVO.getFile_name();
		if(file==null) {return;}
		
	//	qnaDAO.getAttach(qnaVO);
	//	for(String fileName:files) {
			//qnaDAO.getAttach(fileName);
	//	}
}
	
	@Override
	public List<QnaAttachVO> selectAttach(int sn) throws Exception {
		return qnaDAO.selectAttach(sn);
	}
}
