package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberService {
	MemberVO readMember(String mber_id) throws Exception;
	MemberVO readWithPW(LoginDTO dto) throws Exception;
	
	List<MemberVO> idFind(MemberVO memberVO)throws Exception;
	MemberVO pwFind(MemberVO memberVO)throws Exception;
	
	void insertMember(MemberVO vo);
	void updateMember(MemberVO vo);
	void updatePw(MemberVO vo);

	void keepLogin(String mber_id,String sessionId, Date next) throws Exception;
	MemberVO checkLoginBefore(String value);
}
