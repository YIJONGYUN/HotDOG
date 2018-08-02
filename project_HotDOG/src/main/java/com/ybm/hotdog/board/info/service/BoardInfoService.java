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
	/** 게시글 번호로 조회 */
	public ArticleDTO getArticle(int articleNo);
	/** 게시글 등록 */
	public void articleRegister(ArticleDTO article);
	/** 게시글 삭제 */
	public void articleDelete(int articleNo);
	/** 게시글 수정 */
	public void articleEdit(ArticleDTO article);
	/** 게시글 검색 */
	public List<ArticleDTO> searchArticle(String searchOption, String keyword);
}
