package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class EduApplicantAttachDAOImpl implements EduApplicantAttachDAO{

	@Inject private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.eduApplicantAttachMapper";
}
