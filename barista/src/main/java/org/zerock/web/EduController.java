package org.zerock.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.EduApplicantAttachVO;
import org.zerock.domain.EduApplicantVO;
import org.zerock.domain.EduMasterVO;
import org.zerock.domain.ExamApplicantAttachVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.CommonService;
import org.zerock.service.ComnCodeService;
import org.zerock.service.EduService;
import org.zerock.service.MemberService;
import org.zerock.util.UploadFileUtils;

@Controller
@RequestMapping("/edu/*")
public class EduController {
	@Inject MemberService memberService;
	@Inject ComnCodeService comnCodeService;
	@Inject CommonService commonService;
	@Inject EduService eduService;
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public void intro(Model model,EduMasterVO masterVO,HttpSession session) {
		
		List<EduMasterVO> getReceiptList = eduService.getReceiptList();
		
		model.addAttribute("receiptList",getReceiptList);
	}
	
	@RequestMapping("/selectReceiptYN")
	public @ResponseBody int selectReceiptYN(@RequestParam String edu_sn,HttpSession session) throws Exception {
		EduMasterVO beforeMasterVO = new EduMasterVO();	
		beforeMasterVO = eduService.selectMasterView(edu_sn);
		
		//VO안에 VO값을 호출시 NULLPOINT 에러 발생으로 인해 생성한 VO를 세팅.
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		EduMasterVO masterVO = new EduMasterVO();
		EduApplicantVO eduApplicantVO =  new EduApplicantVO();
		
		masterVO.setEdu_bgnde(beforeMasterVO.getEdu_bgnde());
		masterVO.setEdu_endde(beforeMasterVO.getEdu_endde());
		
		eduApplicantVO.setMber_id(memberVO.getMber_id());
		masterVO.setEduApplicantVO(eduApplicantVO); 
		//masterVO.geteduApplicantVO().setMber_id(memberVO.getMber_id());
		int reCeiptYN=eduService.selectReceiptYN(masterVO);
		
		return reCeiptYN;
	}
	
	@RequestMapping(value="/receiptForm", method=RequestMethod.GET)
	public void receiptForm (EduMasterVO masterVO, Model model, HttpSession session) {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		EduMasterVO eduMasterVO = new EduMasterVO();
		eduMasterVO = eduService.selectMasterView(masterVO.getEdu_sn());
		
		EduApplicantVO eduApplicantVO = new EduApplicantVO();
		eduApplicantVO.setEdu_sn(masterVO.getEdu_sn());
		eduApplicantVO.setMber_id(memberVO.getMber_id());

		eduApplicantVO = eduService.selectView(eduApplicantVO);
		//첨부파일
		EduApplicantAttachVO attachVO = new EduApplicantAttachVO();
		
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("masterVO", eduMasterVO);
		model.addAttribute("applicantVO", eduApplicantVO);
	}
	
	@RequestMapping(value="/receiptForm", method=RequestMethod.POST)
	public String eduFormProcess(RedirectAttributes rttr, EduApplicantVO eduApplicantVO,MultipartHttpServletRequest request, HttpSession session) throws Exception{ 
		//20190809 여기 개발예정
		
		String edu_sn = request.getParameter("edu_sn");
		
		System.out.println("reqest : " +request.getParameter("edu_sn"));
		//System.out.println("eduApplicantVO : " +eduApplicantVO.getEdu_sn()); //파라미터가 여러개 찍히는 현상...
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		
		EduMasterVO eduMasterVO = new EduMasterVO();
		eduMasterVO.setEdu_sn(edu_sn);
		eduApplicantVO.setEdu_sn(edu_sn);
		eduApplicantVO.setMber_id(memberVO.getMber_id());
		
		EduApplicantVO applicantVO2 = new EduApplicantVO();
		//글이 존재하는지 확인.
		applicantVO2=eduService.selectView(eduApplicantVO);
		
		
		//본인이 등록한 글이 없다면 접수번호 생성.
		if(applicantVO2==null) {
			String maxKey = eduService.selectMaxSn(eduApplicantVO.getEdu_sn());			
			String getRcpNo ="";
			int rcpNo;
			if(maxKey!=null) { //1건이상의 접수자가 있을 경우.
				String[] cut=maxKey.split("\\_");
				String cutMaxKey=cut[1];		
				rcpNo = Integer.parseInt(cutMaxKey)+1;
				System.out.println("rcpNo : " + rcpNo);
						
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+CommonUtil.key4Change(cutMaxKey)); //조회하여 전달받은 맥스키를 형태에 맞게 연산
			}else{ //등록한 검정에서 접수가 처음인 경우
				rcpNo = 1;
			}
			getRcpNo=commonService.selectRcpNo(rcpNo);
			eduApplicantVO.setApc_sn(eduApplicantVO.getEdu_sn()+"_"+getRcpNo);

		}
		
