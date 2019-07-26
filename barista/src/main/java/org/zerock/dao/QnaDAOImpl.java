package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.QnaAttachVO;
import org.zerock.domain.QnaVO;
import org.zerock.domain.SearchCriteria;

@Repository
public class QnaDAOImpl implements QnaDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.QnaMapper";

	
	@Override
	public int getSeqNo() throws Exception {
		return sqlSession.selectOne(namespace+".getSeqNo");
	}
	@Override
	public List<QnaVO> selectList(SearchCriteria cri) throws Exception {
	 return sqlSession.selectList(namespace+".selectList",cri);
	}
	
	
	@Override
	public int countList(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countList",cri);
	}
	
	@Override
	public QnaVO selectView(int sn) throws Exception {
	 return sqlSession.selectOne(namespace+".selectView",sn);
	}
	@Override
	public void countUpdate(int sn)throws Exception {
		sqlSession.update(namespace+".countUpdate",sn);
	}
	
	@Override
	public void insertQna(QnaVO qnaVO) throws Exception {
		sqlSession.insert(namespace+".insertQna",qnaVO);
	}
	
	@Override
	public void getAttach(QnaVO qnaVO) throws Exception {
		sqlSession.insert(namespace+".getAttach",qnaVO);
	}
	
	@Override
	public List<QnaAttachVO> selectAttach(int sn) throws Exception {
		return sqlSession.selectList(namespace+".selectAttach",sn);
	}
	
}
