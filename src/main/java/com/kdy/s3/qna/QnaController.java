package com.kdy.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s3.util.Pager;

@Controller
@RequestMapping(value = "/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView qnaReply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.qnaReply(qnaDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("path", "./qnaList");
		
		String message = "Reply Write Fail";
		if(result > 0) {
			message = "Reply Write Success";
		}
		
		mv.addObject("msg", message);
		
		return mv;
		
	}
	
	@RequestMapping(value = "qnaReply")
	public void qnaReply() throws Exception {
		
	}
	
	@RequestMapping(value = "qnaSelect")
	public void qnaSelect(long num, Model model) throws Exception {
		QnaDTO qnaDTO = qnaService.qnaSelect(num);
		model.addAttribute("dto", qnaDTO);
		
	}
	
	@RequestMapping(value = "qnaWrite")
	public void qnaWrite() {}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String noticeWrite(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.qnaWrite(qnaDTO);
		System.out.println("Result : "+result);
		
		return "redirect:./qnaList";
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
