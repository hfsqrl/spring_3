package com.kdy.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.s3.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public QnaDTO qnaSelect(long num) throws Exception {
		return qnaDAO.qnaSelect(num);
	}
	
	public List<QnaDTO> qnaList(Pager pager) throws Exception {
		System.out.println("service list");
		
		// rowNum 계산
		pager.makeRow();
		
		// page 계산
		long totalCount = qnaDAO.qnaCount(pager);
		pager.setTotalCount(totalCount);
		pager.makePage();
		
		return qnaDAO.qnaList(pager);
	}

}
