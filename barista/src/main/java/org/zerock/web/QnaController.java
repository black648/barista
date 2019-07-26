package org.zerock.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.domain.AttachVO;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.QnaVO;
import org.zerock.domain.SearchCriteria;
import org.zerock.dto.LoginDTO;
import org.zerock.service.AttachService;
import org.zerock.service.MemberService;
import org.zerock.service.QnaService;
import org.zerock.util.UploadFileUtils;

import com.sun.xml.internal.ws.util.StringUtils;

@Controller
@RequestMapping("**/qna/*")
public class QnaController {

	@Inject QnaService service;
	@Inject MemberService memberService;
	@Inject AttachService attachService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model,QnaVO qnaVO, @ModelAttribute("cri")SearchCriteria cri) throws Exception {
		
			
		
			List<QnaVO> list = service.selectList(cri);
			System.out.println(qnaVO.toString());
			
			
			model.addAttribute("list",list);
			//model.addAttribute("list",service.selectList(cri));
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			//pageMaker.setTotalCount(131);
			pageMaker.setTotalCount(service.countList(cri));
			model.addAttribute("pageMaker",pageMaker);
		
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public void view(Model model, QnaVO qnaVO, @RequestParam("sn") int sn,  @ModelAttribute("cri")SearchCriteria cri) throws Exception {
		//qnaVO = service.selectView(sn);
		
		//List<QnaAttachVO> list = service.selectAttach(sn);
		AttachVO attVO = new AttachVO();
		attVO.setDivision("qna");
		attVO.setGrpno(sn);
		List<AttachVO> list =  attachService.getFileList(attVO);
		
		model.addAttribute("qnaVO",service.selectView(sn));
		model.addAttribute("list",list);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		model.addAttribute("pageMaker",pageMaker);
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET) 
	public void form (LoginDTO dto,Model model, HttpSession session) throws Exception {
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		memberVO = memberService.readMember(memberVO.getMber_id());
		//int sn = service.getSeqNo();
		//System.out.println("sn :"+sn);
		//model.addAttribute("sn",sn);
		model.addAttribute("memberVO",memberVO);
		
	}
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String form(MultipartHttpServletRequest request, Model model, QnaVO qnaVO) throws Exception {
		
		int i=0;
		Iterator<String> itr = request.getFileNames(); 
		System.out.println(request.getFileNames());
		String division = request.getParameter("division");
		String str_seq;
		int savedFileNm ;
		
		qnaVO.setSn(service.getSeqNo());
		AttachVO attachVO = new AttachVO();
		
		
		while(itr.hasNext()) {
		
		MultipartFile mpf = request.getFile(itr.next()); 
		if(mpf.getOriginalFilename()!=null && !"".equals(mpf.getOriginalFilename())) { 
			System.out.println(mpf.getOriginalFilename() +" uploaded!"); 
			i=i+1;
			System.out.println("asdfasddfasd : "+i);
		try { 

			attachVO.setDivision(division);
			AttachVO fileOne =null;
			
			attachVO =UploadFileUtils.uploadFile2(uploadPath, mpf.getOriginalFilename(), mpf.getBytes() );
			attachVO.setGrpno(qnaVO.getSn());
			attachVO.setDivision(division);
			attachVO.setOrgfilename(mpf.getOriginalFilename());
			attachVO.setState("Y");
			attachVO.setUpd_id("");
			logger.debug(attachVO.toString());
			attachService.insertAttach(attachVO);
	
		}catch (IOException e) {
			System.out.println(e.getMessage()); 
			e.printStackTrace(); 
		} 
		}else {
			System.out.println("데이터없음...");
		}
		
		}
	//	String filePath=UploadFileUtils.calcPath(uploadPath);
		System.out.println("qnaform...post!!!");
		System.out.println(qnaVO.toString());
	//	System.out.println("file : "+file);
	//	System.out.println("filename"+file.getName());
	//	System.out.println("fileOname"+file.getOriginalFilename());
	//	System.out.println("getBytes"+file.getBytes());
		
	
		
		//파일 경로에 / 를 제거하기 위해 아래와 같이 문자열을 자름.
		//int idx = filePath.indexOf(File.separator);
		//qnaVO.setPath(filePath.substring(idx+1));
		
		
		service.insertQna(qnaVO);
		String message = "글이 등록되었습니다.";
		model.addAttribute("message",message);
		return "redirect:/news/qna/list";
	}
	
}
