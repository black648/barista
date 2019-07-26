package org.zerock.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.CalendarDetailVO;
import org.zerock.domain.CalendarVO;

@Repository
public class CalendarDAOImpl implements CalendarDAO {
	

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.calendarMapper";

	
	@Override
	public List<String> getYYYYList() throws Exception {
	 return sqlSession.selectList(namespace+".getYYYYList");
	}
	
	@Override
	public CalendarVO getSysDt() throws Exception {
		return sqlSession.selectOne(namespace+".getSysDt");
	}
	
	
	@Override
	public List<CalendarVO> getCalList(CalendarVO calendarVO) throws Exception {
		return sqlSession.selectList(namespace+".getCalList",calendarVO);
	}
	
	@Override
	public List<CalendarDetailVO> getCalDetailList(String spec_date) {
		return sqlSession.selectList(namespace+".getCalDetailList",spec_date);
	}

}
