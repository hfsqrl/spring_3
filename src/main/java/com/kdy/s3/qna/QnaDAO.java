package com.kdy.s3.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kdy.s3.util.Pager;

@Repository
public class QnaDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kdy.s3.qna.QnaDAO.";
	
	// count
	public long qnaCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	}
	
	//selectList
	public List<QnaDTO> qnaList(Pager pager)throws Exception {
		return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	}
	
	// select
	public QnaDTO qnaSelect(long num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", num);
	}
	
	// reply
	public int qnaReply (QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaDTO);
	}
	
	// replyUpdate
	public int qnaReplyUpdate(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaDTO);
	}

	// write
	public int qnaWrite (QnaDTO qnaDTO) throws Exception {
		 return sqlSession.insert(NAMESPACE+"qnaWrite", qnaDTO);
		 
	}
	

}
