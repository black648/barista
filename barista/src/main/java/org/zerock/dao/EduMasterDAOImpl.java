package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.EduMasterVO;

@Repository
public class EduMasterDAOImpl implements EduMasterDAO{

	@Inject private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.eduMasterMapper";
	
	
	@Override
	public List<EduMasterVO> getReceiptList() {
		return sqlSession.selectList(namespace+".getReceiptList");
	}
	
	@Override
	public EduMasterVO selectMasterView(String edu_sn) {
		return sqlSession.selectOne(namespace+".selectMasterView",edu_sn);
	}
	@Override
	public int selectReceiptYN(EduMasterVO masterVO) {
		return sqlSession.selectOne(namespace+".selectReceiptYN",masterVO);
	}
}
