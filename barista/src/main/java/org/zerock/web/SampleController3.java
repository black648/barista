package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;
@Controller
public class SampleController3 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);

	@RequestMapping("/doD")
	public String doD(Model model) {
		ProductVO product = new ProductVO("Sample Product", 10000);
		logger.info("doD");
		model.addAttribute(product);
		//모델어트리뷰트에 이름값을 지정하지 않았기때문에 뷰에서는 productVO.name 이 됨.
		return "productDetail";
	}

}
