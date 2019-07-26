package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;


@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO memberDAO;
	
	public MemberVO readMember (String mber_id) throws Exception {
		return memberDAO.readMember(mber_id);
	}
	public MemberVO readWithPW (LoginDTO dto) throws Exception {
		return memberDAO.readWithPW(dto);
	}
	public List<MemberVO> idFind (MemberVO memberVO) throws Exception {
		return memberDAO.idFind(memberVO);
	}
	public MemberVO pwFind (MemberVO memberVO) throws Exception {
		return memberDAO.pwFind(memberVO);
	}
	public void insertMember(MemberVO memberVO) {
		memberDAO.insertMember(memberVO);
	}
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
	}
	public void updatePw(MemberVO memberVO) {
		memberDAO.updatePw(memberVO);
	}
	public void keepLogin(String mber_id,String sessionId, Date next) {
		memberDAO.keepLogin(mber_id, sessionId, next);
	}
	
	public MemberVO checkLoginBefore(String value) {
		return memberDAO.checkMemberWithSessionKey(value);
	}
	
	
}
