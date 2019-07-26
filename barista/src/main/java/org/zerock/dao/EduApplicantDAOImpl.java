package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EduApplicantDAOImpl implements EduApplicantDAO{

	@Inject private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.eduApplicantMapper";
}