		Iterator<String> itr = request.getFileNames(); 
		
		//request.getFileNames() 파일이 없어도 파일을 불러옴... 
		EduApplicantAttachVO attachVO = new EduApplicantAttachVO();
		
		String photoYN = request.getParameter("photoYN");
		if(photoYN!=null && !"N".equals(photoYN)) {
			while(itr.hasNext()) {
				if(itr.hasNext()) { 
					MultipartFile mpf = request.getFile(itr.next()); 
					System.out.println(mpf.getOriginalFilename() +" uploaded!"); 
				
				try { 
					
					attachVO =UploadFileUtils.uploadEduApplicantFile(uploadPath, mpf.getOriginalFilename(), mpf.getBytes() );
					attachVO.setApc_sn(eduApplicantVO.getApc_sn());
					attachVO.setOrgfilename(mpf.getOriginalFilename());
					eduService.renewApplicantAttach(attachVO);
			
				}catch (IOException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
				} 
				}else {
					System.out.println("데이터없음...");
				}
				
			}
		}
		
		
		System.out.println(eduApplicantVO.toString());
		//MERGE INTO 형식. APC_SN이 존재하면 UPDATE, 없으면 INSERT
		eduService.renewApplicant(eduApplicantVO);
		
		//리다이렉트 형태로 데이터를 전송시  RedirectAttributes의 addAttribute 형태로 보내야 하며 받는 쪽에서는 @RequestParam를 선언해 줘야 함.
		rttr.addAttribute("edu_sn", eduMasterVO.getEdu_sn());
		return "redirect:/edu/receiptView";

	}
	
	//뷰화면 표출
		@RequestMapping(value="/receiptView", method=RequestMethod.GET)
		public String receiptView(Model model,EduMasterVO masterVO,@RequestParam String edu_sn, HttpServletRequest request,HttpSession session) throws Exception{ 
			MemberVO memberVO = (MemberVO)session.getAttribute("login");
			EduApplicantVO eduApplicantVO = new EduApplicantVO();
			
			System.out.println("edu_sn :"+edu_sn);
			System.out.println(masterVO.toString());
			
			if (edu_sn!=null && !"".equals(edu_sn)) {
				masterVO.setEdu_sn(edu_sn);
			}
			//List<ComnCodeVO> codeList = comnCodeService.selectList(codeVO);
			
			//접수자 정보 조회
			eduApplicantVO.setMber_id(memberVO.getMber_id());
			eduApplicantVO.setEdu_sn(masterVO.getEdu_sn());
			eduApplicantVO = eduService.selectView(eduApplicantVO);
			
			//필요한거.
			//시험장관련(code)
			//첨부파일(attach)
			//마스터테이블 정보(master)
			
			//ComnCodeVO codeVO = comnCodeService.selectView(examApplicantVO.getExam_place_code());
			masterVO = eduService.selectMasterView(eduApplicantVO.getEdu_sn());
			EduApplicantAttachVO attachVO = eduService.getOneFile(eduApplicantVO.getApc_sn());
			
			model.addAttribute("eduSn",masterVO.getEdu_sn());
			//model.addAttribute("codeVO",codeVO);
			model.addAttribute("masterVO",masterVO);
			model.addAttribute("memberVO",memberVO);
			model.addAttribute("attachVO",attachVO);
			model.addAttribute("eduApplicantVO",eduApplicantVO);
			
			return "/edu/receiptView";
		}
	
	
	
	
}
