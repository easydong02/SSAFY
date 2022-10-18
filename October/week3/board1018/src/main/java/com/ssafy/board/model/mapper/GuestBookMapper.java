package com.ssafy.board.model.mapper;

import java.util.List;

import com.ssafy.board.model.GuestBookDto;

public interface GuestBookMapper {
	List<GuestBookDto> listArticle() ;
	void writeArticle(GuestBookDto book);
	GuestBookDto selectArticle(int articleNo);
	void updateArticle(GuestBookDto book);
}
