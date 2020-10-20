package com.kdy.s3.notice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kdy.s3.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeDTO noticeDTO) throws Exception {
		System.out.println(noticeDTO.getTitle());
		System.out.println(noticeDTO.getContents());
		System.out.println(noticeDTO.getNum());
		int result = noticeService.noticeUpdate(noticeDTO);
		System.out.println("result : "+result);
		
		ModelAndView mv = new ModelAndView();
		
		if(result>0) {
			mv.addObject("msg", "Update Success");
		} else {
			mv.addObject("msg", "Update Fail");
		}
		
		mv.addObject("path", "./noticeList");
		
		mv.setViewName("common/result");
		
		return mv;
		
	}
	
	@RequestMapping(value = "noticeUpdate")
	public void noticeUpdate(NoticeDTO noticeDTO, Model model) throws Exception {
		// 글번호 출력
		//System.out.println(noticeDTO.getNum());
		// 글제목, 내용
		noticeDTO = noticeService.noticeSelect(noticeDTO.getNum());
		model.addAttribute("dto", noticeDTO);
	}

	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(long num) throws Exception {
		System.out.println("notice delete");
		int result = noticeService.noticeDelete(num);
		//int result = 1;
		
		String message = "Delete Fail";
		
		if(result>0) {
			message = "Delete Success";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/result");
		mv.addObject("msg", message); 
		mv.addObject("path", "./noticeList");
		return mv ;
	}
	
	@RequestMapping(value = "noticeSelect")
	public void noticeSelect(long num, Model model) throws Exception {
		System.out.println("notice select");
		NoticeDTO noticeDTO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeDTO);
		
	}
	
	@RequestMapping(value = "noticeWrite")
	public void noticeWrite() { }
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.noticeWrite(noticeDTO);
		System.out.println("result : "+result);
		
		return "redirect:./noticeList";
	}
	
	@RequestMapping(value = "noticeList")
	public ModelAndView noticeList(Pager pager) throws Exception {
		
		System.out.println("kind : "+pager.getKind());
		System.out.println("search : "+pager.getSearch());
		
		ModelAndView mv = new ModelAndView();

		List<NoticeDTO> ar = noticeService.noticeList(pager);
		
		mv.addObject("lists", ar); 
		mv.addObject("pager", pager);
		
		mv.setViewName("notice/noticeList");
		
		return mv;
		
	}

}
