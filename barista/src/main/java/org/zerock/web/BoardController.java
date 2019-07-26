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
		
		System.out.println("�˻��Ϸ�.///");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		//pageMaker.setTotalCount(131);
		pageMaker.setTotalCount(service.countList(cri));
		model.addAttribute("pageMaker",pageMaker);
	
		return "/board/"+url+"/list";
	}
	
	@RequestMapping(value="/*/view", method=RequestMethod.GET)
	public String view(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("id") int id, @ModelAttribute("cri") Criteria cri) throws Exception {
		//HttpServletResponse �� ����ϸ� void ���·� �ڵ������� �ȵ�....
		
		//����� ��Ű �ҷ�����
		Cookie cookies[] = request.getCookies();
		Map mapCookie = new HashMap();
		if(request.getCookies()!=null) {
			for(int i=0; i<cookies.length; i++) {
			Cookie obj = cookies[i];
			mapCookie.put(obj.getName(), obj.getValue());
			}
		}
		
		//����� ��Ű�߿� read_cnt�� �ҷ�����
		String cookie_read_cnt=(String)mapCookie.get("read_cnt");
		
		//����� ���ο� ��Ű�� ����
		String new_cookie_read_cnt="|"+id;
		
		//����� ��Ű�� ���ο� ��Ű���� �����ϴ� �� �˻�
		if(StringUtils.indexOfIgnoreCase(cookie_read_cnt,new_cookie_read_cnt)==-1) {
			//���� ��� ��Ű ����
			Cookie cookie = new Cookie("read_cnt",cookie_read_cnt+new_cookie_read_cnt);
			response.addCookie(cookie);
			
			service.countUpdate(id);
		}
		System.out.println("view123");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);

		// url �� notice �κи� ����ϱ� ���� split ���
		String[] pathArr = request.getServletPath().split("/");
		url = pathArr[3]; 
		
		
		model.addAttribute("boardVO", service.selectView(id));
		model.addAttribute("pageMaker",pageMaker);
		
		return "/board/"+url+"/view";
		
	}
}
