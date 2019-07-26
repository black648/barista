package org.zerock.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.zerock.dao.CalendarDAO;
import org.zerock.domain.CalendarDetailVO;
import org.zerock.domain.CalendarVO;

@Service
public class CalendarServiceImpl implements CalendarService{
	@Inject
	private CalendarDAO calendarDAO;
	
	@Override
	public List<String> getYYYYList () throws Exception {
		return calendarDAO.getYYYYList();
	}
	
	@Override
	public CalendarVO getSysDt() throws Exception {
		return calendarDAO.getSysDt();
	}
	
	@Override
	public List<CalendarVO> getCalList(CalendarVO calendarVO) throws Exception {
		
		List<CalendarVO> calList = calendarDAO.getCalList(calendarVO);
		List<CalendarVO> calResult = new ArrayList<CalendarVO>();
		List<CalendarDetailVO> detailResult = new ArrayList<CalendarDetailVO>();
		int i=0;
		for(CalendarVO list : calList) {
			CalendarVO calendarVO2 = new CalendarVO(); //VO세팅을 List안에서 처리해줘야함.(매번 엔트리를 새로 생성해줘야 함.) 밖에다 쓰면  마지막 데이터만 누적됨.
			calendarVO2.setCal_yyyy(list.getCal_yyyy());
			calendarVO2.setCal_yyyymmdd(list.getCal_yyyymmdd());
			calendarVO2.setCal_mm(list.getCal_mm());
			calendarVO2.setCal_dd(list.getCal_dd());
			calendarVO2.setCal_day(list.getCal_day());
			calendarVO2.setCal_day_num(list.getCal_day_num());
			calendarVO2.setCal_iw_weeks(list.getCal_iw_weeks());
			calendarVO2.setHoliday_yn(list.getHoliday_yn());
			calendarVO2.setText(list.getText());
			
			List<CalendarDetailVO> getCalDetailList = calendarDAO.getCalDetailList(list.getCal_yyyymmdd());
			calendarVO2.setCalendarDetailVO(getCalDetailList);
			

			/*for(CalendarDetailVO detailVO : getCalDetailList) {
				if(StringUtils.isNotEmpty(detailVO.getMemo())) {
					CalendarDetailVO calendarDetail = new CalendarDetailVO();
					calendarDetail.setMemo(detailVO.getMemo());
					calendarDetail.setSpec_date(detailVO.getSpec_date());
					//detailResult.add(calendarDetail); 
				}
					
					 
			}
				calendarVO2.setCalendarDetailVO(calendarDetail);
*/
			
			
			/* 
			 * 현재 건수만 나오고.. 데이터 표출이 안됨.... 하..... 20190710 18:20
			 * for(CalendarDetailVO detailVO : getCalDetailList) {
				 CalendarDetailVO calendarDetail = new CalendarDetailVO();
				 if(detailVO!=null) {
					 calendarDetail.setMemo(detailVO.getMemo());
					 calendarDetail.setSpec_date(detailVO.getSpec_date());
					 detailResult.add(calendarDetail); 
				 }
				 
			}
			calendarVO2.setCalendarDetailVO(detailResult);*/
			
			
			calResult.add(calendarVO2);
		}
/*
		for(CalendarVO list : calResult) {
			for(CalendarDetailVO dList : list.getCalendarDetailVO()) {
				if(dList.getMemo()!=null && !"".equals(dList.getMemo())) {
					System.out.println("dList :" + dList.getMemo());
				}
				
			}
			
		}
*/
		return calResult;
	}
	
	@Override
	public List<CalendarDetailVO> getCalDetailList(String spec_date)  {
		return calendarDAO.getCalDetailList(spec_date);
	}
	
}
