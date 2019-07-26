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
import org.zerock.domain.ComnCodeVO;
import org.zerock.domain.ExamApplicantAttachVO;
import org.zerock.domain.ExamApplicantVO;
import org.zerock.domain.ExamMasterVO;
import org.zerock.domain.MemberVO;
import org.zerock.service.CommonService;
import org.zerock.service.ComnCodeService;
import org.zerock.service.ExamApplicantAttachService;
import org.zerock.service.ExamApplicantService;
import org.zerock.service.ExamMasterService;
import org.zerock.service.MemberService;
import org.zerock.util.CommonUtil;
import org.zerock.util.UploadFileUtils;

@Controller
@RequestMapping("/exam/*")
public class ExamController {
	
	@Inject ExamMasterService masterService;
	@Inject ExamApplicantService applicantService;
	@Inject MemberService memberService;
	@Inject ComnCodeService comnCodeService;
	@Inject ExamApplicantAttachService attachService;
	@Inject CommonService commonService;
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public void examList(Model model,ExamMasterVO masterVO,HttpSession session) throws Exception{ 
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		List<ExamMasterVO> list = masterService.selectList();
		
		model.addAttribute("list", list);
	}
	//접수 체크. 만약 시험일이 같은 시험을 중복으로 접수하였다면 아래와 같이 접수가 안됨.
	@RequestMapping("/selectReceiptYN")
	public @ResponseBody int selectReceiptYN(@RequestParam String exam_sn,HttpSession session) throws Exception {
		ExamMasterVO beforeMasterVO = new ExamMasterVO();		
		beforeMasterVO = masterService.selectView(exam_sn);
		
		//VO안에 VO값을 호출시 NULLPOINT 에러 발생으로 인해 생성한 VO를 세팅.
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		ExamMasterVO masterVO = new ExamMasterVO();
		ExamApplicantVO examApplicantVO =  new ExamApplicantVO();
		
		masterVO.setExamde(beforeMasterVO.getExamde());
		examApplicantVO.setMber_id(memberVO.getMber_id());
		masterVO.setExamApplicantVO(examApplicantVO); 
		//masterVO.getExamApplicantVO().setMber_id(memberVO.getMber_id());
		int reCeiptYN=masterService.selectReceiptYN(masterVO);
		
		return reCeiptYN;
	}
	
	
	@RequestMapping(value="/receiptForm", method=RequestMethod.GET)
	public String examForm(Model model,ExamMasterVO masterVO, HttpServletRequest request,HttpSession session) throws Exception{ 
		//ExamMasterVO masterVO = new ExamMasterVO();
		//생성자 생성
		
		
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		ExamApplicantVO examApplicantVO = new ExamApplicantVO();
		
	
		masterVO = masterService.selectView(masterVO.getExam_sn());
		
		
		//시험장 코드 조회
		ComnCodeVO codeVO = new ComnCodeVO();
		codeVO.setGrp_cd("GR001");
		codeVO.setP_cd("R01");
		codeVO.setLvl(2L);
		List<ComnCodeVO> codeList = comnCodeService.selectList(codeVO);
		
		//접수시험 정보 조회
		System.out.println(codeList.toString());
		
		
		
		//접수자 정보 조회
		examApplicantVO.setMber_id(memberVO.getMber_id());
		examApplicantVO.setExam_sn(masterVO.getExam_sn());
		
		
		ExamApplicantVO examApplicantVO2 = new ExamApplicantVO();
		examApplicantVO2 = applicantService.selectView(examApplicantVO);
		
		//첨부파일
		ExamApplicantAttachVO attachVO = new ExamApplicantAttachVO();
		
		// 수정일 경우. //
		if(examApplicantVO2!=null) {
			examApplicantVO=examApplicantVO2;
			String[] item = examApplicantVO.getBirth().split("-");
			examApplicantVO.setYear(item[0]);
			examApplicantVO.setMonth(item[1]);
			examApplicantVO.setDate(item[2]);
			//model.addAttribute("yyyy",item[0]);
			//model.addAttribute("month",item[1]);
			//model.addAttribute("date",item[2]);
			//String yyyy= examApplicantVO.getBirth().split("-", limit)
			
			attachVO = attachService.getOneFile(examApplicantVO.getApc_sn());
			
		}
		
		
		model.addAttribute("examSn",masterVO.getExam_sn());
		model.addAttribute("codeList",codeList);
		model.addAttribute("masterVO",masterVO);
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("examApplicantVO",examApplicantVO);
		
		model.addAttribute("attachVO",attachVO);

		return "/exam/receiptForm";
	}
	
