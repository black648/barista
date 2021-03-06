package org.zerock.dao;

import java.util.List;

import org.zerock.domain.CalendarDetailVO;
import org.zerock.domain.CalendarVO;

public interface CalendarDAO {
	public List<String> getYYYYList() throws Exception;

	public CalendarVO getSysDt() throws Exception;
	
	public List<CalendarVO> getCalList(CalendarVO calendarVO) throws Exception;
	
	public List<CalendarDetailVO> getCalDetailList(String spec_date) ;
}
