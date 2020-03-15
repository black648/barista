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
		
		//VO�ȿ� VO���� ȣ��� NULLPOINT ���� �߻����� ���� ������ VO�� ����.
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
		//÷������
		EduApplicantAttachVO attachVO = new EduApplicantAttachVO();
		
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("masterVO", eduMasterVO);
		model.addAttribute("applicantVO", eduApplicantVO);
	}
	
	@RequestMapping(value="/receiptForm", method=RequestMethod.POST)
	public String eduFormProcess(RedirectAttributes rttr, EduApplicantVO eduApplicantVO,MultipartHttpServletRequest request, HttpSession session) throws Exception{ 
		//20190809 ���� ���߿���
		
		String edu_sn = request.getParameter("edu_sn");
		
		System.out.println("reqest : " +request.getParameter("edu_sn"));
		//System.out.println("eduApplicantVO : " +eduApplicantVO.getEdu_sn()); //�Ķ���Ͱ� ������ ������ ����...
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		
		EduMasterVO eduMasterVO = new EduMasterVO();
		eduMasterVO.setEdu_sn(edu_sn);
		eduApplicantVO.setEdu_sn(edu_sn);
		eduApplicantVO.setMber_id(memberVO.getMber_id());
		
		EduApplicantVO applicantVO2 = new EduApplicantVO();
		//���� �����ϴ��� Ȯ��.
		applicantVO2=eduService.selectView(eduApplicantVO);
		
		
		//������ ����� ���� ���ٸ� ������ȣ ����.
		if(applicantVO2==null) {
			String maxKey = eduService.selectMaxSn(eduApplicantVO.getEdu_sn());			
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
			}
			getRcpNo=commonService.selectRcpNo(rcpNo);
			eduApplicantVO.setApc_sn(eduApplicantVO.getEdu_sn()+"_"+getRcpNo);

		}
		
		Iterator<String> itr = request.getFileNames(); 
		
		//request.getFileNames() ������ ��� ������ �ҷ���... 
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
					System.out.println("�����;���...");
				}
				
			}
		}
		
		
		System.out.println(eduApplicantVO.toString());
		//MERGE INTO ����. APC_SN�� �����ϸ� UPDATE, ������ INSERT
		eduService.renewApplicant(eduApplicantVO);
		
		//�����̷�Ʈ ���·� �����͸� ���۽�  RedirectAttributes�� addAttribute ���·� ������ �ϸ� �޴� �ʿ����� @RequestParam�� ������ ��� ��.
		rttr.addAttribute("edu_sn", eduMasterVO.getEdu_sn());
		return "redirect:/edu/receiptView";

	}
	
	//��ȭ�� ǥ��
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
			
			//������ ���� ��ȸ
			eduApplicantVO.setMber_id(memberVO.getMber_id());
			eduApplicantVO.setEdu_sn(masterVO.getEdu_sn());
			eduApplicantVO = eduService.selectView(eduApplicantVO);
			
			//�ʿ��Ѱ�.
			//���������(code)
			//÷������(attach)
			//���������̺� ����(master)
			
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
