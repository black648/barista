package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.AttachVO;

@Repository
public class AttachDAOImpl implements AttachDAO{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.AttachMapper";

	@Override
	public List<AttachVO> getFileList(AttachVO attachVO)  throws Exception {
		return sqlSession.selectList(namespace+".getFileList", attachVO);
	}
	
	@Override
	public AttachVO getOneFile(int seqno) {
		return sqlSession.selectOne(namespace+".getOneFile", seqno);
	}
	
	
	@Override
	public void insertAttach(AttachVO vo) {
		sqlSession.insert(namespace+".insertAttach",vo);
	}
	
	@Override
	public int getSeq() {
		return sqlSession.selectOne(namespace+".getSeq");
	}
}
