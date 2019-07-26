package org.zerock.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardInstanceVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.service.BoardInstanceService;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("**/board/*")
public class BoardController {

	@Inject BoardService service;
	@Inject BoardInstanceService insService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	String url="";
	int idx;
	
	@RequestMapping(value="/*/list", method=RequestMethod.GET)
	public String list(Model model,HttpServletRequest request,BoardVO boardVO, @ModelAttribute("cri")SearchCriteria cri) throws Exception{
		
		
		logger.info(cri.toString());
		
		
		System.out.println("request.getContextPath() :"+request.getServletPath());
		System.out.println("request.getRemoteHost() :"+request.getRequestURL());
		
		
		String[] pathArr = request.getServletPath().split("/");
		url = pathArr[3]; 
	
		BoardInstanceVO boardInsVO = insService.getOneInstance(url);
		
		cri.setInstance_id(boardInsVO.getInstance_id());

		// idx = request.getRequestURL().indexOf("/");
		// url = request.getRequestURL().substring(idx+4);
		 
		 
		 
		 
		 System.out.println("url :"+url);
		model.addAttribute("list",service.selectList(cri));
		
		System.out.println("검색완료.///");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		pageMaker.setTotalCount(service.countList(cri));
		model.addAttribute("pageMaker",pageMaker);
	
		return "/board/"+url+"/list";
	}
	
	@RequestMapping(value="/*/view", method=RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("id") int id, @ModelAttribute("cri") Criteria cri) throws Exception {
		//HttpServletResponse 을 사용하면 void 형태로 자동리턴이 안됨....
		
		//저장된 쿠키 불러오기
		Cookie cookies[] = request.getCookies();
		Map mapCookie = new HashMap();
		if(request.getCookies()!=null) {
			for(int i=0; i<cookies.length; i++) {
			Cookie obj = cookies[i];
			mapCookie.put(obj.getName(), obj.getValue());
			}
		}
		
		//저장된 쿠키중에 read_cnt만 불러오기
		String cookie_read_cnt=(String)mapCookie.get("read_cnt");
		
		//저장될 새로운 쿠키값 생성
		String new_cookie_read_cnt="|"+id;
		
		//저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사
		if(StringUtils.indexOfIgnoreCase(cookie_read_cnt,new_cookie_read_cnt)==-1) {
			//없을 경우 쿠키 생성
			Cookie cookie = new Cookie("read_cnt",cookie_read_cnt+new_cookie_read_cnt);
			response.addCookie(cookie);
			
			service.countUpdate(id);
		}
		System.out.println("view123");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// url 중 notice 부분만 출력하기 위해 split 사용
		String[] pathArr = request.getServletPath().split("/");
		url = pathArr[3]; 
		
		
		model.addAttribute("boardVO", service.selectView(id));
		model.addAttribute("pageMaker",pageMaker);
		
		return "/board/"+url+"/view";
		
	}
}
