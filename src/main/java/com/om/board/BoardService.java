package com.om.board;

import java.util.List;

import com.om.util.Pager;

public interface BoardService {
	
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	public BoardDTO select(int num) throws Exception;
	
	public int insert(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(int num) throws Exception;

}
