package com.ybm.hotdog.board.mating.service;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;

/**
 * 교배게시판 관련 인터페이스 정의
 * 
 * @Package : com.ybm.hotdog.board.mating.service
 * @FileName : BoardMatingService.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface BoardMatingService {

	/** 게시글 목록 전체 조회 */
	public List<ArticleDTO> listAll();
	
	/** 게시글 상세 조회 */
	public ArticleDTO getArticle(int articleNo);
	
}
