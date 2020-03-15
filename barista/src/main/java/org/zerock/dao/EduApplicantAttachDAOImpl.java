package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.EduApplicantAttachVO;

@Repository
public class EduApplicantAttachDAOImpl implements EduApplicantAttachDAO{

	@Inject private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.eduApplicantAttachMapper";
	
	@Override
	public EduApplicantAttachVO getOneFile (String apc_sn) {
		return sqlSession.selectOne(namespace+".getOneFile", apc_sn);
	}
	
	@Override
	public void renewApplicantAttach(EduApplicantAttachVO attachVO) {
		sqlSession.update(namespace+".renewApplicantAttach", attachVO);
	}
	
}
