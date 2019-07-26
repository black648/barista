package org.zerock.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.EduApplicantVO;
import org.zerock.domain.EduMasterVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.ComnCodeService;
import org.zerock.service.EduService;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/edu/*")
public class EduController {
	@Inject MemberService memberService;
	@Inject ComnCodeService comnCodeService;
	@Inject EduService eduService;
	
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public void intro(Model model,EduMasterVO masterVO,HttpSession session) {
		
		List<EduMasterVO> getReceiptList = eduService.getReceiptList();
		
		model.addAttribute("receiptList",getReceiptList);
	}
	
	@RequestMapping("/selectReceiptYN")
	public @ResponseBody int selectReceiptYN(@RequestParam String edu_sn,HttpSession session) throws Exception {
		EduMasterVO beforeMasterVO = new EduMasterVO();	
		System.out.println("12312312313123 : " +  edu_sn);
		beforeMasterVO = eduService.selectMasterView(edu_sn);
		
		
		
		//VO안에 VO값을 호출시 NULLPOINT 에러 발생으로 인해 생성한 VO를 세팅.
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		EduMasterVO masterVO = new EduMasterVO();
		EduApplicantVO eduApplicantVO =  new EduApplicantVO();
		
		masterVO.setEdu_bgnde(beforeMasterVO.getEdu_bgnde());
		masterVO.setEdu_endde(beforeMasterVO.getEdu_endde());
		
		eduApplicantVO.setMber_id(memberVO.getMber_id());
		masterVO.setEduApplicantVO(eduApplicantVO); 
		//masterVO.getExamApplicantVO().setMber_id(memberVO.getMber_id());
		int reCeiptYN=eduService.selectReceiptYN(masterVO);
		
		return reCeiptYN;
	}
	
	@RequestMapping(value="edu/receiptForm", method=RequestMethod.GET)
	public void receiptForm (EduMasterVO masterVO, HttpServletRequest request,Model model) {
		EduMasterVO eduMasterVO = new EduMasterVO();
		eduMasterVO = eduService.selectMasterView(masterVO.getEdu_sn());
		
		model.addAttribute("eduMasterVO", eduMasterVO);
	}
	
	
	
	
}
