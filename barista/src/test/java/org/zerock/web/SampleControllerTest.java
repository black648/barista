package org.zerock.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:/src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject
		private WebApplicationContext wac;
		private MockMvc mockMvc;
	
		@Before
		public void setup()	{
			//매번 테스트를 진행할 때마다 가상의 요청과 응답을 처리하기 위해서  setup() 메소드에서 mockMvc 객체를 만들어 냄.
			this.mockMvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
			logger.info("setup..................");
		}
		
		@Test
		public void testdoA()	throws Exception {
			//perform() 메소드는 get(),post() 등을 이용해서 GET,POST 방식의 호출을 사용하게 됨.
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		}
	
}
