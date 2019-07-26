package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class MemberDAOTest {

	@Inject
	private MemberDAO dao;
	
	@Test
	public void testTime() throws Exception {
		System.out.print(dao.getTime());
	}
	
	@Test
	public void testInsertMember() throws Exception {
		MemberVO vo = new MemberVO();
		vo.setMber_name("HKL");
		vo.setMber_id("black648");
		vo.setPassword("1111");
		vo.setMber_phone("010-0000-0000");
		vo.setAddress1("강원도 원주시 관설동");
		vo.setAddress2("1689-20");
		vo.setMber_se("KOR");
		vo.setEmail("black648@naver.com");
		
		dao.insertMember(vo);
	}
}
