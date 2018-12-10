package com.om.board.notice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.om.s4.AbstractTestCase;
import com.om.util.Pager;

public class PagerTest extends AbstractTestCase {
	
	private static Pager pager;
	
	@BeforeClass
	public static void setData() {
		pager = new Pager();
		
	}
	@Test
	public void test() {
		//assertEquals(1, pager.getCurPage());
		//curPage x 1
		//perBlock x 5
		//assertEquals(5, pager.getPerBlock());
		//perPage x 10
		//assertEquals(10, pager.getPerPage());
		//kind x title
		//assertEquals("title", pager.getKind());
		//search x ""
		//assertEquals("", pager.getSearch());
		//pager.makeRow();
		//assertEquals(10, pager.getLastRow());
	}

}
