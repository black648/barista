package org.zerock.service;

import java.util.List;

import org.zerock.domain.CalendarDetailVO;
import org.zerock.domain.CalendarVO;

public interface CalendarService {
	
	List<String> getYYYYList() throws Exception;

	CalendarVO getSysDt() throws Exception;
	
	List<CalendarVO> getCalList(CalendarVO calendarVO) throws Exception;
	
	List<CalendarDetailVO> getCalDetailList(String spec_date) ;
}
