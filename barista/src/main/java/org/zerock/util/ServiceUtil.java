package org.zerock.util;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.zerock.domain.CalendarVO;
import org.zerock.service.CalendarService;

public class ServiceUtil {

	@Inject
	static CalendarService calendarService;
	
	
	public static void setSearchDate(CalendarVO calendarVO,Model model) throws Exception {
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
		
		model.addAttribute("getYYYYList",getYYYYList);
		model.addAttribute("cal_yyyy", cal_yyyy);
		model.addAttribute("cal_mm", cal_mm);
		
		
	}
	
}
