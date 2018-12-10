package com.om.member;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESACE= "memberMapper.";

	public int join(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(NAMESACE+"join", memberDTO);
	}
	
	public MemberDTO idCheck(String id) throws Exception{
		
		return sqlSession.selectOne(NAMESACE+"idCheck", id);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		/*Map<String, Object> map= new HashMap<String, Object>();
		map.put("id", id);
		map.put("pw", pw);*/
		return sqlSession.selectOne(NAMESACE+"login", memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.update(NAMESACE+"update", memberDTO);
	}
	
	public int delete(String id) throws Exception{
		
		return sqlSession.delete(NAMESACE+"delete", id);
	}

}
