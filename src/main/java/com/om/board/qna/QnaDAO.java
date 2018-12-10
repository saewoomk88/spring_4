package com.om.board.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.om.board.BoardDAO;
import com.om.board.BoardDTO;
import com.om.util.DBConnector;
import com.om.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "qnaMapper.";
	
	
	
	@Override
	public int totalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}

	@Override
	public BoardDTO select(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"select", num);
	}
	
	//원본글 작성
	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"insert", boardDTO);
	}
	
	//답글 작성
	public int reply(QnaDTO qnaDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"reply", qnaDTO);
	}
	//스텝 업데이트
	public int replyUpdate(QnaDTO qnaDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"replyUpdate", qnaDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "update qna set title=?, contents=? where num=?";
		PreparedStatement st =con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContents());
		st.setInt(3, boardDTO.getNum());
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

	@Override
	public int delete(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "delete qna where num=?";
		PreparedStatement st =con.prepareStatement(sql);
		st.setInt(1, num);
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);
		return result;
	}

}
