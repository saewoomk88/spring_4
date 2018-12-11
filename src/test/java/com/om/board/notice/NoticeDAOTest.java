package com.om.board.notice;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.om.board.BoardDTO;
import com.om.s4.AbstractTestCase;

public class NoticeDAOTest extends AbstractTestCase{
	
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private SqlSession sql;
	
	@Test
	public void test() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("test");
		noticeDTO.setWriter("test");
		noticeDTO.setContents("tttttt");
		map.put("noticeDTO", new NoticeDTO());
		map.put("num", 0);
		noticeDAO.test(map);
		System.out.println(map.get("num"));
	}

}
