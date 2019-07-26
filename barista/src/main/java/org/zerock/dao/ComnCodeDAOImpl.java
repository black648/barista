package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ComnCodeVO;

@Repository
public class ComnCodeDAOImpl implements ComnCodeDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.comnCodeMapper";

	
	@Override
	public List<ComnCodeVO> selectList(ComnCodeVO codeVO) throws Exception {
	 return sqlSession.selectList(namespace+".selectList",codeVO);
	}
	
	@Override
	public ComnCodeVO selectView(String cd) throws Exception {
		return sqlSession.selectOne(namespace+".selectView",cd);
	}
}
