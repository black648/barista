package org.zerock.web;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.CalendarDetailVO;
import org.zerock.domain.CalendarVO;
import org.zerock.service.CalendarService;
import org.zerock.service.CommonService;
import org.zerock.service.ComnCodeService;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/barista/*")
public class BaristaController {
	

	@Inject MemberService memberService;
	@Inject ComnCodeService comnCodeService;
	@Inject CommonService commonService;
	
	@Inject CalendarService calendarService;
	@Resource(name="uploadPath")
	private String uploadPath;

	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public void intro(Model model,CalendarVO calendarVO,HttpSession session, HttpServletRequest request) throws Exception {
		
		
	}
	
	@RequestMapping(value="/schedule/list", method=RequestMethod.GET)
	public String calList(Model model,CalendarVO calendarVO,HttpSession session, HttpServletRequest request) throws Exception {
		
		CalendarVO sysDt = new CalendarVO();
		
		String cal_yyyy=calendarVO.getCal_yyyy();
		String cal_mm=calendarVO.getCal_mm();
		
		if(calendarVO.getCal_yyyy()==null || "".equals(calendarVO.getCal_yyyy())) {
			sysDt=calendarService.getSysDt();
			cal_yyyy=sysDt.getCal_yyyy();
			cal_mm=sysDt.getCal_mm();
		}
		//년,월 리스트
		List<String> getYYYYList = calendarService.getYYYYList();
		
		//캘린더 리스트
		List<CalendarVO> getCalList = calendarService.getCalList(calendarVO);
		
	/*	리스트 in 리스트 테스트. 20190712
	 * 
	 * for(CalendarVO list1: getCalList) 
		{
			System.out.println("list1.getCalendarDetailVO() : " + list1.getCalendarDetailVO().size());
			if(list1.getCalendarDetailVO().size()>0) {
				for(CalendarDetailVO list2 : list1.getCalendarDetailVO()) {
					System.out.println("date : " + list2.getSpec_date());
					System.out.println("memo : " + list2.getMemo());
					
				}
			}
		}
		*/
		model.addAttribute("getCalList",getCalList);
		model.addAttribute("getYYYYList",getYYYYList);
		
		
		model.addAttribute("cal_yyyy", cal_yyyy);
		model.addAttribute("cal_mm", cal_mm);
		
		return "/barista/schedule/list";
	}
	
	@RequestMapping(value="/schedule/view", method=RequestMethod.GET)
	public String scheduleView(Model model,CalendarDetailVO calendarDetailVO,HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("calendarDetailVO.getSpec_date() :" +calendarDetailVO.getSpec_date());
		
		CalendarVO sysDt = new CalendarVO();
		
		String cal_yyyy=request.getParameter("cal_yyyy");
		String cal_mm=request.getParameter("cal_mm");
		
		if(cal_yyyy==null || "".equals(cal_mm)) {
			sysDt=calendarService.getSysDt();
			cal_yyyy=sysDt.getCal_yyyy();
			cal_mm=sysDt.getCal_mm();
		}
		//년,월 리스트
		List<String> getYYYYList = calendarService.getYYYYList();
		model.addAttribute("getYYYYList", getYYYYList);
		model.addAttribute("cal_yyyy", cal_yyyy);
		model.addAttribute("cal_mm", cal_mm);
		
		List<CalendarDetailVO> list = calendarService.getCalDetailList(calendarDetailVO.getSpec_date());
		
		model.addAttribute("list", list);
		model.addAttribute("spec_date",calendarDetailVO.getSpec_date());
		return "/barista/schedule/view";
	}
	
	
}
