package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.BoardMapper";

	@Override
	public List<BoardVO> selectList(SearchCriteria cri) throws Exception {
	 return sqlSession.selectList(namespace+".selectList",cri);
	}
	
	
	@Override
	public int countList(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countList",cri);
	}
	
	@Override
	public BoardVO selectView(int id) throws Exception {
	 return sqlSession.selectOne(namespace+".selectView",id);
	}
	@Override
	public void countUpdate(int id)throws Exception {
		sqlSession.update(namespace+".countUpdate",id);
	}
}
