package com.ybm.hotdog.board.info.service;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;

/**
 * 정보게시판 관련 인터페이스 정의
 * 
 * @Package : com.ybm.hotdog.board.info.service
 * @FileName : BoardInfoService.java
 * @Author : YI JONGYUN
 * @date : 2018. 7. 28. 
 *
 */
public interface BoardInfoService {
	
	/** 게시글 목록 전체 조회 */
	public List<ArticleDTO> listAll();

}
