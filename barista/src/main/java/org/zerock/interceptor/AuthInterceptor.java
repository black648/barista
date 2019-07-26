package org.zerock.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Inject
	private MemberService service;
	
	
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
				if(query==null || query.equals("null")) {
			query="";
		}else {
			query="?"+query;
		}
		System.out.println("dest1:"+(uri+query));
		if(req.getMethod().equals("GET")) {
			logger.info("dest:"+(uri+query));
			System.out.println("dest:"+(uri+query));
			req.getSession().setAttribute("dest", uri+query);
		}
	}
	
	//preHandle()을 이용하여 현재 사용자가 로그인 상태인지를 체크하고, 컨트롤러를 호출하게 할것인지를 결정함. 만일 사용자가
	//로그인하지 않은 상태라면 로그인하는'/member/login'으로 이동하게 함.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login")==null) {
			logger.info("current user is not logined");
			saveDest(request);
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie !=null) {
				MemberVO memberVO = service.checkLoginBefore(loginCookie.getValue());
				logger.info("MEMBERVO : " + memberVO);
				if(memberVO != null) {
					session.setAttribute("login", memberVO);
					return false;
				}
			}
			response.sendRedirect("/member/login");
			return false;
		}
		return true;
	}

}
