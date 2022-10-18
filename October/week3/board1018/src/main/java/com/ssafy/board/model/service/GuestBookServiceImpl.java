package com.ssafy.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.board.model.GuestBookDto;
import com.ssafy.board.model.mapper.GuestBookMapper;

@Service
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	@Transactional(readOnly = true)
	public List<GuestBookDto> listArticle() throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		List<GuestBookDto> lists= guestBookMapper.listArticle();
		return lists;
	}

	@Override
	@Transactional //에러나면 다시 rollback 해준다.
	public void writeArticle(GuestBookDto book) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestBookMapper.writeArticle(book);
	}

	@Override
	@Transactional
	public GuestBookDto selectArticle(int articleNo) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		GuestBookDto book = guestBookMapper.selectArticle(articleNo);
		return book;
	}

	@Override
	@Transactional
	public void updateArticle(GuestBookDto book) throws Exception {
		GuestBookMapper guestBookMapper = sqlSession.getMapper(GuestBookMapper.class);
		guestBookMapper.updateArticle(book);
	}

}
