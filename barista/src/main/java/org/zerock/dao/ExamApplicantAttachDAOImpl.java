package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ExamApplicantAttachVO;
import org.zerock.domain.ExamApplicantVO;

@Repository
public class ExamApplicantAttachDAOImpl implements ExamApplicantAttachDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.examApplicantAttachMapper";

	@Override
	public List<ExamApplicantAttachVO> getFileList(ExamApplicantAttachVO attachVO)  throws Exception {
		return sqlSession.selectList(namespace+".getFileList", attachVO);
	}
	
	@Override
	public ExamApplicantAttachVO getOneFile(String apc_sn) {
		return sqlSession.selectOne(namespace+".getOneFile", apc_sn);
	}
	
	
	@Override
	public void insertAttach(ExamApplicantAttachVO vo) {
		sqlSession.insert(namespace+".insertAttach",vo);
	}
	
	@Override
	public int getSeq() {
		return sqlSession.selectOne(namespace+".getSeq");
	}
	
	public void renewApplicant(ExamApplicantAttachVO attachVO) throws Exception {
		sqlSession.update(namespace+".renewApplicant",attachVO);
	}
}
