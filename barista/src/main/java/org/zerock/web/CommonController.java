package org.zerock.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.MenuInfoVO;
import org.zerock.service.CommonService;

@Controller
public class CommonController {

	@Inject CommonService commonService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@RequestMapping(value="/common/topMenu", method=RequestMethod.GET)
	public String topMenu(Model model,HttpServletRequest request,MenuInfoVO menuInfoVO) {
		List<MenuInfoVO> getMenuList = commonService.getMenuList(menuInfoVO);

		model.addAttribute("menuList",getMenuList);
		
		return "common/topMenu";
	}
}
