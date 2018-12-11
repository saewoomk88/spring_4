package com.om.board.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.om.board.BoardDAO;
import com.om.board.BoardDTO;
import com.om.util.DBConnector;
import com.om.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="noticeMapper.";
	
	public void test(Map<String, Object> map) throws Exception{
		sqlSession.insert(NAMESPACE+"ins", map);
	}
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
	

	@Override
	public int totalCount(Pager pager) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select count(num) from notice where "+pager.getKind()+" like ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+pager.getSearch()+"%");
		ResultSet rs = st.executeQuery();
		rs.next();
		int totalCount = rs.getInt(1);
		DBConnector.disConnect(rs, st, con);
		return totalCount;
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}
	
	

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		
		
		return sqlSession.insert(NAMESPACE+"ins", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"del", num);
	}

}
