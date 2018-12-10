package com.om.board;

import java.util.List;

import com.om.util.Pager;

public interface BoardDAO {
	
	//LIst
	public List<BoardDTO> list(Pager pager) throws Exception;
	//select
	public BoardDTO select(int num) throws Exception;
	//insert
	public int insert(BoardDTO boardDTO) throws Exception;
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	//delete
	public int delete(int num) throws Exception;
	//totalCount
	public int totalCount(Pager pager) throws Exception;
	
	

}
