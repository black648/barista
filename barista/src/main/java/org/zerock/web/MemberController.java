package org.zerock.web;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.EmailKeyVO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.EmailKeyService;
import org.zerock.service.MemberService;
import org.zerock.service.MessageService;
import org.zerock.util.CommonUtil;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	

	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	String message = "";


	private static final String String = null;
	
	CommonUtil util=new CommonUtil();
	
	@Inject
	private MemberService service;
	@Inject
	private MessageService messageService;
	@Inject
	private EmailKeyService emailKeyService;
	
	@Autowired
	private JavaMailSender mailSender; // xml에 등록한 bean autowired
	
	@RequestMapping(value="/mberAgree", method=RequestMethod.GET)
	public void mberAgree(Model model) throws Exception {
		//String id= request.getSession(id);
		//String id="";
		//model.addAttribute("list",service.readMember(id));	
		
	}
	
	@RequestMapping(value="/mberForm", method=RequestMethod.GET)
	public void memberForm(Model model) throws Exception {
		//String id= request.getSession(id);
		//String id="";
		//model.addAttribute("list",service.readMember(id));	
		
	}
	@RequestMapping(value="/mberFormPost", method=RequestMethod.POST)
	public String memberProc(RedirectAttributes rttr,MemberVO memberVO, HttpServletRequest request) throws Exception {
		//String id= request.getSession(id);
		//String id="";
		//model.addAttribute("list",service.readMember(id));	
		
		memberVO.setMber_phone(request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3"));
		memberVO.setMber_se("KOR");
		
		EmailKeyVO emailKeyVO = new EmailKeyVO();
		emailKeyVO.setConfirm_yn("Y");
		emailKeyVO.setEmail(memberVO.getEmail());
		emailKeyVO.setMber_id(memberVO.getMber_id());
		
		System.out.println("phone"+ memberVO.getMber_phone());
		
		service.insertMember(memberVO);
		emailKeyService.updateEmail(emailKeyVO);
		
		rttr.addFlashAttribute("result","success");
		//return "redirect:/main/main";
		return "/member/mberComplete";
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPost(LoginDTO dto, HttpSession session, Model model, HttpServletRequest request) throws Exception {
		MemberVO memberVO = service.readWithPW(dto);
		
		if(memberVO==null) {
			
			System.out.println("1111111111111111111");
			
			return;
		}
		System.out.println("dto.isUseCookie() :"+dto.isUseCookie());
		System.out.println("dto.id() :"+dto.getMber_id());
		System.out.println("dto.pass() :"+dto.getPassword());
		System.out.println("useCookie :"+request.getParameter("useCookie"));
	
		model.addAttribute("memberVO",memberVO);
		
		if(dto.isUseCookie()) {
			
			System.out.println("유즈쿠키!!!");
			int amount=60*60*24*7;
			Date sessionLimit=new Date(System.currentTimeMillis()+(1000*amount));
			service.keepLogin(memberVO.getMber_id(), session.getId(), sessionLimit);
		}
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		Object obj = session.getAttribute("login");
		
		if(obj!=null) {
			MemberVO memberVO = (MemberVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie!=null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(memberVO.getMber_id(), session.getId(), new Date());
			}
		}
		return "member/logout";
	}
	
	//내정보
	@RequestMapping("/mypage")
	public void mypage(Model model, HttpSession session) throws Exception {
		
		//String id= (String)session.getAttribute("login");
		
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		
		System.out.println("id : " + memberVO.getMber_id());
		memberVO = service.readMember(memberVO.getMber_id());
		System.out.println("memberVO : " + memberVO);
		model.addAttribute("memberVO",memberVO);
	}
	
	// 회원정보 수정 GET
	@RequestMapping(value="/modifyDefault", method=RequestMethod.GET)
	public void modify(Model model, HttpSession session) throws Exception {
		
		MemberVO memberVO = (MemberVO)session.getAttribute("login");
		memberVO = service.readMember(memberVO.getMber_id());
		
		memberVO.setTel1(memberVO.getMber_phone().substring(0,3));
		memberVO.setTel2(memberVO.getMber_phone().substring(4,8));
		memberVO.setTel3(memberVO.getMber_phone().substring(9,13));
		System.out.println("tel1 : " +memberVO.getTel1());
		System.out.println("tel2 : " +memberVO.getTel2());
		System.out.println("tel3 : " +memberVO.getTel3());
		model.addAttribute("memberVO",memberVO);
	}
	
	// 회원정보 수정 POST
	@RequestMapping(value="/modifyDefault", method=RequestMethod.POST)
	public String modifyPost(MemberVO memberVO, Model model, HttpSession session)  throws Exception{
		memberVO.setMber_phone(memberVO.getTel1()+"-"+memberVO.getTel2()+"-"+memberVO.getTel3());
		service.updateMember(memberVO);
		memberVO = (MemberVO)session.getAttribute("login");
		System.out.println("id : " + memberVO.getMber_id());
		memberVO = service.readMember(memberVO.getMber_id());
		
		model.addAttribute("memberVO",memberVO);
		return "/member/mypage";
	}
	
	@RequestMapping(value="/modifyPw", method=RequestMethod.GET)
	public void modifyPw(MemberVO memberVO, Model model, HttpSession session) {
		memberVO = (MemberVO)session.getAttribute("login");
		model.addAttribute("memberVO",memberVO);
	}
	
	@RequestMapping(value="/modifyPw", method=RequestMethod.POST)
	public String modifyPwPost(MemberVO memberVO, Model model, HttpSession session) throws Exception{
		service.updatePw(memberVO);
		
		memberVO = (MemberVO)session.getAttribute("login");
		System.out.println("id : " + memberVO.getMber_id());
		memberVO = service.readMember(memberVO.getMber_id());
		
		model.addAttribute("memberVO",memberVO);
		
		return "/member/mypage";
		
	}
	
	@RequestMapping(value="/idFind", method=RequestMethod.GET) 
	public void idFind () {
	}
	
	@RequestMapping(value="/idFind", method=RequestMethod.POST) 
	public String idFindPost (MemberVO memberVO, HttpServletResponse response, Model model) throws Exception {
	    
		
		
		memberVO.setMber_phone(memberVO.getTel1()+"-"+memberVO.getTel2()+"-"+memberVO.getTel3());
	    
	    System.out.println("phone:"+ memberVO.getMber_phone());
	    model.addAttribute("mberName", memberVO.getMber_name());
	    model.addAttribute("memberVO",memberVO);
		List<MemberVO> memberVO2 = service.idFind(memberVO);
		
		System.out.println(memberVO2);
		
		if(memberVO2 == null) {
			System.out.println("111111111111111111");
			
			message="회원정보가 틀립니다.";
			model.addAttribute("message",message);
			return "/member/idFind";
		}
		
		model.addAttribute("memberVO2",memberVO2);
		return "/member/login";
	}
	
	@RequestMapping(value="/pwFind", method=RequestMethod.GET) 
	public void pwFind () {
	}
	
	@RequestMapping(value="/pwFind", method=RequestMethod.POST) 
	public String pwFindPost (MemberVO memberVO, HttpServletResponse response, Model model) throws Exception {
	    
		
		memberVO.setMber_phone(memberVO.getTel1()+"-"+memberVO.getTel2()+"-"+memberVO.getTel3());
	    
	    System.out.println("phone:"+ memberVO.getMber_phone());
	    
	    
		memberVO = service.pwFind(memberVO);
		
		System.out.println(memberVO);
		
		if(memberVO == null) {
			System.out.println("111111111111111111");
			
			message="회원정보가 틀립니다.";
			model.addAttribute("message",message);
			return "/member/pwFind";
		}
		
		memberVO.setPassword(util.randomPassword(8));
		service.updatePw(memberVO);
		
		
		System.out.println("memberVO.getEmail() : " + memberVO.getEmail());
		
		messageService.sendMail("barista@naver.com", memberVO.getEmail(),  "바리스타 메일 발송 안내 <임시비밀번호 발급>", memberVO.getMber_id()+"님의 비밀번호는 "+memberVO.getPassword()+" 입니다.");
		message="가입하신 이메일"+memberVO.getEmail()+"로 임시비밀번호가 발송되었습니다.";
		
		model.addAttribute("memberVO",memberVO);
		model.addAttribute("message",message);
		return "/member/login";
	}
	
	
	// 아이디 중복체크
	@RequestMapping("/idCheck")
	public @ResponseBody MemberVO idCheck(@RequestParam String mber_id) throws Exception {
		System.out.println("ajax에서 넘어온 값 : " + mber_id);
		MemberVO memberVO = service.readMember(mber_id);
		System.out.println("DB 값 : " + memberVO);
		return memberVO;
	}
	@RequestMapping("/emailCheck")
	public @ResponseBody Map <String,Object> emailCheck(@RequestParam String email) throws Exception {
		Map<String, Object> map = new LinkedHashMap<String,Object>();
		System.out.println("ajax에서 넘어온 값 : " + email);
		EmailKeyVO emailKeyVO = emailKeyService.readEmail(email);
		EmailKeyVO emailKeyVO2 = new EmailKeyVO();
		System.out.println("DB 값 : " + email);
		String rst = "N";
		if(emailKeyVO==null) {
			emailKeyVO2.setEmail(email);
			emailKeyVO2.setKey(util.randomPassword(8));
			emailKeyService.insertEmail(emailKeyVO2);
			messageService.sendMail("barista@naver.com", email,  "바리스타 메일 발송 안내 <이메일 인증번호 발급안내>", "인증키 "+emailKeyVO2.getKey()+" 값을 입력 하시기 바랍니다.");
			message="이메일"+email+"로 인증번호가 발송되었습니다.";
			rst = "Y";
		}else if(!"Y".equals(emailKeyVO.getConfirm_yn())) {
			emailKeyVO2.setEmail(email);
			emailKeyVO2.setKey(util.randomPassword(8));
			emailKeyService.updateEmail(emailKeyVO2);
			messageService.sendMail("barista@naver.com", email,  "바리스타 메일 발송 안내 <이메일 인증번호 발급안내>", "인증키 "+emailKeyVO2.getKey()+" 값을 입력 하시기 바랍니다.");
			message="이메일"+email+"로 인증번호가 발송되었습니다.";
			rst = "Y";
		}
		map.put("emailKeyVO2",emailKeyVO2);
		map.put("rst",rst);
		//map.put("message",message);
		return map;
	}
	
	
	
}
