package org.zerock.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

@Repository 
//Repository 는 DAO를 스프링에 인식시키기 위해 사용
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "org.zerock.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember",vo);
	}
	
	@Override
	public MemberVO readMember(String mber_id) throws Exception {
		return (MemberVO)sqlSession.selectOne(namespace+".selectMember", mber_id);
	}
	
	@Override
	public MemberVO readWithPW(LoginDTO dto) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		//paramMap.put("mber_id", mber_id);
	//	paramMap.put("password", password);
		
		return (MemberVO)sqlSession.selectOne(namespace+".readWithPW",dto);
	}
	
	@Override
	public List<MemberVO> idFind(MemberVO memberVO) throws Exception {
		return sqlSession.selectList(namespace+".idFind",memberVO);
	}
	
	@Override
	public MemberVO pwFind(MemberVO memberVO) throws Exception {
		return (MemberVO)sqlSession.selectOne(namespace+".pwFind",memberVO);
	}
	
	
	@Override
	public void updateMember(MemberVO vo)  {
		sqlSession.update(namespace+".updateMember", vo);
	}
	
	@Override
	public void updatePw(MemberVO vo)  {
		sqlSession.update(namespace+".updatePw", vo);
	}
	
	
	@Override
	public void keepLogin(String mber_id, String sessionId, Date next) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("mber_id", mber_id);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		sqlSession.update(namespace+".keepLogin",paramMap);
	}
	
	@Override
	public MemberVO checkMemberWithSessionKey(String value) {
		return sqlSession.selectOne(namespace+".checkMemberWithSessionKey",value);
	}
	
}
