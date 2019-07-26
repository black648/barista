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
	//���� üũ. ���� �������� ���� ������ �ߺ����� �����Ͽ��ٸ� �Ʒ��� ���� ������ �ȵ�.
	@RequestMapping("/selectReceiptYN")
	public @ResponseBody int selectReceiptYN(@RequestParam String exam_sn,HttpSession session) throws Exception {
		ExamMasterVO beforeMasterVO = new ExamMasterVO();		
		beforeMasterVO = masterService.selectView(exam_sn);
		
		//VO�ȿ� VO���� ȣ��� NULLPOINT ���� �߻����� ���� ������ VO�� ����.
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
		//������ ����
		
		
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		ExamApplicantVO examApplicantVO = new ExamApplicantVO();
		
	
		masterVO = masterService.selectView(masterVO.getExam_sn());
		
		
		//������ �ڵ� ��ȸ
		ComnCodeVO codeVO = new ComnCodeVO();
		codeVO.setGrp_cd("GR001");
		codeVO.setP_cd("R01");
		codeVO.setLvl(2L);
		List<ComnCodeVO> codeList = comnCodeService.selectList(codeVO);
		
		//�������� ���� ��ȸ
		System.out.println(codeList.toString());
		
		
		
		//������ ���� ��ȸ
		examApplicantVO.setMber_id(memberVO.getMber_id());
		examApplicantVO.setExam_sn(masterVO.getExam_sn());
		
		
		ExamApplicantVO examApplicantVO2 = new ExamApplicantVO();
		examApplicantVO2 = applicantService.selectView(examApplicantVO);
		
		//÷������
		ExamApplicantAttachVO attachVO = new ExamApplicantAttachVO();
		
		// ������ ���. //
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
		
		//���� �����ϴ��� Ȯ��.
		applicantVO2=applicantService.selectView(applicantVO);
		
		//������ ����� ���� ���ٸ� ������ȣ ����.
		if(applicantVO2==null) {
			String maxKey = applicantService.selectMaxSn(applicantVO.getExam_sn());			
			String getRcpNo ="";
			int rcpNo;
			if(maxKey!=null) { //1���̻��� �����ڰ� ���� ���.
				String[] cut=maxKey.split("\\_");
				String cutMaxKey=cut[1];		
				rcpNo = Integer.parseInt(cutMaxKey)+1;
				System.out.println("rcpNo : " + rcpNo);
				
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+CommonUtil.key4Change(cutMaxKey)); //��ȸ�Ͽ� ���޹��� �ƽ�Ű�� ���¿� �°� ����
			}else{ //����� �������� ������ ó���� ���
				rcpNo = 1;
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+commonService.selectRcpNo(1));
			//	applicantVO.setApc_sn(applicantVO.getExam_sn()+"_0001");
			}
			getRcpNo=commonService.selectRcpNo(rcpNo);
			applicantVO.setApc_sn(applicantVO.getExam_sn()+"_"+getRcpNo);

		}
		
		Iterator<String> itr = request.getFileNames(); 
		
		//request.getFileNames() ������ ��� ������ �ҷ���... 
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
					System.out.println("�����;���...");
				}
				
			}
		}
		
		
		System.out.println(applicantVO.toString());
		//MERGE INTO ����. APC_SN�� �����ϸ� UPDATE, ������ INSERT
		applicantService.renewApplicant(applicantVO);
		
		//�����̷�Ʈ ���·� �����͸� ���۽�  RedirectAttributes�� addAttribute ���·� ������ �ϸ� �޴� �ʿ����� @RequestParam�� ������ ��� ��.
		rttr.addAttribute("exam_sn", masterVO.getExam_sn());
		return "redirect:/exam/receiptView";
		
		//������� ���� ���� �ʿ�.
		
		
		
	}
	//view ȭ�� �� ���� ������ ���� ��� ����Ʈ�ڽ��� ����
	@RequestMapping(value="/viewIntro", method=RequestMethod.GET)
	public String examViewIntro(Model model, HttpServletRequest request,HttpSession session) throws Exception{ 
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		List<ExamMasterVO> list = masterService.receiptMasterInfo(memberVO.getMber_id());
		model.addAttribute("list", list);
		model.addAttribute("memberVO", memberVO);
		return "/exam/viewIntro";
	}
	
	//��ȭ�� ǥ��
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
		
		//������ ���� ��ȸ
		examApplicantVO.setMber_id(memberVO.getMber_id());
		examApplicantVO.setExam_sn(masterVO.getExam_sn());
		examApplicantVO = applicantService.selectView(examApplicantVO);
		
		//�ʿ��Ѱ�.
		//���������(code)
		//÷������(attach)
		//���������̺� ����(master)
		
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
	 * �հ��� ��ǥ
	 * 20190328
	 */
	
		//view ȭ�� �� ���� ������ ���� ��� ����Ʈ�ڽ��� ����
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
