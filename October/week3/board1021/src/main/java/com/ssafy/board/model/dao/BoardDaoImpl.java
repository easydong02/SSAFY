package com.ssafy.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.FileInfoDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	private final String NAMESPACE = "com.ssafy.board.model.dao.BoardDao.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int writeArticle(BoardDto boardDto) throws SQLException {
		int articleNo = 0;
			sqlSession.insert(NAMESPACE + "writeArticle", boardDto);
			List<FileInfoDto> fileInfos = boardDto.getFileInfos();
			if (fileInfos != null && !fileInfos.isEmpty()) {
				articleNo = sqlSession.insert(NAMESPACE + "registerFile", boardDto);
			}
		return articleNo;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, Object> map) throws SQLException {
			return sqlSession.selectList(NAMESPACE + "listArticle", map);
	}

	@Override
	public int getTotalArticleCount(Map<String, String> map) throws SQLException {
			return sqlSession.selectOne(NAMESPACE + "getTotalArticleCount", map);
	}

	@Override
	public BoardDto getArticle(int articleNo) throws SQLException {
			return sqlSession.selectOne(NAMESPACE + "getArticle", articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
			sqlSession.update(NAMESPACE + "updateHit", articleNo);
	}

	@Override
	public void modifyArticle(BoardDto boardDto) throws SQLException {
			sqlSession.update(NAMESPACE + "modifyArticle", boardDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
			sqlSession.delete(NAMESPACE + "deleteFile", articleNo);
			sqlSession.delete(NAMESPACE + "deleteArticle", articleNo);
	}

}
