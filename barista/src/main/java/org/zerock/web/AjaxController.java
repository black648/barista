package org.zerock.web;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

@RestController
public class AjaxController {
	
	
	@Inject
	private MemberService service;
	/*
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public String idCheck(HttpServletRequest request, @PathVariable("mber_id") String mber_id)throws Exception {

		System.out.println("ajax");

		//MemberVO memberVO = service.readMember(request.getParameter("mber_id"));
		MemberVO memberVO = service.readMember(mber_id);
		
		
		if(memberVO !=null) {
			return "FALSE";
		}else {
			return "SUCCESS";
		}
		
		
	}
	*/
}
