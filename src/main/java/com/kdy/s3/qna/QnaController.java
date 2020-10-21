package com.kdy.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(long num, Model model) throws Exception {
		System.out.println("qna select");
		QnaDTO qnaDTO = qnaService.qnaSelect(num);
	}
	
	@RequestMapping(value = "qnaList")
	public ModelAndView qnaList(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		List<QnaDTO> ar = qnaService.qnaList(pager);
		
		mv.addObject("lists", ar);
		mv.addObject("pager", pager);
		
		mv.setViewName("qna/qnaList");
		
		return mv;
	}

}
