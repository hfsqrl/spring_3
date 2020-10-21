package com.kdy.s3.qna;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kdy.s3.MyTestCase;


public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void qnaReplyTest() throws Exception {
		
		// 답글
		QnaDTO child = new QnaDTO();
		child.setTitle("test reply title 4");
		child.setWriter("test reply writer 4");
		child.setContents("test reply contents 4");
		
		// 부모글 정보
		QnaDTO parent = qnaDAO.qnaSelect(3);
		
		
		// update
		qnaDAO.qnaReplyUpdate(parent);
		
		
		// 부모글 정보 먼저 조회
		// 부모 글의 정보로 답글에 정보를 입력
		// ref는 부모의 ref
		child.setRef(parent.getRef());
		child.setStep(parent.getStep()+1);
		child.setDepth(parent.getDepth()+1);

		int result = qnaDAO.qnaReply(child);
		
		assertNotNull(parent);
		
		
	}
	
	// @Test
	public void qnaWriteTest() throws Exception {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("test title 2");
		qnaDTO.setWriter("test writer 2");
		qnaDTO.setContents("test contents 2");
		
		int result = qnaDAO.qnaWrite(qnaDTO);
		
		assertNotEquals(0, result);
		
	}

}
