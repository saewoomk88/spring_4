package com.om.board.notice;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@BeforeClass
	public static void start() {
		System.out.println("start test");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("finish test");
	}
	
	@Before
	public void before() {
		System.out.println("Before test");
	}
	@After
	public void after() {
		System.out.println("after test");
	}
	
	@Test
	public void test() {
		assertNotNull(sql);
	}
	
	
	
	public void insert() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("t2");
		boardDTO.setWriter("w2");
		boardDTO.setContents("c2");
		
		try {
			int result = noticeDAO.insert(boardDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void update() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("t2222");
		boardDTO.setContents("c2");
		boardDTO.setNum(2);
		
		try {
			int result = noticeDAO.update(boardDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void del() {
		try {
			int result = noticeDAO.delete(3);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
