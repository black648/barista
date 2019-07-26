package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDAOImpl implements CommonDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.commonMapper";

	
	@Override
	public String selectRcpNo(int rcpNo) {
	 return sqlSession.selectOne(namespace+".selectRcpNo",rcpNo);
	}
}