	@RequestMapping(value="/receiptForm", method=RequestMethod.POST)
	public String examFormProcess(RedirectAttributes rttr,ExamApplicantVO applicantVO, MultipartHttpServletRequest request,HttpSession session) throws Exception{ 

		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		ExamMasterVO masterVO = new ExamMasterVO();
		masterVO.setExam_sn(applicantVO.getExam_sn());
		System.out.println(memberVO.toString());
		System.out.println(applicantVO.toString());
		
		ExamApplicantVO applicantVO2 = new ExamApplicantVO();
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String date = request.getParameter("date");

		applicantVO.setMber_id(memberVO.getMber_id());
		applicantVO.setBirth(year+"-"+month+"-"+date);
		
		//글이 존재하는지 확인.
		applicantVO2=applicantService.selectView(applicantVO);
		
		//본인이 등록한 글이 없다면 접수번호 생성.
		if(applicantVO2==null) {
			String maxKey = applicantService.selectMaxSn(applicantVO.getExam_sn());			
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
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+commonService.selectRcpNo(1));
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_0001");
			}
			getRcpNo=commonService.selectRcpNo(rcpNo);
			applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+getRcpNo);

		}
		
		Iterator<String> itr = request.getFileNames(); 
		
		//request.getFileNames() 파일이 없어도 파일을 불러옴... 
		ExamApplicantAttachVO attachVO = new ExamApplicantAttachVO();
		
		String photoYN = request.getParameter("photoYN");
		if(photoYN!=null && !"N".equals(photoYN)) {
			while(itr.hasNext()) {
				if(itr.hasNext()) { 
					MultipartFile mpf = request.getFile(itr.next()); 
					System.out.println(mpf.getOriginalFilename() +" uploaded!"); 
				
				try { 
					
					attachVO =UploadFileUtils.uploadApplicantFile(uploadPath, mpf.getOriginalFilename(), mpf.getBytes() );
					attachVO.setApc_sn(applicantVO.getApc_sn());
					attachVO.setOrgfilename(mpf.getOriginalFilename());
					attachService.renewApplicant(attachVO);
			
				}catch (IOException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
				} 
				}else {
					System.out.println("데이터없음...");
				}
				
			}
		}
		
		
		System.out.println(applicantVO.toString());
		//MERGE INTO 형식. APC_SN이 존재하면 UPDATE, 없으면 INSERT
		applicantService.renewApplicant(applicantVO);
		
		//리다이렉트 형태로 데이터를 전송시  RedirectAttributes의 addAttribute 형태로 보내야 하며 받는 쪽에서는 @RequestParam를 선언해 줘야 함.
		rttr.addAttribute("exam_sn", masterVO.getExam_sn());
		return "redirect:/exam/receiptView";
		
		//사진등록 관련 로직 필요.
		
		
		
	}
	//view 화면 전 현재 접수한 시험 목록 셀렉트박스로 선택
	@RequestMapping(value="/viewIntro", method=RequestMethod.GET)
	public String examViewIntro(Model model, HttpServletRequest request,HttpSession session) throws Exception{ 
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		List<ExamMasterVO> list = masterService.receiptMasterInfo(memberVO.getMber_id());
		model.addAttribute("list", list);
		model.addAttribute("memberVO", memberVO);
		return "/exam/viewIntro";
	}
	
	//뷰화면 표출
	@RequestMapping(value="/receiptView", method=RequestMethod.GET)
	public String receiptView(Model model,ExamMasterVO masterVO,@RequestParam String exam_sn, HttpServletRequest request,HttpSession session) throws Exception{ 
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		ExamApplicantVO examApplicantVO = new ExamApplicantVO();
		
		System.out.println("exam_sn :"+exam_sn);
		System.out.println(masterVO.toString());
		
		if (exam_sn!=null && !"".equals(exam_sn)) {
			masterVO.setExam_sn(exam_sn);
		}
		//List<ComnCodeVO> codeList = comnCodeService.selectList(codeVO);
		
		//접수자 정보 조회
		examApplicantVO.setMber_id(memberVO.getMber_id());
		examApplicantVO.setExam_sn(masterVO.getExam_sn());
		examApplicantVO = applicantService.selectView(examApplicantVO);
		
		//필요한거.
		//시험장관련(code)
		//첨부파일(attach)
		//마스터테이블 정보(master)
		
		ComnCodeVO codeVO = comnCodeService.selectView(examApplicantVO.getExam_place_code());
		masterVO = masterService.selectView(examApplicantVO.getExam_sn());
		ExamApplicantAttachVO attachVO = attachService.getOneFile(examApplicantVO.getApc_sn());
		
		model.addAttribute("examSn",masterVO.getExam_sn());
		model.addAttribute("codeVO",codeVO);
		model.addAttribute("masterVO",masterVO);
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("attachVO",attachVO);
		model.addAttribute("examApplicantVO",examApplicantVO);
		
		return "/exam/receiptView";
	}
	
	
	
	
	/*
	 * 합격자 발표
	 * 20190328
	 */
	
		//view 화면 전 현재 접수한 시험 목록 셀렉트박스로 선택
		@RequestMapping(value="/passList", method=RequestMethod.GET)
		public String examPassList(Model model, HttpServletRequest request,HttpSession session) throws Exception{ 
			List<ExamMasterVO> list = masterService.getPassList();
			model.addAttribute("list", list);
			return "/exam/passList";
		}
		@RequestMapping(value="/passView", method=RequestMethod.POST)
		public String examPassView(ExamApplicantVO appVO,Model model, HttpServletRequest request,HttpSession session) throws Exception{ 
			//exam_sn, mber_id
			MemberVO memberVO = (MemberVO)session.getAttribute("login");
			String exam_sn = request.getParameter("exam_sn");
			
			appVO.setMber_id(memberVO.getMber_id());
			
			ExamMasterVO masterVO = masterService.getPassView(appVO);
			System.out.println("masterVO dasf : "+masterVO.getMber_id());
			model.addAttribute("masterVO",masterVO);
			model.addAttribute("memberVO", memberVO);
			return "/exam/passView";
		}
	
	
	
	
}
