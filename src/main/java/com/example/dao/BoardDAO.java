package com.example.dao;

import com.example.vo.BoardVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Repository //전역변수로 등록(xml에 bean으로 등록해도 같은기능)
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;

//	private final String BOARD_INSERT = "insert into BOARD (title, writer, content,category) values (?,?,?,?)";
//	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=?, category=? where seq=?";
//	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//	private final String BOARD_GET = "select * from BOARD  where seq=?";
//	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		int result = sqlSession.insert("Board.insertBoard", vo);
		return result;
	}

	// 글 삭제
	public int deleteBoard(int id) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		return sqlSession.delete("Board.deleteBoard",id);
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");

		return sqlSession.update("Board.updateBoard",vo);

	}	
	
	public BoardVO getBoard(int seq) {

		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO vo = sqlSession.selectOne("Board.getBoard",seq);
		return vo;
	}
	
	public List<BoardVO> getBoardList(){
		System.out.println("===> JDBC로 getBoardList() 기능 처리");

		List<BoardVO> list = sqlSession.selectList("Board.getBoardList");

		return list;
	}
}
