package com.kdy.s3.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@RequestMapping(value = "qnaList")
	public void qnaList() throws Exception {
		System.out.println("Qna List");
	}

}
