package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ExamApplicantVO;

@Repository
public class ExamApplicantDAOImpl implements ExamApplicantDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.examApplicantMapper";

	public void renewApplicant(ExamApplicantVO examApplicantVO) throws Exception {
		sqlSession.update(namespace+".renewApplicant",examApplicantVO);
	}
	public ExamApplicantVO selectView(ExamApplicantVO examApplicantVO) throws Exception {
		return sqlSession.selectOne(namespace+".selectView",examApplicantVO);
	}
	
	public String selectMaxSn(String exam_sn) throws Exception {
		return sqlSession.selectOne(namespace+".selectMaxSn",exam_sn);
	}
	
}
