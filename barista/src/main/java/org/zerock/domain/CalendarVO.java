package org.zerock.domain;

import java.util.List;

public class CalendarVO {
	private String cal_yyyymmdd;
	private String cal_yyyy;
	private String cal_mm;
	private String cal_dd;
	private String cal_iw_weeks;
	private int cal_weeks;
	private String cal_day;
	private int cal_day_num;
	private String holiday_yn;
	private String text;
	
	
	private List<CalendarDetailVO> calendarDetailVO;
	
	public String getCal_yyyymmdd() {
		return cal_yyyymmdd;
	}
	public void setCal_yyyymmdd(String cal_yyyymmdd) {
		this.cal_yyyymmdd = cal_yyyymmdd;
	}
	public String getCal_yyyy() {
		return cal_yyyy;
	}
	public void setCal_yyyy(String cal_yyyy) {
		this.cal_yyyy = cal_yyyy;
	}
	public String getCal_mm() {
		return cal_mm;
	}
	public void setCal_mm(String cal_mm) {
		this.cal_mm = cal_mm;
	}
	public String getCal_dd() {
		return cal_dd;
	}
	public void setCal_dd(String cal_dd) {
		this.cal_dd = cal_dd;
	}
	public String getCal_iw_weeks() {
		return cal_iw_weeks;
	}
	public void setCal_iw_weeks(String cal_iw_weeks) {
		this.cal_iw_weeks = cal_iw_weeks;
	}
	public int getCal_weeks() {
		return cal_weeks;
	}
	public void setCal_weeks(int cal_weeks) {
		this.cal_weeks = cal_weeks;
	}
	public String getCal_day() {
		return cal_day;
	}
	public void setCal_day(String cal_day) {
		this.cal_day = cal_day;
	}
	public int getCal_day_num() {
		return cal_day_num;
	}
	public void setCal_day_num(int cal_day_num) {
		this.cal_day_num = cal_day_num;
	}
	public String getHoliday_yn() {
		return holiday_yn;
	}
	public void setHoliday_yn(String holiday_yn) {
		this.holiday_yn = holiday_yn;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<CalendarDetailVO> getCalendarDetailVO() {
		return calendarDetailVO;
	}
	public void setCalendarDetailVO(List<CalendarDetailVO> calendarDetailVO) {
		this.calendarDetailVO = calendarDetailVO;
	}
	@Override
	public String toString() {
		return "CalendarVO [cal_yyyymmdd=" + cal_yyyymmdd + ", cal_yyyy=" + cal_yyyy + ", cal_mm=" + cal_mm
				+ ", cal_dd=" + cal_dd + ", cal_iw_weeks=" + cal_iw_weeks + ", cal_weeks=" + cal_weeks + ", cal_day="
				+ cal_day + ", cal_day_num=" + cal_day_num + ", holiday_yn=" + holiday_yn + ", text=" + text + "]";
	}

	
	
	
	
}
