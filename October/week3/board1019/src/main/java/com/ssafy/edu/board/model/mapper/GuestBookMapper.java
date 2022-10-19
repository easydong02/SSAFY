package com.ssafy.edu.board.model.mapper;

import java.util.List;

import com.ssafy.edu.board.model.GuestBook;

public interface GuestBookMapper {
	List<GuestBook> listArticle() throws Exception;
	GuestBook selectArticle(int articleNo) throws Exception;
	void writeArticle(GuestBook book) throws Exception;
	void updateArticle(GuestBook book) throws Exception;
	void deleteArticle(int articleNo) throws Exception;
}
