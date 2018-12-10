package com.om.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.util.Pager;
@Service
public class NoticeService implements BoardService{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		return noticeDAO.list(pager);
	}
	
	public BoardDTO select(int num) throws Exception{
		return noticeDAO.select(num);
	}
	
	public int insert(BoardDTO boardDTO) throws Exception{
		return noticeDAO.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) throws Exception{
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(int num) throws Exception{
		return noticeDAO.delete(num);
	}
	

	
	

}
