package com.kdy.s3.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdy.s3.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	public int qnaReply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent = qnaDAO.qnaSelect(qnaDTO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parent);
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		return qnaDAO.qnaReply(qnaDTO);
		
	}
	
	public QnaDTO qnaSelect(long num) throws Exception {
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaWrite(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.qnaWrite(qnaDTO);
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
