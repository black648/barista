package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume/*")
public class ResumeController {

	@RequestMapping("/myResume")
	public String myResume() {
		
		return "/myResume";
	}
}
