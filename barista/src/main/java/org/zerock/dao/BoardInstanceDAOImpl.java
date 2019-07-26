package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardInstanceVO;

@Repository
public class BoardInstanceDAOImpl implements BoardInstanceDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.BoardInstanceMapper";

	@Override
	public List<BoardInstanceVO> getInstanceList() throws Exception {
	 return sqlSession.selectList(namespace+".getInstanceList");
	}
	@Override
	public BoardInstanceVO getOneInstance(String instance_name) throws Exception {
	 return sqlSession.selectOne(namespace+".getOneInstance",instance_name);
	}

}
