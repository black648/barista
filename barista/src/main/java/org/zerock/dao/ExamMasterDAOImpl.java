package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;

@Repository
public class ExamMasterDAOImpl implements ExamMasterDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.examMasterMapper";

	
	@Override
	public List<ExamMasterVO> selectList() throws Exception {
	 return sqlSession.selectList(namespace+".selectList");
	}
	
	@Override
	public ExamMasterVO selectView(String exam_sn) throws Exception {
		return sqlSession.selectOne(namespace+".selectView",exam_sn);
	}
	public int selectReceiptYN(ExamMasterVO vo) throws Exception {
		return sqlSession.selectOne(namespace+".selectReceiptYN",vo);
	}
	
	@Override
	public List<ExamMasterVO> receiptMasterInfo(String mber_id) throws Exception {
	 return sqlSession.selectList(namespace+".receiptMasterInfo",mber_id);
	}
	
	//합격자 발표 대상 리스트
	@Override
	public List<ExamMasterVO> getPassList() throws Exception {
	 return sqlSession.selectList(namespace+".getPassList");
	}
	
	@Override
	public ExamMasterVO getPassView(ExamApplicantVO appVO) throws Exception {
		return sqlSession.selectOne(namespace+".getPassView",appVO);
	}

	
}
