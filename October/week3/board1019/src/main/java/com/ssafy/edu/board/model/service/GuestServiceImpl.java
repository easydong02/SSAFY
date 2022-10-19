package com.ssafy.edu.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.board.model.GuestBook;
import com.ssafy.edu.board.model.mapper.GuestBookMapper;


@Service
public class GuestServiceImpl implements GuestService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	@Transactional(readOnly = true)
	public List<GuestBook> listArticle() throws Exception {
		GuestBookMapper guestMapper = sqlSession.getMapper(GuestBookMapper.class);
		return guestMapper.listArticle();
	}

	@Override
	@Transactional(readOnly = true)
	public GuestBook selectArticle(int articleNo) throws Exception {
		GuestBookMapper guestMapper = sqlSession.getMapper(GuestBookMapper.class);
		return guestMapper.selectArticle(articleNo);	}

	@Override
	@Transactional
	public void writeArticle(GuestBook book) throws Exception {
		GuestBookMapper guestMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestMapper.writeArticle(book);
	}

	@Override
	@Transactional
	public void updateArticle(GuestBook book) throws Exception {
		GuestBookMapper guestMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestMapper.updateArticle(book);
	}

	@Override
	@Transactional
	public void deleteArticle(int articleNo) throws Exception {
		GuestBookMapper guestMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestMapper.deleteArticle(articleNo);
	}

}
