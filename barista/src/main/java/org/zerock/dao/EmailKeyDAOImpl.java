package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.EmailKeyVO;

@Repository
public class EmailKeyDAOImpl implements EmailKeyDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.emailKeyMapper";

	
	@Override
	public EmailKeyVO readEmail(String email) throws Exception {
		return (EmailKeyVO)sqlSession.selectOne(namespace+".selectEmail", email);
	}
	
	@Override
	public void insertEmail(EmailKeyVO emailKeyVO) throws Exception {
		sqlSession.insert(namespace+".insertEmail", emailKeyVO);
	}
	
	@Override
	public void updateEmail(EmailKeyVO emailKeyVO) throws Exception {
		sqlSession.update(namespace+".updateEmail", emailKeyVO);
	}
}
