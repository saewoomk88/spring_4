package com.om.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.om.board.BoardDTO;
import com.om.s4.AbstractTestCase;
import com.om.util.Pager;

public class QnaDAOTest extends AbstractTestCase{

	@Inject
	private QnaDAO qnaDAO;

	@Test
	public void replyTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("rt1");
		qnaDTO.setWriter("rw1");
		qnaDTO.setContents("rc1");
		qnaDTO.setRef(2);
		qnaDTO.setStep(1);
		qnaDTO.setDepth(1);
		int result = qnaDAO.reply(qnaDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void insertest() throws Exception {
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("t2");
		boardDTO.setWriter("w2");
		boardDTO.setContents("c2");
		int result = qnaDAO.insert(boardDTO);
		assertEquals(1, result);
	}
	
	
	public void list() {
		Pager pager = new Pager();
		try {
			List<BoardDTO> ar =qnaDAO.list(pager);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
