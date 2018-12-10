package com.om.member;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.om.s4.AbstractTestCase;

public class MemberTest extends AbstractTestCase {

	@Inject
	private MemberDAO memberDAO;
	
	
	//@Test
	public void test() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("test");
		memberDTO.setPw("test");
		memberDTO.setName("test");
		memberDTO.setEmail("sae@woom.kkk");
		memberDTO.setPhone("000");
		memberDTO.setAddress("zzzzzz");
		int result = memberDAO.join(memberDTO);
		
		assertEquals(1, result);
	}
	
	@Test
	public void test1() throws Exception{
	
		MemberDTO memberDTO=memberDAO.login("master", "123");
		
		assertNotNull(memberDTO);
	}

}
