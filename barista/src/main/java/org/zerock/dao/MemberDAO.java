package org.zerock.dao;

import java.util.Date;
import java.util.List;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberDAO {
	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String mber_id) throws Exception;
	public MemberVO readWithPW(LoginDTO dto) throws Exception;
	
	public List<MemberVO> idFind(MemberVO memberVO) throws Exception;
	public MemberVO pwFind(MemberVO memberVO) throws Exception;
	
	public void updateMember(MemberVO vo);
	public void updatePw(MemberVO vo);
	
	public void keepLogin(String mber_id, String sessionId, Date next);
	public MemberVO checkMemberWithSessionKey(String value);
	
}