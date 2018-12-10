package com.om.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Inject
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		int totalCount=qnaDAO.totalCount(pager);
		//row
		pager.makeRow();
		//paging
		pager.makePage(totalCount);
		
		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		
		return qnaDAO.select(num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		
		return qnaDAO.delete(num);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception{ //매개변수는 부모
		//부모의 ref, step, depth
		BoardDTO pDto = qnaDAO.select(qnaDTO.getNum());
		QnaDTO pQnaDTO = (QnaDTO)pDto; //부모 디티오
		
		qnaDAO.replyUpdate(pQnaDTO); //부모데이터로 업데이트
		
		qnaDTO.setRef(pQnaDTO.getRef());
		qnaDTO.setStep(pQnaDTO.getStep()+1);
		qnaDTO.setDepth(pQnaDTO.getDepth()+1);
		
		return qnaDAO.reply(qnaDTO);
	}

}
