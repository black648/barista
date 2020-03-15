package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.EduApplicantVO;

@Repository
public class EduApplicantDAOImpl implements EduApplicantDAO{

	@Inject private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.eduApplicantMapper";
	
	@Override
	public EduApplicantVO selectView (EduApplicantVO eduApplicantVO) { 
		return sqlSession.selectOne(namespace+".selectView", eduApplicantVO);
	}
	@Override
	public String selectMaxSn(String edu_sn) {
		return sqlSession.selectOne(namespace+".selectMaxSn", edu_sn);
	}
	
	@Override
	public void renewApplicant(EduApplicantVO eduApplicantVO) {
		sqlSession.update(namespace+".renewApplicant",eduApplicantVO);
	}
}
