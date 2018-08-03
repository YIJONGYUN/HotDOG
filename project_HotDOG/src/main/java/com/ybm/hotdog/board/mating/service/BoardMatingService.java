package com.ybm.hotdog.board.mating.service;

import java.util.List;

import com.ybm.hotdog.board.domain.ArticleDTO;
import com.ybm.hotdog.board.domain.ReplyDTO;

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
	
	/** 게시글 등록 */
	public void regist (ArticleDTO article);
	
	/** 게시글 삭제 */
	public void delete (int articleNo);
	
	/** 게시글 수정 */
	public void edit (ArticleDTO article);
	
	/** 조회수 증가 */
	public void hitcountUpdate(int articleNo);
	
	/** 전체 게시글 수 조회 */
	public int getArticleNumber();
	
	/** 게시글 검색 */
	public List<ArticleDTO> search(String searchType, String keyword);
	
	/** 검색 게시글 수 조회 */
	public int getSearchNumber(String searchType, String keyword);
	
	/** 댓글 작성 */
	public void registReply (ReplyDTO reply);
	
	/** 댓글 조회 */
	public List<ReplyDTO> getReply (int articleNo);
	
	/** 댓글 수 조회 */
	public int getReplyNumber (int articleNo);
}
